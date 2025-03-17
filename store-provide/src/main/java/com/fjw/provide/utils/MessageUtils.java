package com.fjw.provide.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author：jiawei
 * @CreateTime：2025-03-14 16:52
 * @Description：消息队列工具类
 * @Version：1.0
 **/

@Component
public class MessageUtils {

    private static RabbitTemplate rabbitTemplate;

    @Autowired
    private MessageUtils(RabbitTemplate rabbitTemplate){
        MessageUtils.rabbitTemplate = rabbitTemplate;
    }

    public static <T> void sendMessage(String exchange,String routingKey,T t){
        rabbitTemplate.convertAndSend(exchange,routingKey,JSONObject.toJSONString(t));
    }
}
