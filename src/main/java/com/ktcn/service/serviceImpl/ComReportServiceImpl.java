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
	
	// 查询数据总条数
	@Override
	public int findTotal() {
		return comReportDao.findTotal();
	}
	// 分页查询-查询全部
	@Override
	public List<Kyj_data_table> findAllByIndex(int total) {
		return comReportDao.findAllByIndex(total);
	}
	
	// 时间区间查询总条数
	@Override
	public int findCountByTime(String current_timeA, String current_timeB) {
		return comReportDao.findCountByTime(current_timeA, current_timeB);
	}
	// 根据时间区间查询空压机报表信息
	@Override
	public List<Kyj_data_table> findByTime(String current_timeA, String current_timeB, int total) {
		return comReportDao.findByTime(current_timeA, current_timeB, total);
	}
	
}
