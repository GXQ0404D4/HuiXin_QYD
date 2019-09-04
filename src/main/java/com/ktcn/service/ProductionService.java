package com.ktcn.service;

import java.util.List;
import java.util.Map;

import com.ktcn.entity.Production_plan;
import com.ktcn.entity.Tb_user;

/*
 * 生产管理业务层
 */
public interface ProductionService {
	// 查看全部生产管理表信息
	List<Production_plan> findAll();
	// 生产管理条件搜索
	List<Production_plan> findByParam(String pdt_select);
	// 生产管理时间区间查询
	List<Production_plan> findByTime(String pdt_selecttimeA, String pdt_selecttimeB);
	// 新增生产管理
	void addProduction(Map<String, String> map, Tb_user user);
	// 生产管理汇报
	void ProToReport(Map<String, String> map, Tb_user user);
	// 生产管理审批
	void ProToApprove(int id);

}
