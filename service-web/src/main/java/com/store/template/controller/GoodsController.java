package com.store.template.controller;

import com.alibaba.fastjson.JSONObject;
import com.store.template.common.ServiceModel;
import com.store.template.vo.request.GoodsReq;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Author：jiawei
 * @CreateTime：2022-07-19 12:21
 * @Description：通过HTTP请求调用 db业务层
 * @Version：1.0
 **/
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private ServiceModel serviceModel;


    @ApiOperation(value = "商品列表",notes = "查询页码提供基础商品数据")
    @RequestMapping(method = RequestMethod.POST)
    public JSONObject searchGoods(@RequestBody @Validated GoodsReq goodsReq){
        return serviceModel.getServiceModel("goods?pageNo={no}&pageSize={size}&cid={cid}&title={title}&keywords={keywords}"
                ,goodsReq.getPageNo(),goodsReq.getPageSize(),goodsReq.getCid(),goodsReq.getTitle(),goodsReq.getKeywords());
    }

    @ApiOperation(value = "商品基础信息",notes = "商品详情")
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public JSONObject getGoodsDetail(@NotNull(message = "id不能是空或小于等于0") @Min(value = 1) Integer id){
        return serviceModel.getServiceModel("goods/detail?id={id}",id);
    }

    @ApiOperation(value = "商品库存",notes = "商品详情")
    @RequestMapping(value = "/sku",method = RequestMethod.GET)
    public JSONObject getGoodsSku(@NotNull(message = "id不能是空或小于等于0") @Min(value = 1) Integer id){
        return serviceModel.getServiceModel("goods-sku?id={id}",id);
    }


    @ApiOperation(value = "商品属性列表",notes = "商品详情")
    @RequestMapping(value = "/properties",method = RequestMethod.GET)
    public JSONObject getGoodsProperties(@NotNull(message = "id不能是空或小于等于0") @Min(value = 1) Integer id){
        return serviceModel.getServiceModel("goods-property?id={id}",id);
    }

    @ApiOperation(value = "商品属性图片列表",notes = "商品详情")
    @RequestMapping(value = "/property-images",method = RequestMethod.GET)
    public JSONObject getGoodsPropertyImg(@NotNull(message = "id不能是空或小于等于0") @Min(value = 1) Integer id){
        return serviceModel.getServiceModel("goods-img?id={id}",id);
    }

    @ApiOperation(value = "商品介绍",notes = "商品详情")
    @RequestMapping(value = "/content",method = RequestMethod.GET)
    public JSONObject getGoodsContent(@NotNull(message = "id不能是空或小于等于0") @Min(value = 1) Integer id){
        return serviceModel.getServiceModel("goods-content?id={id}",id);
    }
}
