package com.fjw.provide.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fjw.provide.common.Context;
import com.fjw.provide.common.model.ResponseData;
import com.fjw.provide.enums.ResponseEnum;
import com.fjw.provide.utils.HttpUtils;
import com.fjw.provide.utils.JWTUtils;
import com.fjw.provide.utils.ContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author jiawei
 * @description JWT令牌验证
 * @date 2019/6/8
 */
@Slf4j
@Component
public class JWTInterceptor implements HandlerInterceptor {

    //@Autowired
    //private RedisTemplate redisTemplate;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //请求完删除上下文对象，防止内存溢出
        ContextUtils.remove();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * 请求前拦截操作，校验token
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
        //放行跨域的预检请求
        if (request.getMethod().equals(RequestMethod.OPTIONS)){
            return true;
        }
        String token = request.getHeader("Authorization");
        //校验JWT
        if (StringUtils.isNotEmpty(token) && JWTUtils.verify(token)) {
            ContextUtils.add(new Context(HttpUtils.getIpAddress(request),JWTUtils.getUserInfoByToken(token)));
            return true;
        }else {
            response.getWriter().write(JSONObject.toJSONString(new ResponseData(ResponseEnum.UNAUTHORIZED), SerializerFeature.WriteNullStringAsEmpty));
            return false;
        }


    }

}
