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
 * 用户表
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@Getter
@Setter
@TableName("user")
@ApiModel(value = "User对象", description = "用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("使用uuid")
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("权限ID")
    @TableField("user_role_id")
    private Integer userRoleId;

    @ApiModelProperty("等级ID")
    @TableField("user_level_id")
    private Integer userLevelId;

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
    @TableField("img")
    private String img;

    @ApiModelProperty("盐，加密用")
    @TableField("salt")
    private String salt;

    @ApiModelProperty("生日")
    @TableField("birth")
    private LocalDateTime birth;

    @ApiModelProperty("性别:0女 ,1男")
    @TableField("sex")
    private Boolean sex;

    @ApiModelProperty("积分")
    @TableField("point")
    private Integer point;

    @ApiModelProperty("注册时间")
    @TableField("reg_time")
    private LocalDateTime regTime;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("登录次数")
    @TableField("login_count")
    private Integer loginCount;

    @ApiModelProperty("逻辑删除")
    @TableField("is_deleted")
    private Boolean isDeleted;


}
