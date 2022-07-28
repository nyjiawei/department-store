package com.store.db.mapper;

import com.store.db.entity.GoodsCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 商品分类表 Mapper 接口
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@Mapper
public interface GoodsCategoryMapper extends BaseMapper<GoodsCategory> {

}
