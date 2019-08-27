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
	
	public List<Opc_address> GetAllAddress(){	
		/*List<Opc_address> allAddress = OPCAddressServiceImpl.GetAllAddress();*/
		
		/*for (Opc_address address : allAddress) {
			String name = address.getTag_name();
			System.out.println(name);
		}*/
		//查询所有点位值	
		List<Opc_address> getAllAddress = OPCAddressServiceImpl.GetAllAddress();
		System.out.println(getAllAddress);
		
		return getAllAddress;
		
	}
	
	

}
