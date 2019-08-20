package com.ktcn.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.OPCAddressDao;
import com.ktcn.entity.Opc_address;
import com.ktcn.service.OPCAddressService;
@Service
@Transactional
public class OPCAddressServiceImpl implements OPCAddressService{
    @Autowired
    private OPCAddressDao opcaddressdao;
	@Override
	public List<Opc_address> GetAllAddress() {
		
		return opcaddressdao.GetALLAddress();
	}

}
