package com.store.db.service.impl;

import com.store.db.entity.OrderDetail;
import com.store.db.mapper.OrderDetailMapper;
import com.store.db.service.IOrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDetailService {

}
