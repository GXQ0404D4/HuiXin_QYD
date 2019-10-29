package com.ktcn.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.aspect.SysLog;
import com.ktcn.entity.Alarmseteings;
import com.ktcn.entity.Tb_user;
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
	public List<Alarmseteings> Alarmseteings() {
			List<Alarmseteings> alarmseteings = alarmService.findAll();
			return alarmseteings;
	}
	
	// 修改报警设置
	@RequestMapping("Alarmseteings_update")
	@SysLog(logModule = "报警设置", logName = "修改")
	public String Alarmseteings_update(@RequestBody Map<String,String> map,HttpServletRequest request) {
		// 获取当前登录用户
		Tb_user user = (Tb_user) request.getSession().getAttribute("nowuser");
		if (user.getUserPower() >= 1) {
			// 调用方法
			alarmService.updateAlarm(map);
			return "success";
		} else {
			return null;
		}
	}
	
}