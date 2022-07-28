package com.store.template.config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author jiawei
 * @description 自定义MVC配置
 * @date 2019/6/8
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    /**
     * 注册自定义拦截器
     * @param: InterceptorRegistry
     * @date: 2022/7/19 16:56
    **/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/user/**")
                .excludePathPatterns("/auth/login","/new/register");
        super.addInterceptors(registry);
    }

    /**
     * 允许跨域
     * @param registry
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH","OPTIONS")
                .maxAge(3600);
    }


}
