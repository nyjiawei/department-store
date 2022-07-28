package com.store.template.controller;

import com.alibaba.fastjson.JSONObject;
import com.store.template.common.ServiceModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;


/**
 * @Author：jiawei
 * @CreateTime：2022-07-19 12:21
 * @Description：通过HTTP请求调用 db业务层
 * @Version：1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private ServiceModel serviceModel;

    @ApiOperation(value = "新增配送地址",notes = "用户新增配送地址")
    @RequestMapping(value = "/delivery-address", method = RequestMethod.POST)
    public JSONObject createDeliveryAddress(@RequestBody Object obj) {
        return serviceModel.getServiceModel("xxxx",obj);
    }

    @ApiOperation(value = "删除配送地址",notes = "用户删除配送地址")
    @RequestMapping(value = "/delivery-address", method = RequestMethod.DELETE)
    public JSONObject deleteDeliveryAddress(@RequestParam(value = "orderNo",required=true) Integer id) {
        return serviceModel.getServiceModel("xxxx",id);
    }

    @ApiOperation(value = "配送地址列表",notes = "用户")
    @RequestMapping(value = "/delivery-address", method = RequestMethod.GET)
    public JSONObject deliveryAddressList(@RequestHeader(value = "username",required=true)String username) {
        return serviceModel.getServiceModel("xxxx",username);
    }

    @ApiOperation(value = "提交订单数据",notes = "用户提交订单数据")
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public JSONObject commitOrder(@RequestBody Object obj) {
        return serviceModel.getServiceModel("xxxx",obj);
    }

    @ApiOperation(value = "订单列表",notes = "用户订单列表")
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public JSONObject orderList(@RequestBody Object obj) {
        return serviceModel.getServiceModel("xxxx",obj);
    }

    @ApiOperation(value = "删除订单",notes = "移动到回收站")
    @RequestMapping(value = "/order", method = RequestMethod.DELETE)
    public JSONObject deleteOrder(@RequestParam(value = "order_no",required=true)String order_no) {
        return serviceModel.getServiceModel("xxxx",order_no);
    }

    @ApiOperation(value = "添加到购物车",notes = "购物车数据持久化")
    @RequestMapping(value = "/shopping-cart", method = RequestMethod.POST)
    public JSONObject addToCart(String userName, String id) {
        // TODO Auto-generated method stub
        return null;
    }

}
