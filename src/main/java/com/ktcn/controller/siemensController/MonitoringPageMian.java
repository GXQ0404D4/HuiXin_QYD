package com.ktcn.controller.siemensController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.simensaddress.Monitoring_Address;
import com.ktcn.simens.utils.SiemensPlcConfig;

import HslCommunication.Core.Types.OperateResult;
import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
 * @author 作者 :Runaway programmer
 * @version 创建时间：2020年1月9日 下午1:59:54 
 * 类说明 监控主页面 Controller
 */
@RestController
public final class MonitoringPageMian {
	@Autowired
	Monitoring_Address monitoring_Address;

	// PLC 连接池 封装类配置类
	@Autowired
	SiemensPlcConfig SiemensPlcConfig;

	@RequestMapping("/monitoring")
	public Map <String,Object> getMonitoringPageData() {
		SiemensS7Net siemens_net = SiemensPlcConfig.getSiemensPLC();
		OperateResult connect = siemens_net.ConnectServer();
		Map <String,Object> MMData=new HashMap<String,Object>();

		if (connect.IsSuccess) {
			MMData.put("MD0",siemens_net.ReadFloat(monitoring_Address.getMD0()).Content);
			MMData.put("MD1",siemens_net.ReadFloat(monitoring_Address.getMD1()).Content);
			MMData.put("MD2",siemens_net.ReadFloat(monitoring_Address.getMD2()).Content);
			MMData.put("MD3",siemens_net.ReadFloat(monitoring_Address.getMD3()).Content);
			MMData.put("MD4",siemens_net.ReadFloat(monitoring_Address.getMD4()).Content);
			MMData.put("MD5",siemens_net.ReadFloat(monitoring_Address.getMD5()).Content);
			MMData.put("MD6",siemens_net.ReadFloat(monitoring_Address.getMD6()).Content);
			MMData.put("MD7",siemens_net.ReadFloat(monitoring_Address.getMD7()).Content);
			MMData.put("MD8",siemens_net.ReadFloat(monitoring_Address.getMD8()).Content);
			MMData.put("MD9",siemens_net.ReadFloat(monitoring_Address.getMD9()).Content);
			MMData.put("MD10",siemens_net.ReadFloat(monitoring_Address.getMD10()).Content);
			MMData.put("MD11",siemens_net.ReadFloat(monitoring_Address.getMD11()).Content);
			MMData.put("MD12",siemens_net.ReadFloat(monitoring_Address.getMD12()).Content);
			MMData.put("MD13",siemens_net.ReadFloat(monitoring_Address.getMD13()).Content);
			MMData.put("MD14",siemens_net.ReadFloat(monitoring_Address.getMD14()).Content);
			MMData.put("MD15",siemens_net.ReadFloat(monitoring_Address.getMD15()).Content);
			MMData.put("MD16",siemens_net.ReadFloat(monitoring_Address.getMD16()).Content);
			MMData.put("MD17",siemens_net.ReadFloat(monitoring_Address.getMD17()).Content);
			MMData.put("MD18",siemens_net.ReadFloat(monitoring_Address.getMD18()).Content);
			MMData.put("MD19",siemens_net.ReadFloat(monitoring_Address.getMD19()).Content);
			MMData.put("MD20",siemens_net.ReadFloat(monitoring_Address.getMD20()).Content);
			MMData.put("MD21",siemens_net.ReadFloat(monitoring_Address.getMD21()).Content);
			MMData.put("MD22",siemens_net.ReadFloat(monitoring_Address.getMD22()).Content);
			MMData.put("MD23",siemens_net.ReadFloat(monitoring_Address.getMD23()).Content);
			MMData.put("MD24",siemens_net.ReadFloat(monitoring_Address.getMD24()).Content);
			MMData.put("MD25",siemens_net.ReadFloat(monitoring_Address.getMD25()).Content);
			MMData.put("MD26",siemens_net.ReadFloat(monitoring_Address.getMD26()).Content);
			MMData.put("MD27",siemens_net.ReadFloat(monitoring_Address.getMD27()).Content);
			MMData.put("MD28",siemens_net.ReadFloat(monitoring_Address.getMD28()).Content);
			MMData.put("MD29",siemens_net.ReadFloat(monitoring_Address.getMD29()).Content);
			MMData.put("MD30",siemens_net.ReadFloat(monitoring_Address.getMD30()).Content);
			MMData.put("MD31",siemens_net.ReadFloat(monitoring_Address.getMD31()).Content);
			MMData.put("MD32",siemens_net.ReadFloat(monitoring_Address.getMD32()).Content);
			MMData.put("MD33",siemens_net.ReadFloat(monitoring_Address.getMD33()).Content);
			MMData.put("MD34",siemens_net.ReadFloat(monitoring_Address.getMD34()).Content);
			MMData.put("MD35",siemens_net.ReadFloat(monitoring_Address.getMD35()).Content);
			MMData.put("MD36",siemens_net.ReadFloat(monitoring_Address.getMD36()).Content);
			MMData.put("MD37",siemens_net.ReadFloat(monitoring_Address.getMD37()).Content);
			MMData.put("MD38",siemens_net.ReadFloat(monitoring_Address.getMD38()).Content);
			MMData.put("MD39",siemens_net.ReadFloat(monitoring_Address.getMD39()).Content);
			MMData.put("MD40",siemens_net.ReadFloat(monitoring_Address.getMD40()).Content);
			MMData.put("MD41",siemens_net.ReadFloat(monitoring_Address.getMD41()).Content);
			MMData.put("MD42",siemens_net.ReadFloat(monitoring_Address.getMD42()).Content);
			MMData.put("MD43",siemens_net.ReadFloat(monitoring_Address.getMD43()).Content);
			MMData.put("MD44",siemens_net.ReadFloat(monitoring_Address.getMD44()).Content);
			MMData.put("MD45",siemens_net.ReadFloat(monitoring_Address.getMD45()).Content);
			MMData.put("MD46",siemens_net.ReadFloat(monitoring_Address.getMD46()).Content);
			MMData.put("MD47",siemens_net.ReadFloat(monitoring_Address.getMD47()).Content);
			MMData.put("MD48",siemens_net.ReadFloat(monitoring_Address.getMD48()).Content);
			MMData.put("MD49",siemens_net.ReadFloat(monitoring_Address.getMD49()).Content);
			MMData.put("MD50",siemens_net.ReadFloat(monitoring_Address.getMD50()).Content);
			MMData.put("MD51",siemens_net.ReadFloat(monitoring_Address.getMD51()).Content);
			MMData.put("MD52",siemens_net.ReadFloat(monitoring_Address.getMD52()).Content);
			MMData.put("MD53",siemens_net.ReadBool(monitoring_Address.getMD53()).Content);
			MMData.put("MD54",siemens_net.ReadBool(monitoring_Address.getMD54()).Content);
			MMData.put("MD55",siemens_net.ReadBool(monitoring_Address.getMD55()).Content);
			MMData.put("MD56",siemens_net.ReadBool(monitoring_Address.getMD56()).Content);
			MMData.put("MD57",siemens_net.ReadBool(monitoring_Address.getMD57()).Content);
			MMData.put("MD58",siemens_net.ReadBool(monitoring_Address.getMD58()).Content);
			MMData.put("MD59",siemens_net.ReadBool(monitoring_Address.getMD59()).Content);
			MMData.put("MD60",siemens_net.ReadBool(monitoring_Address.getMD60()).Content);
			MMData.put("MD61",siemens_net.ReadBool(monitoring_Address.getMD61()).Content);
			MMData.put("MD62",siemens_net.ReadBool(monitoring_Address.getMD62()).Content);
			MMData.put("MD63",siemens_net.ReadBool(monitoring_Address.getMD63()).Content);
			MMData.put("MD64",siemens_net.ReadBool(monitoring_Address.getMD64()).Content);
			MMData.put("MD65",siemens_net.ReadBool(monitoring_Address.getMD65()).Content);
			MMData.put("MD66",siemens_net.ReadBool(monitoring_Address.getMD66()).Content);
			MMData.put("MD67",siemens_net.ReadBool(monitoring_Address.getMD67()).Content);
			MMData.put("MD68",siemens_net.ReadBool(monitoring_Address.getMD68()).Content);
			MMData.put("MD69",siemens_net.ReadBool(monitoring_Address.getMD69()).Content);
			MMData.put("MD70",siemens_net.ReadBool(monitoring_Address.getMD70()).Content);
			MMData.put("MD71",siemens_net.ReadBool(monitoring_Address.getMD71()).Content);
			MMData.put("MD72",siemens_net.ReadBool(monitoring_Address.getMD72()).Content);
			MMData.put("MD73",siemens_net.ReadBool(monitoring_Address.getMD73()).Content);
			MMData.put("MD74",siemens_net.ReadBool(monitoring_Address.getMD74()).Content);
			MMData.put("MD75",siemens_net.ReadBool(monitoring_Address.getMD75()).Content);
			MMData.put("MD76",siemens_net.ReadBool(monitoring_Address.getMD76()).Content);
			MMData.put("MD77",siemens_net.ReadBool(monitoring_Address.getMD77()).Content);
			MMData.put("MD78",siemens_net.ReadBool(monitoring_Address.getMD78()).Content);
			MMData.put("MD79",siemens_net.ReadBool(monitoring_Address.getMD79()).Content);
			MMData.put("MD80",siemens_net.ReadBool(monitoring_Address.getMD80()).Content);
			MMData.put("MD81",siemens_net.ReadBool(monitoring_Address.getMD81()).Content);
			MMData.put("MD82",siemens_net.ReadBool(monitoring_Address.getMD82()).Content);
			MMData.put("MD83",siemens_net.ReadBool(monitoring_Address.getMD83()).Content);
			MMData.put("MD84",siemens_net.ReadBool(monitoring_Address.getMD84()).Content);
			MMData.put("MD85",siemens_net.ReadBool(monitoring_Address.getMD85()).Content);
			MMData.put("MD86",siemens_net.ReadBool(monitoring_Address.getMD86()).Content);
			MMData.put("MD87",siemens_net.ReadBool(monitoring_Address.getMD87()).Content);
			MMData.put("MD88",siemens_net.ReadBool(monitoring_Address.getMD88()).Content);
			MMData.put("MD89",siemens_net.ReadBool(monitoring_Address.getMD89()).Content);
			MMData.put("MD90",siemens_net.ReadBool(monitoring_Address.getMD90()).Content);
			MMData.put("MD91",siemens_net.ReadBool(monitoring_Address.getMD91()).Content);
			MMData.put("MD92",siemens_net.ReadBool(monitoring_Address.getMD92()).Content);
			MMData.put("MD93",siemens_net.ReadBool(monitoring_Address.getMD93()).Content);
			MMData.put("MD94",siemens_net.ReadBool(monitoring_Address.getMD94()).Content);
			MMData.put("MD95",siemens_net.ReadBool(monitoring_Address.getMD95()).Content);
			MMData.put("MD96",siemens_net.ReadBool(monitoring_Address.getMD96()).Content);
			MMData.put("MD97",siemens_net.ReadBool(monitoring_Address.getMD97()).Content);
		
		} else {
			System.out.println("failed:" + connect.Message);
		}

		siemens_net.ConnectClose();
		return MMData;

	}
}
