package com.ktcn.initial;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {
    // 定时任务每天0点执行一次
    @Scheduled(cron = "0 0 0 * * ?")
    private void process(){
        
    }
    
}
