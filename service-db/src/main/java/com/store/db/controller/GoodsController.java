package com.store.db.controller;


import com.store.db.entity.Goods;
import com.store.db.service.IGoodsService;
import com.store.db.vo.PageVo;
import com.store.db.vo.ResultVo;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@RestController
@RequestMapping(value ="/db/goods",produces="application/json")
public class GoodsController {

    @Resource
    private IGoodsService goodsService;

    @RequestMapping(method = RequestMethod.GET)
    public PageVo getGoods(Integer pageNo, Integer pageSize, Integer cid, String title, String keywords){
        return goodsService.searchGoods(pageNo,pageSize,cid,title,keywords);
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public ResultVo getGoodsDetail(Integer id){
        return new ResultVo(goodsService.getById(id));
    }

}
