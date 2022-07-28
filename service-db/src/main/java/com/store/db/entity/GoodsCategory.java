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
 * 商品分类表
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@Getter
@Setter
@TableName("goods_category")
@ApiModel(value = "GoodsCategory对象", description = "商品分类表")
public class GoodsCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("上级分类ID")
    @TableField("pid")
    private Integer pid;

    @ApiModelProperty("排序数值")
    @TableField("ord")
    private Integer ord;

    @ApiModelProperty("标签")
    @TableField("title")
    private String title;

    @ApiModelProperty("状态 1正常 ，0 禁用")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("添加时间")
    @TableField("add_time")
    private LocalDateTime addTime;


}
