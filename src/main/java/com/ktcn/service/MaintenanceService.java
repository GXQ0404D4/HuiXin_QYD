package com.ktcn.service;

import java.util.List;
import java.util.Map;

import com.ktcn.entity.Maintenance;
import com.ktcn.entity.Tb_user;

/*
 * 维保记录业务层
 */
public interface MaintenanceService {
	// 新增维保计划
	void addMaintenance(Map<String, String> map, Tb_user user);
	// 查看维保计划
	List<Maintenance> findAll();
	// 执行维保计划
	void updateMaintenance(Map<String, String> map);
	// 查看全部维保记录
	List<Maintenance> findAllOrdList();
	// 按时间区间查看维保记录
	List<Maintenance> findByTime(String timeA, String timeB);

}
