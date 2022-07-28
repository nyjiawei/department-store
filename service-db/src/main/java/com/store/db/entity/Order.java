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
 * 订单
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@Getter
@Setter
@TableName("order")
@ApiModel(value = "Order对象", description = "订单")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("订单编号表中唯一")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty("配送地址ID")
    @TableField("delivery_address_id")
    private Integer deliveryAddressId;

    @ApiModelProperty("下单时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("付款时间")
    @TableField("payment_time")
    private LocalDateTime paymentTime;

    @ApiModelProperty("订单状态:未付款,已付款,已发货,已签收,退货申请,退货中,已退货,取消交易")
    @TableField("status")
    private String status;

    @ApiModelProperty("用户ID")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty("商品计数")
    @TableField("goods_count")
    private Integer goodsCount;

    @ApiModelProperty("商品总价")
    @TableField("amount_total")
    private String amountTotal;

    @ApiModelProperty("订单实付")
    @TableField("order_amount_total")
    private String orderAmountTotal;

    @ApiModelProperty("订单物流编号 订单物流表自动编号")
    @TableField("order_logistics_id")
    private String orderLogisticsId;

    @ApiModelProperty("运费")
    @TableField("logistics_fee")
    private String logisticsFee;

    @ApiModelProperty("支付渠道")
    @TableField("pay_channel")
    private String payChannel;

    @ApiModelProperty("订单支付单号 (第三方支付流水号)")
    @TableField("escrow_trade_no")
    private String escrowTradeNo;

    @ApiModelProperty("发票ID")
    @TableField("invoice_id")
    private Integer invoiceId;

    @ApiModelProperty("是否需要发票")
    @TableField("need_invoice")
    private Boolean needInvoice;

    @ApiModelProperty("用户备注")
    @TableField("comment")
    private String comment;

    @ApiModelProperty("逻辑删除")
    @TableField("is_deleted")
    private Boolean isDeleted;


}
