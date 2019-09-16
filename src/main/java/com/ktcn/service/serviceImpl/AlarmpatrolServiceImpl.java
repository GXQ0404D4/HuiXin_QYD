package com.ktcn.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.AlarmpatrolDao;
import com.ktcn.entity.Alarmpatrol;
import com.ktcn.service.AlarmpatrolService;
/**
 * 报警巡查业务层实现类
 * @author Administrator
 *
 */
@Service
@Transactional
public class AlarmpatrolServiceImpl implements AlarmpatrolService {
	@Resource
	private AlarmpatrolDao alarmpatrolDao;
	// 查询全部报警巡查信息
	@Override
	public List<Alarmpatrol> apFindAll() {
		return alarmpatrolDao.apFindAll();
	}
	
	// 按照时间区间查询报警巡查信息
	@Override
	public List<Alarmpatrol> apFindByTime(String timeA, String timeB) {
		return alarmpatrolDao.apFindByTime(timeA,timeB);
	}
	
}
