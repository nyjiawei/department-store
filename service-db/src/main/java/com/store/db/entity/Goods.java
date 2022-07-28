package com.store.db.entity;

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
 * 商品表
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@Getter
@Setter
@TableName("goods")
@ApiModel(value = "Goods对象", description = "商品表")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("分类ID")
    @TableField("cid")
    private Integer cid;

    @ApiModelProperty("商品名称")
    @TableField("title")
    private String title;

    @ApiModelProperty("商品编码")
    @TableField("pro_no")
    private String proNo;

    @ApiModelProperty("关键字，方便搜索")
    @TableField("keywords")
    private String keywords;

    @ApiModelProperty("主图")
    @TableField("img")
    private String img;

    @ApiModelProperty("价格")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty("描述")
    @TableField("`desc`")
    private String desc;

    @ApiModelProperty("点击量，统计流量")
    @TableField("pv")
    private Integer pv;

    @ApiModelProperty("商品状态 -1 已删除 0 下架 1 上架")
    @TableField("`status`")
    private Integer status;

    @ApiModelProperty("添加时间")
    @TableField("add_time")
    private LocalDateTime addTime;

    @ApiModelProperty("规格")
    @TableField("`property`")
    private String property;

}
