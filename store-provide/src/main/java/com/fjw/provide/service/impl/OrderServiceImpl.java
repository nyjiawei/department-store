package com.fjw.provide.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fjw.provide.constants.Constants;
import com.fjw.provide.enums.OrderStatusEnum;
import com.fjw.provide.model.GoodsImg;
import com.fjw.provide.model.Order;
import com.fjw.provide.mapper.OrderMapper;
import com.fjw.provide.model.OrderSnapshoot;
import com.fjw.provide.request.OrderSnapshootRequest;
import com.fjw.provide.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fjw.provide.service.IOrderSnapshootService;
import com.fjw.provide.utils.ContextUtils;
import com.fjw.provide.utils.MessageUtils;
import com.fjw.provide.utils.OrderUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Wrapper;
import java.util.List;

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

    @Autowired
    private IOrderSnapshootService orderSnapshootService;

    @Transactional
    @Override
    public String create(OrderSnapshootRequest orderSnapshoot) {
        Order newOrder = createOrderModel(orderSnapshoot);
        //订单主体存表
        this.save(newOrder);
        //订单详细存表
        orderSnapshootService.saveOrderSnapshoot(newOrder,orderSnapshoot.getEntries());
        //计算金额后填充更新
        this.updateById(newOrder);
        //发送到延迟队列
        MessageUtils.sendMessageJson(Constants.ORDER_SUBMIT_EXCHANGE,Constants.ORDER_SUBMIT_ROUTING,newOrder);
        //返回订单id
        return newOrder.getId().toString();
    }

    @Override
    public Order getByOrderNo(String orderNo) {
        Order detail = this.getOne(Wrappers.lambdaQuery(Order.class)
                .eq(Order::getOrderNo,orderNo)
                .and((LambdaQueryWrapper<Order> q) -> q.eq(Order::getEnabledFlag,1L)));
        List<OrderSnapshoot> snapshootList = orderSnapshootService.list(Wrappers.lambdaQuery(OrderSnapshoot.class)
                .eq(OrderSnapshoot::getOrderNo,orderNo)
                .and((LambdaQueryWrapper<OrderSnapshoot> q) -> q.eq(OrderSnapshoot::getEnabledFlag,1L)));
        detail.setSnapshootList(snapshootList);
        return detail;
    }

    @Override
    public Order getByOrderId(Long orderId) {
        Order detail = this.getById(orderId);
        List<OrderSnapshoot> snapshootList = orderSnapshootService.list(Wrappers.lambdaQuery(OrderSnapshoot.class)
                .eq(OrderSnapshoot::getOrderId,orderId)
                .and((LambdaQueryWrapper<OrderSnapshoot> q) -> q.eq(OrderSnapshoot::getEnabledFlag,1L)));
        detail.setSnapshootList(snapshootList);
        return detail;
    }

    private Order createOrderModel(OrderSnapshootRequest snapshoot){
        Order order = new Order();
        order.setOrderNo(OrderUtils.getFormatUUId());
        order.setDeliveryAddress(snapshoot.getAddress().getAddressStr());
        order.setAddressee(snapshoot.getAddress().getAddressee());
        order.setMobile(snapshoot.getAddress().getMobile());
        order.setArea(snapshoot.getAddress().getArea());
        order.setStatus(OrderStatusEnum.UNPAID.getCode());
        order.setUserId(ContextUtils.getUserId());
        order.setCreatorBy(ContextUtils.getUserInfo().getUsername());
        order.setUpdateBy(ContextUtils.getUserInfo().getUsername());
        return order;
    }
}
