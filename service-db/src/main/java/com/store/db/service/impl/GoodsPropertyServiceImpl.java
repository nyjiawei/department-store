package com.store.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.store.db.entity.GoodsProperty;
import com.store.db.entity.GoodsPropertyName;
import com.store.db.entity.GoodsPropertyValue;
import com.store.db.mapper.GoodsPropertyMapper;
import com.store.db.service.IGoodsPropertyNameService;
import com.store.db.service.IGoodsPropertyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.store.db.service.IGoodsPropertyValueService;
import com.store.db.vo.GoodsPropertyValueVo;
import com.store.db.vo.ResultVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品规格表 服务实现类
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@Service
public class GoodsPropertyServiceImpl extends ServiceImpl<GoodsPropertyMapper, GoodsProperty> implements IGoodsPropertyService {

    @Resource
    private IGoodsPropertyValueService goodsPropertyValueService;

    @Resource
    private IGoodsPropertyNameService goodsPropertyNameService;


    @Override
    public ResultVo getGoodsPropertyById(Integer id) {
        QueryWrapper<GoodsProperty> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_id",id);
        //所有属性
        List<GoodsProperty> propertyList = list(queryWrapper);
        if (propertyList.size() == 0){
            return new ResultVo(propertyList);
        }
        //所有属性名
        List<GoodsPropertyName> propertyNameList = goodsPropertyNameService.listByIds(propertyList.stream().map(p -> p.getNameId()).collect(Collectors.toList()));

        List<GoodsPropertyValueVo> res = new ArrayList<>();
        //遍历所有属性值
        for (GoodsPropertyName propertyName: propertyNameList) {
            QueryWrapper<GoodsPropertyValue> valueQueryWrapper = new QueryWrapper<>();
            valueQueryWrapper.eq("name_id",propertyName.getId());
            List<GoodsPropertyValue> propertyValueList = goodsPropertyValueService.getListUnionSku(id,propertyName.getId());
            res.add(new GoodsPropertyValueVo(propertyName,propertyValueList));
        }
        return new ResultVo(res);
    }
}
