package top.tobycold.controller.user.home;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.tobycold.util.Result;

@RestController
@RequestMapping("user/home")
public class CardController {

    /**
     * name         名字
     * signature    个签
     * grade        等级
     * isAdmin      是否为管理员
     *
     * Card 原型
     */

    @GetMapping("card")
    @Operation(summary = "获取个人名片信息")
    public Result<?> getCard(){

        return Result.success("success");
    }

}
