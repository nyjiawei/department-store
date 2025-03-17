package com.fjw.provide.service;

import com.fjw.provide.model.Order;
import com.fjw.provide.model.OrderSnapshoot;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fjw.provide.request.OrderSnapshootRequest;

import java.util.List;

/**
 * <p>
 * 订单详情/快照 服务类
 * </p>
 *
 * @author jiawei
 * @since 2025-03-16
 */
public interface IOrderSnapshootService extends IService<OrderSnapshoot> {

    void saveOrderSnapshoot(Order order, List<OrderSnapshoot> list);

}
