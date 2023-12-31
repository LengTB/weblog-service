package top.tobycold.controller.user.home;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.tobycold.util.Result;

@RestController
@RequestMapping("user/summary")
@Tag(name = "摘要相关接口")
public class SummaryController {

    //TODO 摘要分页查询 待开发接口 tobycold 23-12-31

    @GetMapping
    @Operation(summary = "根据id分页查询")
    public Result<?> getPages(@PathVariable int id){
        //泛型也待确定！！！
        return null;
    }
}
