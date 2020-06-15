package com.ktcn.controller.siemensController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.siemensentity.DryingMachine;
import com.ktcn.entity.simensaddress.Monitoring_Address;
import com.ktcn.simens.utils.SiemensPlcConfig;
import com.ktcn.simens.PLCdata.DryingMachineDatagain;

import HslCommunication.Core.Types.OperateResult;
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
	@Autowired
	DryingMachineDatagain DryingMachineDatagain;

	@RequestMapping("/monitoringPage")
	public Map<String, Object> getMonitoringData() {
		DryingMachine dryingMachine = DryingMachineDatagain.getDryingMachineData();
		
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		Map<String, Object> MMData = new HashMap<String, Object>();
		if (siemensPLC.ConnectServer().IsSuccess) {
//			五台空压机数据
			MMData.put("MD0", siemensPLC.ReadFloat(MT_Address.getMD0()).Content);
			MMData.put("MD0", siemensPLC.ReadFloat(MT_Address.getMD0()).Content);
			MMData.put("MD1", siemensPLC.ReadFloat(MT_Address.getMD1()).Content);
			MMData.put("MD2", siemensPLC.ReadFloat(MT_Address.getMD2()).Content);
			MMData.put("MD3", siemensPLC.ReadFloat(MT_Address.getMD3()).Content);
			MMData.put("MD4", siemensPLC.ReadFloat(MT_Address.getMD4()).Content);
			MMData.put("MD5", siemensPLC.ReadFloat(MT_Address.getMD5()).Content);
			MMData.put("MD6", siemensPLC.ReadFloat(MT_Address.getMD6()).Content);
			MMData.put("MD7", siemensPLC.ReadFloat(MT_Address.getMD7()).Content);
			MMData.put("MD8", siemensPLC.ReadFloat(MT_Address.getMD8()).Content);
			MMData.put("MD9", siemensPLC.ReadFloat(MT_Address.getMD9()).Content);
			MMData.put("MD10", siemensPLC.ReadFloat(MT_Address.getMD10()).Content);
			MMData.put("MD11", siemensPLC.ReadFloat(MT_Address.getMD11()).Content);
			MMData.put("MD12", siemensPLC.ReadFloat(MT_Address.getMD12()).Content);
			MMData.put("MD13", siemensPLC.ReadFloat(MT_Address.getMD13()).Content);
			MMData.put("MD14", siemensPLC.ReadFloat(MT_Address.getMD14()).Content);
//          干燥机数据
			MMData.put("MD15", siemensPLC.ReadFloat(MT_Address.getMD15()).Content);
			MMData.put("MD16", siemensPLC.ReadFloat(MT_Address.getMD16()).Content);
			MMData.put("MD17", siemensPLC.ReadFloat(MT_Address.getMD17()).Content);
			MMData.put("MD18", siemensPLC.ReadFloat(MT_Address.getMD18()).Content);
			MMData.put("MD19", siemensPLC.ReadFloat(MT_Address.getMD19()).Content);
			MMData.put("MD20", siemensPLC.ReadFloat(MT_Address.getMD20()).Content);
//          外围数据
			MMData.put("MD21", siemensPLC.ReadFloat(MT_Address.getMD21()).Content);
			MMData.put("MD22", siemensPLC.ReadFloat(MT_Address.getMD22()).Content);
			MMData.put("MD23", siemensPLC.ReadFloat(MT_Address.getMD23()).Content);
			MMData.put("MD24", siemensPLC.ReadFloat(MT_Address.getMD24()).Content);

			MMData.put("MD25", siemensPLC.ReadFloat(MT_Address.getMD25()).Content);
			MMData.put("MD26", siemensPLC.ReadFloat(MT_Address.getMD26()).Content);
			MMData.put("MD27", siemensPLC.ReadFloat(MT_Address.getMD27()).Content);
			MMData.put("MD28", siemensPLC.ReadFloat(MT_Address.getMD28()).Content);

			MMData.put("MD29", siemensPLC.ReadFloat(MT_Address.getMD29()).Content);
			MMData.put("MD30", siemensPLC.ReadFloat(MT_Address.getMD30()).Content);
			MMData.put("MD31", siemensPLC.ReadFloat(MT_Address.getMD31()).Content);
			MMData.put("MD32", siemensPLC.ReadFloat(MT_Address.getMD32()).Content);
//          冷却水
			MMData.put("MD33", siemensPLC.ReadFloat(MT_Address.getMD33()).Content);
			MMData.put("MD34", siemensPLC.ReadFloat(MT_Address.getMD34()).Content);
			MMData.put("MD35", siemensPLC.ReadFloat(MT_Address.getMD35()).Content);
//          空压机运行状态
			MMData.put("MD36", siemensPLC.ReadBool(MT_Address.getMD36()).Content);
			MMData.put("MD37", siemensPLC.ReadBool(MT_Address.getMD37()).Content);
			MMData.put("MD38", siemensPLC.ReadBool(MT_Address.getMD38()).Content);
			MMData.put("MD39", siemensPLC.ReadBool(MT_Address.getMD39()).Content);
			MMData.put("MD40", siemensPLC.ReadBool(MT_Address.getMD40()).Content);
//			干燥机 运行状态和启停
			MMData.put("MD42", siemensPLC.ReadBool(MT_Address.getMD40()).Content);
			MMData.put("MD43", siemensPLC.ReadBool(MT_Address.getMD40()).Content);
//			通讯复位
//			MMData.put("MD41", siemensPLC.ReadBool(MT_Address.getMD41()).Content);
		} else {
			System.out.println("failed:" + siemensPLC.ConnectServer().Message + "监控页面数据");
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
			if (MDname.equals("FWA")) {
				OperateResult write = siemensPLC.Write("DB24.38.0", true);
				if (write.IsSuccess) {
					siemensPLC.Write("DB24.38.0", false);
						return write.Message;
					}
				}
			if (MDname.equals("FWB")) {
				OperateResult write = siemensPLC.Write("DB24.28.0", true);
				if (write.IsSuccess) {
				 siemensPLC.Write("DB24.28.0", false);
						return write.Message;
				}
			}
			if (MDname.equals("FWC")) {
				OperateResult write = siemensPLC.Write("DB24.18.0", true);
				if (write.IsSuccess) {
					 siemensPLC.Write("DB24.18.0", false);					
						return write.Message;
				}
			}
		} else {
			System.out.println("failed:" + siemensPLC.ConnectServer().Message + "监控页面数据");
			return "failed";
		}
		siemensPLC.ConnectClose();
		return "ununited";

	}

