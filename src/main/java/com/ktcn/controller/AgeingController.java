package com.ktcn.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.AgeingService;

/**
 * 系统运行时效控制层
 * @author Administrator
 *
 */
@RestController
public class AgeingController implements CommandLineRunner {
	
	@Resource
	private AgeingService ageingService;
	
	// 写入初始时间轴
	@Override
	public void run(String... args) throws Exception {
		ageingService.writeInitialCode();
	}
	
	// 定时任务每3个月执行一次, 写入系统运行时间轴
	@Scheduled(cron = "* * * * */3 ?")
    private void process(){
		// 写入单次时间轴数据
		ageingService.writeOnceCode();
    }
    
    // 用户登录调用此方法, 查看系统运行是否超时
    @RequestMapping("getAgeingCode")
    public Map<String,String> getAgeingCode(){
    	return ageingService.comparisonCode();
    }
    
}
