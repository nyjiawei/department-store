package com.store.db.service;

import com.store.db.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.store.db.vo.PageVo;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
public interface IGoodsService extends IService<Goods> {

    public PageVo searchGoods(Integer pageNo, Integer pageSize, Integer cid, String title, String keywords);
}
