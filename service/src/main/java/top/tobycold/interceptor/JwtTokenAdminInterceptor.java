package top.tobycold.interceptor;

import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
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
    //TODO token 不需要解密就能拿值，头和体是不加密的，而是base64编码，而最后签名是加密的


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("JWTToken拦截器拦截请求-> ip:{}",request.getLocalAddr());

        String token = request.getHeader("token");
        //校验时间
        try {
            JWT jwt = JWTUtil.parseToken(token);
            if(!JWTUtil.verify(token, JwtConfig.TOKEN_KEY.getBytes())){
                log.info("JWT验证失败");
                response.setStatus(401);
                return false;
            }
            JSONObject payloads = jwt.getPayloads();
            //这里将id存储在线程空间中ThreadLocal
            Object id = payloads.get(JwtConfig.EID);
            BaseContext.setId(id.toString());
            return true;
        }catch (Exception e){
            response.setStatus(401);
            return false;
        }
        //放行
    }


}
