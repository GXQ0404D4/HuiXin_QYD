package com.ktcn.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Alarmseteings> Alarmseteings(){
		List<Alarmseteings> alarmseteings = alarmService.findAll();
		return alarmseteings;
	}
	
	// 修改报警设置
	@RequestMapping("Alarmseteings_update")
	public String Alarmseteings_update(Alarmseteings alarm) {
		System.out.println(alarm);
		alarmService.updateAlarm(alarm);
		return "success";
	}
}
