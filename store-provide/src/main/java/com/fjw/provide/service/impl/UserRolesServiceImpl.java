package com.fjw.provide.service.impl;

import com.fjw.provide.model.UserRoles;
import com.fjw.provide.mapper.UserRolesMapper;
import com.fjw.provide.service.IUserRolesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户权限表 服务实现类
 * </p>
 *
 * @author jiawei
 * @since 2023-05-01
 */
@Service
public class UserRolesServiceImpl extends ServiceImpl<UserRolesMapper, UserRoles> implements IUserRolesService {

}
