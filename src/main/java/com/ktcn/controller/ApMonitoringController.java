package com.ktcn.controller;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.ApMonitoringService;

/**
 * 报警巡查实时监控控制类
 * @author Administrator
 *
 */
@Order(value = 3)
@RestController
public class ApMonitoringController implements CommandLineRunner {
	
	@Resource
	private ApMonitoringService apMonitoringService;
	
	@Override
	public void run(String... args) throws Exception {
		apMonitoringService.alarmpatrolMethod();
		// this.process();
	}
	// 定时任务每天0点执行一次 
//    @Scheduled(cron = "*/1 * * * * ?")
    private void process(){
        System.out.println("每秒定时任务: ");
        // 监控数据
        
    }
}
