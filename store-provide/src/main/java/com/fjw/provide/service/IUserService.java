package com.fjw.provide.service;

import com.fjw.provide.exception.ApplicationException;
import com.fjw.provide.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fjw.provide.request.UserRegRequest;
import com.fjw.provide.vo.UserInfoVo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author jiawei
 * @since 2023-05-01
 */
public interface IUserService extends IService<User> {

    UserInfoVo register(UserRegRequest request);

    UserInfoVo sign(User request) throws ApplicationException;
}
