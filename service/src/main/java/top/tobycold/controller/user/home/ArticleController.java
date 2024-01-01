package top.tobycold.controller.user.home;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("UserArticle")
@RequestMapping("user/article")
@Tag(name = "文章模块相关接口")
public class ArticleController {


}
