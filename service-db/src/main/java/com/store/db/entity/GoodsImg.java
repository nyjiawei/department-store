package com.store.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 商品图片表
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@Getter
@Setter
@TableName("goods_img")
@ApiModel(value = "GoodsImg对象", description = "商品图片表")
public class GoodsImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("商品ID")
    @TableField("goods_id")
    private Integer goodsId;

    @ApiModelProperty("商品属性值ID")
    @TableField("property_value_id")
    private Integer propertyValueId;

    @ApiModelProperty("图片URL")
    @TableField("img")
    private String img;

    @ApiModelProperty("添加时间")
    @TableField("add_time")
    private LocalDateTime addTime;


}
