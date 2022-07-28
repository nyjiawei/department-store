package com.store.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 商品库存量表
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@Getter
@Setter
@TableName("goods_sku")
@ApiModel(value = "GoodsSku对象", description = "商品库存量表")
public class GoodsSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("商品ID")
    @TableField("goods_id")
    private Integer goodsId;

    @ApiModelProperty("属性键ID")
    @TableField("property_name_id")
    private Integer propertyNameId;

    @ApiModelProperty("属性值ID")
    @TableField("property_value_id")
    private Integer propertyValueId;

    @ApiModelProperty("不同规格商品价格(在标配价格之上的递增价格)，可无值")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty("库存")
    @TableField("stock")
    private Integer stock;

    @ApiModelProperty("重量，克")
    @TableField("weight")
    private Integer weight;


}
