package com.ktcn.service.readingAmmeterService;

import java.util.List;

import com.ktcn.entity.Reading_Ammeter;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月17日 下午4:24:51
* 类说明 抄表模块 获取 正向有功总电能的数据
*/

public interface ReadAmmeterService {

	List<Reading_Ammeter> getReadAmmeterData();

}
