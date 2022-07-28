package com.store.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.store.db.entity.User;
import com.store.db.mapper.UserMapper;
import com.store.db.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User getUserByUnameOrMobile(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username).or().eq("mobile",username);
        User user = getOne(queryWrapper);
        return user;
    }
}
