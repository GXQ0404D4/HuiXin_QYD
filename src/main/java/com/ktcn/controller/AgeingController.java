package com.ktcn.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.Ageing;
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
		// 获取最后一条时间轴信息
		Ageing ageing = ageingService.getLastCode();
//		ageingService.writeInitialCode();
	}
	
	// 定时任务每3个月执行一次, 写入系统运行时间轴
	@Scheduled(cron = "0 0 0 * * ?")
    private void process(){
    	
        System.out.println("时间到!");
    }
    
    // 用户登录调用此方法, 查看系统运行是否超时
    @RequestMapping("getAgeingCode")
    public Map<String,String> getAgeingCode(){
    	// 定义一个Map集合用来保存返回值
    	Map<String,String> map = new HashMap<String,String>();
    	
    	int i = 1;
    	if (i == 1) {
    		map.put("code","0000");
    		map.put("message","未超时效");
		} else {
			map.put("code","0001");
    		map.put("message","已超时效");
		}
    	
    	return map;
    }
    
    @RequestMapping("testXin")
    public Object testXin() {
    	Ageing ageing = ageingService.getLastCode();
    	return ageing;
    }

}
