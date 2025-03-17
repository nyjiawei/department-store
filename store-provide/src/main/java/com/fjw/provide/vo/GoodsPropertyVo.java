package com.fjw.provide.vo;


/*import com.fjw.provide.entity.GoodsPropertyName;
import com.fjw.provide.entity.GoodsPropertyValue;*/
import com.fjw.provide.model.GoodsPropertyValue;
import lombok.Data;

import java.util.List;

/**
 * @Author：jiawei
 * @CreateTime：2022-07-22 22:33
 * @Description：商品属性包装类
 * @Version：1.0
 **/
@Data
public class GoodsPropertyVo {


    private Integer id;

    private String title;

    private String label;

    private List<GoodsPropertyValue> entities;

}
