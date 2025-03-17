package com.fjw.provide.model;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
 * @since 2023-05-01
 */
@Getter
@Setter
@TableName("goods")
@ApiModel(value = "Goods对象", description = "商品表")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("分类ID")
    @TableField("cid")
    private Long cid;

    @ApiModelProperty("商品名称")
    @TableField("title")
    private String title;

    @ApiModelProperty("商品规格，json集合类型")
    @TableField(exist = false)
    private String spec;

    @ApiModelProperty("商品内容详细，富文本")
    @TableField(exist = false)
    private String content;

    @ApiModelProperty("商品编码")
    @TableField("pro_no")
    private String proNo;

    @ApiModelProperty("关键字，方便搜索")
    @TableField("keywords")
    private String keywords;

    @ApiModelProperty("主图")
    @TableField("img_url")
    private String imgUrl;

    @ApiModelProperty("价格")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty("描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("点击量，统计流量")
    @TableField("pv")
    private Long pv;

    @ApiModelProperty("商品状态 0 下架 1 上架")
    @TableField("`status`")
    private Integer status;

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
    @TableLogic
    private Boolean enabledFlag;

    @TableField(exist = false)
    private GoodsContent contents;

    @TableField(exist = false)
    private List<GoodsImg> imageList;

    @TableField(exist = false)
    private Map<String, List<GoodsProperty>> propertyMap;
}
