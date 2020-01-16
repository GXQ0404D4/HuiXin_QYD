package com.ktcn.controller.machineController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.simens.utils.SiemensPlcConfig;

import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月15日 下午3:09:29
* 类说明  监控界面 干燥机机器开关
*/
@RestController
public class DryingMachineSwitch {
	@Autowired
	SiemensPlcConfig siemensPlcConfig;
	

	@RequestMapping("/dc_incident")
	public void DryingMachineSwitchIncident() {
		//获取连接
		SiemensS7Net siemensPLC = siemensPlcConfig.getSiemensPLC();
		if (siemensPLC.ConnectServer().IsSuccess) {
				System.out.println((siemensPLC.ReadBool("DB4.0.4").Content));
				siemensPLC.Write("DB4.0.4",1);
			
			siemensPLC.ConnectClose();
		}else {
			System.out.println("failed:" +siemensPLC.ConnectServer().Message);
		}
	}
}
