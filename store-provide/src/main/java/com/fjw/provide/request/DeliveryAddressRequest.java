package com.fjw.provide.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
@Data
@ApiModel(value = "配送地址请求", description = "用于新增/修改用户配送地址")
public class DeliveryAddressRequest {

    private Integer id;

    @ApiModelProperty("国家,默认中国大陆")
    private String country;

    @NotBlank(message = "省份不能为空")
    @ApiModelProperty("省份")
    private String province;

    @NotBlank(message = "城市不能为空")
    @ApiModelProperty("城市")
    private String city;

    @NotBlank(message = "地区/县不能为空")
    @ApiModelProperty("地区/县")
    private String area;

    @NotBlank(message = "街道详细地址不能为空")
    @ApiModelProperty("街道详细地址")
    private String address;

    @NotBlank(message = "手机号不能为空")
    @ApiModelProperty("手机")
    private String mobile;

    @ApiModelProperty("是否设置为默认")
    private Boolean isDefault;


}
