package com.ktcn.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.KYJdatatable.Kyj_data_table;
import com.ktcn.service.MonitoringService;

/*
 * 监控页面控制层
 */
@RestController
public class MonitoringController {
	@Resource
	private MonitoringService monitoringService;
		
	private static String BDYC="DIKYJBDYC";
	private static String ZDSD="DOKYJZDSD";
	private static String KYJQD="KYJQD";
	private static String KYJTZ="KYJTZ";
	
	//监控主角页面数据获取
	@RequestMapping("MonitorHomePage")
	public Map<String,Object> OPCRealTimeData(){
		Map<String,Object> map=new HashMap<String,Object>();
		
		Kyj_data_table kyj_data_table = monitoringService.OPCRealTimeData(1);
		Kyj_data_table kyj_data_table2 = monitoringService.OPCRealTimeData2(2);
		Kyj_data_table kyj_data_table3 = monitoringService.OPCRealTimeData3(3);
		// 监控主页面 上  数据和
		kyj_data_table.setTotal_energy(kyj_data_table.getTotal_energy()+kyj_data_table2.getTotal_energy()+kyj_data_table3.getTotal_energy());
		kyj_data_table.setActive_Service_Rate(kyj_data_table.getActive_Service_Rate()+kyj_data_table2.getActive_Service_Rate()+kyj_data_table3.getActive_Service_Rate());
		kyj_data_table.setCumulative_flow(kyj_data_table.getCumulative_flow()+kyj_data_table2.getCumulative_flow()+kyj_data_table3.getCumulative_flow());			
		List<Boolean> opcSwtichInputLGJ = monitoringService.OPCSwtichInputLGJ();
		
		map.put("kyj_data_table", kyj_data_table);
		map.put("kyj_data_table2", kyj_data_table2);
		map.put("kyj_data_table3", kyj_data_table3);
		map.put("kyj_data_table4", kyj_data_table);
		map.put("kyj_data_table5", kyj_data_table2);
		map.put("kyj_data_table6", kyj_data_table3);
		map.put("kyj_data_table7", kyj_data_table);
		
		map.put("opcSwtichInputLGJ", opcSwtichInputLGJ);
		
		return map;
	}
	//空压机1页面数据获取
	@RequestMapping("compressorA")
	public Map<String,Object> KYJ1GetData(){
		Map<String,Object> map=new HashMap<String,Object>();
		//获取所需要的switch_input 数据
		List<Integer> getKYJSwtichInput = monitoringService.GetKYJSwtichInput();
		//获取所需要的switch_output 数据
		List<Integer> getKYJSwtichOutput1 = monitoringService.GetKYJSwtichOutput();
		//存储展示状态
		List<Integer> ZTshow=new ArrayList<Integer>();
		//报警/故障
		ZTshow.add(getKYJSwtichInput.get(4));
		//空压机准备好/未准备
		ZTshow.add(getKYJSwtichInput.get(5));
		//空压机加载/卸载
		ZTshow.add(getKYJSwtichInput.get(6));
		//空压机停机故障
		ZTshow.add(getKYJSwtichInput.get(8));
		//空压机运行
		ZTshow.add(getKYJSwtichInput.get(9));
		
	    //键位判断传递
		//本地远程状态判断
		if (getKYJSwtichInput.get(3) !=0) {
			//自动手动状态判断
			if (getKYJSwtichOutput1.get(12)!=1) {
				map.put(BDYC, 1);
				map.put(ZDSD, 0);
				map.put(KYJQD, 0);
				map.put(KYJTZ, 0);				  
			} else {
				map.put(BDYC, 1);
				map.put(ZDSD, 1);
				//准备好状态
				if(getKYJSwtichInput.get(8) ==0){
				map.put(KYJQD, 1);
				map.put(KYJTZ, 0);	
				}
				if(getKYJSwtichInput.get(8) ==1){
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
		map.put("ZTshow",ZTshow);
		//传递空压机1展示数据
        map.put("kyjGetData", monitoringService.KYJGetData(1));
		return map;		
	}
	//空压机2页面数据获取
	@RequestMapping("compressorB")
	public Map<String,Object> KYJ2GetData(){
		Map<String,Object> map=new HashMap<String,Object>();
		//获取所需要的switch_input 数据
		List<Integer> getKYJSwtichInput = monitoringService.GetKYJSwtichInput();
		//获取所需要的switch_output 数据
		List<Integer> getKYJSwtichOutput1 = monitoringService.GetKYJSwtichOutput();
		//存储展示状态
		List<Integer> ZTshow=new ArrayList<Integer>();
		//报警/故障
		ZTshow.add(getKYJSwtichInput.get(14));
		//空压机准备好/未准备
		ZTshow.add(getKYJSwtichInput.get(15));
		//空压机加载/卸载
		ZTshow.add(getKYJSwtichInput.get(0));
		//空压机停机故障
		ZTshow.add(getKYJSwtichInput.get(16));
		//空压机运行
		ZTshow.add(getKYJSwtichInput.get(17));
						    
	    //键位判断传递
		if (getKYJSwtichInput.get(13) !=0) {
			if (getKYJSwtichOutput1.get(13)!=1) {
				map.put(BDYC, 1);
				map.put(ZDSD, 0);
				map.put(KYJQD, 0);
				map.put(KYJTZ, 0);				  
			} else {
				map.put(BDYC, 1);
				map.put(ZDSD, 1);
				if(getKYJSwtichInput.get(17) ==0){
				map.put(KYJQD, 1);
				map.put(KYJTZ, 0);	
				}
				if(getKYJSwtichInput.get(17) ==1){
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
		map.put("ZTshow",ZTshow);
		//传递空压机1展示数据
        map.put("kyjGetData", monitoringService.KYJGetData(2));
		return map;		
		
	}
	//空压机3页面数据获取
	@RequestMapping("compressorC")
	public Map<String,Object> KYJ3GetData(){
		Map<String,Object> map=new HashMap<String,Object>();
		//获取所需要的switch_input 数据
		List<Integer> getKYJSwtichInput = monitoringService.GetKYJSwtichInput();
		//获取所需要的switch_output 数据
		List<Integer> getKYJSwtichOutput1 = monitoringService.GetKYJSwtichOutput();
		//存储展示状态
		List<Integer> ZTshow=new ArrayList<Integer>();
		//报警/故障
		ZTshow.add(getKYJSwtichInput.get(23));
		//空压机准备好/未准备
		ZTshow.add(getKYJSwtichInput.get(24));
		//空压机加载/卸载
		ZTshow.add(getKYJSwtichInput.get(1));
		//空压机停机故障
		ZTshow.add(getKYJSwtichInput.get(25));
		//空压机运行
		ZTshow.add(getKYJSwtichInput.get(26));
						
	    //键位判断传递
		if (getKYJSwtichInput.get(22) !=0) {
			if (getKYJSwtichOutput1.get(14)!=1) {
				map.put(BDYC, 1);
				map.put(ZDSD, 0);
				map.put(KYJQD, 0);
				map.put(KYJTZ, 0);				  
			} else {
				map.put(BDYC, 1);
				map.put(ZDSD, 1);
				if(getKYJSwtichInput.get(26) ==0){
				map.put(KYJQD, 1);
				map.put(KYJTZ, 0);	
				}
				if(getKYJSwtichInput.get(26) ==1){
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
		map.put("ZTshow",ZTshow);
		//传递空压机1展示数据
        map.put("kyjGetData", monitoringService.KYJGetData(3));
		return map;		
		
	}
}
