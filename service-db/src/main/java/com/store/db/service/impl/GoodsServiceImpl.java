package com.store.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.store.db.entity.Goods;
import com.store.db.mapper.GoodsMapper;
import com.store.db.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.store.db.vo.PageVo;
import com.store.db.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public PageVo searchGoods(Integer pageNo, Integer pageSize, Integer cid, String title, String keywords) {
        Page<Goods> queryPage = new Page<>(pageNo,pageSize);
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();

        if (cid != null && cid > 0 ){
            queryWrapper.eq("cid", cid);
        }
        if (StringUtils.isNotEmpty(title)){
            queryWrapper.and(q -> queryWrapper.like("title", title));
        }
        if (StringUtils.isNotEmpty(keywords)){
            queryWrapper.and(q -> queryWrapper.like("keywords", keywords));
        }
        long count = count(queryWrapper);
        IPage<Goods> iPage = goodsMapper.selectPage(queryPage,queryWrapper);
        iPage.setTotal(count);
        return new PageVo(iPage);
    }

}
