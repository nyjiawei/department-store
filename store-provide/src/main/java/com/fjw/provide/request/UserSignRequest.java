package com.fjw.provide.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author：jiawei
 * @CreateTime：2022-09-05 01:25
 * @Description：
 * @Version：1.0
 **/
@Data
@Validated
public class UserSignRequest implements Serializable {
    private static final long serialVersionUID = 2885873922983610020L;

    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty("用户名")
    private String username;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty("明文密码")
    private String password;

    @ApiModelProperty("验证码，密码多次校验错误的时候需要")
    private String verificationCode;

}
