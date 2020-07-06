package com.ktcn.controller.siemensController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.controller.semensData.PeripheralDataController;
import com.ktcn.controller.semensData.ScrewMachineDataController;
import com.ktcn.entity.siemensentity.Peripheral_entity;
import com.ktcn.entity.siemensentity.Peripheral_qt;
import com.ktcn.entity.siemensentity.ScrewMachine;
import com.ktcn.entity.simensaddress.Monitoring_AddressB;
import com.ktcn.simens.utils.EmptyUtil;
import com.ktcn.simens.utils.SiemensPlcConfig;

import HslCommunication.Core.Types.OperateResult;
import HslCommunication.Profinet.Siemens.SiemensPLCS;
import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
 * @author 作者 :Runaway programmer
 * @version 创建时间：2020年6月11日 下午7:13:21 类说明
 */

@RestController
public class MonitoringControllerB {

	@Autowired
	ScrewMachineDataController SMDReaml;
	@Autowired
	PeripheralDataController PDReaml;
	@Autowired
	SiemensPlcConfig SiemensPlcConfig;
	@Autowired
	EmptyUtil emptyUtil;

	@Autowired
	Monitoring_AddressB Mt_AddressB;
	
    private final short data1=1;
    private final short data2=2;
    private final short data4=4;
	//监控页面2实时数据展示
	@RequestMapping("/monitoringPageB")
	public Map<String, Object> getMonitoringBData() {
		Map<String, Object> MMDataB = new HashMap<String, Object>();
		SiemensS7Net siemensPLCm = SiemensPlcConfig.getSiemensPLC();
//		开启长连接
		OperateResult connectServer = siemensPLCm.ConnectServer();
		if (connectServer.IsSuccess) {
			MMDataB.put("QT0", siemensPLCm.ReadBool(Mt_AddressB.getQT0()).Content);
			MMDataB.put("QT1", siemensPLCm.ReadFloat(Mt_AddressB.getQT1()).Content);
			MMDataB.put("QT2", siemensPLCm.ReadFloat(Mt_AddressB.getQT2()).Content);
			MMDataB.put("QT3", siemensPLCm.ReadFloat(Mt_AddressB.getQT3()).Content);
			
			MMDataB.put("QT4", siemensPLCm.ReadBool(Mt_AddressB.getQT4()).Content);
			MMDataB.put("QT5", siemensPLCm.ReadFloat(Mt_AddressB.getQT5()).Content);
			MMDataB.put("QT6", siemensPLCm.ReadFloat(Mt_AddressB.getQT6()).Content);
			MMDataB.put("QT7", siemensPLCm.ReadFloat(Mt_AddressB.getQT7()).Content);
//          空压机运行状态
			MMDataB.put("QT8", siemensPLCm.ReadBool(Mt_AddressB.getQT8()).Content);
			MMDataB.put("QT9", siemensPLCm.ReadBool(Mt_AddressB.getQT9()).Content);
			MMDataB.put("QT10", siemensPLCm.ReadBool(Mt_AddressB.getQT10()).Content);
			MMDataB.put("QT11", siemensPLCm.ReadBool(Mt_AddressB.getQT11()).Content);
			MMDataB.put("QT12", siemensPLCm.ReadBool(Mt_AddressB.getQT12()).Content);
//          空压机 切机  主机 备机
			MMDataB.put("QT13", siemensPLCm.ReadInt16(Mt_AddressB.getQT13()).Content);
			MMDataB.put("QT14", siemensPLCm.ReadInt16(Mt_AddressB.getQT14()).Content);
			MMDataB.put("QT15", siemensPLCm.ReadInt16(Mt_AddressB.getQT15()).Content);
			MMDataB.put("QT16", siemensPLCm.ReadInt16(Mt_AddressB.getQT16()).Content);
			MMDataB.put("QT17", siemensPLCm.ReadInt16(Mt_AddressB.getQT17()).Content);
			siemensPLCm.ConnectClose();
			return MMDataB;
			
		}else {
			siemensPLCm.ConnectClose();
			return MMDataB;
		}
			
	}
//  5台空压机 切除 主机 备机 按钮操作
	@RequestMapping("/montoringButtion")
	public String knobControl(String MMDname, String MMDbuttion) {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		try {
			if (siemensPLC.ConnectServer().IsSuccess) {
				if ("LGJA".equals(MMDname)) {
					if ("BTA".equals(MMDbuttion)) {
						OperateResult result = siemensPLC.Write("M302", data1);
						if (result.IsSuccess) {
							return result.Message;
						}
					}
					if ("BTB".equals(MMDbuttion)) {
						OperateResult result = siemensPLC.Write("M302", data2);
						if (result.IsSuccess) {
							return result.Message;
						}
					}
					if ("BTC".equals(MMDbuttion)) {
						OperateResult result = siemensPLC.Write("M302", data4);
						if (result.IsSuccess) {
							return result.Message;
						}
					}
				}
				if ("LGJB".equals(MMDname)) {
					if ("BTA".equals(MMDbuttion)) {
						OperateResult result = siemensPLC.Write("M300", data1);
						if (result.IsSuccess) {
							return result.Message;
						}
					}
					if ("BTB".equals(MMDbuttion)) {
						OperateResult result = siemensPLC.Write("M300", data2);
						if (result.IsSuccess) {
							return result.Message;
						}
					}
					if ("BTC".equals(MMDbuttion)) {
						OperateResult result = siemensPLC.Write("M300", data4);
						if (result.IsSuccess) {
							return result.Message;
						}
					}
				}
				if ("LGJC".equals(MMDname)) {
					if ("BTA".equals(MMDbuttion)) {
						OperateResult result = siemensPLC.Write("M304", data1);
						if (result.IsSuccess) {
							return result.Message;
						}
					}
					if ("BTB".equals(MMDbuttion)) {
						OperateResult result = siemensPLC.Write("M304", data2);
						if (result.IsSuccess) {
							return result.Message;
						}
					}
					if ("BTC".equals(MMDbuttion)) {
						OperateResult result = siemensPLC.Write("M304", data4);
						if (result.IsSuccess) {
							return result.Message;
						}
					}
				}
				if ("LGJD".equals(MMDname)) {
					if ("BTA".equals(MMDbuttion)) {
						OperateResult result = siemensPLC.Write("M306", data1);
						if (result.IsSuccess) {
							return result.Message;
						}
					}
					if ("BTB".equals(MMDbuttion)) {
						OperateResult result = siemensPLC.Write("M306", data2);
						if (result.IsSuccess) {
							return result.Message;
						}
					}
					if ("BTC".equals(MMDbuttion)) {
						OperateResult result = siemensPLC.Write("M306", data4);
						if (result.IsSuccess) {
							return result.Message;
						}
					}
				}
				if ("LGJE".equals(MMDname)) {
					if ("BTA".equals(MMDbuttion)) {
						OperateResult result = siemensPLC.Write("M308", data1);
						if (result.IsSuccess) {
							return result.Message;
						}
					}
					if ("BTB".equals(MMDbuttion)) {
						OperateResult result = siemensPLC.Write("M308", data2);
						if (result.IsSuccess) {
							return result.Message;
						}
					}
					if ("BTC".equals(MMDbuttion)) {
						OperateResult result = siemensPLC.Write("M308", data4);
						if (result.IsSuccess) {
							return result.Message;
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
//	.四个参数点击传值
	@RequestMapping("/setParameters")
	public String setUpParameters(String PtName,float PtValue) {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		try {
			if (siemensPLC.ConnectServer().IsSuccess) {
				if ("QT2".equals(PtName)) {
					OperateResult result = siemensPLC.Write("DB21.2", PtValue);
					if (result.IsSuccess) {
						return result.Message;
					}
				}
				if ("QT3".equals(PtName)) {
					OperateResult result = siemensPLC.Write("DB21.6", PtValue);
					if (result.IsSuccess) {
						return result.Message;
					}
				}
				if ("QT6".equals(PtName)) {
					OperateResult result = siemensPLC.Write("DB21.10", PtValue);
					if (result.IsSuccess) {
						return result.Message;
					}
				}
				if ("QT7".equals(PtName)) {
					OperateResult result = siemensPLC.Write("DB21.14", PtValue);
					if (result.IsSuccess) {
						return result.Message;
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
	
	//高压低压手自动
	@RequestMapping("/updataSelfMotion")
	public String updataSelfMotion(String GYDYname,Boolean QTvalue) {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		try {
			if (siemensPLC.ConnectServer().IsSuccess) {
				if ("DYsmotion".equals(GYDYname)) {
					if ( QTvalue == true) {
						OperateResult result = siemensPLC.Write("DB21.18.4", false);
						if (result.IsSuccess) {
							return result.Message;
						}
					}
					if ( QTvalue == false) {
						OperateResult result = siemensPLC.Write("DB21.18.4", true);
						if (result.IsSuccess) {
							return result.Message;
						}
					}

				}
				if ("GYsmotion".equals(GYDYname)) {
					if ( QTvalue == true) {
						OperateResult result = siemensPLC.Write("DB21.18.5", false);
						if (result.IsSuccess) {
							return result.Message;
						}
					}
					if ( QTvalue == false) {
						OperateResult result = siemensPLC.Write("DB21.18.5", true);
						if (result.IsSuccess) {
							return result.Message;
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

}
