package com.fjw.provide.service;

import com.fjw.provide.model.GoodsContent;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品详细描述 服务类
 * </p>
 *
 * @author jiawei
 * @since 2025-03-11
 */
public interface IGoodsContentService extends IService<GoodsContent> {

    GoodsContent getByGoodsId(Long goodsId);

}
