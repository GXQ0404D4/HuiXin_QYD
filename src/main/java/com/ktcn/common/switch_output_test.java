/*package com.ktcn.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.Switch_output;
import com.ktcn.entity.Switch_output_value;
import com.ktcn.service.OPCSwitch_output_Service;

*//**
* @Title: switch_output_test.java
* @Package com.ktcn.common
* @Description: TODOswitch_output 测试类
* @author Administrator
* @date 2019年9月4日
* @version V1.0
*//*
@RestController
public class switch_output_test {
	
	 @Autowired
	    OPCSwitch_output_Service opcswitch_output_service;
	    
		@RequestMapping("switch")
		public void selectswitch(){
			
			Switch_output_value Switch= new Switch_output_value();
			Switch.setS1(1);
			Switch.setS2(2);
			Switch.setS3(3);
			Switch.setS4(4);
			Switch.setS5(5);
			Switch.setS6(6);
			Switch.setS7(7);
			Switch.setS8(8);
			Switch.setS9(9);
			Switch.setS10(10);
			Switch.setS11(11);
			Switch.setS12(12);
			System.out.println(Switch);
			//List<Switch_output> getswitch = opcswitch_output_service.getswitch(list);
		    opcswitch_output_service.getswitch(Switch);
			//System.out.println(getswitch);
		}

}
*/