package com.ktcn.service.readingAmmeterServiceimg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktcn.dao.readingAmmeterDao.ReadAmmeterDao;
import com.ktcn.entity.Reading_Ammeter;
import com.ktcn.service.readingAmmeterService.ReadAmmeterService;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月17日 下午4:25:23
* 类说明 抄表模块 获取 正向有功总电能的数据
*/
@Service
public class ReadAmmeterServiceImp implements ReadAmmeterService {

	@Autowired
	ReadAmmeterDao readAmmeterDao;
	@Override
	public List<Reading_Ammeter> getReadAmmeterData() {
		// TODO Auto-generated method stub
		return readAmmeterDao.getReadAmmeterData();
	}

}
