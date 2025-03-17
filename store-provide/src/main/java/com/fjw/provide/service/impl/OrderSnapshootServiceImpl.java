package com.fjw.provide.service.impl;

import com.fjw.provide.model.Order;
import com.fjw.provide.model.OrderSnapshoot;
import com.fjw.provide.mapper.OrderSnapshootMapper;
import com.fjw.provide.request.OrderSnapshootRequest;
import com.fjw.provide.service.IOrderSnapshootService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fjw.provide.utils.DefinedExceptionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 订单详情/快照 服务实现类
 * </p>
 *
 * @author jiawei
 * @since 2025-03-16
 */
@Service
public class OrderSnapshootServiceImpl extends ServiceImpl<OrderSnapshootMapper, OrderSnapshoot> implements IOrderSnapshootService {

    @Transactional
    @Override
    public void saveOrderSnapshoot(Order order, List<OrderSnapshoot> list) {
        DefinedExceptionUtils.isEmpty(list);
        BigDecimal finaAmount = BigDecimal.ZERO;
        int goodsCount = 0;
        for (OrderSnapshoot item : list){
            item.setId(null);
            item.setOrderId(order.getId());
            item.setOrderNo(order.getOrderNo());
            //小记金额
            item.setSubtotal(item.getPrice().multiply(new BigDecimal(item.getCount())));
            //总金额
            finaAmount = item.getSubtotal().add(finaAmount);
            goodsCount += item.getCount();
        }
        order.setAmount(finaAmount);
        order.setGoodsCount(goodsCount);
        this.saveBatch(list);
    }


}
