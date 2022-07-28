package com.store.db.service.impl;

import com.store.db.entity.GoodsPropertyValue;
import com.store.db.mapper.GoodsPropertyValueMapper;
import com.store.db.service.IGoodsPropertyValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商品属性值表 服务实现类
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@Service
public class GoodsPropertyValueServiceImpl extends ServiceImpl<GoodsPropertyValueMapper, GoodsPropertyValue> implements IGoodsPropertyValueService {

    @Resource
    private GoodsPropertyValueMapper mapper;

    @Override
    public List<GoodsPropertyValue> getListUnionSku(Integer goodsId, Integer propertyNameId) {
        return mapper.findListUnionSku(goodsId,propertyNameId);
    }
}
