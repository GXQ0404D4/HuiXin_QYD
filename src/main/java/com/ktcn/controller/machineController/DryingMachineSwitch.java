package com.ktcn.controller.machineController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.simens.utils.SiemensPlcConfig;

import HslCommunication.Core.Types.OperateResult;
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
	//提取传入的操作机器按钮
	private String DMSNAME;
	
	@Transactional
	@RequestMapping("/dc_incident")
	public String DryingMachineSwitchIncident(String DMSname,Boolean DMSof) {
		DMSNAME=DMSname;
		try {
			switch (DMSname) {
			case "MD82":
				String incidentDX1 = DryingMachineSwitchIncidentDX("DB4.0.4",DMSof);
				return incidentDX1;
			case "MD83":
				String incidentDX2 = DryingMachineSwitchIncidentDX("DB4.0.5",DMSof);
				return incidentDX2;
			case "MD84":
				String incidentDX3 = DryingMachineSwitchIncidentDX("DB4.0.6",DMSof);
				return incidentDX3;
			case "MD85":
				String incidentDX4 = DryingMachineSwitchIncidentDX("DB4.0.7",DMSof);
				return incidentDX4;
			case "MD86":
				String incidentDX5 = DryingMachineSwitchIncidentDX("DB4.1.0",DMSof);
				return incidentDX5;
			case "MD87":
				String incidentDX6 = DryingMachineSwitchIncidentDX("DB4.1.1",DMSof);
				return incidentDX6;
			case "MD88":
				String incidentDX7 = DryingMachineSwitchIncidentDX("DB4.1.4",DMSof);
				return incidentDX7;
			case "MD89":
				String incidentDX8 = DryingMachineSwitchIncidentDX("DB4.1.5",DMSof);
				return incidentDX8;
			case "MD90":
				String incidentDX9 = DryingMachineSwitchIncidentDX("DB4.1.6",DMSof);
				return incidentDX9;
			case "MD91":
				String incidentDX10 = DryingMachineSwitchIncidentDX("DB4.1.7",DMSof);
				return incidentDX10;
			case "MD92":
				String incidentDX11 = DryingMachineSwitchIncidentDX("DB4.2.0",DMSof);
				return incidentDX11;
			case "MD93":
				String incidentDX12 = DryingMachineSwitchIncidentDX("DB4.2.1",DMSof);
				return incidentDX12;
			case "MD94":
				String incidentDX13 = DryingMachineSwitchIncidentDX("DB4.1.2",DMSof);
				return incidentDX13;
			case "MD95":
				String incidentDX14 = DryingMachineSwitchIncidentDX("DB4.1.3",DMSof);
				return incidentDX14;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DMSNAME;
	}
	public String DryingMachineSwitchIncidentDX(String DMSaddress,Boolean DMSof) {
		//获取连接
		try {
			SiemensS7Net siemensPLC = siemensPlcConfig.getSiemensPLC();
			if (siemensPLC.ConnectServer().IsSuccess) {
				OperateResult write = siemensPLC.Write(DMSaddress, DMSof);
				if ((siemensPLC.ReadBool(DMSaddress).Content)==DMSof) {
					siemensPLC.ConnectClose();
					return write.Message;
				} else {
					return DMSNAME;
				}
			}else {
				System.out.println("failed:" +siemensPLC.ConnectServer().Message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return DMSNAME;
		
					}
}
