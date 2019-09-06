package com.ktcn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.Real_time_data;
import com.ktcn.service.MonitoringService;

/*
 * 监控页面控制层
 */
@RestController
public class MonitoringController {
	@Resource
	private MonitoringService monitoringService;
	
	static Map<String,Object> map=new HashMap<String,Object>();
	
	@RequestMapping("MonitorHomePage")
	public Map<String,Object> OPCRealTimeData(){
		
		Real_time_data opcRealTimeData = monitoringService.OPCRealTimeData();
		opcRealTimeData.setActive_Service_Rate1(opcRealTimeData.getActive_Service_Rate1()+opcRealTimeData.getActive_Service_Rate2()+opcRealTimeData.getActive_Service_Rate3());
		opcRealTimeData.setTotal_energy_1(opcRealTimeData.getTotal_energy_1()+opcRealTimeData.getTotal_energy_2()+opcRealTimeData.getTotal_energy_3());		
		List<Boolean> opcSwtichInputLGJ = monitoringService.OPCSwtichInputLGJ();
		map.put("opcRealTimeData", opcRealTimeData);
		map.put("opcSwtichInputLGJ", opcSwtichInputLGJ);
		
		return map;
	}
	@RequestMapping("compressorA")
	public Map<String,Object> KYJ1GetData(){
		
        map.put("kyj1GetData", monitoringService.KYJ1GetData());
		return map;
		
	}
	
	@RequestMapping("compressorB")
	public Map<String,Object> KYJ2GetData(){
		
		map.put("kyj2GetData", monitoringService.KYJ2GetData());
		return map;
		
	}
	
	@RequestMapping("compressorC")
	public Map<String,Object> KYJ3GetData(){
        
		map.put("kyj3GetData", monitoringService.KYJ3GetData());
		return map;
		
	}
}
