package com.fjw.provide.controller;


import com.fjw.provide.common.model.ResponseData;
import com.fjw.provide.model.GoodsSku;
import com.fjw.provide.service.IGoodsSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;


/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author jiawei
 * @since 2023-05-01
 */
@RestController
@RequestMapping("/sku")
public class GoodsSkuController {

    @Autowired
    private IGoodsSkuService goodsSkuService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ResponseData<GoodsSku> get(@RequestParam @Validated @NotBlank String id){
        ResponseData<GoodsSku> response = new ResponseData<>();
        response.setData(goodsSkuService.getById(id));
        return response;
    }

    @RequestMapping(value = "/getBySpec",method = RequestMethod.GET)
    public ResponseData<GoodsSku> getBySpec(@RequestParam @Validated @NotBlank String goodsId, @NotBlank String spec){
        ResponseData<GoodsSku> response = new ResponseData<>();
        response.setData(goodsSkuService.getSkuByGoodsSpec(goodsId,spec));
        return response;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseData<List<GoodsSku>> list(@RequestParam @Validated @NotBlank String goodsId){
        ResponseData<List<GoodsSku>> response = new ResponseData<>();
        response.setData(goodsSkuService.listByGoods(goodsId));
        return response;
    }

}
