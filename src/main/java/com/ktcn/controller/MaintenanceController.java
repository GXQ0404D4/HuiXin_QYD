package com.ktcn.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.Maintenance;
import com.ktcn.entity.Tb_user;
import com.ktcn.service.MaintenanceService;
import com.ktcn.utils.MD5Util;

/*
 * 维保记录控制层
 */
@RestController
public class MaintenanceController {
	@Resource
	private MaintenanceService maintenanceService;
	// 新增维保计划
	@RequestMapping("MtcApply")
	public String MtcApply(Maintenance maintenance, HttpServletRequest request) {
		// 判断用户输入维保码是否有效
		if (MD5Util.getMaintenanceCode().equals(maintenance.getMt_num())) {
			// 获取当前用户
			Tb_user user = (Tb_user) request.getSession().getAttribute("nowuser");
			// 调用新增维保计划方法
			maintenanceService.addMaintenance(maintenance,user);
			return "success";
		} else {
			return "error";
		}
	}
	
	// 查看维保计划
	@RequestMapping("MtcPlan")
	public List<Maintenance> MtcPlan() {
		List<Maintenance> maintenance = maintenanceService.findAll();
		return maintenance;
	}
	
	// 执行维保计划
	@RequestMapping("executeMtcPlan")
	public String executeMtcPlan(Maintenance maintenance) {
		maintenanceService.updateMaintenance(maintenance);
		return "success";
	}
	
	// 查看全部维保记录
	@RequestMapping("MtcRecords")
	public List<Maintenance> MtcRecords() {
		List<Maintenance> maintenance = maintenanceService.findAllOrdList();
		return maintenance;
	}
	
	// 按时间区间查看维保记录
	@RequestMapping("MtcRecords_time")
	public List<Maintenance> MtcRecords_time(String TimeA, String TimeB) {
		List<Maintenance> maintenance = maintenanceService.findByTime(TimeA,TimeB);
		return maintenance;
	}
}
