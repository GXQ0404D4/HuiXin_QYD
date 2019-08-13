package com.ktcn.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.CoulometryDao;
import com.ktcn.entity.Electric_massage;
import com.ktcn.service.CoulometryService;
/*
 * 电量曲线分析业务层实现类
 */
@Service
@Transactional
public class CoulometryServiceImpl implements CoulometryService {
	@Resource
	private CoulometryDao coulometryDao;
	// 查询当天24小时的电量曲线信息
	@Override
	public List<Electric_massage> findByNowDate() {
		return coulometryDao.findByNowDate();
	}
	// 查询本月流量曲线
	@Override
	public List<Electric_massage> findByNowMonth() {
		return coulometryDao.findByNowMonth();
	}
	// 根据机器查询本月流量曲线
	@Override
	public List<Electric_massage> findByMachine(String machine) {
		return coulometryDao.findByMachine(machine);
	}
	// 按照时间区间查询
	@Override
	public List<Electric_massage> findByTime(String timeA, String timeB) {
		return coulometryDao.findByTime(timeA,timeB);
	}
}
