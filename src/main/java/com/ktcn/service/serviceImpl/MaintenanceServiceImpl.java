package com.ktcn.service.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.MaintenanceDao;
import com.ktcn.entity.Maintenance;
import com.ktcn.entity.Tb_user;
import com.ktcn.service.MaintenanceService;
/*
 * 维保记录业务层实现类
 */
@Service
@Transactional
public class MaintenanceServiceImpl implements MaintenanceService {
	@Resource
	private MaintenanceDao maintenanceDao;

	// 新增维保计划
	@Override
	public void addMaintenance(Map<String, String> map, Tb_user user) {
		map.put("", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		maintenanceDao.addMaintenance(map,user);
	}
	// 查看维保计划
	@Override
	public List<Maintenance> findAll() {
		return maintenanceDao.findAll();
	}
	// 执行维保计划
	@Override
	public void updateMaintenance(Map<String, String> map) {
		map.put("mt_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		maintenanceDao.updateMaintenance(map);
	}
	// 查看全部维保记录
	@Override
	public List<Maintenance> findAllOrdList() {
		return maintenanceDao.findAllOrdList();
	}
	// 按时间区间查看维保记录
	@Override
	public List<Maintenance> findByTime(String timeA, String timeB) {
		return maintenanceDao.findByTime(timeA,timeB);
	}
}
