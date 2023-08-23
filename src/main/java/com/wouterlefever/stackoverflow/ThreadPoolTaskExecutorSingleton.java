package com.wouterlefever.stackoverflow;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class ThreadPoolTaskExecutorSingleton {
    private static ThreadPoolTaskExecutor executor;

    static {
        executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(8);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("customThread-");
        executor.initialize();
        System.out.println("Creation of ThreadPoolTaskExecutor during start up.");
    }

    public static ThreadPoolTaskExecutor getInstance() {
        return executor;
    }

}
