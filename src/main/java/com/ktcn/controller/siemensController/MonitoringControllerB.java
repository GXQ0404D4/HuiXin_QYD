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
	
    private final short data1=1;
    private final short data2=2;
    private final short data4=4;
	//监控页面2实时数据展示
	@RequestMapping("/monitoringPageB")
	public Map<String, Object> getMonitoringBData() {
		Map<String, Object> MMDataB = new HashMap<String, Object>();
		Peripheral_qt nLRealData = PDReaml.getNewLyRealData();
		Peripheral_entity ppRealData = PDReaml.getPeripheralRealData();
		Map<String, ScrewMachine> smReamldata = SMDReaml.getRealDataPage();
		if (nLRealData!=null && ppRealData!=null && smReamldata!=null) {
			MMDataB.put("QT0",nLRealData.getWwqt2());
			MMDataB.put("QT1",ppRealData.getWw44());
			MMDataB.put("QT2",nLRealData.getWwqt0());
			MMDataB.put("QT3",nLRealData.getWwqt1());

			MMDataB.put("QT4",nLRealData.getWwqt5());
			MMDataB.put("QT5",ppRealData.getWw37());
			MMDataB.put("QT6",nLRealData.getWwqt3());
			MMDataB.put("QT7",nLRealData.getWwqt4());

			MMDataB.put("QT8",smReamldata.get("ScrewMachine1").getLGJ19());
			MMDataB.put("QT9",smReamldata.get("ScrewMachine2").getLGJ19());
			MMDataB.put("QT10",smReamldata.get("ScrewMachine3").getLGJ19());
			MMDataB.put("QT11",smReamldata.get("ScrewMachine4").getLGJ19());
			MMDataB.put("QT12",smReamldata.get("ScrewMachine5").getLGJ19());
			
			MMDataB.put("QT13",smReamldata.get("ScrewMachine1").getLGJ12());
			MMDataB.put("QT14",smReamldata.get("ScrewMachine2").getLGJ12());
			MMDataB.put("QT15",smReamldata.get("ScrewMachine3").getLGJ12());
			MMDataB.put("QT16",smReamldata.get("ScrewMachine4").getLGJ12());
			MMDataB.put("QT17",smReamldata.get("ScrewMachine5").getLGJ12());
		return MMDataB;
		}else {
			MMDataB.put("state", "loading");
			return MMDataB;
		}
			

	}
//  5台空压机 切除 主机 备机 按钮操作
	@RequestMapping("/montoringButtion")
	public String knobControl(String MMDname, String MMDbuttion) {
		System.out.println(MMDname+"_____"+MMDbuttion);
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
						OperateResult result = siemensPLC.Write("M309", data2);
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
		System.out.println(PtName+"________"+PtValue);
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
	@RequestMapping("/updataSelfMotion")
	public String updataSelfMotion(String GYDYname,Boolean QTvalue) {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		System.out.println(GYDYname+"_____"+QTvalue);
		try {
			if (siemensPLC.ConnectServer().IsSuccess) {
				if ("DYsmotion".equals(GYDYname)) {
					if ("true".equals(QTvalue) || QTvalue == true) {
						OperateResult result = siemensPLC.Write("DB21.18.4", false);
						if (result.IsSuccess) {
							return result.Message;
						}
					}
					if ("false".equals(QTvalue) || QTvalue == false) {
						OperateResult result = siemensPLC.Write("DB21.18.4", true);
						if (result.IsSuccess) {
							return result.Message;
						}
					}

				}
				if ("GYsmotion".equals(GYDYname)) {
					if ("true".equals(QTvalue) || QTvalue == true) {
						OperateResult result = siemensPLC.Write("DB21.18.5", false);
						if (result.IsSuccess) {
							return result.Message;
						}
					}
					if ("false".equals(QTvalue) || QTvalue == false) {
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
