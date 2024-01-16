package top.tobycold.interceptor;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.JWTValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import top.tobycold.admin.JwtConfig;
import top.tobycold.util.BaseContext;

@Slf4j
@Component
public class JwtTokenAdminInterceptor implements HandlerInterceptor {

    /**
     * token 不需要解密就能拿值，头和体是不加密的，而是base64编码，而最后签名是加密的
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("\033[0;31m JWTToken拦截器拦截请求-> ip:{} \033[0m",request.getLocalAddr());

        String token = request.getHeader("token");
        //校验时间
        try {
            JWT jwt = JWTUtil.parseToken(token);
            JWTValidator.of(jwt).validateDate();
            if (!jwt.setKey(JwtConfig.TOKEN_KEY.getBytes()).verify()) {
                log.error("\033[0;31m token有误 \033[0m");
                response.setStatus(401);
                return false;
            }
            //这里将name存储在线程空间中ThreadLocal
            Object name = jwt.getPayloads().get(JwtConfig.EID);
            BaseContext.setName(name.toString());
            return true;
        }catch (Exception e){
            log.error("\033[0;31m token有效时间已失效啦！\033[0m");
            response.setStatus(401);
            return false;
        }
        //放行
    }


}
