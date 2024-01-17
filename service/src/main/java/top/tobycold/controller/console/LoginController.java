package top.tobycold.controller.console;

import cn.hutool.jwt.JWT;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import top.tobycold.admin.JwtConfig;
import top.tobycold.admin.LoginStatus;
import top.tobycold.service.LoginService;
import top.tobycold.util.ColdUtil;
import top.tobycold.dto.EmailDTO;
import top.tobycold.dto.LoginDTO;
import top.tobycold.util.Result;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("console")
@Tag("登录相关接口")
public class LoginController {

    @Autowired
    LoginService loginService;


    @PostMapping("login")
    @Operation(summary = "用户登录接口")
    public Result<String> login(@RequestBody LoginDTO loginDTO) {
        LoginStatus status = loginService.login(loginDTO);

        if (status == LoginStatus.SUCCESS) {
            String token = JWT.create().setKey(JwtConfig.TOKEN_KEY.getBytes())
                    .setNotBefore(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 2)))
                    .setPayload("name", loginDTO.getAccount())
                    .sign();
            return Result.success("登录成功", token);
        }

        return Result.error("登录失败");
    }

    @PostMapping("register")
    @Operation(summary = "用户注册接口")
    public Result<String> register(@RequestBody LoginDTO loginDTO) {
        LoginStatus status = loginService.register(loginDTO);

        if (status == LoginStatus.SUCCESS)
            return Result.success("注册成功");

        return Result.error("注册失败");
    }

    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    RedisTemplate redisTemplate;
    @PostMapping("code")
    @Operation(summary = "获取验证码接口")
    public Result<String> getCode(@RequestBody EmailDTO emailDTO) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            int code = ColdUtil.getRandomCode();
            ValueOperations valueOperations = redisTemplate.opsForValue();
            if (valueOperations.get(emailDTO.getEmail()) != null) {
                return Result.error("验证码已发送");
            }
            valueOperations.set(emailDTO.getEmail(), code, 60, TimeUnit.SECONDS);

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false);
            mimeMessageHelper.setFrom("coldlen@qq.com", "Cold的窝");
            mimeMessageHelper.setSubject("Cold的窝官方");
            mimeMessageHelper.setText("<h2>验证码:" + code + "</h2>", true);
            mimeMessageHelper.setTo(emailDTO.getEmail());
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            return Result.error("获得验证码失败");
        }

        return Result.success("验证码已发送");
    }
}