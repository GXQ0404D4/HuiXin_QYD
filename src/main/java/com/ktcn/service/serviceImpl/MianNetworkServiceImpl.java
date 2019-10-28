package com.ktcn.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.MianNetworkDao;
import com.ktcn.entity.KYJdatatable.Kyj_data_table;
import com.ktcn.service.MianNetworkService;
/*
 * 总管网报表业务层实现类
 */
@Service
@Transactional
public class MianNetworkServiceImpl implements MianNetworkService {
	@Resource
	private MianNetworkDao mianNetworkDao;
	// 查询全部总管网信息
	@Override
	public List<Kyj_data_table> findAll() {
		return mianNetworkDao.findAll();
	}
	// 查询全部电量报表信息
	@Override
	public List<Kyj_data_table> findAllByTime(String current_timeA, String current_timeB) {
		return mianNetworkDao.findAllByTime(current_timeA,current_timeB);
	}
}
