package com.store.db.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.store.db.entity.GoodsPropertyName;
import com.store.db.entity.GoodsPropertyValue;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author：jiawei
 * @CreateTime：2022-07-22 22:33
 * @Description：商品属性包装类
 * @Version：1.0
 **/
@Data
public class GoodsPropertyValueVo {


    private Integer id;

    private Integer cid;

    private String title;

    private String label;

    private List<GoodsPropertyValue> entities;

    public GoodsPropertyValueVo(GoodsPropertyName propertyName,List<GoodsPropertyValue> entities){
        this.id = propertyName.getId();
        this.cid = propertyName.getCid();
        this.title = propertyName.getTitle();
        this.label = propertyName.getLabel();
        this.entities = entities;

    }
}
