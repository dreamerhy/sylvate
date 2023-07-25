package com.sylvate.exclusive.mainpackage.example;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@EnableScheduling//开启定时任务
@Component
public class TimerTask {

    @Scheduled(cron = "0 0/1 * * * ?")
    public void task() {
        System.out.println("定时任务执行：" + new Date());
    }
}