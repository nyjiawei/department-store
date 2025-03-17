package com.fjw.provide.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author jiawei
 * @description 自定义MVC配置
 * @date 2019/6/8
 */

@Configuration
public class MyWebConfig extends WebMvcConfigurationSupport {

    @Autowired
    private JWTInterceptor tokenInterceptor;

    /**
     * 注册自定义拦截器
     * @param: InterceptorRegistry
     * @date: 2022/7/19 16:56
    **/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/user/access/**","/goods/**","/sku/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui/**","/error**");
        super.addInterceptors(registry);
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/").resourceChain(false);
         registry.addResourceHandler("/swagger-ui/**")
                 .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/").resourceChain(false);
         registry.addResourceHandler("/webjars/**")
                 .addResourceLocations("classpath:/META-INF/resources/webjars/").resourceChain(false);
    }


    /**
     * 允许跨域
     * @param registry
     */
    /*@Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH","OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }*/


}
