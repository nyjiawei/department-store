package com.fjw.provide.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 订单主表
 * </p>
 *
 * @author jiawei
 * @since 2025-03-16
 */
@Getter
@Setter
@TableName("`order`")
@ApiModel(value = "Order对象", description = "订单主表")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("订单编号")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty("配送地址")
    @TableField("delivery_address")
    private String deliveryAddress;

    @ApiModelProperty("收货人")
    @TableField("addressee")
    private String addressee;

    @ApiModelProperty("联系电话")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty("配送区域")
    @TableField("area")
    private String area;

    @ApiModelProperty("付款时间")
    @TableField("payment_time")
    private LocalDateTime paymentTime;

    @ApiModelProperty("订单状态:未付款,已付款,已发货,已签收,退货申请,退货中,已退货,取消交易")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("用户ID")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("商品计数")
    @TableField("goods_count")
    private Integer goodsCount;

    @ApiModelProperty("商品总价")
    @TableField("amount")
    private BigDecimal amount;

    @ApiModelProperty("订单实付")
    @TableField("real_amount")
    private BigDecimal realAmount;

    @ApiModelProperty("订单物流编号 订单物流表自动编号")
    @TableField("order_logistics_id")
    private String orderLogisticsId;

    @ApiModelProperty("运费")
    @TableField("logistics_fee")
    private BigDecimal logisticsFee;

    @ApiModelProperty("支付渠道")
    @TableField("pay_channel")
    private String payChannel;

    @ApiModelProperty("订单支付单号 (第三方支付流水号)")
    @TableField("escrow_trade_no")
    private String escrowTradeNo;

    @ApiModelProperty("发票ID")
    @TableField("invoice_id")
    private Long invoiceId;

    @ApiModelProperty("是否需要发票")
    @TableField("need_invoice")
    private Boolean needInvoice;

    @ApiModelProperty("用户备注")
    @TableField("remark")
    private String remark;

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

    @TableField(exist = false)
    private List<OrderSnapshoot> snapshootList;


}
