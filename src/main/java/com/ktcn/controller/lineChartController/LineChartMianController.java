package com.ktcn.controller.lineChartController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.lineChartService.CentrifugeLineChartService;
import com.ktcn.service.lineChartService.ControlValueLineChartService;
import com.ktcn.service.lineChartService.FlowGaugeLineChartService;
import com.ktcn.service.lineChartService.ScrewMachineLineChartService;
import com.ktcn.service.lineChartServiceImp.ControlValueLineChartServiceImp;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月16日 上午11:29:51
* 类说明
*/
@RestController
public class LineChartMianController {
	@Autowired
	ScrewMachineLineChartService screwMachineLineChartServiceImp;
	@Autowired
	FlowGaugeLineChartService flowGaugeLineChartServiceImp;
	@Autowired
	ControlValueLineChartService controlValueLineChartServiceImp;
	@Autowired
	CentrifugeLineChartService centrifugeLineChartServiceImp;
	

	@RequestMapping("/LineChartMian")
	public Map<String,Map> getLineChartMianControllerData(){
		Map<String,Map> LineChartMap=new HashMap<String,Map>();
		Map<String, List> centrifugeLineChartData = centrifugeLineChartServiceImp.getCentrifugeLineChartData();
		Map<String, Object> controlValueData = controlValueLineChartServiceImp.getControlValueData();
		Map<String, List> flowGaugeLineChartData = flowGaugeLineChartServiceImp.getFlowGaugeLineChartData();
		Map<String, List> screwMachineLineChartData = screwMachineLineChartServiceImp.getScrewMachineLineChartData();
		System.out.println(centrifugeLineChartData);
		System.out.println(controlValueData);
		System.out.println(flowGaugeLineChartData);
		System.out.println(screwMachineLineChartData);
		LineChartMap.put("centrifugeLineChartData", centrifugeLineChartData);
		LineChartMap.put("controlValueData", controlValueData);
		LineChartMap.put("flowGaugeLineChartData", flowGaugeLineChartData);
		LineChartMap.put("screwMachineLineChartData", screwMachineLineChartData);
		return LineChartMap;
		
	}
}
