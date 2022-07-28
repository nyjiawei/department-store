package com.store.template.config.security;

import com.alibaba.fastjson.JSONObject;
import com.store.template.enums.ResultCode;
import com.store.template.util.JWTUtil;
import com.store.template.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jiawei
 * @description 自定义token拦截器。每次请求从request的头里面取出token，进而校验
 * @date 2019/6/8
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 拦截操作，校验token
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            response.setCharacterEncoding("UTF-8");
            String token = request.getHeader("accessToken");
            if (null != token) {
                //JWT工具校验token合法性
                boolean result = JWTUtil.verify(token);
                if (result) {
                    return true;
                }
            }
            response.getWriter().write(JSONObject.toJSONString(
                    new ResultVo(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMsg(),null)));
        } catch (Exception e) {
            response.getWriter().write(JSONObject.toJSONString(new ResultVo(
                    ResultCode.UNAUTHORIZED.getCode(),e.getMessage(),null)));
        }

        return false;
    }
}
