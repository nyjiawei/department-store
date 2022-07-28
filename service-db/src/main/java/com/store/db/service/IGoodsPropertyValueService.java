package com.store.db.service;

import com.store.db.entity.GoodsPropertyValue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品属性值表 服务类
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
public interface IGoodsPropertyValueService extends IService<GoodsPropertyValue> {

    List<GoodsPropertyValue> getListUnionSku(Integer goodsId,Integer propertyNameId);
}
