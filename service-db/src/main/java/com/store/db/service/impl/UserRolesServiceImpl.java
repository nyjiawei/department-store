package com.store.db.service.impl;

import com.store.db.entity.UserRoles;
import com.store.db.mapper.UserRolesMapper;
import com.store.db.service.IUserRolesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户权限表 服务实现类
 * </p>
 *
 * @author jiawei
 * @since 2022-07-18
 */
@Service
public class UserRolesServiceImpl extends ServiceImpl<UserRolesMapper, UserRoles> implements IUserRolesService {

}
