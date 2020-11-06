package com.yuanjie.springboot.common.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * description:
 * 定时任务配置类
 * @author yuanjie 2020/11/06
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {

    @Scheduled(cron = "10 * 1 * * ?") // 定时任务配置表达式
    public void demoScheduler() {
        System.out.println(System.currentTimeMillis());
    }

}
