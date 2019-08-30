package com.ktcn.utils;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.dao.OPCAddressDao;
import com.ktcn.entity.Opc_address;
import com.ktcn.service.OPCAddressService;
import com.ktcn.service.serviceImpl.OPCAddressServiceImpl;
@RestController
public class OPCAddress {
		
	@Autowired
    OPCAddressService OPCAddressServiceImpl;
	
	@RequestMapping("/opcaddress")	
	public List<String> GetAllAddress(){	
		//查询Datamaster 所有点位		
		return OPCAddressServiceImpl.GetAllAddress();
		
	}
		

}
