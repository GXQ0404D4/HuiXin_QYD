package com.ktcn.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktcn.dao.OPCAddressDao;
import com.ktcn.entity.Opc_address;
import com.ktcn.service.OPCAddressService;
@Service
public class OPCAddressServiceImpl implements OPCAddressService{
   
	
	@Autowired (required=true)
    OPCAddressDao opcaddressdao;

	@Override
	public List<String> GetAllAddress() {
		// TODO Auto-generated method stub
		 return opcaddressdao.GetALLAddress();
	}

	@Override
	public List<String> GetSwtichAddress() {
		// TODO Auto-generated method stub
		return opcaddressdao.GetSwitchAddress();
	}
	
	

	

}
