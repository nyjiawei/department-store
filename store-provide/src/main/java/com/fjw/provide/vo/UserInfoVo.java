package com.fjw.provide.vo;

import lombok.Data;

@Data
public class UserInfoVo {
    private Long id;
    private String nick;
    private String username;
    private String imgUrl;
    private String token;
}
