package com.fjw.provide.config;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

/**
 * @Author：jiawei
 * @CreateTime：2022-07-19 17:34
 * @Description：自定义RestTemplate 的ErrorHandler
 * @Version：1.0
 **/
public class MyRestTemplateErrorHandler implements ResponseErrorHandler {


    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return true; //默认报错的话返回false。然后叫个交给handleError处理。希望能像HttpClient 一样直接从 Response 获取 HttpStatus 和 body 中的报错信息 而不抛出异常
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        //不做任何处理
    }
}
