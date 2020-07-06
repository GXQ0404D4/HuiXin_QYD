package com.ktcn.controller.semensData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.siemensentity.ScrewMachine;
import com.ktcn.service.siemensService.ScrewMachine_service;
import com.ktcn.simens.PLCdata.ScrewMachineDatagain;
import com.ktcn.simens.utils.EmptyUtil;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月15日 下午3:22:59
* 类说明
*/
@RestController
public class ScrewMachineDataController {
	@Autowired
	ScrewMachineDatagain ScrewMachineDatagain;
	@Autowired
	ScrewMachine_service ScrewMachine_serviceimp;
	
//	Map<String, ScrewMachine> SMData;
	
	@Autowired
	EmptyUtil emptyUtil;
	
//	@Async
	@Scheduled(cron = "0/15 * * * * ?")
//	方法执行完成后50毫秒再启动
//	@Scheduled(fixedDelay = 500)
	public void setScrewMachineDataBB() {
//		System.out.println("___"+"空压机实时数据4"+  new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
		Map<String, ScrewMachine> screwMachineData = ScrewMachineDatagain.getScrewMachineData();
		//集合对象非空判断
		if (emptyUtil.isNotEmpty(screwMachineData.get("ScrewMachine1")) && emptyUtil.isNotEmpty(screwMachineData.get("ScrewMachine2")) && emptyUtil.isNotEmpty(screwMachineData.get("ScrewMachine3")) && emptyUtil.isNotEmpty(screwMachineData.get("ScrewMachine4")) && emptyUtil.isNotEmpty(screwMachineData.get("ScrewMachine5"))) {
			// 空压机数据 存入常量SCmapdata集合里
			ScrewMachine_serviceimp.setScrewMachineData(screwMachineData);
//			SMData=screwMachineData;
			//低压机 高压机 报警监测
			Boolean lgjA13 = (Boolean) screwMachineData.get("ScrewMachine1").getLGJ13();
			Boolean lgjA14 = (Boolean) screwMachineData.get("ScrewMachine1").getLGJ14();
			Boolean lgjA15 = (Boolean) screwMachineData.get("ScrewMachine1").getLGJ15();
			Boolean lgjA16 = (Boolean) screwMachineData.get("ScrewMachine1").getLGJ16();
			
			Boolean lgjB13 = (Boolean) screwMachineData.get("ScrewMachine2").getLGJ13();
			Boolean lgjB14 = (Boolean) screwMachineData.get("ScrewMachine2").getLGJ14();
			Boolean lgjB15 = (Boolean) screwMachineData.get("ScrewMachine2").getLGJ15();
			Boolean lgjB16 = (Boolean) screwMachineData.get("ScrewMachine2").getLGJ16();

			Boolean lgjC13 = (Boolean) screwMachineData.get("ScrewMachine3").getLGJ13();
			Boolean lgjC14 = (Boolean) screwMachineData.get("ScrewMachine3").getLGJ14();
			Boolean lgjC15 = (Boolean) screwMachineData.get("ScrewMachine3").getLGJ15();
			Boolean lgjC16 = (Boolean) screwMachineData.get("ScrewMachine3").getLGJ16();
			
			Boolean lgjD13 = (Boolean) screwMachineData.get("ScrewMachine4").getLGJ13();
			Boolean lgjD14 = (Boolean) screwMachineData.get("ScrewMachine4").getLGJ14();
			Boolean lgjD15 = (Boolean) screwMachineData.get("ScrewMachine4").getLGJ15();
			Boolean lgjD16 = (Boolean) screwMachineData.get("ScrewMachine4").getLGJ16();
			
			Boolean lgjE13 = (Boolean) screwMachineData.get("ScrewMachine5").getLGJ13();
			Boolean lgjE14 = (Boolean) screwMachineData.get("ScrewMachine5").getLGJ14();
			Boolean lgjE15 = (Boolean) screwMachineData.get("ScrewMachine5").getLGJ15();
			Boolean lgjE16 = (Boolean) screwMachineData.get("ScrewMachine5").getLGJ16();
			if (lgjA13==true || lgjA14==true || lgjA15==true || lgjA16==true) {
				ScrewMachine_serviceimp.setBJScrewMachineData(screwMachineData.get("ScrewMachine1"));
			}
			if (lgjB13==true || lgjB14==true || lgjB15==true || lgjB16==true) {
				ScrewMachine_serviceimp.setBJScrewMachineData(screwMachineData.get("ScrewMachine2"));
			}
			if (lgjC13==true || lgjC14==true || lgjC15==true || lgjC16==true) {
				ScrewMachine_serviceimp.setBJScrewMachineData(screwMachineData.get("ScrewMachine3"));
			}
			if (lgjD13==true || lgjD14==true || lgjD15==true || lgjD16==true) {
				ScrewMachine_serviceimp.setBJScrewMachineData(screwMachineData.get("ScrewMachine4"));
			}
			if (lgjE13==true || lgjE14==true || lgjE15==true || lgjE16==true) {
				ScrewMachine_serviceimp.setBJScrewMachineData(screwMachineData.get("ScrewMachine5"));
			}
		}
		
			
	}
	//每小时执行一次
	@Scheduled(cron = "0 0 * * * ?")
//	@Scheduled(cron = "0/1 * * * * ?")
	public void setRealData(){
//		Map<String, ScrewMachine> screwMachineData = ScrewMachineDatagain.getScrewMachineData();
		ScrewMachine_serviceimp.setScrewMachineDataHour(ScrewMachineDatagain.getScrewMachineData());
	}
	
//  定时删除当前一个月之前的数据
//	@Scheduled(cron = "0 0 1 ? * L") //每周星期天凌晨1点执行一次
	@Scheduled(cron = "0 0 1 * * ?") //每天凌晨1点执行一次
	public void deleteScrewMachineReamlData() {
		ScrewMachine_serviceimp.deleteScrewMachineReamlData();
	}
	
	//页面刷新获取实时数据
	@RequestMapping("/screwMachineRealData")
	public Map<String, ScrewMachine> getRealDataPage(){
		return ScrewMachineDatagain.getScrewMachineData();

	}
}
