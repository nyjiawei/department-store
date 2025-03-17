package com.fjw.provide.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fjw.provide.common.model.GeneralBo;

/**
 * @Author：jiawei
 * @CreateTime：2023-05-01 17:59
 * @Description：分页工具类
 * @Version：1.0
 **/
public class PageUtils {

    /**
     * 构建page
     * @param bo
     * @return
     * @param <T>
     */
    public static <T> Page<T> getPageInstance(GeneralBo<T> bo){
        Page<T> page = new Page<>(bo.getPage(), bo.getPageSize(),true);
        page.setOptimizeJoinOfCountSql(false);
        return page;
    }

    public static <T> QueryWrapper<T> getQueryWrapper(T entity){
        return Wrappers.query(entity);
    }

}
