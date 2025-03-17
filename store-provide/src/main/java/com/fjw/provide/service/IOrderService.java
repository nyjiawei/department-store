package com.fjw.provide.service;

import com.fjw.provide.model.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fjw.provide.request.OrderSnapshootRequest;

/**
 * <p>
 * 订单主表 服务类
 * </p>
 *
 * @author jiawei
 * @since 2025-03-16
 */
public interface IOrderService extends IService<Order> {

    String create(OrderSnapshootRequest orderSnapshoot);
}
