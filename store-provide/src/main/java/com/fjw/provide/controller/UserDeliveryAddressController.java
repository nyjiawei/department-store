package com.fjw.provide.controller;

import com.fjw.provide.common.model.ResponseData;
import com.fjw.provide.model.UserDeliveryAddress;
import com.fjw.provide.service.IUserDeliveryAddressService;
import com.fjw.provide.utils.ContextUtils;
import com.fjw.provide.utils.DefinedExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户配送地址表 前端控制器
 * </p>
 *
 * @author jiawei
 * @since 2025-03-07
 */
@RestController
@RequestMapping("/user-delivery-address")
public class UserDeliveryAddressController {
    @Autowired
    private IUserDeliveryAddressService deliveryAddressService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseData<String> save(@RequestBody UserDeliveryAddress body) {
       ResponseData<String> response = new ResponseData<>();
       response.setData(deliveryAddressService.saveOrUpdateDef(body));
       return response;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseData<List<UserDeliveryAddress>> list() {
        ResponseData<List<UserDeliveryAddress>> response = new ResponseData<>();
        response.setData(deliveryAddressService.getList());
        return response;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public ResponseData<Boolean> delete(@RequestParam(value = "id") Long id) {
        ResponseData<Boolean> response = new ResponseData<>();
        response.setData(deliveryAddressService.removeById(id));
        return response;
    }


}
