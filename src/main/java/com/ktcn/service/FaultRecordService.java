package com.ktcn.service;

import java.util.List;

import com.ktcn.entity.Error_recording;

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
	void addFaultRecord(Error_recording error_recording);
	// 删除故障记录
	void deleteFaultRecord(int id);
	// 修改故障记录
	void updateFaultRecord(Error_recording error_recording);

}
