package com.fjw.provide.mapper;

import com.fjw.provide.model.GoodsPropertyName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 商品属性,用于定制商品配置纬度 Mapper 接口
 * </p>
 *
 * @author jiawei
 * @since 2023-05-01
 */
@Mapper
public interface GoodsPropertyKeyMapper extends BaseMapper<GoodsPropertyName> {

}
