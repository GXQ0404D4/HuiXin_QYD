package com.ktcn.simens.PLCdata;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.siemensentity.Peripheral_entity;
import com.ktcn.entity.siemensentity.Peripheral_qt;
import com.ktcn.entity.simensaddress.Peripheral_Address;
import com.ktcn.simens.utils.SiemensPlcConfig;

import HslCommunication.Profinet.Siemens.SiemensS7Net;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月9日 下午4:19:25
* 类说明  外围数据
*/
//@EnableScheduling // 开启定时器任务，springboot启动类 已添加这里就不需要了
@Component
@Order(value = 1)//此类运行顺序
public  class Peripheral_data {
	//PLC地址点位获取类
    @Autowired
    Peripheral_Address Ph_Address;
	//连接池工具类
	@Autowired
	SiemensPlcConfig SiemensPlcConfig;	 
	//实体类
	@Autowired
	Peripheral_entity PeripheralData;
	//实体类
	@Autowired
	Peripheral_qt Peripheral_qt;
	
	
	public   Map<String,Object> getPeripheral_data() {
		Map<String,Object> DataMap=new HashMap<String,Object>();
		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
		if (siemensPLC.ConnectServer().IsSuccess) {
			//外围数据获取
			PeripheralData.setWw0(siemensPLC.ReadFloat(Ph_Address.getWW0()).Content);
			PeripheralData.setWw1(siemensPLC.ReadFloat(Ph_Address.getWW1()).Content);
			PeripheralData.setWw2(siemensPLC.ReadFloat(Ph_Address.getWW2()).Content);
			PeripheralData.setWw3(siemensPLC.ReadFloat(Ph_Address.getWW3()).Content);
			PeripheralData.setWw4(siemensPLC.ReadFloat(Ph_Address.getWW4()).Content);
			PeripheralData.setWw5(siemensPLC.ReadBool(Ph_Address.getWW5()).Content);
			PeripheralData.setWw6(siemensPLC.ReadBool(Ph_Address.getWW6()).Content);
			PeripheralData.setWw7(siemensPLC.ReadFloat(Ph_Address.getWW7()).Content);
			PeripheralData.setWw8(siemensPLC.ReadFloat(Ph_Address.getWW8()).Content);
			PeripheralData.setWw9(siemensPLC.ReadFloat(Ph_Address.getWW9()).Content);
			PeripheralData.setWw10(siemensPLC.ReadFloat(Ph_Address.getWW10()).Content);
			PeripheralData.setWw11(siemensPLC.ReadFloat(Ph_Address.getWW11()).Content);
			PeripheralData.setWw12(siemensPLC.ReadBool(Ph_Address.getWW12()).Content);
			PeripheralData.setWw13(siemensPLC.ReadBool(Ph_Address.getWW13()).Content);
			PeripheralData.setWw14(siemensPLC.ReadFloat(Ph_Address.getWW14()).Content);
			PeripheralData.setWw15(siemensPLC.ReadFloat(Ph_Address.getWW15()).Content);
			PeripheralData.setWw16(siemensPLC.ReadFloat(Ph_Address.getWW16()).Content);
			PeripheralData.setWw17(siemensPLC.ReadFloat(Ph_Address.getWW17()).Content);
			PeripheralData.setWw18(siemensPLC.ReadFloat(Ph_Address.getWW18()).Content);
			PeripheralData.setWw19(siemensPLC.ReadBool(Ph_Address.getWW19()).Content);
			PeripheralData.setWw20(siemensPLC.ReadBool(Ph_Address.getWW20()).Content);
			PeripheralData.setWw21(siemensPLC.ReadFloat(Ph_Address.getWW21()).Content);
			PeripheralData.setWw22(siemensPLC.ReadFloat(Ph_Address.getWW22()).Content);
			PeripheralData.setWw23(siemensPLC.ReadFloat(Ph_Address.getWW23()).Content);
			PeripheralData.setWw24(siemensPLC.ReadFloat(Ph_Address.getWW24()).Content);
			PeripheralData.setWw25(siemensPLC.ReadFloat(Ph_Address.getWW25()).Content);
			PeripheralData.setWw26(siemensPLC.ReadFloat(Ph_Address.getWW26()).Content);
			PeripheralData.setWw27(siemensPLC.ReadFloat(Ph_Address.getWW27()).Content);
			PeripheralData.setWw28(siemensPLC.ReadFloat(Ph_Address.getWW28()).Content);
			PeripheralData.setWw29(siemensPLC.ReadFloat(Ph_Address.getWW29()).Content);
			PeripheralData.setWw30(siemensPLC.ReadFloat(Ph_Address.getWW30()).Content);
			PeripheralData.setWw31(siemensPLC.ReadFloat(Ph_Address.getWW31()).Content);
			PeripheralData.setWw32(siemensPLC.ReadFloat(Ph_Address.getWW32()).Content);
			PeripheralData.setWw33(siemensPLC.ReadFloat(Ph_Address.getWW33()).Content);
			PeripheralData.setWw34(siemensPLC.ReadFloat(Ph_Address.getWW34()).Content);
			PeripheralData.setWw35(siemensPLC.ReadBool(Ph_Address.getWW35()).Content);
			PeripheralData.setWw36(siemensPLC.ReadBool(Ph_Address.getWW36()).Content);
			PeripheralData.setWw37(siemensPLC.ReadFloat(Ph_Address.getWW37()).Content);
			PeripheralData.setWw38(siemensPLC.ReadFloat(Ph_Address.getWW38()).Content);
			PeripheralData.setWw39(siemensPLC.ReadFloat(Ph_Address.getWW39()).Content);
			PeripheralData.setWw40(siemensPLC.ReadFloat(Ph_Address.getWW40()).Content);
			PeripheralData.setWw41(siemensPLC.ReadFloat(Ph_Address.getWW41()).Content);
			PeripheralData.setWw42(siemensPLC.ReadBool(Ph_Address.getWW42()).Content);
			PeripheralData.setWw43(siemensPLC.ReadBool(Ph_Address.getWW43()).Content);
			PeripheralData.setWw44(siemensPLC.ReadFloat(Ph_Address.getWW44()).Content);
			PeripheralData.setWw45(siemensPLC.ReadFloat(Ph_Address.getWW45()).Content);
			PeripheralData.setWw46(siemensPLC.ReadFloat(Ph_Address.getWW46()).Content);
			PeripheralData.setWw47(siemensPLC.ReadFloat(Ph_Address.getWW47()).Content);
			PeripheralData.setWw48(siemensPLC.ReadFloat(Ph_Address.getWW48()).Content);
			PeripheralData.setWw49(siemensPLC.ReadBool(Ph_Address.getWW49()).Content);
			PeripheralData.setWw50(siemensPLC.ReadBool(Ph_Address.getWW50()).Content);
			PeripheralData.setWw51(siemensPLC.ReadFloat(Ph_Address.getWW51()).Content);
			PeripheralData.setWw52(siemensPLC.ReadFloat(Ph_Address.getWW52()).Content);
			PeripheralData.setWw53(siemensPLC.ReadFloat(Ph_Address.getWW53()).Content);
			PeripheralData.setWw54(siemensPLC.ReadFloat(Ph_Address.getWW54()).Content);
			PeripheralData.setWw55(siemensPLC.ReadFloat(Ph_Address.getWW55()).Content);
			PeripheralData.setWw56(siemensPLC.ReadBool(Ph_Address.getWW56()).Content);
			PeripheralData.setWw57(siemensPLC.ReadBool(Ph_Address.getWW57()).Content);
			PeripheralData.setWw58(siemensPLC.ReadFloat(Ph_Address.getWW58()).Content);
			PeripheralData.setWw59(siemensPLC.ReadFloat(Ph_Address.getWW59()).Content);
			PeripheralData.setWw60(siemensPLC.ReadFloat(Ph_Address.getWW60()).Content);
			PeripheralData.setWw61(siemensPLC.ReadFloat(Ph_Address.getWW61()).Content);
			PeripheralData.setWw62(siemensPLC.ReadFloat(Ph_Address.getWW62()).Content);
			PeripheralData.setWw63(siemensPLC.ReadBool(Ph_Address.getWW63()).Content);
			PeripheralData.setWw64(siemensPLC.ReadBool(Ph_Address.getWW64()).Content);
			PeripheralData.setWw65(siemensPLC.ReadFloat(Ph_Address.getWW65()).Content);
			PeripheralData.setWw66(siemensPLC.ReadFloat(Ph_Address.getWW66()).Content);
			PeripheralData.setWw67(siemensPLC.ReadFloat(Ph_Address.getWW67()).Content);
			PeripheralData.setWw68(siemensPLC.ReadFloat(Ph_Address.getWW68()).Content);
			PeripheralData.setWw69(siemensPLC.ReadFloat(Ph_Address.getWW69()).Content);
			PeripheralData.setWw70(siemensPLC.ReadBool(Ph_Address.getWW70()).Content);
			PeripheralData.setWw71(siemensPLC.ReadBool(Ph_Address.getWW71()).Content);
			PeripheralData.setWw72(siemensPLC.ReadFloat(Ph_Address.getWW72()).Content);
			PeripheralData.setWw73(siemensPLC.ReadFloat(Ph_Address.getWW73()).Content);
			PeripheralData.setWw74(siemensPLC.ReadFloat(Ph_Address.getWW74()).Content);
			PeripheralData.setWw75(siemensPLC.ReadFloat(Ph_Address.getWW75()).Content);
			PeripheralData.setWw76(siemensPLC.ReadFloat(Ph_Address.getWW76()).Content);
			PeripheralData.setWw77(siemensPLC.ReadBool(Ph_Address.getWW77()).Content);
			PeripheralData.setWw78(siemensPLC.ReadBool(Ph_Address.getWW78()).Content);
			PeripheralData.setWw79(siemensPLC.ReadFloat(Ph_Address.getWW79()).Content);
			PeripheralData.setWw80(siemensPLC.ReadFloat(Ph_Address.getWW80()).Content);
			PeripheralData.setWw81(siemensPLC.ReadFloat(Ph_Address.getWW81()).Content);
			PeripheralData.setWw82(siemensPLC.ReadFloat(Ph_Address.getWW82()).Content);
			PeripheralData.setWw83(siemensPLC.ReadFloat(Ph_Address.getWW83()).Content);
			PeripheralData.setWw84(siemensPLC.ReadBool(Ph_Address.getWW84()).Content);
			PeripheralData.setWw85(siemensPLC.ReadBool(Ph_Address.getWW85()).Content);
			PeripheralData.setWw86(siemensPLC.ReadFloat(Ph_Address.getWW86()).Content);
			PeripheralData.setWw87(siemensPLC.ReadFloat(Ph_Address.getWW87()).Content);
			PeripheralData.setWw88(siemensPLC.ReadBool(Ph_Address.getWW88()).Content);
			PeripheralData.setWw89(siemensPLC.ReadFloat(Ph_Address.getWW89()).Content);
			PeripheralData.setWw90(siemensPLC.ReadFloat(Ph_Address.getWW90()).Content);
			PeripheralData.setWw91(siemensPLC.ReadBool(Ph_Address.getWW91()).Content);
			PeripheralData.setWw92(siemensPLC.ReadFloat(Ph_Address.getWW92()).Content);
			PeripheralData.setWw93(siemensPLC.ReadFloat(Ph_Address.getWW93()).Content);
			PeripheralData.setWw94(siemensPLC.ReadBool(Ph_Address.getWW94()).Content);
			//QT
			Peripheral_qt.setWwqt0(siemensPLC.ReadFloat(Ph_Address.getWWQT0()).Content);
			Peripheral_qt.setWwqt1(siemensPLC.ReadFloat(Ph_Address.getWWQT1()).Content);
			Peripheral_qt.setWwqt2(siemensPLC.ReadBool(Ph_Address.getWWQT2()).Content);
			Peripheral_qt.setWwqt3(siemensPLC.ReadFloat(Ph_Address.getWWQT3()).Content);
			Peripheral_qt.setWwqt4(siemensPLC.ReadFloat(Ph_Address.getWWQT4()).Content);
			Peripheral_qt.setWwqt5(siemensPLC.ReadBool(Ph_Address.getWWQT5()).Content);
			Peripheral_qt.setWwqt6(siemensPLC.ReadBool(Ph_Address.getWWQT6()).Content);
			Peripheral_qt.setWwqt7(siemensPLC.ReadFloat(Ph_Address.getWWQT7()).Content);
			Peripheral_qt.setWwqt8(siemensPLC.ReadBool(Ph_Address.getWWQT8()).Content);
			Peripheral_qt.setWwqt9(siemensPLC.ReadBool(Ph_Address.getWWQT9()).Content);
//			Peripheral_serviceimp.setPeripheral_data(Peripheral_Data);
//			Newly_serviceimp.setNewlyData(Peripheral_qt);
			DataMap.put("PeripheralData", PeripheralData);
			DataMap.put("Peripheral_qt", Peripheral_qt);
		} else {
			System.out.println("failed:" + siemensPLC.ConnectServer().Message+"干燥机异常");
		}
		siemensPLC.ConnectClose();
		// 数据读取完毕 获取当前时间
		System.out.println(PeripheralData );
		System.out.println(Peripheral_qt );
		System.out.println("干燥机数据持久化+555" + new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
		System.out.println(" ");
		return DataMap;
	}


}
