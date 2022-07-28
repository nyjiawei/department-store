package com.store.db;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.store.db.utils.PropertiesBeanUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Collections;
import java.util.Properties;


/**
 * @Author：jiawei
 * @CreateTime：2022-07-18 14:14
 * @Description：mybatis plus 代码生成器
 * @Version：1.0
 **/
public class MybatisPlusCodeGenerator {

    private static final String[] NEED_TABLES = {
            "goods","goods_category","goods_content","goods_img","goods_property","goods_property_name",
            "goods_property_value","goods_sku","order","order_detail","order_logistics","user","user_roles",
            "user_delivery_address",
    };

    // 设置过滤表前缀
    private static final String[] PREFIX_TABLES = {
    };

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PropertiesBeanUtils.class);
        Properties properties = context.getBean("myProperties",Properties.class);

        //代码生成器配置
        FastAutoGenerator.create(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"))
                .globalConfig(builder -> {
                    builder.author("jiawei") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(System.getProperty("user.dir") + "/service-db/src/main/java"); // 指定输出目录
                })
                //包配置
                .packageConfig(builder -> {
                    builder.parent("com.store") // 设置父包名
                            .moduleName("db") // 设置父包模块名
                            .entity("entity") // 实体类包名
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
                            .xml("mapper.xml")
                            .controller("controller")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir") + "/service-db/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                //策略配置
                .strategyConfig(builder -> {
                    builder.addInclude(NEED_TABLES) // 设置需要生成的表名
                            //.addTablePrefix(PREFIX_TABLES);  设置过滤表前缀
                            .entityBuilder()    //实体类配置
                            .enableLombok()     //使用lombok
                            .enableTableFieldAnnotation()  //实体类字段注解
                            .controllerBuilder()  //controller配置
                            .enableRestStyle()    //开启restController
                            .mapperBuilder()
                            .enableMapperAnnotation()  //开启mapper注解
                            .enableBaseResultMap()      //启用BaseResultMap 生成
                            .enableBaseColumnList();   //启用BaseColumnList
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
