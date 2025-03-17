package com.fjw.provide.enums;

import com.fjw.provide.common.StatusCode;

/**
 * @Author：jiawei
 * @CreateTime：2022-07-18 12:58
 * @Description：TODO
 * @Version：1.0
 **/
public enum OrderStatusEnum implements StatusCode {
    UNPAID(0,"未付款"),
    PAID(1,"已付款"),
    DELIVERED(2,"已发货"),
    SIGNED(3,"已签收"),
    RETURN_REQUEST(4,"申请退货"),
    RETURNING(5,"退货中"),
    RETURNED(6,"已退货"),
    CANCELLED(7,"取消交易");

    private Integer code;

    private String message;

    OrderStatusEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
