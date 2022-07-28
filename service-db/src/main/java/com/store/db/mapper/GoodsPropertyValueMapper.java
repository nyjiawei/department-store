package com.store.db.mapper;

import com.store.db.entity.GoodsPropertyValue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品属性值表 Mapper 接口
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@Mapper
public interface GoodsPropertyValueMapper extends BaseMapper<GoodsPropertyValue> {

    List<GoodsPropertyValue> findListUnionSku(@Param("goodsId") Integer goodsId, @Param("propertyNameId")Integer propertyNameId);
}
