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
import com.ktcn.entity.siemensentity.DryingMachine;
import com.ktcn.entity.siemensentity.Peripheral_entity;
import com.ktcn.entity.siemensentity.ScrewMachine;
import com.ktcn.entity.simensaddress.Monitoring_Address;
import com.ktcn.simens.utils.SiemensPlcConfig;
import com.ktcn.simens.PLCdata.DryingMachineDatagain;

import HslCommunication.Core.Types.OperateResult;
import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
 * @author 作者 :Runaway programmer
 * @version 创建时间：2020年6月11日 上午10:21:29 类说明 : 监控界面数据获取以及操作
 */

@RestController
public class MonitoringController {

	@Autowired
	SiemensPlcConfig SiemensPlcConfig;
	@Autowired
	ScrewMachineDataController SMDReaml;
	@Autowired
	PeripheralDataController PDReaml;
	@Autowired
	DryingMachineDataController DMReaml;

	@RequestMapping("/monitoringPage")
	public Map<String, Object> getMonitoringData() {
		Map<String, Object> MMData = new HashMap<String, Object>();
		Map<String, ScrewMachine> smReamlData = SMDReaml.getRealDataPage();
		Peripheral_entity ppReamlData = PDReaml.getPeripheralRealData();
		DryingMachine dmReamlData = DMReaml.getDryingMachineRealDataPage();
//			五台空压机数据
		MMData.put("MD0", smReamlData.get("ScrewMachine1").getLGJ0());
		MMData.put("MD1", smReamlData.get("ScrewMachine1").getLGJ2());
		MMData.put("MD2", smReamlData.get("ScrewMachine1").getLGJ4());

		MMData.put("MD3", smReamlData.get("ScrewMachine2").getLGJ0());
		MMData.put("MD4", smReamlData.get("ScrewMachine2").getLGJ2());
		MMData.put("MD5", smReamlData.get("ScrewMachine2").getLGJ4());

		MMData.put("MD6", smReamlData.get("ScrewMachine3").getLGJ0());
		MMData.put("MD7", smReamlData.get("ScrewMachine3").getLGJ2());
		MMData.put("MD8", smReamlData.get("ScrewMachine3").getLGJ4());

		MMData.put("MD9", smReamlData.get("ScrewMachine4").getLGJ0());
		MMData.put("MD10", smReamlData.get("ScrewMachine4").getLGJ2());
		MMData.put("MD11", smReamlData.get("ScrewMachine4").getLGJ4());

		MMData.put("MD12", smReamlData.get("ScrewMachine5").getLGJ0());
		MMData.put("MD13", smReamlData.get("ScrewMachine5").getLGJ2());
		MMData.put("MD14", smReamlData.get("ScrewMachine5").getLGJ4());
//          干燥机数据
		MMData.put("MD15", ppReamlData.getWw65());
		MMData.put("MD16", ppReamlData.getWw79());
		MMData.put("MD17", ppReamlData.getWw58());
		MMData.put("MD18", ppReamlData.getWw72());
		//干燥机运行状态、报警
		MMData.put("MD19", dmReamlData.getGZJ10());
		MMData.put("MD20", dmReamlData.getGZJ11());
//          外围数据
		MMData.put("MD21", ppReamlData.getWw92());
		MMData.put("MD22", ppReamlData.getWw93());
		MMData.put("MD23", ppReamlData.getWw27());
		MMData.put("MD24", ppReamlData.getWw44());

		MMData.put("MD25", ppReamlData.getWw89());
		MMData.put("MD26", ppReamlData.getWw90());
		MMData.put("MD27", ppReamlData.getWw24());
		MMData.put("MD28", ppReamlData.getWw37());

		MMData.put("MD29", ppReamlData.getWw86());
		MMData.put("MD30", ppReamlData.getWw87());
		MMData.put("MD31", ppReamlData.getWw21());
		MMData.put("MD32", ppReamlData.getWw30());
////          冷却水
		MMData.put("MD33", ppReamlData.getWw0());
		MMData.put("MD34", ppReamlData.getWw7());
		MMData.put("MD35", ppReamlData.getWw14());
//          空压机运行状态
		MMData.put("MD36", smReamlData.get("ScrewMachine1").getLGJ19());
		MMData.put("MD37", smReamlData.get("ScrewMachine2").getLGJ19());
		MMData.put("MD38", smReamlData.get("ScrewMachine3").getLGJ19());
		MMData.put("MD39", smReamlData.get("ScrewMachine4").getLGJ19());
		MMData.put("MD40", smReamlData.get("ScrewMachine5").getLGJ19());
//		空压机综合报警状态
		MMData.put("MD41", smReamlData.get("ScrewMachine1").getLGJ16());
		MMData.put("MD42", smReamlData.get("ScrewMachine2").getLGJ16());
		MMData.put("MD43", smReamlData.get("ScrewMachine3").getLGJ16());
		MMData.put("MD44", smReamlData.get("ScrewMachine4").getLGJ16());
		MMData.put("MD45", smReamlData.get("ScrewMachine5").getLGJ16());
//			干燥机 运行状态和启停
//		MMData.put("MD42", dmReamlData.getGZJ8());
//		MMData.put("MD43", dmReamlData.getGZJ9());
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

	// 通信复位
	@RequestMapping("/txFuWei")
	public String setTongxinFW() {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		if (siemensPLC.ConnectServer().IsSuccess) {
			OperateResult write = siemensPLC.Write("DB21.18.6", true);
			if (write.IsSuccess) {
				siemensPLC.Write("DB21.18.6", false);
				return write.Message;
			}
		} else {
			return "failed";
		}
		siemensPLC.ConnectClose();
		return "ununited";

	}

	// 干燥机启停
	@RequestMapping("/dryingMachineQT")
	public String setDryingMachine(String MDname) {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		if (siemensPLC.ConnectServer().IsSuccess) {
			// 获取到干燥机的运行状态 如果
			if (MDname.equals("DmQD")) {
				OperateResult write = siemensPLC.Write("DB21.1.2", true);
				if (write.IsSuccess) {
					siemensPLC.Write("DB21.1.2", false);
					return write.Message;
				}
			}
			if (MDname.equals("DmTZ")) {
				OperateResult write = siemensPLC.Write("DB21.1.3", true);
				if (write.IsSuccess) {
					siemensPLC.Write("DB21.1.3", false);
					return write.Message;
				}
			}

		} else {
			return "failed";
		}
		siemensPLC.ConnectClose();
		return "ununited";
	}
}
