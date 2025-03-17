package com.fjw.provide.controller;


import com.fjw.provide.common.model.ResponseData;
import com.fjw.provide.enums.OrderStatusEnum;
import com.fjw.provide.model.Order;
import com.fjw.provide.request.OrderSnapshootRequest;
import com.fjw.provide.service.IOrderService;
import com.fjw.provide.utils.ContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 订单主表 前端控制器
 * </p>
 *
 * @author jiawei
 * @since 2025-03-16
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    public IOrderService orderService;

    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public ResponseData<String> submit(@RequestBody OrderSnapshootRequest snapshoot){
        ResponseData<String> response = new ResponseData<>();
        response.setData(orderService.create(snapshoot));
        return response;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseData<List<Order>> list(){
        ResponseData<List<Order>> response = new ResponseData<>();
        //todo
        response.setData(null);
        return response;
    }


    @RequestMapping(value = "/getByOrderId",method = RequestMethod.GET)
    public ResponseData<Order> getByOrderId(@RequestParam(value = "id") @NotNull Long id){
        ResponseData<Order> response = new ResponseData<>();
        response.setData(orderService.getByOrderId(id));
        return response;
    }

    @RequestMapping(value = "/getByOrderNo",method = RequestMethod.GET)
    public ResponseData<Order> getByOrderNo(@RequestParam(value = "orderNo") @NotBlank String orderNo){
        ResponseData<Order> response = new ResponseData<>();
        response.setData(orderService.getByOrderNo(orderNo));
        return response;
    }



}
