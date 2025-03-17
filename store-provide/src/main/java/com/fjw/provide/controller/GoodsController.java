package com.fjw.provide.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fjw.provide.bo.GoodsBo;
import com.fjw.provide.common.model.GeneralBo;
import com.fjw.provide.common.model.ResponseData;
import com.fjw.provide.model.Goods;
import com.fjw.provide.service.IGoodsService;
import com.fjw.provide.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author jiawei
 * @since 2023-05-01
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public ResponseData<IPage<GoodsVo>> search(@RequestBody GoodsBo bo){
        ResponseData<IPage<GoodsVo>> response = new ResponseData<>();
        response.setData(goodsService.search(bo));
        return response;
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public ResponseData<Goods> detail(@RequestParam Long id){
        ResponseData<Goods> response = new ResponseData<>();
        response.setData(goodsService.getDetail(id));
        return response;
    }

}
