package com.ktcn.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.aspect.SysLog;
import com.ktcn.entity.Alarmseteings;
import com.ktcn.service.AlarmService;

/*
 * 报警设置控制层
 */
@RestController
public class AlarmController {
	@Resource
	private AlarmService alarmService;
	
	// 查看报警设置
	@RequestMapping("Alarmseteings")
	@SysLog(logModule = "报警设置", logName = "查看")
	public List<Alarmseteings> Alarmseteings(){
		List<Alarmseteings> alarmseteings = alarmService.findAll();
		return alarmseteings;
	}
	
	// 修改报警设置
	@RequestMapping("Alarmseteings_update")
	@SysLog(logModule = "报警设置", logName = "修改")
	public String Alarmseteings_update(Alarmseteings alarm) {
		alarmService.updateAlarm(alarm);
		return "success";
	}
}
