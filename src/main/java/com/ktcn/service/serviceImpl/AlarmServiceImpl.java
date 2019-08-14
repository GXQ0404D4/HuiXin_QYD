package com.ktcn.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.AlarmDao;
import com.ktcn.entity.Alarmseteings;
import com.ktcn.service.AlarmService;
/*
 * 报警设置业务层实现类
 */
@Service
@Transactional
public class AlarmServiceImpl implements AlarmService {
	@Resource
	private AlarmDao alarmDao;
	// 查看报警设置
	@Override
	public List<Alarmseteings> findAll() {
		return alarmDao.findAll();
	}
	// 修改报警设置
	@Override
	public void updateAlarm(Alarmseteings alarm) {
		alarmDao.updateAlarm(alarm);
	}
}
