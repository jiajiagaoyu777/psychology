package com.whlg.psychology.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册处理拦截器的操作
 */
@Configuration
public class ApiInterceptorConfigurer implements WebMvcConfigurer {
    //允许get、post、put、delete方法的请求

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //"/**"代表下面的所有地址
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("GET","POST","PUT","DELETE")
                .allowedOrigins("*");
    }
}
