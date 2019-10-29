package com.ktcn.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.aspect.SysLog;
import com.ktcn.entity.Maintenance;
import com.ktcn.entity.Tb_user;
import com.ktcn.service.AgeingService;
import com.ktcn.service.MaintenanceService;
import com.ktcn.utils.MD5Util;

/*
 * 维保记录控制层
 */
@RestController
public class MaintenanceController {
	@Resource
	private MaintenanceService maintenanceService;
	@Resource
	private AgeingService ageingService;
	// 新增维保计划
	@RequestMapping("MtcApply")
	@SysLog(logModule = "维保记录", logName = "新增维保计划")
	public String MtcApply(@RequestBody Map<String,String> map, HttpServletRequest request) {
		// 判断用户输入维保码是否有效
		if (MD5Util.getMaintenanceCode().equals(map.get("mt_num"))) {
			// 获取当前用户
			Tb_user user = (Tb_user) request.getSession().getAttribute("nowuser");
			if (user.getUserPower() ==2) {
				// 调用新增维保计划方法
				maintenanceService.addMaintenance(map,user);
				return "success";
			} else {
				return null;
			}
		} else {
			return "error";
		}
	}
	
	// 查看维保计划
	@RequestMapping("MtcPlan")
	@SysLog(logModule = "维保记录", logName = "查看维保计划")
	public List<Maintenance> MtcPlan() {
		List<Maintenance> maintenance = maintenanceService.findAll();
		return maintenance;
	}
	
	// 执行维保计划
	@RequestMapping("executeMtcPlan")
	@SysLog(logModule = "维保记录", logName = "执行维保计划")
	public String executeMtcPlan(@RequestBody Map<String,String> map,HttpServletRequest request) {
		// 获取当前用户
		Tb_user user = (Tb_user) request.getSession().getAttribute("nowuser");
		// 判断用户权限
		if (user.getUserPower() >= 1) {
			// 执行维保计划
			maintenanceService.updateMaintenance(map);
			// 写入"系统运行时间轴"节点数据
			ageingService.writeOnceCode();
			return "success";
		} else {
			return null;
		}
	}
	
	// 查看全部维保记录
	@RequestMapping("MtcRecords")
	@SysLog(logModule = "维保记录", logName = "查看维保记录")
	public List<Maintenance> MtcRecords() {
		List<Maintenance> maintenance = maintenanceService.findAllOrdList();
		return maintenance;
	}
	
	// 按时间区间查看维保记录
	@RequestMapping("MtcRecords_time")
	@SysLog(logModule = "维保记录", logName = "时间区间查看维保记录")
	public List<Maintenance> MtcRecords_time(String TimeA, String TimeB) {
		List<Maintenance> maintenance = maintenanceService.findByTime(TimeA,TimeB);
		return maintenance;
	}
}
