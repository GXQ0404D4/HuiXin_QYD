package com.ktcn.controller.siemensController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.simens.utils.SiemensPlcConfig;
import com.ktcn.simens.utils.SiemensPlcConfig3;

import HslCommunication.Core.Types.OperateResult;
import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月9日 下午4:52:52
* 类说明    烧结变频机 1号机 2号机数据(螺杆机)
*/
@RestController
@PropertySource({ "classpath:config/screw_machine.properties" })
public final class ScrewMachinePage {
	// 烧结变频1
	@Value("${PLC7.LGJ5}")
	private String LGJ7_5;
	@Value("${PLC7.LGJ6}")
	private String LGJ7_6;
	@Value("${PLC7.LGJ25}")
	private String LGJ7_25;
	@Value("${PLC7.LGJ26}")
	private String LGJ7_26;
	@Value("${PLC7.LGJ27}")
	private String LGJ7_27;
	// 烧结变频2
	@Value("${PLC8.LGJ5}")
	private String LGJ8_5;
	@Value("${PLC8.LGJ6}")
	private String LGJ8_6;
	@Value("${PLC8.LGJ25}")
	private String LGJ8_25;
	@Value("${PLC8.LGJ26}")
	private String LGJ8_26;
	@Value("${PLC8.LGJ27}")
	private String LGJ8_27;

	@Autowired
	SiemensPlcConfig3 SiemensPlcConfig;
	// 烧结变频1
	@RequestMapping("/screwmachine1")
	public Map <String,Object> getScrewMachineData1() {
		SiemensS7Net siemens_net = SiemensPlcConfig3.getSiemensPLC();
		OperateResult connect = siemens_net.ConnectServer();
		Map <String,Object> SJBP1=new HashMap<String,Object>();
		
		if (connect.IsSuccess) {
			SJBP1.put("SJBP_A0",siemens_net.ReadFloat(LGJ7_5).Content);
			SJBP1.put("SJBP_A1",siemens_net.ReadFloat(LGJ7_6).Content);
			SJBP1.put("SJBP_A2",siemens_net.ReadBool(LGJ7_25).Content);
			SJBP1.put("SJBP_A3",siemens_net.ReadBool(LGJ7_26).Content);
			SJBP1.put("SJBP_A4",siemens_net.ReadBool(LGJ7_27).Content);
			
			System.out.println("connect success!");
		} else {
			System.out.println("failed:" + connect.Message);
		}

		siemens_net.ConnectClose();
		System.out.println("关闭连接");
		return SJBP1;
	}
	// 烧结变频2
	@RequestMapping("/screwmachine2")
	public Map <String,Object> getScrewMachineData2() {
		SiemensS7Net siemens_net = SiemensPlcConfig3.getSiemensPLC();
		OperateResult connect = siemens_net.ConnectServer();
		Map <String,Object> SJBP2=new HashMap<String,Object>();
		
		if (connect.IsSuccess) {
			SJBP2.put("SJBP_B0",siemens_net.ReadFloat(LGJ8_5).Content);
			SJBP2.put("SJBP_B1",siemens_net.ReadFloat(LGJ8_6).Content);
			SJBP2.put("SJBP_B2",siemens_net.ReadBool(LGJ8_25).Content);
			SJBP2.put("SJBP_B3",siemens_net.ReadBool(LGJ8_26).Content);
//			遗留问题未排除
			SJBP2.put("SJBP_B4",siemens_net.ReadBool("DB35.46.2").Content);
			
			System.out.println("connect success!");
		} else {
			System.out.println("failed:" + connect.Message);
		}

		siemens_net.ConnectClose();
		System.out.println("关闭连接");
		return SJBP2;
	}
}
