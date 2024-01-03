package top.tobycold.controller.user.home;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.tobycold.dao.SummaryPages;
import top.tobycold.pojo.SummaryEntity;
import top.tobycold.service.SummaryService;
import top.tobycold.util.Result;

import java.util.List;

@RestController
@RequestMapping("user/summary")
@Tag(name = "摘要相关接口")
public class SummaryController {

    @Autowired
    SummaryService summaryService;

    /**
     * 这里只要数据页码是为了不让爬友一次性爬光内容，这里我只让分页查询，但是没给这条数据加限流，后期有空再补上
     * @param page
     * @return
     */
    @GetMapping("{page}")
    @Operation(summary = "根据id分页查询")
    public Result<SummaryPages> getPages(@PathVariable Integer page){

        List<SummaryEntity> summaryEntities = summaryService.selectByPages(page);
        SummaryPages summaryPages = SummaryPages.builder()
                .summaryEntities(summaryEntities)
                .total(summaryService.getTotal())
                .build();
        return Result.success(summaryPages);
    }
    /**
     * 需求：
     *      这里还很多需求没有完善哦
     *
     *      创建人
     *      创建时间
     *      文章发布状态
     *      是否为可见 --这里跟发布状态合并一个数据，用 1 代表 可见， 0 代表不可见， 2 代表未发布
     */
}
