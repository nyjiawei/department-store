package com.store.db.mapper;

import com.store.db.entity.GoodsSku;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 商品库存量表 Mapper 接口
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@Mapper
public interface GoodsSkuMapper extends BaseMapper<GoodsSku> {

}
