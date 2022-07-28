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
 * 用户权限表
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@Getter
@Setter
@TableName("user_roles")
@ApiModel(value = "UserRoles对象", description = "用户权限表")
public class UserRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("权限名")
    @TableField("role_name")
    private String roleName;

    @ApiModelProperty("备注")
    @TableField("comment")
    private String comment;

    @ApiModelProperty("逻辑删除")
    @TableField("is_deleted")
    private Boolean isDeleted;


}
