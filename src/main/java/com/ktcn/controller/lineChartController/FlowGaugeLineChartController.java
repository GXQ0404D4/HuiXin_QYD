package com.ktcn.controller.lineChartController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.lineChartService.FlowGaugeLineChartService;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月10日 下午4:40:30
* 类说明 流量计    曲线分析（折线图）controller层  获取当天24小时数据
*/
@Component
@RestController
public class FlowGaugeLineChartController {

	@Autowired
	FlowGaugeLineChartService flowGaugeLineChartServiceImp;
	
//	@RequestMapping("/flowGaugeLineChart")
	public Map<String,List> getFlowGaugeLineChartData(){
		
		Map<String, List> flowGaugeLineChartData = flowGaugeLineChartServiceImp.getFlowGaugeLineChartData();
		return flowGaugeLineChartData;
		
	}
}
