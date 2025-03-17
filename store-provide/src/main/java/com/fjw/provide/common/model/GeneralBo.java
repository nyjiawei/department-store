package com.fjw.provide.common.model;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GeneralBo<T>{

    private List<Long> ids;
    private int page = 1;
    private int pageSize = 10;
    private T vo;

    List<OrderItem> orders = new ArrayList<>();


    public GeneralBo(){

    }

}

