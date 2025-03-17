package com.fjw.provide.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fjw.provide.model.GoodsSku;
import com.fjw.provide.mapper.GoodsSkuMapper;
import com.fjw.provide.service.IGoodsSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * <p>
 * 商品库存量表 服务实现类
 * </p>
 *
 * @author jiawei
 * @since 2023-05-01
 */
@Service
public class GoodsSkuServiceImpl extends ServiceImpl<GoodsSkuMapper, GoodsSku> implements IGoodsSkuService {

    @Override
    public GoodsSku getSkuByGoodsSpec(String goodsId,String spec){
        GoodsSku sku = this.getBaseMapper().selectOne(Wrappers.lambdaQuery(GoodsSku.class)
                .eq(GoodsSku::getGoodsId,goodsId)
                .and((LambdaQueryWrapper<GoodsSku> q) -> q.eq(GoodsSku::getProperties,spec))
                .and((LambdaQueryWrapper<GoodsSku> q) -> q.eq(GoodsSku::getEnabledFlag,1L)));
        return sku;

    }

    @Override
    public List<GoodsSku> listByGoods(String goodsId) {
        List<GoodsSku> skus = this.getBaseMapper().selectList(Wrappers.lambdaQuery(GoodsSku.class)
                .eq(GoodsSku::getGoodsId,goodsId)
                .and((LambdaQueryWrapper<GoodsSku> q) -> q.eq(GoodsSku::getEnabledFlag,1L)));
        return skus;
    }

}
