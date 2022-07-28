package com.store.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 商品属性,用于定制商品配置纬度
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@Getter
@Setter
@TableName("goods_property_name")
@ApiModel(value = "GoodsPropertyName对象", description = "商品属性,用于定制商品配置纬度")
public class GoodsPropertyName implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("所属类目ID,与商品信息表中的cid对应 与商品类目表中的ID对应")
    @TableField("cid")
    private Integer cid;

    @ApiModelProperty("属性名,例如：颜色 版本 尺寸")
    @TableField("title")
    private String title;

    @ApiModelProperty("属性英文别名")
    @TableField("label")
    private String label;

}
