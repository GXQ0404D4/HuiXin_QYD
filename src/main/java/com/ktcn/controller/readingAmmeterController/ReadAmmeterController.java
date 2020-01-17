package com.ktcn.controller.readingAmmeterController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.Reading_Ammeter;
import com.ktcn.service.readingAmmeterService.ReadAmmeterService;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月17日 下午4:27:09
* 类说明 抄表模块 获取 正向有功总电能的数据
*/
@RestController
public class ReadAmmeterController {
	
	@Autowired
	ReadAmmeterService ReadAmmeterServiceImp;

	
	
	@RequestMapping("/readAmmeter")
	public List<Reading_Ammeter> getReadAmmeterData() {
		return ReadAmmeterServiceImp.getReadAmmeterData();
	}
}
