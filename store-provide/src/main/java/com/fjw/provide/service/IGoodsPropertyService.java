package com.fjw.provide.service;

import com.fjw.provide.model.GoodsProperty;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品规格配置表 服务类
 * </p>
 *
 * @author jiawei
 * @since 2025-02-27
 */
public interface IGoodsPropertyService extends IService<GoodsProperty> {

    public Map<String, List<GoodsProperty>> getGoodsPropertyMap(Long id);
}
