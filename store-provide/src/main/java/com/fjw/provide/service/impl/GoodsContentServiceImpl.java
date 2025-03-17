package com.fjw.provide.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fjw.provide.model.GoodsContent;
import com.fjw.provide.mapper.GoodsContentMapper;
import com.fjw.provide.model.GoodsImg;
import com.fjw.provide.service.IGoodsContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品详细描述 服务实现类
 * </p>
 *
 * @author jiawei
 * @since 2025-03-11
 */
@Service
public class GoodsContentServiceImpl extends ServiceImpl<GoodsContentMapper, GoodsContent> implements IGoodsContentService {

    @Override
    public GoodsContent getByGoodsId(Long goodsId) {
        return getBaseMapper().selectOne(Wrappers.lambdaQuery(GoodsContent.class)
                .eq(GoodsContent::getGoodsId,goodsId)
                .and((LambdaQueryWrapper<GoodsContent> q) -> q.eq(GoodsContent::getEnabledFlag,1L)));
    }
}
