package com.ktcn.service;

import java.util.Map;

import com.ktcn.entity.Tb_user;

/*
 * 生产管理业务层
 */
public interface ProductionService {
	// 查询方法
	Map<String, Object> find(String pageSize, int sizeNum, String pdt_people, String timeA, String timeB);
	// 新增生产管理
	void addProduction(Map<String, String> map, Tb_user user);
	// 生产管理汇报
	void ProToReport(Map<String, String> map, Tb_user user);
	// 生产管理审批
	void ProToApprove(int id);

}
