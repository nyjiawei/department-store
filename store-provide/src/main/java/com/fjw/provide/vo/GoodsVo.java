package com.fjw.provide.vo;


import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 商品列表，多纬度
 * @author jiawei
 * @since 2023-05-01
 */
@Getter
@Setter
public class GoodsVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long cid;

    private Long skuId;

    private String title;

    private String proNo;

    private String keywords;

    private String imgUrl;

    private String propertiesValue;

    private BigDecimal price;

    private Long pv;

}
