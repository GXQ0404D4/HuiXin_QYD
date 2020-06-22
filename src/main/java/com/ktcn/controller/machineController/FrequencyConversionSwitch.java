//package com.ktcn.controller.machineController;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ktcn.simens.utils.SiemensPlcConfig;
//
//import HslCommunication.Core.Types.OperateResult;
//import HslCommunication.Profinet.Siemens.SiemensS7Net;
//
///**
//* @author 作者 :Runaway programmer
//* @version 创建时间：2020年1月15日 下午3:36:38
//* 类说明  监控界面烧结界面  启动停止
//*/
//@RestController
//public class FrequencyConversionSwitch {
//	@Autowired
//	SiemensPlcConfig siemensPlcConfig;
//	
//	private String FCCNAME;
//	
//
//
//	@RequestMapping("/fc_incident")
//	public String FrequencyConversionControllerIncident(String FCCname,Boolean FCCof) {
//		SiemensS7Net siemensPLC = siemensPlcConfig.getSiemensPLC();
//		FCCNAME=FCCname;
//		
//		if (siemensPLC.ConnectServer().IsSuccess) {
//			switch (FCCname) {
//			case "MD53":
//				OperateResult write1 = siemensPLC.Write("DB4.2.4", FCCof);
//				if (siemensPLC.ReadBool("DB4.2.4").Content==FCCof) {
//					return write1.Message;
//				} else {
//					return FCCNAME;
//				}
//			case "MD54":
//				OperateResult write2 = siemensPLC.Write("DB4.2.7", FCCof);
//				if (siemensPLC.ReadBool("DB4.2.7").Content==FCCof) {
//					return write2.Message;
//				} else {
//					return FCCNAME;
//				}
//				
//			}
//			
//			siemensPLC.ConnectClose();
//		}else {
//			System.out.println("failed:" +siemensPLC.ConnectServer().Message);
//		}
//		return FCCNAME;
//	}
//}
