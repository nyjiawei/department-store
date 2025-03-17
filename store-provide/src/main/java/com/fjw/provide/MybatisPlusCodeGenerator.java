package com.fjw.provide;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.util.Collections;


/**
 * @Author：jiawei
 * @CreateTime：2022-07-18 14:14
 * @Description：mybatis plus 代码生成器
 * @Version：1.0
 **/
public class MybatisPlusCodeGenerator {

    //要生成的表放这里
    private static final String[] NEED_TABLES = {"order","order_snapshoot"};

    //需要过滤的表前缀
    private static final String[] PREFIX_TABLES = {
    };

    public static void main(String[] args) {

        //代码生成器配置
        FastAutoGenerator.create("jdbc:mysql://gz-cdb-i977ztl1.sql.tencentcdb.com:21441/mall_db?useUnicode=true&characterEncoding=utf-8&useSSL=true",
                        "root", "jysru6-tojnaT-cinqen")
                .globalConfig(builder -> {
                    builder.author("jiawei") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(System.getProperty("user.dir") + "/store-provide/src/main/java"); // 指定输出目录
                })
                //包配置
                .packageConfig(builder -> {
                    builder.parent("com.fjw") // 设置父包名
                            // provide模块
                            .moduleName("provide") // 设置父包模块名
                            .entity("model")
                            .controller("controller")
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
                            .xml("mapper.xml")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir") + "/store-provide/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                //策略配置
                .strategyConfig(builder -> {
                    builder.addInclude(NEED_TABLES) // 设置需要生成的表名
                            //.addTablePrefix(PREFIX_TABLES);  设置过滤表前缀
                            //entity配置策略
                            .entityBuilder()
                            .enableLombok()     //使用lombok
                            .enableTableFieldAnnotation()  //实体类字段注解
                            //controller配置策略
                            //.controllerBuilder()
                            //.enableRestStyle()    //开启restController
                            //mapper配置策略
                            .mapperBuilder()
                            .enableMapperAnnotation()  //开启mapper注解
                            .enableBaseResultMap()      //启用BaseResultMap 生成
                            .enableBaseColumnList();   //启用BaseColumnList
                }).templateEngine(new FreemarkerTemplateEngine()).execute();

    }
}
