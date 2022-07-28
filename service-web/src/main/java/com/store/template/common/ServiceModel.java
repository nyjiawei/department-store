package com.store.template.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author：jiawei
 * @CreateTime：2022-07-20 12:14
 * @Description：再restTemplate的请求方法封装一下
 * @Version：1.0
 **/

@Component
public class ServiceModel {

    @Value("${db-service-url}")
    private String SERVICE_URL;

    @Resource
    private RestTemplate restTemplate;

    private String getServiceUrl(String service){
        return SERVICE_URL + "/db/" + service;
    }

    public JSONObject getServiceModel(String service, Object... uriVariables){
        ResponseEntity<JSONObject> res = restTemplate.getForEntity(getServiceUrl(service),
                JSONObject.class,uriVariables);
        return res.getBody();
    }

    public JSONObject postServiceModel(String service, @Nullable Object request, Object... uriVariables){
        ResponseEntity<JSONObject> res = restTemplate.postForEntity(getServiceUrl(service),request,
                JSONObject.class,uriVariables);
        return res.getBody();
    }

    public JSONArray getServiceModelArray(String service, Object... uriVariables) {
        ResponseEntity<JSONArray> res = restTemplate.getForEntity(getServiceUrl(service),
                JSONArray.class, uriVariables);
        return res.getBody();
    }
}
