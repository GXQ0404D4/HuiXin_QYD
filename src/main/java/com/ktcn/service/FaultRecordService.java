package com.ktcn.service;

import java.util.List;
import java.util.Map;

import com.ktcn.entity.Error_recording;
import com.ktcn.entity.Tb_user;

/*
 * 故障记录业务层
 */
public interface FaultRecordService {
	// 跳转并查看所有故障记录
	List<Error_recording> findAll();
	// 按时间查询故障记录
	List<Error_recording> findByTime(String timeA, String timeB);
	// 按照故障机器名称查询
	List<Error_recording> findByName(String fault_machine);
	// 新增故障记录
	void addFaultRecord(Map<String, String> map, Tb_user user);
	// 删除故障记录
	void deleteFaultRecord(int id);
	// 修改故障记录
	void updateFaultRecord(Map<String, String> map, Tb_user user);

}
