package com.store.template.enums;


import com.store.template.common.StatusCode;

public enum ResultCode implements StatusCode {
    SUCCESS(200,"请求成功"),
    UNAUTHORIZED(401,"未授权"),
    INVALID_PARAMS(400,"请求参数不合法"),
    PERMISSION_DENIED(403,"权限不足"),
    NOT_FOUND(404,"服务器端无法找到所请求的资源"),
    FORBIDDEN(405,"资源被禁止"),
    INTERNAL_ERROR(500,"db服务出错");

    private int code;

    private String msg;

    ResultCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}