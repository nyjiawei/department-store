package com.store.template.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**

 * @author jiawei
 * @since 2022-07-18
 */
@Data
@ApiModel(value = "User注册对象", description = "用于注册或登录")
public class UserReq{

    private String id;

    @NotBlank(message = "用户名/登录名不能为空")
    @ApiModelProperty("用户名/登录名")
    private String username;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty("明文密码")
    private String password;

    @ApiModelProperty("昵称")
    private String nick;

    @NotBlank(message = "手机号码不能为空")
    @ApiModelProperty("手机号码")
    private String mobile;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("生日")
    private LocalDateTime birth;

    private String salt;

    @ApiModelProperty("性别:0女 ,1男")
    private Boolean sex;

}
