package com.fjw.provide.mapper;

import com.fjw.provide.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author jiawei
 * @since 2023-05-01
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
