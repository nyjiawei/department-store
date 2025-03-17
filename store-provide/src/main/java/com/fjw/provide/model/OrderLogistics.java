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
 * 订单物流表
 * </p>
 *
 * @author jiawei
 * @since 2023-05-01
 */
@Getter
@Setter
@TableName("order_logistics")
@ApiModel(value = "OrderLogistics对象", description = "订单物流表")
public class OrderLogistics implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("订单ID")
    @TableField("order_id")
    private Long orderId;

    @ApiModelProperty("物流单号")
    @TableField("express_no")
    private String expressNo;

    @ApiModelProperty("收货人可能更新或删除，因此要在这里记录")
    @TableField("consignee_name")
    private String consigneeName;

    @ApiModelProperty("收货手机可能更新或删除，因此要在这里记录")
    @TableField("consignee_mobile")
    private String consigneeMobile;

    @ApiModelProperty("收货地址表可能更新或删除，因此要在这里记录")
    @TableField("consignee_address")
    private String consigneeAddress;

    @ApiModelProperty("收货地址邮编可能更新或删除，因此要在这里记录")
    @TableField("consignee_zip")
    private String consigneeZip;

    @ApiModelProperty("物流公司：如顺丰、圆通等")
    @TableField("logistics_type")
    private String logisticsType;

    @ApiModelProperty("物流商家表自动编号")
    @TableField("logistics_id")
    private String logisticsId;

    @ApiModelProperty("显示给客户的订单运费")
    @TableField("logistics_fee")
    private BigDecimal logisticsFee;

    @ApiModelProperty("快递公司代收货款费率，如货值的2%-5%，一般月结")
    @TableField("agency_fee")
    private BigDecimal agencyFee;

    @ApiModelProperty("实际支付给物流公司的金额")
    @TableField("delivery_amount")
    private BigDecimal deliveryAmount;

    @ApiModelProperty("物流状态")
    @TableField("order_logistics_status")
    private String orderLogisticsStatus;

    @ApiModelProperty("物流结算状态 ：未结算，已结算，部分结算")
    @TableField("logistics_settlement_status")
    private String logisticsSettlementStatus;

    @ApiModelProperty("物流最后状态描述")
    @TableField("logistics_result_last")
    private String logisticsResultLast;

    @ApiModelProperty("发货时间")
    @TableField("logistics_create_time")
    private LocalDateTime logisticsCreateTime;

    @ApiModelProperty("物流更新时间")
    @TableField("logistics_update_time")
    private LocalDateTime logisticsUpdateTime;

    @ApiModelProperty("物流结算时间")
    @TableField("logistics_settlement_time")
    private LocalDateTime logisticsSettlementTime;

    @ApiModelProperty("物流支付渠道")
    @TableField("logistics_pay_channel")
    private String logisticsPayChannel;

    @ApiModelProperty("物流支付单号")
    @TableField("logistics_pay_no")
    private String logisticsPayNo;

    @ApiModelProperty("物流公司已对账状态 :已对账,未对账")
    @TableField("reconciliation_status")
    private String reconciliationStatus;

    @ApiModelProperty("物流公司对账日期")
    @TableField("reconciliation_time")
    private LocalDateTime reconciliationTime;

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
