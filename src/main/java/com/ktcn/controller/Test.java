package com.ktcn.controller;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ktcn.entity.Opc_address;
import com.ktcn.service.Login_Service;
import com.ktcn.service.OPCAddressService;

import ch.qos.logback.core.net.server.Client;

@Controller
public class Test {
	Logger logger = LoggerFactory.getLogger(Test.class);
	@Autowired 
	Login_Service login_serviceimp;
	
	@Autowired
	OPCAddressService OPCAddressServiceImpl;
	
	@RequestMapping("test")
	public String test() {
		/*logger.info("进入测试方法");
		login_serviceimp.LoginUser();*/
		/*List<Opc_address> allAddress = OPCAddressServiceImpl.GetAllAddress();
		System.out.println(allAddress);*/
		 InputStream in = null;
		 Properties prop=new Properties(); 
			try {
				in = new BufferedInputStream(new FileInputStream("src/main/resources/OPCAddress.properties"));
				try {
					prop.load(new InputStreamReader(Client.class.getClassLoader().getResourceAsStream("OPCAddress.properties"), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 Properties p = new Properties();
			 try {
				p.load(in);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 String as = prop.getProperty("f1");
			 System.out.println(as);
		
		return "page/login";
	}
	@RequestMapping("img")
	public String img() {
		return "page/img";
	}
}
