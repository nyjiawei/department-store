package com.fjw.provide.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fjw.provide.model.User;
import com.fjw.provide.exception.ApplicationException;
import com.fjw.provide.mapper.UserMapper;
import com.fjw.provide.request.UserRegRequest;
import com.fjw.provide.request.UserSignRequest;
import com.fjw.provide.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fjw.provide.utils.*;
import com.fjw.provide.vo.UserInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jiawei
 * @since 2023-05-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    /*@Autowired
    private RedisUtils redisUtils;*/

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Override
    public UserInfoVo register(UserRegRequest request) {
        User user = new User();
        BeanUtils.copyProperties(request,user);
        //密码加密储存
        user.setPassword(PassWordUtils.encode(request.getPassword().trim()));
        save(user);
        //创建后补充基础数据
        user.setCreatorBy(user.getId().toString());
        user.setUpdateBy(user.getId().toString());
        user.setUserLevelId(1L);
        user.setUserRoleId(1L);
        getBaseMapper().updateById(user);
        UserInfoVo vo = new UserInfoVo();
        BeanUtils.copyProperties(request,vo);
        //发放令牌
        vo.setToken(JWTUtils.createToken(user));
        return vo;
    }

    @Override
    public UserInfoVo sign(User request) throws ApplicationException {
        //securityValidate(request);
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery(User.class)
                .eq(User::getMobile, request.getUsername()).or().eq(User::getUsername, request.getUsername());
        User existUser = getBaseMapper().selectOne(queryWrapper);
        //用户存在并且密码验证通过
        if (!Objects.isNull(existUser) && PassWordUtils.isPasswordValid(existUser.getPassword(),request.getPassword())){
            UserInfoVo userInfoVO = new UserInfoVo();
            BeanUtils.copyProperties(existUser,userInfoVO);
            //发放令牌
            userInfoVO.setToken(JWTUtils.createToken(existUser));
            return userInfoVO;
        }
        //记录登录失败次数，防止暴力破解
        //redisUtils.incr("requestIp:" + HttpUtils.getIpAddress(httpServletRequest),1);
        //redisUtils.expire("requestIp:" + HttpUtils.getIpAddress(httpServletRequest),60*3);
        return null;
    }


    /*private void securityValidate(UserSignRequest request) throws ApplicationException {
        String key = "requestIp:" + HttpUtils.getIpAddress(httpServletRequest);
        if(!redisUtils.hasKey(key)){
            return;
        }
        int signNum = (int) redisUtils.get(key);
        //需要验证图形码
        if (signNum > 3 && signNum < 10) {
            String code = (String) httpServletRequest.getSession().getAttribute(HttpUtils.getIpAddress(httpServletRequest));
            if (!request.getVerificationCode().equals(code)) throw new ApplicationException("图形码错误");
        }
        if (signNum == 10) {
            redisUtils.expire(key,60*10);
        }
        //限制登录
        if (signNum > 10) throw new ApplicationException("请于10分钟后尝试");
    }*/


}
