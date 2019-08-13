package com.ktcn.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.Maintenance;
import com.ktcn.service.MaintenanceService;

/*
 * 维保记录控制层
 */
@RestController
public class MaintenanceController {
	@Resource
	private MaintenanceService maintenanceService;
	
	// 新增维保计划
	@RequestMapping("MtcApply")
	public String MtcApply(Maintenance maintenance) {
		maintenanceService.addMaintenance(maintenance);
		return "success";
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
