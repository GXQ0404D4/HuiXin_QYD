package com.ktcn.service;

import java.util.Map;

import com.ktcn.entity.Tb_user;

/*
 * 故障记录业务层
 */
public interface FaultRecordService {
	// 查看方法
	Map<String, Object> find(String pageSize, int sizeNum, String falut_summary, String timeA, String timeB);
	// 新增故障记录
	void addFaultRecord(Map<String, String> map, Tb_user user);
	// 删除故障记录
	void deleteFaultRecord(int id);
	// 修改故障记录
	void updateFaultRecord(Map<String, String> map, Tb_user user);

}
