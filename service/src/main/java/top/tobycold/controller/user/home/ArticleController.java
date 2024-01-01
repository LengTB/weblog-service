package top.tobycold.controller.user.home;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.tobycold.util.Result;

@Slf4j
@RestController("UserArticle")
@RequestMapping("user/article")
@Tag(name = "文章模块相关接口")
public class ArticleController {

    /**
     * TODO 等待前端确定文章界面，后再完善接口
     * @param routerName
     * @return
     */
    @GetMapping
    @Operation(summary = "获取文章接口")
    public Result<?> getArticle(@PathVariable String routerName){
        log.info("请求路由为：{} 的文章", routerName);
        return Result.success(routerName);
    }
}
