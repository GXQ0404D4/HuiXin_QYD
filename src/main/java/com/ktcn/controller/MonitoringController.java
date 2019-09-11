package com.ktcn.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.swing.plaf.synth.SynthStyle;

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
	
    
	
	//监控主角页面数据获取
	@RequestMapping("MonitorHomePage")
	public Map<String,Object> OPCRealTimeData(){
		Map<String,Object> map=new HashMap<String,Object>();
		
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
		Map<String,Object> map=new HashMap<String,Object>();
		//获取所需要的switch_input 数据
		List<Switch_input> getKYJSwtichInput = monitoringService.GetKYJSwtichInput();					
		//获取按钮上面展示 机器点位状态数据 传到前台 list集合
		List<Integer> SwitchInputList=new ArrayList<Integer>();
		for (Switch_input switch_input : getKYJSwtichInput) {
             SwitchInputList.add(switch_input.getSwitch_input_data());			 
		}	
		int YCBD= SwitchInputList.get(0);
				
		//获取所需要的switch_output 数据
		List<Switch_output> getKYJSwtichOutput = monitoringService.GetKYJSwtichOutput();
		List<Integer> SwitchOutputList=new ArrayList<Integer>();
		for (Switch_output switch_output : getKYJSwtichOutput) {
			 SwitchOutputList.add(switch_output.getSwitch_ouput_data());
		}
		Integer KYJQD = SwitchOutputList.get(0);
		Integer KYJTZ = SwitchOutputList.get(1);
		Integer KYJZDSD = SwitchOutputList.get(2);
			
	    //键位判断传递
		if (YCBD !=0) {
			if (KYJZDSD!=0) {
				map.put("DIKYJBDYC", 1);
				map.put("DOKYJZDSD", KYJZDSD);
				map.put("KYJQD", KYJQD);
				map.put("KYJTZ", KYJTZ);
								  
			} else {
				map.put("DIKYJBDYC", 1);
				map.put("DOKYJZDSD", KYJZDSD);
				map.put("KYJQD", KYJQD);
				map.put("KYJTZ", KYJTZ);
			}			
		} else {
			map.put("DIKYJBDYC", 0);
			map.put("DOKYJZDSD", KYJZDSD);
			map.put("KYJQD", 0);
			map.put("KYJTZ", 0);
		}			
		//传递按钮状态参数
		map.put("getKYJSwtichInput",SwitchInputList);
		//传递空压机1展示数据
        map.put("kyj1GetData", monitoringService.KYJ1GetData());
		return map;		
	}
	
	
	
	//空压机2页面数据获取
	@RequestMapping("compressorB")
	public Map<String,Object> KYJ2GetData(){
		Map<String,Object> map=new HashMap<String,Object>();
		//获取所需要的switch_input 数据
		List<Switch_input> getKYJSwtichInput2 = monitoringService.GetKYJSwtichInput2();			
		//获取按钮上面展示 机器点位状态数据 传到前台 list集合
		List<Integer> SwitchInputList=new ArrayList<Integer>();
				for (Switch_input switch_input : getKYJSwtichInput2) {
		             SwitchInputList.add(switch_input.getSwitch_input_data());			 
				}	
				int YCBD= SwitchInputList.get(0);
				System.out.println(SwitchInputList);
		
		List<Switch_output> getKYJSwtichOutput2 = monitoringService.GetKYJSwtichOutput2();
		List<Integer> SwitchOutputList=new ArrayList<Integer>();
				for (Switch_output switch_output : getKYJSwtichOutput2) {
					 SwitchOutputList.add(switch_output.getSwitch_ouput_data());
				}
		Integer KYJQD = SwitchOutputList.get(0);
		Integer KYJTZ = SwitchOutputList.get(1);
		Integer KYJZDSD = SwitchOutputList.get(2);
		System.out.println(KYJZDSD);
		System.out.println(KYJQD);
		System.out.println(KYJTZ);
		
		//键位判断传递
		if (YCBD !=0) {
			if (KYJZDSD!=0) {
				map.put("DIKYJBDYC", 1);
				map.put("DOKYJZDSD", KYJZDSD);
				map.put("KYJQD", KYJQD);
				map.put("KYJTZ", KYJTZ);
								  
			} else {
				map.put("DIKYJBDYC", 1);
				map.put("DOKYJZDSD", KYJZDSD);
				map.put("KYJQD", KYJQD);
				map.put("KYJTZ", KYJTZ);
			}			
		} else {
			map.put("DIKYJBDYC", 0);
			map.put("DOKYJZDSD", KYJZDSD);
			map.put("KYJQD", 0);
			map.put("KYJTZ", 0);
		}			
		
		//传递按钮状态参数
		map.put("getKYJSwtichInput2", SwitchInputList);
		//传递空压机2页面参数
		map.put("kyj2GetData", monitoringService.KYJ2GetData());
		return map;
		
	}
	
	
	
	//空压机3页面数据获取
	@RequestMapping("compressorC")
	public Map<String,Object> KYJ3GetData(){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Switch_input> getKYJSwtichInput3 = monitoringService.GetKYJSwtichInput3();			
		//获取按钮上面展示 机器点位状态数据 传到前台 list集合
		List<Integer> SwitchInputList=new ArrayList<Integer>();
				for (Switch_input switch_input : getKYJSwtichInput3) {
				       SwitchInputList.add(switch_input.getSwitch_input_data());			 
				    }	
				int YCBD= SwitchInputList.get(0);
				
		
		List<Switch_output> getKYJSwtichOutput3 = monitoringService.GetKYJSwtichOutput3();
		List<Integer> SwitchOutputList=new ArrayList<Integer>();
		for (Switch_output switch_output : getKYJSwtichOutput3) {
			 SwitchOutputList.add(switch_output.getSwitch_ouput_data());
		}
			Integer KYJQD = SwitchOutputList.get(0);
			Integer KYJTZ = SwitchOutputList.get(1);
			Integer KYJZDSD = SwitchOutputList.get(2);
		
			//键位判断传递
			if (YCBD !=0) {
				if (KYJZDSD!=0) {
					map.put("DIKYJBDYC", 1);
					map.put("DOKYJZDSD", KYJZDSD);
					map.put("KYJQD", KYJQD);
					map.put("KYJTZ", KYJTZ);
									  
				} else {
					map.put("DIKYJBDYC", 1);
					map.put("DOKYJZDSD", KYJZDSD);
					map.put("KYJQD", KYJQD);
					map.put("KYJTZ", KYJTZ);
				}			
			} else {
				map.put("DIKYJBDYC", 0);
				map.put("DOKYJZDSD", KYJZDSD);
				map.put("KYJQD", 0);
				map.put("KYJTZ", 0);
			}			
	
		//传递按钮状态参数
		map.put("getKYJSwtichInput3", SwitchInputList);
		//传递空压机3页面参数
		map.put("kyj3GetData", monitoringService.KYJ3GetData());
		return map;
		
	}
}
