package com.ktcn.service;

import java.util.List;

import com.ktcn.entity.Maintenance;

/*
 * 维保记录业务层
 */
public interface MaintenanceService {
	// 新增维保计划
	void addMaintenance(Maintenance maintenance);
	// 查看维保计划
	List<Maintenance> findAll();
	// 执行维保计划
	void updateMaintenance(Maintenance maintenance);
	// 查看全部维保记录
	List<Maintenance> findAllOrdList();
	// 按时间区间查看维保记录
	List<Maintenance> findByTime(String timeA, String timeB);

}
