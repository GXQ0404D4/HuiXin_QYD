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
import com.ktcn.simens.utils.EmptyUtil;
import com.ktcn.simens.utils.SiemensPlcConfig;
import com.ktcn.simens.PLCdata.DryingMachineDatagain;

import HslCommunication.Core.Types.OperateResult;
import HslCommunication.Profinet.Siemens.SiemensPLCS;
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
	@Autowired
	EmptyUtil emptyUtil;
	
	@Autowired
	Monitoring_Address Mt_Address;

	//监控页面1实时数据展示
	@RequestMapping("/monitoringPage")
	public Map<String, Object> getMonitoringData() {
		Map<String, Object> MMData = new HashMap<String, Object>();
		SiemensS7Net siemensPLCm = SiemensPlcConfig.getSiemensPLC();
//		开启长连接
		OperateResult connectServer = siemensPLCm.ConnectServer();
		if (connectServer.IsSuccess) {
			MMData.put("MD0",siemensPLCm.ReadFloat(Mt_Address.getMD0()).Content);
			MMData.put("MD1",siemensPLCm.ReadFloat(Mt_Address.getMD1()).Content);
			MMData.put("MD2",siemensPLCm.ReadFloat(Mt_Address.getMD2()).Content);
			MMData.put("MD3",siemensPLCm.ReadFloat(Mt_Address.getMD3()).Content);
			MMData.put("MD4",siemensPLCm.ReadFloat(Mt_Address.getMD4()).Content);
			MMData.put("MD5",siemensPLCm.ReadFloat(Mt_Address.getMD5()).Content);
			MMData.put("MD6",siemensPLCm.ReadFloat(Mt_Address.getMD6()).Content);
			MMData.put("MD7",siemensPLCm.ReadFloat(Mt_Address.getMD7()).Content);
			MMData.put("MD8",siemensPLCm.ReadFloat(Mt_Address.getMD8()).Content);
			MMData.put("MD9",siemensPLCm.ReadFloat(Mt_Address.getMD9()).Content);
			MMData.put("MD10",siemensPLCm.ReadFloat(Mt_Address.getMD10()).Content);
			MMData.put("MD11",siemensPLCm.ReadFloat(Mt_Address.getMD11()).Content);
			MMData.put("MD12",siemensPLCm.ReadFloat(Mt_Address.getMD12()).Content);
			MMData.put("MD13",siemensPLCm.ReadFloat(Mt_Address.getMD13()).Content);
			MMData.put("MD14",siemensPLCm.ReadFloat(Mt_Address.getMD14()).Content);
			//干燥机排气 进气
			MMData.put("MD15",siemensPLCm.ReadFloat(Mt_Address.getMD15()).Content);
			MMData.put("MD16",siemensPLCm.ReadFloat(Mt_Address.getMD16()).Content);
			MMData.put("MD17",siemensPLCm.ReadFloat(Mt_Address.getMD17()).Content);
			MMData.put("MD18",siemensPLCm.ReadFloat(Mt_Address.getMD18()).Content);
			//干燥机运行状态
			MMData.put("MD19",siemensPLCm.ReadBool(Mt_Address.getMD19()).Content);
			MMData.put("MD20",siemensPLCm.ReadBool(Mt_Address.getMD20()).Content);
			//外围数据
			MMData.put("MD21",siemensPLCm.ReadFloat(Mt_Address.getMD21()).Content);
			MMData.put("MD22",siemensPLCm.ReadFloat(Mt_Address.getMD22()).Content);
			MMData.put("MD23",siemensPLCm.ReadFloat(Mt_Address.getMD23()).Content);
			MMData.put("MD24",siemensPLCm.ReadFloat(Mt_Address.getMD24()).Content);
			
			MMData.put("MD25",siemensPLCm.ReadFloat(Mt_Address.getMD25()).Content);
			MMData.put("MD26",siemensPLCm.ReadFloat(Mt_Address.getMD26()).Content);
			MMData.put("MD27",siemensPLCm.ReadFloat(Mt_Address.getMD27()).Content);
			MMData.put("MD28",siemensPLCm.ReadFloat(Mt_Address.getMD28()).Content);
			
			MMData.put("MD29",siemensPLCm.ReadFloat(Mt_Address.getMD29()).Content);
			MMData.put("MD30",siemensPLCm.ReadFloat(Mt_Address.getMD30()).Content);
			MMData.put("MD31",siemensPLCm.ReadFloat(Mt_Address.getMD31()).Content);
			MMData.put("MD32",siemensPLCm.ReadFloat(Mt_Address.getMD32()).Content);
			//冷却水
			MMData.put("MD33",siemensPLCm.ReadFloat(Mt_Address.getMD33()).Content);
			MMData.put("MD34",siemensPLCm.ReadFloat(Mt_Address.getMD34()).Content);
			MMData.put("MD35",siemensPLCm.ReadFloat(Mt_Address.getMD35()).Content);
			//空压机
			MMData.put("MD36",siemensPLCm.ReadBool(Mt_Address.getMD36()).Content);
			MMData.put("MD37",siemensPLCm.ReadBool(Mt_Address.getMD37()).Content);
			MMData.put("MD38",siemensPLCm.ReadBool(Mt_Address.getMD38()).Content);
			MMData.put("MD39",siemensPLCm.ReadBool(Mt_Address.getMD39()).Content);
			MMData.put("MD40",siemensPLCm.ReadBool(Mt_Address.getMD40()).Content);
			MMData.put("MD41",siemensPLCm.ReadBool(Mt_Address.getMD41()).Content);
			MMData.put("MD42",siemensPLCm.ReadBool(Mt_Address.getMD42()).Content);
			MMData.put("MD43",siemensPLCm.ReadBool(Mt_Address.getMD43()).Content);
			MMData.put("MD44",siemensPLCm.ReadBool(Mt_Address.getMD44()).Content);
			MMData.put("MD45",siemensPLCm.ReadBool(Mt_Address.getMD45()).Content);
			MMData.put("MD46",siemensPLCm.ReadBool(Mt_Address.getMD46()).Content);
			MMData.put("MD47",siemensPLCm.ReadBool(Mt_Address.getMD47()).Content);
			MMData.put("MD48",siemensPLCm.ReadBool(Mt_Address.getMD48()).Content);
			MMData.put("MD49",siemensPLCm.ReadBool(Mt_Address.getMD49()).Content);
			MMData.put("MD50",siemensPLCm.ReadBool(Mt_Address.getMD50()).Content);
			//干燥机压力容力
			MMData.put("MD51",siemensPLCm.ReadFloat(Mt_Address.getMD51()).Content);
			MMData.put("MD52",siemensPLCm.ReadFloat(Mt_Address.getMD52()).Content);
			//调节阀
			MMData.put("MD53",siemensPLCm.ReadFloat(Mt_Address.getMD53()).Content);
			MMData.put("MD54",siemensPLCm.ReadFloat(Mt_Address.getMD54()).Content);
			MMData.put("MD55",siemensPLCm.ReadFloat(Mt_Address.getMD55()).Content);
			MMData.put("MD56",siemensPLCm.ReadFloat(Mt_Address.getMD56()).Content);
			MMData.put("MD57",siemensPLCm.ReadFloat(Mt_Address.getMD57()).Content);
			MMData.put("MD58",siemensPLCm.ReadBool(Mt_Address.getMD58()).Content);
			//其他数据
			MMData.put("MD59",siemensPLCm.ReadFloat(Mt_Address.getMD59()).Content);
			MMData.put("MD60",siemensPLCm.ReadBool(Mt_Address.getMD60()).Content);
			MMData.put("MD61",siemensPLCm.ReadBool(Mt_Address.getMD61()).Content);
			siemensPLCm.ConnectClose();
			return MMData;
		}else {
			siemensPLCm.ConnectClose(); 
			return MMData;
		}
		
		

	}

