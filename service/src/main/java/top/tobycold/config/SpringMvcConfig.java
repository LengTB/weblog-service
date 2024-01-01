package top.tobycold.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.tobycold.interceptor.JwtTokenAdminInterceptor;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Autowired
    JwtTokenAdminInterceptor jwtTokenAdminInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(jwtTokenAdminInterceptor)
                .addPathPatterns("/**")//默认拦截所有
                .excludePathPatterns("/user/resources")//排除 resources 请求接口
                .excludePathPatterns("/user/resources/**")//排除 resources 下所有请求接口
                .excludePathPatterns("/user/card")//排除 个人信息 请求接口
                .excludePathPatterns("/user/summary/*")//排除 摘要 请求接口
                .excludePathPatterns("/console/login")//排除 登录 相关接口
                .excludePathPatterns("/console/login/**");

    }


}
