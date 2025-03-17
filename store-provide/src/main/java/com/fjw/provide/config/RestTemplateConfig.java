package com.fjw.provide.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import java.nio.charset.Charset;

/**
 * @Author：jiawei
 * @CreateTime：2022-07-19 12:21
 * @Description：RestTemplateConfig 工具
 * @Version：1.0
 **/

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        RestTemplate restTemplate = new RestTemplate(factory);
        // UTF-8编码设置
        restTemplate.getMessageConverters().set(1,
                new StringHttpMessageConverter(Charset.forName("UTF-8")));
        restTemplate.setErrorHandler(new MyRestTemplateErrorHandler()); //设置自定义的错误处理器
        return restTemplate;

    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        // 超时时间 5秒
        factory.setReadTimeout(5 * 1000);
        factory.setConnectTimeout(5 * 1000);
        return factory;
    }

}
