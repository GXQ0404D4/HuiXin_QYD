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
	// 查询全部电量报表信息
	@Override
	public List<Kyj_data_table> findAll() {
		return electricMessDao.findAll();
	}
	// 根据时间区间查询电量报表信息
	@Override
	public List<Kyj_data_table> findAllByTime(String current_timeA, String current_timeB) {
		return electricMessDao.findAllByTime(current_timeA,current_timeB);
	}
	
}
