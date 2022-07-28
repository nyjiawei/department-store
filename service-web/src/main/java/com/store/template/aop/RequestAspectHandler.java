package com.store.template.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author：jiawei
 * @CreateTime：2022-07-19 17:49
 * @Description：定义一个切面，do something
 * @Version：1.0
 **/

//@Component
//@Aspect
public class RequestAspectHandler {

    //@Pointcut
    public void pointCut(){

    }

    //@Before("pointCut()")
    public void before(){
        //不做处理
    }

   // @After("pointCut()")
    public void after(){

    }

}
