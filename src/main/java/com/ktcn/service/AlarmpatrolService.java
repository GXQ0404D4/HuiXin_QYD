package com.ktcn.service;

import java.util.List;

import com.ktcn.entity.Alarmpatrol;
import com.ktcn.entity.KYJdatatable.Kyj_data_table;

/**
 * 报警巡查业务层
 * 
 * @author Administrator
 *
 */
public interface AlarmpatrolService {

	// 查询数据总条数
	int findTotal();
	// 分页查询-查询全部
	List<Alarmpatrol> findAllByIndex(int total);

	// 时间区间查询总条数
	int findCountByTime(String timeA, String timeB);
	// 根据时间区间查询空压机报表信息
	List<Alarmpatrol> findByTime(String timeA, String timeB, int total);

}
