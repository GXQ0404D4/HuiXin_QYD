package com.ktcn.controller.machineController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.simens.utils.SiemensPlcConfig;

import HslCommunication.Core.Types.OperateResult;
import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月15日 下午3:36:38
* 类说明  监控界面烧结界面  启动停止
*/
@RestController
public class FrequencyConversionSwitch {
	@Autowired
	SiemensPlcConfig siemensPlcConfig;

	@RequestMapping("/fc_incident")
	public String FrequencyConversionControllerIncident(String FCname,String FCof) {
		SiemensS7Net siemensPLC = siemensPlcConfig.getSiemensPLC();
		if (siemensPLC.ConnectServer().IsSuccess) {
			switch (FCname) {
			case "fcA":
				System.out.println((siemensPLC.ReadBool("DB4.0.4").Content));
//				System.out.println((siemensPLC.Write("DB4.0.4", FCof).ErrorCode)+"_______ErrorCode");
//				System.out.println((siemensPLC.Write("DB4.0.4", FCof).IsSuccess)+"_______IsSuccess");
//				System.out.println((siemensPLC.Write("DB4.0.4", FCof).Message)+"_______Message");
//				System.out.println((siemensPLC.Write("DB4.0.4", FCof).ToMessageShowString())+"_______ToMessageShowString");
//				System.out.println((siemensPLC.Write("DB4.0.4", FCof).CreateSuccessResult())+"_______CreateSuccessResult");
//				
				OperateResult write = siemensPLC.Write("DB4.0.4", FCof);
//				System.out.println((siemensPLC.ReadBool("DB4.0.4").Content));
				System.out.println(write+"_______");
				return "00001";
			}
			
			siemensPLC.ConnectClose();
		}else {
			System.out.println("failed:" +siemensPLC.ConnectServer().Message);
		}
		return "0002";
	}
}
