package com.fjw.provide.request;

import com.fjw.provide.model.OrderSnapshoot;
import com.fjw.provide.model.UserDeliveryAddress;
import lombok.Data;

import java.util.List;

/**
 * @Author：jiawei
 * @CreateTime：2025-03-11 21:11
 * @Description：订单发起（快照）
 * @Version：1.0
 **/
@Data
public class OrderSnapshootRequest {

    /**
     * 收货地址快照
     */
    private UserDeliveryAddress address;

    /**
     * 商品列表
     */
    private List<OrderSnapshoot> entries;
}
