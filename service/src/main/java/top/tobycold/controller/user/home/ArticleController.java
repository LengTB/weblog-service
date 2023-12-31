package top.tobycold.controller.user.home;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.tobycold.dto.ArticleDTO;
import top.tobycold.service.ArticleService;
import top.tobycold.service.SummaryService;
import top.tobycold.util.Result;

@Slf4j
@RestController("UserArticle")
@RequestMapping("user/article")
@Tag(name = "文章模块相关接口")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    SummaryService summaryService;

    @PostMapping
    @Operation(summary = "存储文章")
    public Result<String> saveArticle(@RequestBody ArticleDTO articleDTO, HttpServletRequest httpServletRequest){
        log.info("用户ip：{} -> 存储文章 article:{}", httpServletRequest.getRemoteAddr(), articleDTO);
        articleDTO.setIp(httpServletRequest.getRemoteAddr());
        articleService.save(articleDTO);
        summaryService.save(articleDTO);
        return Result.success("存储文章成功");
    }
}
