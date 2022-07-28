package com.store.template.vo;

import com.store.template.common.StatusCode;
import com.store.template.enums.ResultCode;
import lombok.Data;

@Data
public class ResultVo {

    private int code;

    private String msg;

    private Object data;

    public ResultVo(int code,String msg,Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    //返回默认状态码和数据
    public ResultVo(Object data){
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
        this.data = data;
    }

    //返回状态码和数据
    public ResultVo(StatusCode statusCode, Object data){
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = data;
    }

    //只返回状态码
    public ResultVo(StatusCode statusCode){
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = null;
    }

    //只返回状态码和提示
    public ResultVo(StatusCode statusCode,String msg){
        this.code = statusCode.getCode();
        this.msg = msg;
        this.data = null;
    }

}
