package com.store.db.service;

import com.store.db.entity.GoodsProperty;
import com.baomidou.mybatisplus.extension.service.IService;
import com.store.db.vo.GoodsPropertyValueVo;
import com.store.db.vo.ResultVo;

import java.util.List;

/**
 * <p>
 * 商品规格表 服务类
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
public interface IGoodsPropertyService extends IService<GoodsProperty> {

    /**
     * 获取商品属性
     * @param id 商品ID
     * @return List<GoodsPropertyValueVo>
     */
    public ResultVo getGoodsPropertyById(Integer id);

}
