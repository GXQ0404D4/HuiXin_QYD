package com.ktcn.controller.lineChartController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.service.lineChartService.CentrifugeLineChartService;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月13日 上午9:01:44
* 类说明  离心机 曲线分析（折线图）controller层 获取当天24小时数据
*/
@Component
@RestController
public class CentrifugeLineChartController {

	@Autowired
	CentrifugeLineChartService centrifugeLineChartServiceImp;
	
	@RequestMapping("/centrifugelinechart")
	public Map<String,List> getCentrifugeLineChartData(){
		
		return centrifugeLineChartServiceImp.getCentrifugeLineChartData();
		
	}
}
