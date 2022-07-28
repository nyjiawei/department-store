package com.store.db.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.store.db.entity.GoodsImg;
import com.store.db.entity.GoodsSku;
import com.store.db.service.IGoodsImgService;
import com.store.db.service.IGoodsSkuService;
import com.store.db.vo.ResultVo;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 商品库存量表 前端控制器
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@RestController
@RequestMapping("/db/goods-sku")
public class GoodsSkuController {

    @Resource
    private IGoodsSkuService goodsSkuService;

    @RequestMapping(method = RequestMethod.GET)
    public ResultVo getGoodsSkuList(@RequestParam Integer id){
        QueryWrapper<GoodsSku> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_id",id);
        return new ResultVo(goodsSkuService.list(queryWrapper));
    }

}
