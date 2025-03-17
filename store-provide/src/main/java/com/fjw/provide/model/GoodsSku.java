package com.fjw.provide.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
 * @since 2023-05-01
 */
@Getter
@Setter
@TableName("goods_sku")
@ApiModel(value = "GoodsSku对象", description = "商品库存量表")
public class GoodsSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商品ID")
    @TableField("goods_id")
    private Long goodsId;

    @ApiModelProperty("规格ID")
    @TableField("properties")
    private String properties;

    @ApiModelProperty("规格Id,逗号隔开")
    @TableField("property_ids")
    private String propertyIds;

    @ApiModelProperty("规格")
    @TableField("properties_value")
    private String propertiesValue;

    @ApiModelProperty("规格Json")
    @TableField("properties_obj")
    private String propertiesObj;

    @ApiModelProperty("不同规格商品价格，可有可无值")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty("库存")
    @TableField("stock")
    private Long stock;

    @ApiModelProperty("重量，克")
    @TableField("weight")
    private Long weight;

    @ApiModelProperty("单位")
    @TableField("unit_name")
    private String unitName;

    @ApiModelProperty("封面图片")
    @TableField("cover_picture")
    private String coverPicture;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("创建者")
    @TableField("creator_by")
    private String creatorBy;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("更新人")
    @TableField("update_by")
    private String updateBy;

    @ApiModelProperty("是否有效")
    @TableField("enabled_flag")
    private Boolean enabledFlag;


}
