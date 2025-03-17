package com.fjw.provide.model;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
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
 * @since 2025-03-07
 */
@Getter
@Setter
@TableName("user_delivery_address")
@ApiModel(value = "UserDeliveryAddress对象", description = "用户配送地址表")
public class UserDeliveryAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("国家")
    @TableField("country")
    private String country;

    @ApiModelProperty("省份")
    @TableField("province")
    private String province;

    @ApiModelProperty("省份编码")
    @TableField("province_code")
    private String provinceCode;

    @ApiModelProperty("城市")
    @TableField("city")
    private String city;

    @ApiModelProperty("城市编码")
    @TableField("city_code")
    private String cityCode;

    @ApiModelProperty("地区/县")
    @TableField("area")
    private String area;

    @ApiModelProperty("地区编码")
    @TableField("area_code")
    private String areaCode;

    @ApiModelProperty("街道")
    @TableField("street")
    private String street;

    @ApiModelProperty("街道编码")
    @TableField("street_code")
    private String streetCode;

    @ApiModelProperty("具体地址")
    @TableField("specific_address")
    private String specificAddress;

    @ApiModelProperty("手机")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty("是否设置为默认")
    @TableField("is_default")
    private Boolean isDefault;

    @ApiModelProperty("收件人")
    @TableField("addressee")
    private String addressee;

    @ApiModelProperty("标签")
    @TableField("tags")
    private String tags;

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

    public String getAddressStr(){
        StringBuilder builder = new StringBuilder(this.province);
        builder.append(this.city)
                .append(this.area)
                .append(this.street)
                .append(this.specificAddress);
        return builder.toString();
    }
}
