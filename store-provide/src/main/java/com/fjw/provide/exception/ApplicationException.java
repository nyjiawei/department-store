package com.fjw.provide.exception;

import com.fjw.provide.common.StatusCode;

/**
 * @Author：jiawei
 * @CreateTime：2022-09-10 23:13
 * @Description：自定义异常
 * @Version：1.0
 **/
public class ApplicationException extends Exception{

    private Integer code;

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(StatusCode statusCode){
        super(statusCode.getMessage());
        this.code = statusCode.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
