package com.ktcn.controller.siemensController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.controller.semensData.DryingMachineDataController;
import com.ktcn.controller.semensData.PeripheralDataController;
import com.ktcn.controller.semensData.ScrewMachineDataController;
import com.ktcn.entity.siemensentity.ControlValue;
import com.ktcn.entity.siemensentity.DryingMachine;
import com.ktcn.entity.siemensentity.Peripheral_entity;
import com.ktcn.entity.siemensentity.ScrewMachine;
import com.ktcn.entity.simensaddress.Monitoring_AddressC;
import com.ktcn.simens.utils.EmptyUtil;
import com.ktcn.simens.utils.SiemensPlcConfig;

import HslCommunication.Core.Types.OperateResult;
import HslCommunication.Core.Types.OperateResultExOne;
import HslCommunication.Profinet.Siemens.SiemensPLCS;
import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
 * @author 作者 :Runaway programmer
 * @version 创建时间：2020年6月16日 上午11:03:22 类说明
 */

@RestController
public class MonitoringControllerC {

	@Autowired
	DryingMachine dryingMachine;
	@Autowired
	SiemensPlcConfig SiemensPlcConfig;
	@Autowired
	EmptyUtil emptyUtil;
//	@Autowired
//	Monitoring_AddressC Mt_AddressC;
	@Autowired
	Peripheral_entity Peripheral_entity;
	@Autowired
	ControlValue controlValue;
	// 监控页面3实时数据展示
	@RequestMapping("/monitoringPageC")
	public Map<String, Object> getMonitoringCData() {
		Map<String, Object> MTCdat = new HashMap<String, Object>();
		SiemensS7Net siemensPLCm = SiemensPlcConfig.getSiemensPLC();
		Map<String, ScrewMachine> smReamlDataPage = new HashMap<String, ScrewMachine>();
		ScrewMachine ScrewMachine1 = new ScrewMachine();
		ScrewMachine ScrewMachine2 = new ScrewMachine();
		ScrewMachine ScrewMachine3 = new ScrewMachine();
		ScrewMachine ScrewMachine4 = new ScrewMachine();
		ScrewMachine ScrewMachine5 = new ScrewMachine();

		OperateResultExOne<float[]> smData1 = siemensPLCm.ReadFloat("DB4.70", (short) 7);
		OperateResultExOne<float[]> smData2 = siemensPLCm.ReadFloat("DB3.70", (short) 7);
		OperateResultExOne<float[]> smData3 = siemensPLCm.ReadFloat("DB5.70", (short) 7);
		OperateResultExOne<float[]> smData4 = siemensPLCm.ReadFloat("DB6.70", (short) 7);
		OperateResultExOne<float[]> smData5 = siemensPLCm.ReadFloat("DB7.70", (short) 7);

		OperateResultExOne<int[]> smData1a = siemensPLCm.ReadInt32("DB4.98", (short) 5);
		OperateResultExOne<int[]> smData2a = siemensPLCm.ReadInt32("DB3.98", (short) 5);
		OperateResultExOne<int[]> smData3a = siemensPLCm.ReadInt32("DB5.98", (short) 5);
		OperateResultExOne<int[]> smData4a = siemensPLCm.ReadInt32("DB6.98", (short) 5);
		OperateResultExOne<int[]> smData5a = siemensPLCm.ReadInt32("DB7.98", (short) 5);
		OperateResult connectServer = siemensPLCm.ConnectServer();
		if (connectServer.IsSuccess) {
			if (smData1.IsSuccess&&smData1a.IsSuccess) {
				ScrewMachine1.setLGJ0(smData1.Content[0]);
				ScrewMachine1.setLGJ1(smData1.Content[1]);
				ScrewMachine1.setLGJ2(smData1.Content[2]);
				ScrewMachine1.setLGJ3(smData1.Content[3]);
				ScrewMachine1.setLGJ4(smData1.Content[4]);
				ScrewMachine1.setLGJ5(smData1.Content[5]);
				ScrewMachine1.setLGJ6(smData1.Content[6]);
				ScrewMachine1.setLGJ7(smData1a.Content[0]);
				ScrewMachine1.setLGJ8(smData1a.Content[1]);
				ScrewMachine1.setLGJ9(smData1a.Content[2]);
				ScrewMachine1.setLGJ10(smData1a.Content[3]);
				ScrewMachine1.setLGJ11(smData1a.Content[4]);
			}
			if (smData2.IsSuccess&&smData2a.IsSuccess) {
				ScrewMachine2.setLGJ0(smData2.Content[0]);
				ScrewMachine2.setLGJ1(smData2.Content[1]);
				ScrewMachine2.setLGJ2(smData2.Content[2]);
				ScrewMachine2.setLGJ3(smData2.Content[3]);
				ScrewMachine2.setLGJ4(smData2.Content[4]);
				ScrewMachine2.setLGJ5(smData2.Content[5]);
				ScrewMachine2.setLGJ6(smData2.Content[6]);
				ScrewMachine2.setLGJ7(smData2a.Content[0]);
				ScrewMachine2.setLGJ8(smData2a.Content[1]);
				ScrewMachine2.setLGJ9(smData2a.Content[2]);
				ScrewMachine2.setLGJ10(smData2a.Content[3]);
				ScrewMachine2.setLGJ11(smData2a.Content[4]);
					}
			if (smData3.IsSuccess&&smData3a.IsSuccess) {
				ScrewMachine3.setLGJ0(smData3.Content[0]);
				ScrewMachine3.setLGJ1(smData3.Content[1]);
				ScrewMachine3.setLGJ2(smData3.Content[2]);
				ScrewMachine3.setLGJ3(smData3.Content[3]);
				ScrewMachine3.setLGJ4(smData3.Content[4]);
				ScrewMachine3.setLGJ5(smData3.Content[5]);
				ScrewMachine3.setLGJ6(smData3.Content[6]);
				ScrewMachine3.setLGJ7(smData3a.Content[0]);
				ScrewMachine3.setLGJ8(smData3a.Content[1]);
				ScrewMachine3.setLGJ9(smData3a.Content[2]);
				ScrewMachine3.setLGJ10(smData3a.Content[3]);
				ScrewMachine3.setLGJ11(smData3a.Content[4]);
			}
			if (smData4.IsSuccess&&smData4a.IsSuccess) {
				ScrewMachine4.setLGJ0(smData4.Content[0]);
				ScrewMachine4.setLGJ1(smData4.Content[1]);
				ScrewMachine4.setLGJ2(smData4.Content[2]);
				ScrewMachine4.setLGJ3(smData4.Content[3]);
				ScrewMachine4.setLGJ4(smData4.Content[4]);
				ScrewMachine4.setLGJ5(smData4.Content[5]);
				ScrewMachine4.setLGJ6(smData4.Content[6]);
				ScrewMachine4.setLGJ7(smData4a.Content[0]); 
				ScrewMachine4.setLGJ8(smData4a.Content[1]); 
				ScrewMachine4.setLGJ9(smData4a.Content[2]); 
				ScrewMachine4.setLGJ10(smData4a.Content[3]);
				ScrewMachine4.setLGJ11(smData4a.Content[4]);
			}
			if (smData5.IsSuccess&&smData5a.IsSuccess) {
				ScrewMachine5.setLGJ0(smData5.Content[0]);
				ScrewMachine5.setLGJ1(smData5.Content[1]);
				ScrewMachine5.setLGJ2(smData5.Content[2]);
				ScrewMachine5.setLGJ3(smData5.Content[3]);
				ScrewMachine5.setLGJ4(smData5.Content[4]);
				ScrewMachine5.setLGJ5(smData5.Content[5]);
				ScrewMachine5.setLGJ6(smData5.Content[6]);
				ScrewMachine5.setLGJ7(smData5a.Content[0]); 
				ScrewMachine5.setLGJ8(smData5a.Content[1]); 
				ScrewMachine5.setLGJ9(smData5a.Content[2]); 
				ScrewMachine5.setLGJ10(smData5a.Content[3]);
				ScrewMachine5.setLGJ11(smData5a.Content[4]);
			}
			
			OperateResultExOne<float[]> dmData1 = siemensPLCm.ReadFloat("DB8.42", (short) 6);
			OperateResultExOne<int[]> dmData2 = siemensPLCm.ReadInt32("DB8.66", (short) 2);
			if (dmData1.IsSuccess&&dmData2.IsSuccess) {
				dryingMachine.setGZJ0(dmData1.Content[0]);
				dryingMachine.setGZJ1(dmData1.Content[1]);
				dryingMachine.setGZJ2(dmData1.Content[2]);
				dryingMachine.setGZJ3(dmData1.Content[3]);
				dryingMachine.setGZJ4(dmData1.Content[4]);
				dryingMachine.setGZJ5(dmData1.Content[5]);
				
				dryingMachine.setGZJ6(dmData2.Content[0]);
				dryingMachine.setGZJ7(dmData2.Content[1]);
				
			}
			OperateResultExOne<float[]> ppData1 = siemensPLCm.ReadFloat("DB11.8", (short) 14);
			OperateResultExOne<float[]> ppData2 = siemensPLCm.ReadFloat("DB12.8", (short) 14);
			OperateResultExOne<float[]> ppData3 = siemensPLCm.ReadFloat("DB13.8", (short) 14);
			OperateResultExOne<float[]> ppData4 = siemensPLCm.ReadFloat("DB14.8", (short) 14);
			OperateResultExOne<float[]> ppData5 = siemensPLCm.ReadFloat("DB15.8", (short) 14);
			if (ppData1.IsSuccess) {
				Peripheral_entity.setWw0(ppData1.Content[0]);
				Peripheral_entity.setWw7(ppData1.Content[4]);
				Peripheral_entity.setWw14(ppData1.Content[13]);
				Peripheral_entity.setWw21(ppData1.Content[1]);
				Peripheral_entity.setWw24(ppData1.Content[2]);
				Peripheral_entity.setWw27(ppData1.Content[3]);
				Peripheral_entity.setWw30(ppData1.Content[5]);
				Peripheral_entity.setWw37(ppData1.Content[6]);
				Peripheral_entity.setWw44(ppData1.Content[7]);
				Peripheral_entity.setWw51(ppData1.Content[8]);
				Peripheral_entity.setWw58(ppData1.Content[9]);
				Peripheral_entity.setWw65(ppData1.Content[10]);
				Peripheral_entity.setWw72(ppData1.Content[11]);
				Peripheral_entity.setWw79(ppData1.Content[12]);
			}
            if (ppData2.IsSuccess) {
            	Peripheral_entity.setWw1(ppData2.Content[0]);
            	Peripheral_entity.setWw8(ppData2.Content[4]);
            	Peripheral_entity.setWw15(ppData2.Content[13]);
            	Peripheral_entity.setWw22(ppData2.Content[1]);
            	Peripheral_entity.setWw25(ppData2.Content[2]);
            	Peripheral_entity.setWw28(ppData2.Content[3]);
            	Peripheral_entity.setWw31(ppData2.Content[5]);
            	Peripheral_entity.setWw38(ppData2.Content[6]);
            	Peripheral_entity.setWw45(ppData2.Content[7]);
            	Peripheral_entity.setWw52(ppData2.Content[8]);
            	Peripheral_entity.setWw59(ppData2.Content[9]);
            	Peripheral_entity.setWw66(ppData2.Content[10]);
            	Peripheral_entity.setWw73(ppData2.Content[11]);
            	Peripheral_entity.setWw80(ppData2.Content[12]);
			}
            if (ppData3.IsSuccess) {
            	Peripheral_entity.setWw2(ppData3.Content[0]);
            	Peripheral_entity.setWw9(ppData3.Content[4]);
            	Peripheral_entity.setWw16(ppData3.Content[13]);
            	Peripheral_entity.setWw23(ppData3.Content[1]);
            	Peripheral_entity.setWw26(ppData3.Content[2]);
            	Peripheral_entity.setWw29(ppData3.Content[3]);
            	Peripheral_entity.setWw32(ppData3.Content[5]);
            	Peripheral_entity.setWw39(ppData3.Content[6]);
            	Peripheral_entity.setWw46(ppData3.Content[7]);
            	Peripheral_entity.setWw53(ppData3.Content[8]);
            	Peripheral_entity.setWw60(ppData3.Content[9]);
            	Peripheral_entity.setWw67(ppData3.Content[10]);
            	Peripheral_entity.setWw74(ppData3.Content[11]);
            	Peripheral_entity.setWw81(ppData3.Content[12]);
			}
            if (ppData4.IsSuccess) {
            	Peripheral_entity.setWw3(ppData4.Content[0]);
            	Peripheral_entity.setWw10(ppData4.Content[4]);
            	Peripheral_entity.setWw17(ppData4.Content[13]);
            	Peripheral_entity.setWw33(ppData4.Content[5]);
            	Peripheral_entity.setWw40(ppData4.Content[6]);
            	Peripheral_entity.setWw47(ppData4.Content[7]);
            	Peripheral_entity.setWw54(ppData4.Content[8]);
            	Peripheral_entity.setWw61(ppData4.Content[9]);
            	Peripheral_entity.setWw68(ppData4.Content[10]);
            	Peripheral_entity.setWw75(ppData4.Content[11]);
            	Peripheral_entity.setWw82(ppData4.Content[12]);
			}
            if (ppData5.IsSuccess) {
            	Peripheral_entity.setWw4(ppData5.Content[0]);
            	Peripheral_entity.setWw11(ppData5.Content[4]);
            	Peripheral_entity.setWw18(ppData5.Content[13]);
            	Peripheral_entity.setWw34(ppData5.Content[5]);
            	Peripheral_entity.setWw41(ppData5.Content[6]);
            	Peripheral_entity.setWw48(ppData5.Content[7]);
            	Peripheral_entity.setWw55(ppData5.Content[8]);
            	Peripheral_entity.setWw62(ppData5.Content[9]);
            	Peripheral_entity.setWw69(ppData5.Content[10]);
            	Peripheral_entity.setWw76(ppData5.Content[11]);
            	Peripheral_entity.setWw83(ppData5.Content[12]);
			}
            
            OperateResultExOne<float[]> cvData = siemensPLCm.ReadFloat("DB30.0", (short) 7);
            
            if (cvData.IsSuccess) {
            	controlValue.setTJF0(cvData.Content[0]);
            	controlValue.setTJF1(cvData.Content[1]);
            	controlValue.setTJF2(cvData.Content[2]);
            	controlValue.setTJF3(cvData.Content[3]);
            	controlValue.setTJF4(cvData.Content[4]);
            	controlValue.setTJF5(cvData.Content[5]);
            	controlValue.setTJF6(cvData.Content[6]);
			}
            
			smReamlDataPage.put("ScrewMachine1", ScrewMachine1);
			smReamlDataPage.put("ScrewMachine2", ScrewMachine2);
			smReamlDataPage.put("ScrewMachine3", ScrewMachine3);
			smReamlDataPage.put("ScrewMachine4", ScrewMachine4);
			smReamlDataPage.put("ScrewMachine5", ScrewMachine5);
			
			MTCdat.put("ControlValue", controlValue);
			MTCdat.put("Peripheral_entity", Peripheral_entity);
			MTCdat.put("ScrewMachineData", smReamlDataPage);
			MTCdat.put("DryingMachineData", dryingMachine);
		}
		
		siemensPLCm.ConnectClose();
		return MTCdat;


	}

	// 监控界面3 外围数据点击修改数值
	@RequestMapping("/updataPeripheralValue")
	public String updataPeripheralValue(String PLCip, float ppValue) {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		try {
			if (siemensPLC.ConnectServer().IsSuccess) {
				OperateResult result = siemensPLC.Write(PLCip, ppValue);
				return result.Message;
			} else {
				return "ununited";
			} 
		} finally {
			siemensPLC.ConnectClose();
		}

	}
	
	//监控页面3 调节阀数据操作
	@RequestMapping("/updataControlValueData")
	public String updataControlValueData(String PLCcvip,float cvValue) {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		try {
			if (siemensPLC.ConnectServer().IsSuccess) {
				OperateResult result = siemensPLC.Write(PLCcvip, cvValue);
				return result.Message;
			} else {
				
				return "ununited";
			} 
		} finally {
			siemensPLC.ConnectClose();
		}
	}

}
