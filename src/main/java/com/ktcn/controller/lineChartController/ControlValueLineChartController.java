package com.ktcn.controller.lineChartController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.lineChartServiceImp.ControlValueLineChartServiceImp;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月10日 下午3:03:44
* 类说明  调节阀(曲线分析) 折线图controller层  获取当天24小时数据
*/
@RestController
public class ControlValueLineChartController {
	@Autowired
	ControlValueLineChartServiceImp controlValueLineChartServiceImp;
	
	 

	@RequestMapping("/getcontrolvalue")
	public Map<String, Object> getControlValueData(){
	
		return controlValueLineChartServiceImp.getControlValueData();
		
	}
}
