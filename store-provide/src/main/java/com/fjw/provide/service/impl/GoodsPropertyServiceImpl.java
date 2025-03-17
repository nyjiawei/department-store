package com.fjw.provide.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fjw.provide.model.GoodsProperty;
import com.fjw.provide.mapper.GoodsPropertyMapper;
import com.fjw.provide.service.IGoodsPropertyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品规格配置表 服务实现类
 * </p>
 *
 * @author jiawei
 * @since 2025-02-27
 */
@Service
public class GoodsPropertyServiceImpl extends ServiceImpl<GoodsPropertyMapper, GoodsProperty> implements IGoodsPropertyService {

    public Map<String, List<GoodsProperty>> getGoodsPropertyMap(Long id){
        Map<String, List<GoodsProperty>> res = Collections.emptyMap();
        List<GoodsProperty> goodsProperties = this.list(Wrappers.lambdaQuery(GoodsProperty.class)
                .eq(GoodsProperty::getGoodsId,id)
                .and((LambdaQueryWrapper<GoodsProperty> q) -> q.eq(GoodsProperty::getEnabledFlag,1L)));

        return goodsProperties.stream().collect(Collectors.groupingBy(GoodsProperty::getPropertyName));

    }
}
