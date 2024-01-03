package top.tobycold.controller.console;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.tobycold.admin.ArticleStatus;
import top.tobycold.dao.SummaryPages;
import top.tobycold.pojo.SummaryEntity;
import top.tobycold.service.SummaryService;
import top.tobycold.util.Result;

import java.util.List;

@RestController("ConsoleSummary")
@RequestMapping("console/summary")
@Tag(name = "摘要相关接口")
public class SummaryController {
    @Autowired
    SummaryService summaryService;

    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    TransactionDefinition transactionDefinition;
    /**
     * 这里只要数据页码是为了不让爬友一次性爬光内容，这里我只让分页查询，但是没给这条数据加限流，后期有空再补上
     * @param page
     * @return
     */
    @GetMapping("{page}")
    @Operation(summary = "根据id分页查询")
    public Result<SummaryPages> getPages(@PathVariable Integer page){
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);

        /**
         * 前端在处理状态时，不太方便，这里考虑把status 改为 varchar 类型
         */
        try {
            List<SummaryEntity> summaryEntities = summaryService.selectByPages(ArticleStatus.ALL.STATUS(), page);
            SummaryPages summaryPages = SummaryPages.builder()
                    .summaryEntities(summaryEntities)
                    .total(summaryService.getTotal(ArticleStatus.ALL.STATUS()))
                    .build();
            dataSourceTransactionManager.commit(transactionStatus);
            return Result.success(summaryPages);
        }catch (Exception e){
            dataSourceTransactionManager.rollback(transactionStatus);
            return Result.error("分页查询失败");
        }

    }
}
