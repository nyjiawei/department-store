package com.fjw.provide.controller;


import com.fjw.provide.common.model.ResponseData;
import com.fjw.provide.request.OrderSnapshootRequest;
import com.fjw.provide.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

}
