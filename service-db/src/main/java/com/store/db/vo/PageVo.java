package com.store.db.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * @Author：jiawei
 * @CreateTime：2022-07-19 12:07
 * @Description：分页数据VO
 * @Version：1.0
 **/

@Setter
@Getter
public class PageVo extends ResultVo{

    //总数
    private long total;

    public PageVo(IPage iPage) {
        super(iPage.getRecords());
        this.total = iPage.getTotal();
    }


}
