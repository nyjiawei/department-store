package com.fjw.provide.service.impl;

import com.fjw.provide.constants.Constants;
import com.fjw.provide.model.Order;
import com.fjw.provide.mapper.OrderMapper;
import com.fjw.provide.request.OrderSnapshootRequest;
import com.fjw.provide.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fjw.provide.utils.MessageUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单主表 服务实现类
 * </p>
 *
 * @author jiawei
 * @since 2025-03-16
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {


    @Override
    public String create(OrderSnapshootRequest orderSnapshoot) {
        //todo  存表
        //todo 发送到延迟队列
        MessageUtils.sendMessage(Constants.ORDER_SUBMIT_EXCHANGE,Constants.ORDER_SUBMIT_ROUTING,orderSnapshoot);
        //todo 返回订单号

        return "";
    }
}
