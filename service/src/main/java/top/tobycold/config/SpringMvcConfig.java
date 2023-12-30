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
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/console/login")
                .excludePathPatterns("/api/data");
    }


}
