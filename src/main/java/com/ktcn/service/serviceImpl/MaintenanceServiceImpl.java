package com.ktcn.service.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.MaintenanceDao;
import com.ktcn.entity.Maintenance;
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
	public void addMaintenance(Maintenance maintenance) {
		maintenance.setMt_plan_time(new Date());
		maintenanceDao.addMaintenance(maintenance);
	}
	// 查看维保计划
	@Override
	public List<Maintenance> findAll() {
		return maintenanceDao.findAll();
	}
	// 执行维保计划
	@Override
	public void updateMaintenance(Maintenance maintenance) {
		maintenance.setMt_time(new Date());
		maintenanceDao.updateMaintenance(maintenance);
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
