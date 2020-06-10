package com.ktcn.service.siemensServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktcn.dao.siemensdao.Newly_dao;
import com.ktcn.entity.siemensentity.Peripheral_qt;
import com.ktcn.service.siemensService.Newly_service;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月10日 上午10:57:02
* 类说明
*/
@Service
public class Newly_serviceimp implements Newly_service{
	@Autowired
	Newly_dao Newly_dao;
	
	public void setNewlyData(Peripheral_qt newlyData) {
		Newly_dao.setNewlyData(newlyData);
	}

}
