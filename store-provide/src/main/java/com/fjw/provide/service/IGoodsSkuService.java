package com.fjw.provide.service;

import com.fjw.provide.model.GoodsSku;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品库存量表 服务类
 * </p>
 *
 * @author jiawei
 * @since 2023-05-01
 */
public interface IGoodsSkuService extends IService<GoodsSku> {

    GoodsSku getSkuByGoodsSpec(String goodsId,String spec);

    List<GoodsSku> listByGoods(String goodsId);
}
