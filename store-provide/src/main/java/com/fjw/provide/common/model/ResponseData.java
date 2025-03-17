package com.fjw.provide.common.model;

import com.fjw.provide.common.StatusCode;
import com.fjw.provide.enums.ResponseEnum;
import lombok.Data;

@Data
public class ResponseData<T> {
    private int code;

    private String msg;

    private T data;

    public ResponseData(){
        this.code = ResponseEnum.SUCCESS.getCode();
        this.msg = ResponseEnum.SUCCESS.getMessage();
    }

    public ResponseData(StatusCode statusCode){
        this.code = statusCode.getCode();
        this.msg = statusCode.getMessage();
    }

    public ResponseData(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public void setData(T data){
        this.data = data;
        success();
    }

    public void success(){
        this.code = ResponseEnum.SUCCESS.getCode();
        this.msg = ResponseEnum.SUCCESS.getMessage();
    }
}

