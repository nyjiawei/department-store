package com.fjw.provide.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fjw.provide.model.UserDeliveryAddress;
import com.fjw.provide.mapper.UserDeliveryAddressMapper;
import com.fjw.provide.service.IUserDeliveryAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fjw.provide.utils.ContextUtils;
import com.fjw.provide.utils.DefinedExceptionUtils;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 用户配送地址表 服务实现类
 * </p>
 *
 * @author jiawei
 * @since 2025-03-07
 */
@Service
public class UserDeliveryAddressServiceImpl extends ServiceImpl<UserDeliveryAddressMapper, UserDeliveryAddress> implements IUserDeliveryAddressService {


    @Override
    public List<UserDeliveryAddress> getList() {
        Long userId = ContextUtils.getUserId();
        DefinedExceptionUtils.isNull(userId);
        return this.list(Wrappers.lambdaQuery(UserDeliveryAddress.class)
                .eq(UserDeliveryAddress::getCreatorBy,userId)
                .and((LambdaQueryWrapper<UserDeliveryAddress> q) -> q.eq(UserDeliveryAddress::getEnabledFlag,1L)));

    }

    @Override
    public String saveOrUpdateDef(UserDeliveryAddress data) {
        DefinedExceptionUtils.isNull(ContextUtils.getUserId());
        //ID为空视为新增
        if (Objects.isNull(data.getId())){
            data.setCreatorBy(ContextUtils.getUserId().toString());
            this.save(data);
        }else {
            data.setUpdateBy(ContextUtils.getUserId().toString());
            this.updateById(data);
        }
        return data.getId().toString();
    }
}
