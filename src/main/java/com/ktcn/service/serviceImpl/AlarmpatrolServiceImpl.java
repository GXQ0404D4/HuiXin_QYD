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
 * 
 * @author Administrator
 *
 */
@Service
@Transactional
public class AlarmpatrolServiceImpl implements AlarmpatrolService {
	@Resource
	private AlarmpatrolDao alarmpatrolDao;

	// 查询数据总条数
	public int findTotal() {
		return alarmpatrolDao.findTotal();
	}
	// 分页查询-查询全部
	public List<Alarmpatrol> findAllByIndex(int total) {
		return alarmpatrolDao.findAllByIndex(total);
	}

	// 时间区间查询总条数
	public int findCountByTime(String timeA, String timeB) {
		return alarmpatrolDao.findCountByTime(timeA,timeB);
	}
	// 根据时间区间查询空压机报表信息
	public List<Alarmpatrol> findByTime(String timeA, String timeB, int total) {
		return alarmpatrolDao.findByTime(timeA,timeB,total);
	}
}
