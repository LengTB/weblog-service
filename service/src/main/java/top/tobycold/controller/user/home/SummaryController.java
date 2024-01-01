package top.tobycold.controller.user.home;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.tobycold.pojo.SummaryEntity;
import top.tobycold.service.SummaryService;
import top.tobycold.util.Result;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user/summary")
@Tag(name = "摘要相关接口")
public class SummaryController {

    @Autowired
    SummaryService summaryService;
    @GetMapping("{page}")
    @Operation(summary = "根据id分页查询")
    public Result<List<SummaryEntity>> getPages(@PathVariable Integer page){
        //泛型也待确定！！！

        List<SummaryEntity> summaryEntities = summaryService.selectByPages(page);
        return Result.success(summaryEntities);
    }
}
