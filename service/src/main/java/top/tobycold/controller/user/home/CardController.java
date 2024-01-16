package top.tobycold.controller.user.home;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.tobycold.pojo.UserEntity;
import top.tobycold.service.UserService;
import top.tobycold.util.BaseContext;
import top.tobycold.util.Result;

@RestController
@RequestMapping("user/card")
public class CardController {

    /**
     * avatar         头像
     * name           名称
     * signature      个签
     * grade          等级
     * isAdmin        是否为管理员
     * commentCount   评论数
     * likeCount      点赞数
     * tagCount       标签数
     * github         github
     * qq             qq
     * bilibili       bilibili
     *
     * @Card 原型
     */
    @Autowired
    UserService userService;

    @GetMapping
    @Operation(summary = "获取个人名片信息")
    public Result<?> getCard() {
        return Result.error();
    }

}
