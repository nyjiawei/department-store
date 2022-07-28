package com.store.db.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.store.db.entity.GoodsImg;
import com.store.db.service.IGoodsImgService;
import com.store.db.vo.GoodsPropertyValueVo;
import com.store.db.vo.ResultVo;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 商品图片表 前端控制器
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@RestController
@RequestMapping("/db/goods-img")
public class GoodsImgController {

    @Resource
    private IGoodsImgService goodsImgService;

    @RequestMapping(method = RequestMethod.GET)
    public ResultVo getGoodsProperty(@RequestParam Integer id){
        QueryWrapper<GoodsImg> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_id",id);
        return new ResultVo(goodsImgService.list(queryWrapper));
    }
}
