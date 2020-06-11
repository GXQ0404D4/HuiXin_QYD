package com.ktcn.controller.siemensController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.simensaddress.Monitoring_Address;
import com.ktcn.simens.utils.SiemensPlcConfig;

import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
 * @author 作者 :Runaway programmer
 * @version 创建时间：2020年6月11日 上午10:21:29 
 * 类说明 : 监控界面数据获取以及操作
 */

@RestController
public class MonitoringController {

	@Autowired
	SiemensPlcConfig SiemensPlcConfig;
	@Autowired
	Monitoring_Address MT_Address;
	
	
	@RequestMapping("/monitoringPage")
	public Map <String,Object> getMonitoringData() {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		Map <String,Object> MMData=new HashMap<String,Object>();
		if (siemensPLC.ConnectServer().IsSuccess) {
			MMData.put("MD0",siemensPLC.ReadFloat(MT_Address.getMD0()).Content);
			MMData.put("MD0",siemensPLC.ReadFloat(MT_Address.getMD0()).Content);
			MMData.put("MD1",siemensPLC.ReadFloat(MT_Address.getMD1()).Content);
			MMData.put("MD2",siemensPLC.ReadFloat(MT_Address.getMD2()).Content);
			MMData.put("MD3",siemensPLC.ReadFloat(MT_Address.getMD3()).Content);
			MMData.put("MD4",siemensPLC.ReadFloat(MT_Address.getMD4()).Content);
			MMData.put("MD5",siemensPLC.ReadFloat(MT_Address.getMD5()).Content);
			MMData.put("MD6",siemensPLC.ReadFloat(MT_Address.getMD6()).Content);
			MMData.put("MD7",siemensPLC.ReadFloat(MT_Address.getMD7()).Content);
			MMData.put("MD8",siemensPLC.ReadFloat(MT_Address.getMD8()).Content);
			MMData.put("MD9",siemensPLC.ReadFloat(MT_Address.getMD9()).Content);
			MMData.put("MD10",siemensPLC.ReadFloat(MT_Address.getMD10()).Content);
			MMData.put("MD11",siemensPLC.ReadFloat(MT_Address.getMD11()).Content);
			MMData.put("MD12",siemensPLC.ReadFloat(MT_Address.getMD12()).Content);
			MMData.put("MD13",siemensPLC.ReadFloat(MT_Address.getMD13()).Content);
			MMData.put("MD14",siemensPLC.ReadFloat(MT_Address.getMD14()).Content);
			
			MMData.put("MD15",siemensPLC.ReadFloat(MT_Address.getMD15()).Content);
			MMData.put("MD16",siemensPLC.ReadFloat(MT_Address.getMD16()).Content);
			MMData.put("MD17",siemensPLC.ReadFloat(MT_Address.getMD17()).Content);
			MMData.put("MD18",siemensPLC.ReadFloat(MT_Address.getMD18()).Content);
			MMData.put("MD19",siemensPLC.ReadFloat(MT_Address.getMD19()).Content);
			MMData.put("MD20",siemensPLC.ReadFloat(MT_Address.getMD20()).Content);
			
			MMData.put("MD21",siemensPLC.ReadFloat(MT_Address.getMD21()).Content);
			MMData.put("MD22",siemensPLC.ReadBool(MT_Address.getMD22()).Content);
			MMData.put("MD23",siemensPLC.ReadFloat(MT_Address.getMD23()).Content);
			MMData.put("MD24",siemensPLC.ReadFloat(MT_Address.getMD24()).Content);
			
			MMData.put("MD25",siemensPLC.ReadFloat(MT_Address.getMD25()).Content);
			MMData.put("MD26",siemensPLC.ReadBool(MT_Address.getMD26()).Content);
			MMData.put("MD27",siemensPLC.ReadFloat(MT_Address.getMD27()).Content);
			MMData.put("MD28",siemensPLC.ReadFloat(MT_Address.getMD28()).Content);
			
			MMData.put("MD29",siemensPLC.ReadFloat(MT_Address.getMD29()).Content);
			MMData.put("MD30",siemensPLC.ReadBool(MT_Address.getMD30()).Content);
			MMData.put("MD31",siemensPLC.ReadFloat(MT_Address.getMD31()).Content);
			MMData.put("MD32",siemensPLC.ReadFloat(MT_Address.getMD32()).Content);
			
			MMData.put("MD33",siemensPLC.ReadFloat(MT_Address.getMD33()).Content);
			MMData.put("MD34",siemensPLC.ReadFloat(MT_Address.getMD34()).Content);
			MMData.put("MD35",siemensPLC.ReadFloat(MT_Address.getMD35()).Content);
			
			MMData.put("MD35",siemensPLC.ReadBool(MT_Address.getMD36()).Content);
			MMData.put("MD35",siemensPLC.ReadBool(MT_Address.getMD37()).Content);
			MMData.put("MD35",siemensPLC.ReadBool(MT_Address.getMD38()).Content);
			MMData.put("MD35",siemensPLC.ReadBool(MT_Address.getMD39()).Content);
			MMData.put("MD35",siemensPLC.ReadBool(MT_Address.getMD40()).Content);
		} else {
			System.out.println("failed:" +siemensPLC.ConnectServer().Message+"监控页面数据");
		}
		System.out.println(MMData);
		siemensPLC.ConnectClose();
		// 数据读取完毕 获取当前时间
		return MMData;
	}
//    	监控界面三个重置按钮
	@RequestMapping("/resetButtion")
	public String setFUWEI(String MDname) {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		if (siemensPLC.ConnectServer().IsSuccess) {
		if (MDname.equals("MD22")) {
			String md22 = MT_Address.getMD22();
			siemensPLC.Write(md22, true);
			System.out.println(siemensPLC.ReadBool(md22).Content);
			siemensPLC.Write(md22, false);
			System.out.println(siemensPLC.ReadBool(md22).Content);
			return "22succeed";
		}if (MDname.equals("MD26")) {
			String md26 = MT_Address.getMD26();
			siemensPLC.Write(md26, true);
			siemensPLC.Write(md26, false);
			return "26succeed";
		}if (MDname.equals("MD30")) {
			String md30 = MT_Address.getMD30();
			siemensPLC.Write(md30, true);
			siemensPLC.Write(md30, false);
			return "30succeed";
		}
		}else {
			System.out.println("failed:" +siemensPLC.ConnectServer().Message+"监控页面数据");
			return "failed";
		}
		return "ununited";
		
	}
	
//	监控界面5台空压机控制按钮
	@RequestMapping("/compressButtion")
	public String setCompressorButton(String MDname,Boolean MDTF) {
		System.out.println(MDname+"__________"+MDTF);
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		if (siemensPLC.ConnectServer().IsSuccess) {
			
			if (MDname.equals("MDA")) {
				if (MDTF.equals(true)) {
					siemensPLC.Write("DB21.0.2", true);
					siemensPLC.Write("DB21.0.2", false);
					System.out.println("MDA"+true);
				}if (MDTF.equals(false)) {
					siemensPLC.Write("DB21.0.3", true);
					siemensPLC.Write("DB21.0.3", false);
					System.out.println("MDA"+false);
				}
				return "MDA_succeed";
			}if (MDname.equals("MDB")) {
				if (MDTF.equals(true)) {
					siemensPLC.Write("DB21.0.0", true);
					siemensPLC.Write("DB21.0.0", false);
					System.out.println("MDB"+true);
				}if (MDTF.equals(false)) {
					siemensPLC.Write("DB21.0.1", true);
					siemensPLC.Write("DB21.0.1", false);
					System.out.println("MDB"+false);
				}
				return "MDB_succeed";
			}if (MDname.equals("MDC")){
				if (MDTF.equals(true)) {
					siemensPLC.Write("DB21.0.4", true);
					siemensPLC.Write("DB21.0.4", false);
				}if (MDTF.equals(false)) {
					siemensPLC.Write("DB21.0.5", true);
					siemensPLC.Write("DB21.0.5", false);
				}
				return "MDC_succeed";
			}if (MDname.equals("MDD")){
				if (MDTF.equals(true)) {
					siemensPLC.Write("DB21.0.6", true);
					siemensPLC.Write("DB21.0.6", false);
				}if (MDTF.equals(false)) {
					siemensPLC.Write("DB21.0.7", true);
					siemensPLC.Write("DB21.0.7", false);
				}
				return "MDD_succeed";
			}if (MDname.equals("MDE")){
				if (MDTF.equals(true)) {
					siemensPLC.Write("DB21.1.0", true);
					siemensPLC.Write("DB21.1.0", false);
				}if (MDTF.equals(false)) {
					siemensPLC.Write("DB21.1.1", true);
					siemensPLC.Write("DB21.1.1", false);
				}
				return "MDE_succeed";
			}
			
		}else {
			return "failed";
		}
		siemensPLC.ConnectClose();
		return "ununited";
		
	}
}
