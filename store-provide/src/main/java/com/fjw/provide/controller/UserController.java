package com.fjw.provide.controller;


import com.fjw.provide.common.model.ResponseData;
import com.fjw.provide.exception.ApplicationException;
import com.fjw.provide.model.User;
import com.fjw.provide.request.UserRegRequest;
import com.fjw.provide.service.IUserService;
import com.fjw.provide.utils.VerificationCodeUtils;
import com.fjw.provide.vo.UserInfoVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author jiawei
 * @since 2023-05-01
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "注册")
    @RequestMapping(value = "/access/register",method = RequestMethod.POST)
    ResponseData<UserInfoVo> register(@RequestBody UserRegRequest request){
        ResponseData response = new ResponseData<>();
        response.setData(userService.register(request));
        return response;
    }

    @ApiOperation(value = "登录")
    @RequestMapping(value = "/access/sign",method = RequestMethod.POST)
    ResponseData<UserInfoVo> sign(@RequestBody User request) throws ApplicationException {
        ResponseData response = new ResponseData<>();
        response.setData(userService.sign(request));
        return response;
    }

    @ApiOperation(value = "验证码",notes = "输出验证码图片")
    @RequestMapping(value = "/access/verification", method = {RequestMethod.POST, RequestMethod.GET})
    public void verification(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        VerificationCodeUtils.write(request, response);
    }

    @ApiOperation(value = "登出")
    @RequestMapping(value = "/access/logout",method = RequestMethod.POST)
    ResponseData<Boolean> logout(){
        ResponseData response = new ResponseData<>();
        response.setData(true);
        return response;
    }

}
