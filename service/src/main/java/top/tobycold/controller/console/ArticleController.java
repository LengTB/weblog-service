package top.tobycold.controller.console;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.tobycold.pojo.ArticleEntity;
import top.tobycold.util.Result;

@Slf4j
@RestController
@RequestMapping("console/article")
public class ArticleController {

    public Result<ArticleEntity> getArticle(){
        return Result.success();
    }
}
