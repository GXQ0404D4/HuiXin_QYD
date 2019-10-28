package com.ktcn.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.ComReportDao;
import com.ktcn.entity.KYJdatatable.Kyj_data_table;
import com.ktcn.service.ComReportService;
/*
 * 空压机报表业务层实现类
 */
@Service
@Transactional
public class ComReportServiceImpl implements ComReportService {
	@Resource
	private ComReportDao comReportDao;
	// 查询全部空压机报表信息
	@Override
	public List<Kyj_data_table> findAll() {
		return comReportDao.findAll();
	}
	// 根据时间区间查询空压机报表信息
	@Override
	public List<Kyj_data_table> findAllByTime(String current_timeA, String current_timeB) {
		return comReportDao.findAllByTime(current_timeA,current_timeB);
	}
	
}
