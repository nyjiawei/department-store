package com.store.db.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.store.db.entity.GoodsContent;
import com.store.db.service.IGoodsContentService;
import com.store.db.vo.ResultVo;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 商品详细描述 前端控制器
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@RestController
@RequestMapping("/db/goods-content")
public class GoodsContentController {
    @Resource
    private IGoodsContentService goodsContentService;

    @RequestMapping(method = RequestMethod.GET)
    public ResultVo getGoodsProperty(@RequestParam Integer id){
        QueryWrapper<GoodsContent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_id",id);
        return new ResultVo(goodsContentService.getOne(queryWrapper));
    }
}