//    	监控界面三个重置按钮
	@RequestMapping("/resetButtion")
	public String setFUWEI(String MDname) {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		try {
			if (siemensPLC.ConnectServer().IsSuccess) {
				if ("FWA".equals(MDname)) {
					OperateResult write = siemensPLC.Write("DB24.38.0", true);
					if (write.IsSuccess) {
						siemensPLC.Write("DB24.38.0", false);
						return write.Message;
					}
				}
				if ("FWB".equals(MDname)) {
					OperateResult write = siemensPLC.Write("DB24.28.0", true);
					if (write.IsSuccess) {
						siemensPLC.Write("DB24.28.0", false);
						return write.Message;
					}
				}
				if ("FWC".equals(MDname)) {
					OperateResult write = siemensPLC.Write("DB24.18.0", true);
					if (write.IsSuccess) {
						siemensPLC.Write("DB24.18.0", false);
						return write.Message;
					}
				}
			} else {
				return "failed";
			} 
			return "ununited";
		} finally {
			siemensPLC.ConnectClose();
		}
		

	}

//	监控界面5台空压机控制按钮
	@RequestMapping("/compressButtion")
	public String setCompressorButton(String MDname, Boolean MDTF) {
		SiemensS7Net siemensPLC =  SiemensPlcConfig.getSiemensPLC();
		try {
			if (siemensPLC.ConnectServer().IsSuccess) {
				if ("MDA".equals(MDname)) {
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
				if ("MDB".equals(MDname)) {
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
				if ("MDC".equals(MDname)) {
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
				if ("MDD".equals(MDname)) {
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
				if ("MDE".equals(MDname)) {
					if (MDTF.equals(true)) {
						OperateResult write9 = siemensPLC.Write("DB21.1.0", true);
						if (write9.IsSuccess) {
							siemensPLC.Write("DB21.1.0", false);
							return write9.Message;
						}
					}
					if (MDTF.equals(false)) {
						OperateResult write10 = siemensPLC.Write("DB21.1.1", true);
						if (write10.IsSuccess) {
							siemensPLC.Write("DB21.1.1", false);
							return write10.Message;
						}
					}
				}

			} else {
				return "failed";
			} 
			return "ununited";
		} finally {
			siemensPLC.ConnectClose();
		}
	

	}

	// 通信复位
	@RequestMapping("/txFuWei")
	public String setTongxinFW() {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		try {
			if (siemensPLC.ConnectServer().IsSuccess) {
				OperateResult write = siemensPLC.Write("DB21.18.6", true);
				if (write.IsSuccess) {
					siemensPLC.Write("DB21.18.6", false);
					return write.Message;
				}
			} else {
				return "failed";
			} 
			return "ununited";
		} finally {
			siemensPLC.ConnectClose();
		}
	
	

	}

	// 干燥机启停
	@RequestMapping("/dryingMachineQT")
	public String setDryingMachine(String MDname) {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		try {
			if (siemensPLC.ConnectServer().IsSuccess) {
				// 获取到干燥机的运行状态 如果
				if ("DmQD".equals(MDname)) {
					OperateResult write = siemensPLC.Write("DB21.1.2", true);
					if (write.IsSuccess) {
						siemensPLC.Write("DB21.1.2", false);
						return write.Message;
					}
				}
				if ("DmTZ".equals(MDname)) {
					OperateResult write = siemensPLC.Write("DB21.1.3", true);
					if (write.IsSuccess) {
						siemensPLC.Write("DB21.1.3", false);
						return write.Message;
					}
				}

			} else {
				return "failed";
			} 
			return "ununited";
		} finally {
			siemensPLC.ConnectClose();
		}
	}
	
	//监控页面1 调节阀的手自动
	@RequestMapping("/updataControlValueSZD")
	public String updataControlValueSZD(Boolean CVszd) {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		try {
			if (siemensPLC.ConnectServer().IsSuccess) {
				if (CVszd==true) {
					OperateResult write = siemensPLC.Write("DB30.32.0", false);
					return write.Message;
				}if (CVszd==false) {
					OperateResult write = siemensPLC.Write("DB30.32.0", true);
					return write.Message;
				} 
			} 
			return "ununited";
		} finally {
			siemensPLC.ConnectClose();
		}
		
		
	}
}
