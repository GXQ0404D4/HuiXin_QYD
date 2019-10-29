package com.ktcn.service.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.FaultRecordDao;
import com.ktcn.entity.Error_recording;
import com.ktcn.entity.Tb_user;
import com.ktcn.service.FaultRecordService;
/*
 * 故障记录业务层实现类
 */
@Service
@Transactional
public class FaultRecordServiceImpl implements FaultRecordService {
	@Resource
	private FaultRecordDao faultRecordDao;
	// 跳转并查看所有故障记录
	@Override
	public List<Error_recording> findAll() {
		return faultRecordDao.findAll();
	}
	// 按时间查询故障记录
	@Override
	public List<Error_recording> findByTime(String timeA, String timeB) {
		return faultRecordDao.findByTime(timeA,timeB);
	}
	// 按照故障机器名称查询
	@Override
	public List<Error_recording> findByName(String fault_machine) {
		return faultRecordDao.findByName(fault_machine);
	}
	// 新增故障记录
	@Override
	public void addFaultRecord(Map<String, String> map, Tb_user user) {
		map.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		faultRecordDao.addFaultRecord(map,user);
	}
	// 删除故障记录
	@Override
	public void deleteFaultRecord(int id) {
		faultRecordDao.deleteFaultRecord(id);
	}
	// 修改故障记录
	@Override
	public void updateFaultRecord(Map<String, String> map, Tb_user user) {
		map.put("Repair_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		faultRecordDao.updateFaultRecord(map,user);
	}
}
