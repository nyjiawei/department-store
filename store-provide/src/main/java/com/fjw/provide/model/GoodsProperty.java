package com.fjw.provide.model;

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
 * 商品规格配置表
 * </p>
 *
 * @author jiawei
 * @since 2025-02-27
 */
@Getter
@Setter
@TableName("goods_property")
@ApiModel(value = "GoodsProperty对象", description = "商品规格配置表")
public class GoodsProperty implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商品ID")
    @TableField("goods_id")
    private Long goodsId;

    @ApiModelProperty("规格名称")
    @TableField("property_name")
    private String propertyName;

    @ApiModelProperty("规格值")
    @TableField("property_value")
    private String propertyValue;

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
