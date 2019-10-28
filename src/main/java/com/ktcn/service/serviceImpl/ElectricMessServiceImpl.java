package com.ktcn.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.ElectricMessDao;
import com.ktcn.entity.KYJdatatable.Kyj_data_table;
import com.ktcn.service.ElectricMessService;
/*
 * 电量报表业务实现层
 */
@Service
@Transactional
public class ElectricMessServiceImpl implements ElectricMessService {

	@Resource
	private ElectricMessDao electricMessDao;
	
	// 获取数据总条数
	@Override
	public int findTotal() {
		return electricMessDao.findTotal();
	}
	// 获取查询数据
	@Override
	public List<Kyj_data_table> findAllByIndex(int x) {
		return electricMessDao.findAllByIndex(x);
	}
	
	// 时间区间查询总条数
	@Override
	public int findCountByTime(String current_timeA, String current_timeB) {
		return electricMessDao.findCountByTime(current_timeA,current_timeB);
	}
	// 根据时间区间查询空压机报表信息
	@Override
	public List<Kyj_data_table> findByTime(String current_timeA, String current_timeB, int total) {
		return electricMessDao.findByTime(current_timeA,current_timeB,total);
	}
	
}
