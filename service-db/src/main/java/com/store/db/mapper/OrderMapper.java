package com.store.db.mapper;

import com.store.db.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单 Mapper 接口
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
