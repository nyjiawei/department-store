package com.fjw.provide.enums;

import com.fjw.provide.common.StatusCode;

public enum ResponseEnum implements StatusCode {
    SUCCESS(200,"请求成功"),
    INVALID(1002,"请求参数不合法"),
    NOT_FOUND(404,"服务器端无法找到所请求的资源"),
    ERROR(500, "请求异常"),
    UNAUTHORIZED(403,"无权限"),
    BED_REQUEST(400,"错误的请求");

    private int code;

    private String value;

    private ResponseEnum(Integer code, String msg){
        this.code = code;
        this.value = msg;
    }


    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.value;
    }
}