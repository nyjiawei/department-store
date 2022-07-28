package com.store.db.enums;

import com.store.db.common.StatusCode;

public enum ResultCode implements StatusCode {
    SUCCESS(200,"请求成功"),
    INVALID(1002,"请求参数不合法"),
    NOT_FOUND(404,"服务器端无法找到所请求的资源"),
    ERROR(500, "内部服务器错误"),
    ERROR_REQ(400,"错误的请求");

    private int code;

    private String msg;

    ResultCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return SUCCESS.code;
    }

    @Override
    public String getMsg() {
        return SUCCESS.msg;
    }
}