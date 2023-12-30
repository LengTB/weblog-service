package top.tobycold.controller.console;

import cn.hutool.jwt.JWT;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.tobycold.admin.JwtConfig;
import top.tobycold.util.Result;
import top.tobycold.dto.ContextDTO;
import top.tobycold.dto.UserDTO;
import top.tobycold.pojo.UserEntity;
import top.tobycold.service.ConsoleService;
import top.tobycold.service.ArticleService;

import java.util.Date;


@RestController
@RequestMapping("api/console")
@Slf4j
@CrossOrigin
@Tag(name = "控制台相关接口")
public class ConsoleController {

    /**
     * 登录的接口
     */
    @Autowired
    private ConsoleService consoleService;
    @Autowired
    ArticleService articleService;

    @PostMapping("login")
    public Result<?> login(@RequestBody UserDTO userDTO, HttpServletRequest request) {
        log.info("登录用户详细：{} -> ip地址：{}", userDTO, request.getRemoteAddr());
        UserEntity user = consoleService.login(userDTO, request.getLocalAddr());
        //TODO 这里可能走异常处理器，不会查询出结果
        log.info("service查询结果UserEntity:{}", user);
        if (user == null || !user.getPassword().equals(userDTO.getPassword())){
            return Result.error("账号或密码错误", null);
        }
        String token = JWT.create()
                .setNotBefore(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2))   //两个小时
                .setKey(JwtConfig.TOKEN_KEY.getBytes())
                .setPayload("id", user.getId())
                .sign();
        return Result.success("登录成功", token);
    }

    /**
     * 注册功能
     * TODO 待完成
     * @param userDTO
     * @param request
     * @return Response
     */
    @RequestMapping(value = "registered", method = RequestMethod.POST)
    public Result<?> registered(UserDTO userDTO, HttpServletRequest request) {
        
        return Result.success();
    }

    @GetMapping("verify")
    public Result<?> verifyLogin(){
        return Result.success("登录成功");
    }

    @PostMapping("save")
    @Operation(summary = "存储文章")
    public Result<?> saveContext(@RequestBody ContextDTO contextDTO, HttpServletRequest httpServletRequest){
        log.info("保存文章为context:{}", contextDTO);
        articleService.save(contextDTO);
        return Result.success();
    }

}

