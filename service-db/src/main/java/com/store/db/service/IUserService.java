package com.store.db.service;

import com.store.db.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
public interface IUserService extends IService<User> {

    /**
     * 验证用户名密码
     * @param username 用户名或手机号
     * @return
     */
    public User getUserByUnameOrMobile(String username);
}
