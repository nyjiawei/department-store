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
 * 用户配送地址表
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@Getter
@Setter
@TableName("user_delivery_address")
@ApiModel(value = "UserDeliveryAddress对象", description = "用户配送地址表")
public class UserDeliveryAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("国家")
    @TableField("country")
    private String country;

    @ApiModelProperty("省份")
    @TableField("province")
    private String province;

    @ApiModelProperty("城市")
    @TableField("city")
    private String city;

    @ApiModelProperty("地区/县")
    @TableField("area")
    private String area;

    @ApiModelProperty("街道详细地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("手机")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty("是否设置为默认")
    @TableField("is_default")
    private Boolean isDefault;

    @ApiModelProperty("用户ID")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty("逻辑删除")
    @TableField("is_deleted")
    private Boolean isDeleted;


}
