package com.store.db.service.impl;

import com.store.db.entity.GoodsCategory;
import com.store.db.mapper.GoodsCategoryMapper;
import com.store.db.service.IGoodsCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品分类表 服务实现类
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@Service
public class GoodsCategoryServiceImpl extends ServiceImpl<GoodsCategoryMapper, GoodsCategory> implements IGoodsCategoryService {

}
