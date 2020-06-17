package com.ktcn.controller.siemensController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.controller.semensData.DryingMachineDataController;
import com.ktcn.controller.semensData.PeripheralDataController;
import com.ktcn.controller.semensData.ScrewMachineDataController;
import com.ktcn.entity.siemensentity.DryingMachine;
import com.ktcn.entity.siemensentity.Peripheral_entity;
import com.ktcn.entity.siemensentity.ScrewMachine;
import com.ktcn.simens.utils.SiemensPlcConfig;

import HslCommunication.Core.Types.OperateResult;
import HslCommunication.Profinet.Siemens.SiemensPLCS;
import HslCommunication.Profinet.Siemens.SiemensS7Net;
/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月16日 上午11:03:22
* 类说明
*/

@RestController
public class MonitoringControllerC {
	@Autowired
	DryingMachineDataController DMReaml;
	@Autowired
	ScrewMachineDataController SMDReaml;
	@Autowired
	PeripheralDataController PDReaml;
	@Autowired
	SiemensPlcConfig SiemensPlcConfig;
	//监控页面3实时数据展示
	@RequestMapping("/monitoringPageC")
	public Map<String, Object> getMonitoringCData() {
		Map<String, Object> MTCdat= new HashMap<String, Object>();
		DryingMachine dmRealDataPage = DMReaml.getDryingMachineRealDataPage();
		Map<String, ScrewMachine> smReamlDataPage = SMDReaml.getRealDataPage();
		Peripheral_entity ppRealDataPage = PDReaml.getPeripheralRealData();
		if (dmRealDataPage !=null && smReamlDataPage !=null && ppRealDataPage !=null) {
			MTCdat.put("DryingMachineData", dmRealDataPage);
			MTCdat.put("ScrewMachineData", smReamlDataPage);
			MTCdat.put("PeripheralData", ppRealDataPage);
			return MTCdat;
		}else {
			MTCdat.put("state", "loading");
			return MTCdat;
		}
		
	}
	//监控界面3 外围数据点击修改数值
	@RequestMapping("/updataPeripheralValue")
	public String updataPeripheralValue(String PLCip,float ppValue) {
		System.out.println(PLCip+"____"+ppValue);
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		if (siemensPLC.ConnectServer().IsSuccess) {
			OperateResult result = siemensPLC.Write(PLCip, ppValue);
			siemensPLC.ConnectClose();
			return result.Message;
		}else {
			siemensPLC.ConnectClose();
			return "ununited";
		}
		
	}

}