//	监控界面5台空压机控制按钮
	@RequestMapping("/compressButtion")
	public String setCompressorButton(String MDname, Boolean MDTF) {
		System.out.println(MDname + "__________" + MDTF);
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		if (siemensPLC.ConnectServer().IsSuccess) {
			if (MDname.equals("MDA")) {
				if (MDTF.equals(true)) {
					OperateResult write1 = siemensPLC.Write("DB21.0.2", true);
					if (write1.IsSuccess) {
						siemensPLC.Write("DB21.0.2", false);
						return write1.Message;
					}
				}
				if (MDTF.equals(false)) {
					OperateResult write2 = siemensPLC.Write("DB21.0.3", true);
					if (write2.IsSuccess) {
						siemensPLC.Write("DB21.0.3", false);
						return write2.Message;
					}
				}
			}
			if (MDname.equals("MDB")) {
				if (MDTF.equals(true)) {
					OperateResult write3 = siemensPLC.Write("DB21.0.0", true);
					if (write3.IsSuccess) {
						siemensPLC.Write("DB21.0.0", false);
						return write3.Message;
					}
				}
				if (MDTF.equals(false)) {
					OperateResult write4 = siemensPLC.Write("DB21.0.1", true);
					if (write4.IsSuccess) {
						siemensPLC.Write("DB21.0.1", false);
						return write4.Message;
					}
				}
			}
			if (MDname.equals("MDC")) {
				if (MDTF.equals(true)) {
					OperateResult write5 = siemensPLC.Write("DB21.0.4", true);
					if (write5.IsSuccess) {
						siemensPLC.Write("DB21.0.4", false);
						return write5.Message;
					}
				}
				if (MDTF.equals(false)) {
					OperateResult write6 = siemensPLC.Write("DB21.0.5", true);
					if (write6.IsSuccess) {
						siemensPLC.Write("DB21.0.5", false);
						return write6.Message;
					}
				}
			}
			if (MDname.equals("MDD")) {
				if (MDTF.equals(true)) {
					OperateResult write7 = siemensPLC.Write("DB21.0.6", true);
					if (write7.IsSuccess) {
						siemensPLC.Write("DB21.0.6", false);
						return write7.Message;
					}
				}
				if (MDTF.equals(false)) {
					OperateResult write8 = siemensPLC.Write("DB21.0.7", true);
					if (write8.IsSuccess) {
						siemensPLC.Write("DB21.0.7", false);
						return write8.Message;
					}
				}
			}
			if (MDname.equals("MDE")) {
				if (MDTF.equals(true)) {
					OperateResult write9 = siemensPLC.Write("DB21.0.6", true);
					if (write9.IsSuccess) {
						siemensPLC.Write("DB21.0.6", false);
						return write9.Message;
					}
				}
				if (MDTF.equals(false)) {
					OperateResult write10 = siemensPLC.Write("DB21.0.7", true);
					if (write10.IsSuccess) {
						siemensPLC.Write("DB21.0.7", false);
						return write10.Message;
					}
				}
			}

		} else {
			return "failed";
		}
		siemensPLC.ConnectClose();
		return "ununited";

	}
	
	@RequestMapping("/txFuWei")
	public String setTongxinFW() {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		if (siemensPLC.ConnectServer().IsSuccess) {
			OperateResult write = siemensPLC.Write(MT_Address.getMD41(), true);
			if (write.IsSuccess) {
				siemensPLC.Write(MT_Address.getMD41(), false);
				return write.Message;
			}
		}else {
			return "failed";
		}
		siemensPLC.ConnectClose();
		return "ununited";
		
	}
	
	@RequestMapping("/dryingMachineQT")
	public String  setDryingMachine() {
		
		return null;
		
	}
}
