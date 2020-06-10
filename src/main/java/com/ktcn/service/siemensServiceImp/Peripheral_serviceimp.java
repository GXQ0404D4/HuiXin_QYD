package com.ktcn.service.siemensServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ktcn.dao.siemensdao.Peripheral_dao;
import com.ktcn.entity.siemensentity.Peripheral_Data;
import com.ktcn.service.siemensService.Peripheral_service;
/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月10日 上午10:57:29
* 类说明
*/


@Component
@Service
public class Peripheral_serviceimp implements Peripheral_service  {
	@Autowired
	Peripheral_dao Peripheral_dao;
	

	@Override
	public void setPeripheral_data(Peripheral_Data p_da) {
		// TODO Auto-generated method stub
		Peripheral_dao.setPeripheral_data(p_da);
	}


	

}
