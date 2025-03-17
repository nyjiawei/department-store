package com.fjw.provide.utils;

import com.fjw.provide.common.Context;
import com.fjw.provide.common.model.UserInfo;

/**
 * @Author：jiawei
 * @CreateTime：2022-09-05 00:02
 * @Description：用户上下文工具类
 * @Version：1.0
 **/
public class ContextUtils {

    private static ThreadLocal<Context> threadLocal = new InheritableThreadLocal<>();

    /** 构造函数私有化 */
    private ContextUtils(){

    }

    public static void add(Context context){
        threadLocal.set(context);
    }

    public static void remove(){
        threadLocal.remove();
    }

    public static Context getContext(){
        return threadLocal.get();
    }

    public static UserInfo getUserInfo(){
        return getContext().getUserInfo();
    }

    public static Long getUserId(){
        return getUserInfo().getId();
    }
}
