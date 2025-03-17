package com.fjw.provide.utils;

import java.util.concurrent.*;

/**
 * @Author：jiawei
 * @CreateTime：2022-09-01 00:43
 * @Description：线程池工具类
 * @Version：1.0
 **/
public class ThreadPoolUtils {

    /**  核心线程数 */
    private static final int DEFAULT_CORE_SIZE = Runtime.getRuntime().availableProcessors() - 1;

    /**  最大线程数 */
    private static final int MAX_POOL_SIZE = ((DEFAULT_CORE_SIZE + 1) * 2 + 1) * 2;

    /** 线程最大空闲时间 */
    private static final long KEEP_ALIVE_TIME = 0L;

    //设置构造函数私有
    private ThreadPoolUtils(){

    }


    /**
     * 静态类部类保证线程安全
     */
    private static class ThreadPoolHolder {

        //初始化一个单例的线程池
        private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                DEFAULT_CORE_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2000),
                new ThreadPoolExecutor.AbortPolicy()
        );

        //定时线程程池
        private static ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(
                DEFAULT_CORE_SIZE
        );

    }


    /**
     * 获取单例的ThreadPoolExecutor
     * @return
     */
    public static ThreadPoolExecutor getInstance(){
        return ThreadPoolHolder.threadPoolExecutor;
    }
    /**
     * 获取单例的ScheduledThreadPoolExecutor
     * @return
     */
    public static ScheduledThreadPoolExecutor getScheduledInstance(){
        return ThreadPoolHolder.scheduledThreadPoolExecutor;
    }


    /**
     * new 一个船新线程池函数
     * @return
     */
    public static ThreadPoolExecutor getNewInstance(){
        return new ThreadPoolExecutor(
                DEFAULT_CORE_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2000),
                new ThreadPoolExecutor.AbortPolicy()
        );
    }

}
