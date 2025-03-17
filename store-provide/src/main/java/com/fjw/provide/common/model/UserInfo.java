package com.fjw.provide.common.model;

import lombok.Data;

@Data
public class UserInfo {
    private Long id;
    private String nick;
    private String username;
    private Integer roleId;
    private String roleName;
}
