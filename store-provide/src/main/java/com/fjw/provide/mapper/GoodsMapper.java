package com.fjw.provide.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fjw.provide.bo.GoodsBo;
import com.fjw.provide.model.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fjw.provide.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author jiawei
 * @since 2023-05-01
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

    IPage<GoodsVo> search(@Param("page")Page<GoodsVo> page, @Param("bo") GoodsBo bo);

}
