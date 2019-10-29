package com.ktcn.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.Real_time_data;
import com.ktcn.entity.Switch_input;
import com.ktcn.entity.Switch_output;
import com.ktcn.service.MonitoringService;

/*
 * 监控页面控制层
 */
@RestController
public class MonitoringController {
	@Resource
	private MonitoringService monitoringService;
	
	static Map<String,Object> map=new HashMap<String,Object>();
	
	private static String BDYC="DIKYJBDYC";
	private static String ZDSD="DOKYJZDSD";
	private static String KYJQD="KYJQD";
	private static String KYJTZ="KYJTZ";
	
	//监控主角页面数据获取
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
	//空压机1页面数据获取
	@RequestMapping("compressorA")
	public Map<String,Object> KYJ1GetData(){
		//获取所需要的switch_input 数据
		List<Switch_input> getKYJSwtichInput = monitoringService.GetKYJSwtichInput();					
		//获取按钮上面展示 机器点位状态数据 传到前台 list集合
		List<Integer> SwitchInputList1=new ArrayList<Integer>();
		for (Switch_input switch_input : getKYJSwtichInput) {
             SwitchInputList1.add(switch_input.getSwitch_input_data());  
		}	
		int YCBD1= SwitchInputList1.get(0);
		Integer KYJYX1 = SwitchInputList1.get(5);
		//获取所需要的switch_output 数据
		List<Switch_output> getKYJSwtichOutput1 = monitoringService.GetKYJSwtichOutput();		
		Integer KYJZDSD1 = getKYJSwtichOutput1.get(0).getSwitch_ouput_data();
	    //键位判断传递
		if (YCBD1 !=0) {
			if (KYJZDSD1!=1) {
				map.put(BDYC, 1);
				map.put(ZDSD, 0);
				map.put(KYJQD, 0);
				map.put(KYJTZ, 0);				  
			} else {
				map.put(BDYC, 1);
				map.put(ZDSD, 1);
				if(KYJYX1 ==0){
				map.put(KYJQD, 1);
				map.put(KYJTZ, 0);	
				}
				if(KYJYX1 ==1){
				map.put(KYJQD, 0);
				map.put(KYJTZ, 1);	
				}				
			}			
		} else {
			map.put(BDYC, 0);
			map.put(ZDSD, 0);
			map.put(KYJQD, 0);
			map.put(KYJTZ, 0);
		}			
		//传递按钮状态参数
		map.put("getKYJSwtichInput",SwitchInputList1);
		//传递空压机1展示数据
        map.put("kyj1GetData", monitoringService.KYJ1GetData());
		return map;		
	}
	//空压机2页面数据获取
	@RequestMapping("compressorB")
	public Map<String,Object> KYJ2GetData(){
		//获取所需要的switch_input 数据
		//获取所需要的switch_input 数据
				List<Switch_input> getKYJSwtichInput2 = monitoringService.GetKYJSwtichInput2();					
				//获取按钮上面展示 机器点位状态数据 传到前台 list集合
				List<Integer> SwitchInputList2=new ArrayList<Integer>();
				 
				for (Switch_input switch_input : getKYJSwtichInput2) {
		             SwitchInputList2.add(switch_input.getSwitch_input_data());  
				}	
				int YCBD2= SwitchInputList2.get(0);
				Integer KYJYX2 = SwitchInputList2.get(4);
				//获取所需要的switch_output 数据
				List<Switch_output> getKYJSwtichOutput2 = monitoringService.GetKYJSwtichOutput2();		
				Integer KYJZDSD2 = getKYJSwtichOutput2.get(0).getSwitch_ouput_data();
		//键位判断传递
				if (YCBD2 !=0) {
					if (KYJZDSD2 !=1) {
						map.put(BDYC, 1);
						map.put(ZDSD, 0);
						map.put(KYJQD, 0);
						map.put(KYJTZ, 0);				  
					} else {
						map.put(BDYC, 1);
						map.put(ZDSD, 1);
						if(KYJYX2 ==0){
							map.put(KYJQD, 1);
							map.put(KYJTZ, 0);	
							}
							if(KYJYX2 ==1){
							map.put(KYJQD, 0);
							map.put(KYJTZ, 1);	
							}				
					}			
				} else {
					map.put(BDYC, 0);
					map.put(ZDSD, 0);
					map.put(KYJQD, 0);
					map.put(KYJTZ, 0);
				}			
		
		//传递按钮状态参数
		map.put("getKYJSwtichInput2", SwitchInputList2);
		//传递空压机2页面参数
		map.put("kyj2GetData", monitoringService.KYJ2GetData());
		return map;
		
	}
	//空压机3页面数据获取
	@RequestMapping("compressorC")
	public Map<String,Object> KYJ3GetData(){
		List<Switch_input> getKYJSwtichInput3 = monitoringService.GetKYJSwtichInput3();					
		//获取按钮上面展示 机器点位状态数据 传到前台 list集合
		List<Integer> SwitchInputList3=new ArrayList<Integer>();
		 
		for (Switch_input switch_input : getKYJSwtichInput3) {
             SwitchInputList3.add(switch_input.getSwitch_input_data());  
		}	
		int YCBD3= SwitchInputList3.get(0);
		Integer KYJYX3 = SwitchInputList3.get(4);
		//获取所需要的switch_output 数据
		List<Switch_output> getKYJSwtichOutput3 = monitoringService.GetKYJSwtichOutput3();		
		Integer KYJZDSD3 = getKYJSwtichOutput3.get(0).getSwitch_ouput_data();
			//键位判断传递
			if (YCBD3 !=0) {
				if (KYJZDSD3 !=1) {
					map.put(BDYC, 1);
					map.put(ZDSD, 0);
					map.put(KYJQD, 0);
					map.put(KYJTZ, 0);				  
				} else {
					map.put(BDYC, 1);
					map.put(ZDSD, 1);
					if(KYJYX3 ==0){
						map.put(KYJQD, 1);
						map.put(KYJTZ, 0);	
						}
						if(KYJYX3 ==1){
						map.put(KYJQD, 0);
						map.put(KYJTZ, 1);	
						}		
				}			
			} else {
				map.put(BDYC, 0);
				map.put(ZDSD, 0);
				map.put(KYJQD, 0);
				map.put(KYJTZ, 0);
			}			
	
		//传递按钮状态参数
		map.put("getKYJSwtichInput3", SwitchInputList3);
		//传递空压机3页面参数
		map.put("kyj3GetData", monitoringService.KYJ3GetData());
		return map;
		
	}
}
