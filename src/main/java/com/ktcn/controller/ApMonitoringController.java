package com.ktcn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.Alarmpatrol;
import com.ktcn.service.ApMonitoringService;

/**
 * 报警巡查实时监控控制类
 * @author Administrator
 *
 */
@RestController
public class ApMonitoringController {
	
	@Resource
	private ApMonitoringService apMonitoringService;
	
	// 定时任务每秒执行一次,进行报警监控
	// 该功能开发环境隐藏, 生产环境放开
//    @Scheduled(cron = "*/1 * * * * ?")
    private void process(){
        // 监控数据, 将报警信息写入数据库
        apMonitoringService.writeAlarmpatrol();
    }
    
    // 前端调用报警巡查方法
    @RequestMapping("getAlarmpatroCode")
    public Map<String,String> getAlarmpatroCode(){
    	// 创建一个map用来保存返回数据
    	Map<String,String> map = new HashMap<String,String>();
    	// 调用servic层方法
    	List<Alarmpatrol> list = apMonitoringService.alarmpatrolMethod();
    	// 判断是否产生报警, list为空则为正常状态, list非空则表示产生报警
    	if (list.isEmpty()) {
			map.put("code", "0000");
			map.put("message", "正常");
		} else {
			map.put("code", "0001");
			map.put("message", "报警");
		}
    	return map;
    }
}
