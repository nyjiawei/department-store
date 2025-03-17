package com.fjw.provide.mapper;

import com.fjw.provide.model.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单主表 Mapper 接口
 * </p>
 *
 * @author jiawei
 * @since 2025-03-16
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
