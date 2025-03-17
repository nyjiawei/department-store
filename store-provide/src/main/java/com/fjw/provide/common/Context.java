package com.fjw.provide.common;

import com.fjw.provide.common.model.UserInfo;

/**
 * @Author：jiawei
 * @CreateTime：2022-09-05 23:09
 * @Description：上下文工具类
 * @Version：1.0
 **/
public class Context {

    /** 请求的ip地址 */
    private String requestIp;

    private long sessionId;

    private UserInfo userInfo;

    public Context(String requestIp,UserInfo userInfo){
        this.requestIp = requestIp;
        this.userInfo = userInfo;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}