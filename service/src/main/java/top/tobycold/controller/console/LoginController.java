package top.tobycold.controller.console;

import cn.hutool.jwt.JWT;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.tobycold.admin.JwtConfig;
import top.tobycold.dto.UserDTO;
import top.tobycold.pojo.UserEntity;
import top.tobycold.service.UserService;
import top.tobycold.util.Result;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("controller/login")
@Tag("登录相关接口")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping()
    @Operation(summary = "登录接口")
    public Result<String> login(@RequestBody UserDTO userDTO, HttpServletRequest request) {
        log.info("登录用户详细：{} -> ip地址：{}", userDTO, request.getRemoteAddr());
        UserEntity user = userService.select(userDTO);
        //TODO 这里可能走异常处理器，不会查询出结果
        log.info("service查询结果UserEntity:{}", user);
        if (user == null){
            return Result.error("账号或密码错误");
        }
        String token = JWT.create()
                .setNotBefore(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2))   //失效时间 -> 两个小时
                .setKey(JwtConfig.TOKEN_KEY.getBytes())
                .setPayload("id", user.getId())
                .sign();
        return Result.success("登录成功", token);
    }

    @PostMapping("register")
    @Operation(summary = "注册接口")
    public Result<String>  register(@RequestBody UserDTO userDTO, HttpServletRequest httpServletRequest){
        userDTO.setIp(httpServletRequest.getRemoteAddr());
        userService.insert(userDTO);

        return Result.success();
    }
}
