package com.store.db.enums;

import com.store.db.common.StatusCode;

/**
 * @Author：jiawei
 * @CreateTime：2022-07-18 12:58
 * @Description：TODO
 * @Version：1.0
 **/
public enum OrderStatusCode implements StatusCode{
    UNPAID(0,"未付款"),
    PAID(1,"已付款"),
    DELIVERED(2,"已发货"),
    SIGNED(3,"已签收"),
    RETURN_REQUEST(4,"退货申请"),
    RETURNING(5,"退货中"),
    RETURNED(6,"已退货"),
    CANCELLED(7,"取消交易");

    private int code;

    private String msg;

    OrderStatusCode(int code, String msg){
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
