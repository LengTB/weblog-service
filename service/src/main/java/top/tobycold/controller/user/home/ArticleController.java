package top.tobycold.controller.user.home;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.tobycold.pojo.ArticleEntity;
import top.tobycold.service.ArticleService;
import top.tobycold.util.Result;

@Slf4j
@RestController("UserArticle")
@RequestMapping("user/article")
@Tag(name = "文章模块相关接口")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    /**
     * @param path
     * @return
     */
    @GetMapping("{path}")
    @Operation(summary = "获取文章接口")
    public Result<ArticleEntity> getArticle(@PathVariable String path){
        log.info("请求路由为：{} 的文章", path);
        ArticleEntity articleEntity = articleService.selectByPath(path);
        return Result.success(articleEntity);
    }
}
