package com.fjw.provide.request;


import com.fjw.provide.model.Goods;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * @Author：jiawei
 * @CreateTime：2022-07-19 12:44
 * @Description：GoodsVo
 * @Version：1.0
 **/

@Data
public class GoodsRequest extends Goods {

    @NotNull(message = "页码不能为空")
    private Integer currentPage = 1;

    @NotNull(message = "页大小，默认10条")
    private Integer pageSize = 20;

    private Long cid;

    private String keywords;

    private String title;

}
