package com.ktcn.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktcn.dao.OPCSwitch_output_Dao;
import com.ktcn.entity.Switch_output;
import com.ktcn.entity.Switch_output_value;
import com.ktcn.service.OPCSwitch_output_Service;

/**
* @Title: OPCSwitch_output_ServiceImp.java
* @Package com.ktcn.service.serviceImpl
* @Description: TODO opcswitch_output_serviceimp
* @author GXQ
* @date 2019年9月2日
* @version V1.0
*/
@Service
public class OPCSwitch_output_ServiceImp implements OPCSwitch_output_Service{
    
	@Autowired
	OPCSwitch_output_Dao opcwitch_output_dao;

	@Override
	public void getswitch(Switch_output_value switch1) {
		// TODO Auto-generated method stub
		 opcwitch_output_dao.getswitch(switch1);
	}
	

	

	
 
	
}
