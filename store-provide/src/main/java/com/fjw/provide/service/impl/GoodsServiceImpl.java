package com.fjw.provide.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fjw.provide.bo.GoodsBo;
import com.fjw.provide.model.*;
import com.fjw.provide.mapper.GoodsMapper;
import com.fjw.provide.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fjw.provide.utils.PageUtils;
import com.fjw.provide.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author jiawei
 * @since 2023-05-01
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {


    @Autowired
    private IGoodsImgService goodsImgService;
    @Autowired
    private IGoodsSkuService goodsSkuService;
    @Autowired
    private IGoodsPropertyService goodsPropertyService;
    @Autowired
    private IGoodsContentService goodsContentService;


    @Override
    public IPage<GoodsVo> search(GoodsBo bo) {
        Page<GoodsVo> page =  PageUtils.getPageInstance(bo);
        return this.getBaseMapper().search(page,bo);
    }

    @Override
    public Goods getDetail(Long id) {
        Goods goods = this.getById(id);
        Assert.notNull(goods,"该商品不存在");
        //图片
        List<GoodsImg> goodsImages = goodsImgService.list(Wrappers.lambdaQuery(GoodsImg.class)
                .eq(GoodsImg::getGoodsId,id)
                .and((LambdaQueryWrapper<GoodsImg> q) -> q.eq(GoodsImg::getEnabledFlag,1L)) );
        //规格
        goods.setPropertyMap(goodsPropertyService.getGoodsPropertyMap(id) );
        goods.setImageList(goodsImages);
        //内容介绍
        goods.setContents(goodsContentService.getByGoodsId(id));
        return goods;
    }

}
