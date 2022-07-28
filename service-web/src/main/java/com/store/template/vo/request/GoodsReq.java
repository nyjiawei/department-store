package com.store.template.vo.request;


import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * @Author：jiawei
 * @CreateTime：2022-07-19 12:44
 * @Description：GoodsVo
 * @Version：1.0
 **/

@Data
public class GoodsReq {

    @NotNull(message = "页码不能为空")
    private Integer pageNo;

    @NotNull(message = "页大小，默认10条")
    private Integer pageSize;

    private Integer cid;

    private String keywords;

    private String title;
}
