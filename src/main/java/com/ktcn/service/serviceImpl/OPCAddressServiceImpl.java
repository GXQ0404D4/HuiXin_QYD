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
	
	
	public List<Opc_address> GetAllAddress() {	
	
		return opcaddressdao.GetALLAddress();
	}

}
