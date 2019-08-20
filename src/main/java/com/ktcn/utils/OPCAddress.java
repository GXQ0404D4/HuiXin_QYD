package com.ktcn.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktcn.entity.Opc_address;
import com.ktcn.service.OPCAddressService;
@Controller
public class OPCAddress {
	/*private  static OPCAddress OPCADDRESS= new OPCAddress();
	
	public OPCAddress(){}
	
	@SuppressWarnings("unused")
	private final static OPCAddress getOPCADDRESS(){
		
		return OPCADDRESS;		
	}*/
	
	@Autowired
	private   OPCAddressService OPCAddressServiceImpl;
	
	@ResponseBody
	@RequestMapping("/opcaddress")
	public final   List<Opc_address> GetAllAddress(){
		//查询所有opc地址 		
		List<Opc_address> getALLAddress = OPCAddressServiceImpl.GetAllAddress();
		for (Opc_address opc_address : getALLAddress) {
			String tag_name = opc_address.getTag_name();
			System.out.println(tag_name+"tag_name");
		}
		
		return getALLAddress;
		
	}
	
	

}
