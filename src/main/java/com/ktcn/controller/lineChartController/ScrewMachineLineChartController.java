package com.ktcn.controller.lineChartController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.lineChartService.ScrewMachineLineChartService;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月13日 下午4:29:25
* 类说明  曲线分析 螺杆机数据获取 （折线图）controller层 获取当天24小时数据
*/
@Component
@RestController
public class ScrewMachineLineChartController {
	
	@Autowired
	ScrewMachineLineChartService screwMachineLineChartServiceImp;
	
//	@RequestMapping("/screwmachine")
	public Map<String,List> getScrewMachineLineChartData(){
		return screwMachineLineChartServiceImp.getScrewMachineLineChartData();
		
	}

}
