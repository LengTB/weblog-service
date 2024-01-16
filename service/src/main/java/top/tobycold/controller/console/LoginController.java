package top.tobycold.controller.console;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import top.tobycold.admin.CodeUtil;
import top.tobycold.dto.EmailDTO;
import top.tobycold.dto.IdentityDTO;
import top.tobycold.service.IdentityService;
import top.tobycold.util.Result;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("console/")
@Tag("登录相关接口")
public class LoginController {

    @Autowired
    IdentityService identityService;

    @Autowired
    RedisTemplate redisTemplate;

    @PostMapping("login")
    @Operation(summary = "用户登录接口")
    public Result<String> login(@RequestBody IdentityDTO identityDTO, HttpServletRequest request) {
        return identityService.select(identityDTO);
    }

    @PostMapping("register")
    @Operation(summary = "用户注册接口")
    public Result<String> register(@RequestBody IdentityDTO identityDTO) {
        return identityService.insert(identityDTO);
    }

    @DeleteMapping
    @Operation(summary = "删除用户接口")
    public Result<String> deleteUser(@RequestBody IdentityDTO identityDTO) {
        return identityService.delete(identityDTO);
    }

    @PutMapping
    @Operation(summary = "修改用户接口")
    public Result<String> updateUser(@RequestBody IdentityDTO identityDTO) {
        return identityService.update(identityDTO);
    }

    @Autowired
    JavaMailSender javaMailSender;

    @PostMapping("code")
    @Operation(summary = "获取验证码接口")
    public Result<String> getCode(@RequestBody EmailDTO emailDTO) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            int code = CodeUtil.getRandomCode();
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