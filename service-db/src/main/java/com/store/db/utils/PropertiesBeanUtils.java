package com.store.db.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 读取配置文件内容，封装成Javabean。注意：不能完美读取yaml文件，没有yaml层级之分
 * @author jiawei
 * 2022年7月14日下午9:27:02
 */
@Component
@Slf4j
public class PropertiesBeanUtils {

    @Value("${spring.profiles.active}")
    private String env;

    @Bean(name = "myProperties")
    public Properties getProperties(){
        //要读取的文件名
        String fileName = "application-" + env + ".yaml";
        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader(PropertiesBeanUtils.class.getClassLoader().getResourceAsStream(fileName),"UTF-8"));
        } catch (IOException e) {
            log.error("配置文件读取异常:",e);
        }
        return properties;
    }

}