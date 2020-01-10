package com.ktcn.service.siemens.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktcn.dao.siemensdao.ControlValveDao;
import com.ktcn.entity.siemensentity.ControlValve;
import com.ktcn.service.ControlValveService;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月2日 下午4:24:11
* 类说明
*/
@Service
public class ControlValveServiceImp implements ControlValveService{

	@Autowired
	ControlValveDao controlValveDao;

	@Override
	public void setControlValueData(ControlValve controlValve) {
		//持久化到调节阀数据表
		controlValveDao.setControlValueData(controlValve);
		
	}
}
