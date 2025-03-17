package com.fjw.provide.common.model;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @Author：jiawei
 * @CreateTime：2023-05-01 16:23
 * @Description：通用分页DTO
 * @Version：1.0
 **/
public class PaginationDTO<T> extends Page<T> {
    public PaginationDTO(){
        super();
    }

    public PaginationDTO<T> getInstance(GeneralBo bo){
        PaginationDTO pagination = new PaginationDTO<>();
        pagination.setCurrent(bo.getPage());
        pagination.setSize(bo.getPageSize());
        pagination.setOrders(bo.getOrders());
        return pagination;
    }
}
