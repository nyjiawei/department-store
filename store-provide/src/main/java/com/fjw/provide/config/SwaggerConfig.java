package com.fjw.provide.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author：jiawei
 * @CreateTime：2025-03-13 20:09
 * @Description：SwaggerConfig
 * @Version：1.0
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig{

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fjw.provide.controller"))
                .build();
    }


    private ApiInfo apiInfo() {
        return  new ApiInfoBuilder()
                // 标题
                .title("商城项目接口文档")
                // 说明信息
                .description("一个电商商城")
                // 作者信息
                .contact(new Contact("jiawei","暂无","690862839@qq.com"))
                //版本
                .version("版本号：1.0")
                .build();

    }
}

