package com.fjw.provide.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fjw.provide.bo.GoodsBo;
import com.fjw.provide.model.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fjw.provide.vo.GoodsVo;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author jiawei
 * @since 2023-05-01
 */
public interface IGoodsService extends IService<Goods> {

    IPage<GoodsVo> search(GoodsBo bo);

    Goods getDetail(Long id);
}
