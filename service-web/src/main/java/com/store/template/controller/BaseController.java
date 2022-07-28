package com.store.template.controller;

import com.alibaba.fastjson.JSONObject;
import com.store.template.common.ServiceModel;
import com.store.template.common.StatusCode;
import com.store.template.enums.ResultCode;
import com.store.template.util.CreateVerificationCode;
import com.store.template.util.JWTUtil;
import com.store.template.util.PassWordUtil;
import com.store.template.vo.ResultVo;
import com.store.template.vo.request.UserReq;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author：jiawei
 * @CreateTime：2022-07-19 12:21
 * @Description：基础服务
 * @Version：1.0
 **/

@RestController
public class BaseController {

    @Resource
    private ServiceModel serviceModel;

    private static final String arithmetic = "sha-256";

    @ApiOperation(value = "验证码",notes = "输出验证码图片")
    @RequestMapping(value = "/verification", method = {RequestMethod.POST, RequestMethod.GET})
    public void verification(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        new CreateVerificationCode().write(request, response);
    }

    @ApiOperation(value = "登出",notes = "注销登录状态")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public JSONObject logOut(@RequestHeader(value = "username",required=true) String username){
        // TODO Auto-generated method stub
        return null;
    }

    @ApiOperation(value = "登录",notes = "用户登录")
    @RequestMapping(value = "/sign", method = RequestMethod.POST)
    public ResultVo sign(HttpServletRequest request, @RequestBody UserReq userReq) {
        //如果同一个IP登录超过三次还未成功，需要验证图形码 todo
        JSONObject data = serviceModel.getServiceModel("user?username={username}",userReq.getUsername());
        if (data.get("data") == null) {
            return new ResultVo(ResultCode.SUCCESS,"用户不存在或密码不正确");
        } else { //存在 对比密码
            JSONObject user = data.getJSONObject("data");
            String salt = user.getString("salt");
            String encWord = user.getString("password"); //获取DB查询到的加密密码
            PassWordUtil pWordUtil = new PassWordUtil(salt, arithmetic);
            boolean isValid = pWordUtil.isPasswordValid(encWord,userReq.getPassword());//验证密码
            if(isValid) {
                String token = JWTUtil.createToken(user.getString("username"),user.getString("id"));
                user.put("token",token);
                deleteSensitiveInfo(user);
                //todo token放入redis
                return new ResultVo(ResultCode.SUCCESS,user);
            }
            return new ResultVo("用户不存在或密码不正确");
        }
    }

    @ApiOperation(value = "注册",notes = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JSONObject register(@RequestBody @Validated UserReq userReq) {
        String salt = UUID.randomUUID().toString();
        PassWordUtil pWordUtil = new PassWordUtil(salt, arithmetic);
        String rawWord = pWordUtil.encode(userReq.getPassword());
        userReq.setPassword(rawWord); //覆盖明文密码
        userReq.setSalt(salt);
        return serviceModel.postServiceModel("user",userReq);
    }

    //删除风险字段
    private void deleteSensitiveInfo(JSONObject user){
        user.remove("password");
        user.remove("salt");
        user.remove("remark");
        user.remove("loginCount");
    }


}
