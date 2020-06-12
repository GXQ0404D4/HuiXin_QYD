package com.ktcn.controller.siemensController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.simensaddress.Monitoring_AddressB;
import com.ktcn.simens.utils.SiemensPlcConfig;

import HslCommunication.Core.Types.OperateResult;
import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
 * @author 作者 :Runaway programmer
 * @version 创建时间：2020年6月11日 下午7:13:21 类说明
 */

@RestController
public class MonitoringControllerB {

	@Autowired
	Monitoring_AddressB MT_AddressB;

	@Autowired
	SiemensPlcConfig SiemensPlcConfig;
	
    private final short data1=1;
    private final short data2=2;
    private final short data4=4;

	@RequestMapping("/monitoringPageB")
	public Map<String, Object> setMonitoringBData() {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		Map<String, Object> MMDataB = new HashMap<String, Object>();
		if (siemensPLC.ConnectServer().IsSuccess) {
			MMDataB.put("QT0", siemensPLC.ReadBool(MT_AddressB.getQT0()).Content);
			MMDataB.put("QT1", siemensPLC.ReadFloat(MT_AddressB.getQT1()).Content);
			MMDataB.put("QT2", siemensPLC.ReadFloat(MT_AddressB.getQT2()).Content);
			MMDataB.put("QT3", siemensPLC.ReadFloat(MT_AddressB.getQT3()).Content);

			MMDataB.put("QT4", siemensPLC.ReadBool(MT_AddressB.getQT4()).Content);
			MMDataB.put("QT5", siemensPLC.ReadFloat(MT_AddressB.getQT5()).Content);
			MMDataB.put("QT6", siemensPLC.ReadFloat(MT_AddressB.getQT6()).Content);
			MMDataB.put("QT7", siemensPLC.ReadFloat(MT_AddressB.getQT7()).Content);

			MMDataB.put("QT8", siemensPLC.ReadBool(MT_AddressB.getQT8()).Content);
			MMDataB.put("QT9", siemensPLC.ReadBool(MT_AddressB.getQT9()).Content);
			MMDataB.put("QT10", siemensPLC.ReadBool(MT_AddressB.getQT10()).Content);
			MMDataB.put("QT11", siemensPLC.ReadBool(MT_AddressB.getQT11()).Content);
			MMDataB.put("QT12", siemensPLC.ReadBool(MT_AddressB.getQT12()).Content);

		} else {
			System.out.println("failed:" + siemensPLC.ConnectServer().Message + "B监控页面数据");
		}
		System.out.println(MMDataB);
		siemensPLC.ConnectClose();
		return MMDataB;

	}
//  5台空压机 切除 主机 备机 按钮操作
	@RequestMapping("/montoringButtion")
	public String knobControl(String MMDname, String MMDbuttion) {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		if (siemensPLC.ConnectServer().IsSuccess) {
			if (MMDname.equals("LGJA")) {
				if (MMDbuttion.equals("BTA")) {
//					System.out.println(siemensPLC.ReadInt16("M302").Content);
					OperateResult result = siemensPLC.Write("M302", data1);
					if (result.IsSuccess) {
						return result.Message;
					}
					
				}
				if (MMDbuttion.equals("BTB")) {
//					System.out.println(siemensPLC.ReadInt16("M302").Content);
					OperateResult result = siemensPLC.Write("M302", data2);
					if (result.IsSuccess) {
						return result.Message;
					}
				}
				if (MMDbuttion.equals("BTC")) {
//					System.out.println(siemensPLC.ReadInt16("M302").Content);
					OperateResult result = siemensPLC.Write("M302", data4);
					if (result.IsSuccess) {
						return result.Message;
					}
				}

			}
			if (MMDname.equals("LGJB")) {
				if (MMDbuttion.equals("BTA")) {
					OperateResult result =siemensPLC.Write("M300", data1);
					if (result.IsSuccess) {
						return result.Message;
					}
				}
				if (MMDbuttion.equals("BTB")) {
					OperateResult result =siemensPLC.Write("M300", data2);
					if (result.IsSuccess) {
						return result.Message;
					}
				}
				if (MMDbuttion.equals("BTC")) {
					OperateResult result =siemensPLC.Write("M300", data4);
					if (result.IsSuccess) {
						return result.Message;
					}
				}

			}
			if (MMDname.equals("LGJC")) {
				if (MMDbuttion.equals("BTA")) {
					OperateResult result =siemensPLC.Write("M304", data1);
					if (result.IsSuccess) {
						return result.Message;
					}
				}
				if (MMDbuttion.equals("BTB")) {
					OperateResult result =siemensPLC.Write("M304", data2);
					if (result.IsSuccess) {
						return result.Message;
					}
				}
				if (MMDbuttion.equals("BTC")) {
					OperateResult result =siemensPLC.Write("M304", data4);
					if (result.IsSuccess) {
						return result.Message;
					}
				}

			}
			if (MMDname.equals("LGJD")) {
				if (MMDbuttion.equals("BTA")) {
					OperateResult result =siemensPLC.Write("M306", data1);
					if (result.IsSuccess) {
						return result.Message;
					}
				}
				if (MMDbuttion.equals("BTB")) {
					OperateResult result =siemensPLC.Write("M306", data2);
					if (result.IsSuccess) {
						return result.Message;
					}
				}
				if (MMDbuttion.equals("BTC")) {
					OperateResult result =siemensPLC.Write("M306", data4);
					if (result.IsSuccess) {
						return result.Message;
					}
				}

			}
			if (MMDname.equals("LGJE")) {
				if (MMDbuttion.equals("BTA")) {
					OperateResult result =siemensPLC.Write("M308", data1);
					if (result.IsSuccess) {
						return result.Message;
					}
				}
				if (MMDbuttion.equals("BTB")) {
					OperateResult result =siemensPLC.Write("M308", data2);
					if (result.IsSuccess) {
						return result.Message;
					}
				}
				if (MMDbuttion.equals("BTC")) {
					OperateResult result =siemensPLC.Write("M309", data2);
					if (result.IsSuccess) {
						return result.Message;
					}
				}

			}
		}else {
			System.out.println("failed:" + siemensPLC.ConnectServer().Message + "B监控页面BUTTION数据");
			return "failed";
		}
		
		return "ununited";

	}
	
	@RequestMapping("/setParameters")
	public String setUpParameters(String PtName,float PtValue) {
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		float flValue=PtValue;
		System.out.println(PtName+"________"+PtValue);
		if (siemensPLC.ConnectServer().IsSuccess) {
			if (PtName.equals("QT2")) {
				System.out.println("11111___"+siemensPLC.ReadFloat("DB21.2").Content);
				OperateResult result = siemensPLC.Write("DB21.2", flValue);
				System.out.println("22222___"+siemensPLC.ReadFloat("DB21.2").Content);
				if (result.IsSuccess) {
					return result.Message;
				}
			}if (PtName.equals("QT3")) {
				OperateResult result = siemensPLC.Write("DB21.6", flValue);
				if (result.IsSuccess) {
					return result.Message;
				}
			}if (PtName.equals("QT6")) {
				OperateResult result = siemensPLC.Write("DB21.10", flValue);
				if (result.IsSuccess) {
					return result.Message;
				}
			}if (PtName.equals("QT7")) {
				OperateResult result = siemensPLC.Write("DB21.14", flValue);
				if (result.IsSuccess) {
					return result.Message;
				}
			}
		}else {
			System.out.println("failed:" + siemensPLC.ConnectServer().Message + "B监控页面高低数据");
			return "failed";
		}
		return "ununited";
		
	}

}
