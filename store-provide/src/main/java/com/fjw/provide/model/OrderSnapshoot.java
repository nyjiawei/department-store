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
 * 订单详情/快照
 * </p>
 *
 * @author jiawei
 * @since 2025-03-16
 */
@Getter
@Setter
@TableName("order_snapshoot")
@ApiModel(value = "OrderSnapshoot对象", description = "订单详情/快照")
public class OrderSnapshoot implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("订单id")
    @TableField("order_id")
    private Long orderId;

    @ApiModelProperty("订单编号")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty("商品编号")
    @TableField("goods_no")
    private String goodsNo;

    @ApiModelProperty("商品id")
    @TableField("goods_id")
    private Long goodsId;

    @ApiModelProperty("商品名快照")
    @TableField("title")
    private String title;

    @ApiModelProperty("skuID")
    @TableField("sku_id")
    private Long skuId;

    @ApiModelProperty("封面图片")
    @TableField("image_url")
    private String imageUrl;

    @ApiModelProperty("价格快照")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty("商品品牌")
    @TableField("marque")
    private String marque;

    @ApiModelProperty("商品仓库条码")
    @TableField("store_barcode")
    private String storeBarcode;

    @ApiModelProperty("记录详细商品型号，如颜色、规格、包装等")
    @TableField("mode_desc")
    private String modeDesc;

    @ApiModelProperty("JSON格式规格")
    @TableField("mode_params")
    private String modeParams;

    @ApiModelProperty("折扣")
    @TableField("discount_rate")
    private Integer discountRate;

    @ApiModelProperty("折扣金额")
    @TableField("discount_amount")
    private BigDecimal discountAmount;

    @ApiModelProperty("购买数量")
    @TableField("count")
    private Integer count;

    @ApiModelProperty("小记金额")
    @TableField("subtotal")
    private BigDecimal subtotal;

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
