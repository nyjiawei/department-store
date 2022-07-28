package com.store.db.controller;


import com.store.db.service.IGoodsPropertyService;
import com.store.db.vo.GoodsPropertyValueVo;
import com.store.db.vo.ResultVo;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商品规格表 前端控制器
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@RestController
@RequestMapping("/db/goods-property")
public class GoodsPropertyController {

    @Resource
    private IGoodsPropertyService goodsPropertyService;

    @RequestMapping(method = RequestMethod.GET)
    public ResultVo getGoodsProperty(@RequestParam Integer id){
        return goodsPropertyService.getGoodsPropertyById(id);
    }

}
