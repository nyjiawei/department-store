package com.fjw.provide.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author jiawei
 * @since 2023-05-01
 */
@Getter
@Setter
@TableName("user")
@ApiModel(value = "User对象", description = "用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("权限ID")
    @TableField("user_role_id")
    private Long userRoleId;

    @ApiModelProperty("等级ID")
    @TableField("user_level_id")
    private Long userLevelId;

    @ApiModelProperty("用户名/登录名")
    @TableField("username")
    private String username;

    @ApiModelProperty("密码，用盐加密")
    @TableField("password")
    private String password;

    @ApiModelProperty("昵称")
    @TableField("nick")
    private String nick;

    @ApiModelProperty("手机")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("头像")
    @TableField("img_url")
    private String imgUrl;

    @ApiModelProperty("盐，加密用")
    @TableField("salt")
    private String salt;

    @ApiModelProperty("生日")
    @TableField("birth")
    private LocalDate birth;

    @ApiModelProperty("性别:0女 ,1男")
    @TableField("sex")
    private Boolean sex;

    @ApiModelProperty("积分")
    @TableField("point")
    private Integer point;

    @ApiModelProperty("备注")
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

    /** 非数据库字段，密码多次校验错误的时候需要 */
    @ApiModelProperty("验证码")
    @JsonIgnore
    @TableField(exist = false)
    private String verificationCode;

}
