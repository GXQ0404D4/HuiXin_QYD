package com.ktcn.controller.siemensController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.controller.semensData.DryingMachineDataController;
import com.ktcn.controller.semensData.PeripheralDataController;
import com.ktcn.controller.semensData.ScrewMachineDataController;
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
	
	@RequestMapping("/monitoringPageC")
	public Map<String, Object> getMonitoringCData() {
		Map<String, Object> MTCdat= new HashMap<String, Object>();
		MTCdat.put("DryingMachineData", DMReaml.getDryingMachineRealDataPage());
		MTCdat.put("ScrewMachineData", SMDReaml.getRealDataPage());
		MTCdat.put("PeripheralData", PDReaml.getPeripheralRealData());
		return MTCdat;
	}

}
