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
 * 
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@Getter
@Setter
@TableName("order_detail")
@ApiModel(value = "OrderDetail对象", description = "")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("订单编号")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty("商品编号")
    @TableField("pro_no")
    private String proNo;

    @ApiModelProperty("商品名可能删除,所以这里要记录，不能直接读商品表")
    @TableField("goods_name")
    private String goodsName;

    @ApiModelProperty("商品价格可能变更或删除,所以这里要记录，不能直接读商品表")
    @TableField("goods_price")
    private String goodsPrice;

    @ApiModelProperty("商品品牌")
    @TableField("goods_marque")
    private String goodsMarque;

    @ApiModelProperty("商品仓库条码")
    @TableField("goods_store_barcode")
    private String goodsStoreBarcode;

    @ApiModelProperty("记录详细商品型号，如颜色、规格、包装等")
    @TableField("goods_mode_desc")
    private String goodsModeDesc;

    @ApiModelProperty("JSON格式，记录单位编号、颜色编号、规格编号等")
    @TableField("goods_mode_params")
    private String goodsModeParams;

    @ApiModelProperty("打几折")
    @TableField("discount_rate")
    private Integer discountRate;

    @ApiModelProperty("折扣金额")
    @TableField("discount_amount")
    private String discountAmount;

    @ApiModelProperty("购买数量")
    @TableField("number")
    private Integer number;

    @ApiModelProperty("小记金额")
    @TableField("subtotal")
    private String subtotal;

    @ApiModelProperty("商品还有效吗")
    @TableField("goods_exists")
    private Boolean goodsExists;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;


}
