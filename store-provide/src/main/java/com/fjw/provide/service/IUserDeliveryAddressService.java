package com.fjw.provide.service;

import com.fjw.provide.model.UserDeliveryAddress;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户配送地址表 服务类
 * </p>
 *
 * @author jiawei
 * @since 2025-03-07
 */
public interface IUserDeliveryAddressService extends IService<UserDeliveryAddress> {

    List<UserDeliveryAddress> getList();

    String saveOrUpdateDef(UserDeliveryAddress data);

}
