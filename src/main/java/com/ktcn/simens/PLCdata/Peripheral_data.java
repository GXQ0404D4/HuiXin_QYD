//package com.ktcn.simens.PLCdata;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.annotation.Order;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.ktcn.entity.siemensentity.Peripheral_qt;
//import com.ktcn.entity.siemensentity.Peripheral_Data;
//import com.ktcn.entity.simensaddress.Peripheral_Address;
//import com.ktcn.service.siemensService.Peripheral_service;
//import com.ktcn.service.siemensServiceImp.Newly_serviceimp;
//import com.ktcn.simens.utils.SiemensPlcConfig;
//
//import HslCommunication.Profinet.Siemens.SiemensS7Net;
//
///**
//* @author 作者 :Runaway programmer
//* @version 创建时间：2020年6月9日 下午4:19:25
//* 类说明  外围数据
//*/
////@EnableScheduling // 此注解必加,必须要加，重中之重
//@Component // 此注解必加
////@Async
//@Order(value = 1)
////@PropertySource({ "classpath:config/peripheral_data.properties" })
//public final class Peripheral_data {
//	//PLC地址点位获取类
//    @Autowired
//    Peripheral_Address Ph_Address;
//	//连接池工具类
//	@Autowired
//	SiemensPlcConfig SiemensPlcConfig;	 
//	//实体类
//	@Autowired
//	Peripheral_Data Peripheral_Data;
//	//实体类
//	@Autowired
//	Peripheral_qt Peripheral_qt;
//	//实体类
//	@Autowired
//	Newly_serviceimp Newly_serviceimp;
//	//service
//	@Autowired
//	Peripheral_service Peripheral_serviceimp;
//	
////	@Async
//	@Scheduled(cron = "0/1 * * * * ?")
//	public  void getPeripheral_data() {
//		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
//		
//		if (siemensPLC.ConnectServer().IsSuccess) {
//			//外围数据获取
//			Peripheral_Data.setWw0(siemensPLC.ReadFloat(Ph_Address.getWW0()).Content);
//			Peripheral_Data.setWw1(siemensPLC.ReadFloat(Ph_Address.getWW1()).Content);
//			Peripheral_Data.setWw2(siemensPLC.ReadFloat(Ph_Address.getWW2()).Content);
//			Peripheral_Data.setWw3(siemensPLC.ReadFloat(Ph_Address.getWW3()).Content);
//			Peripheral_Data.setWw4(siemensPLC.ReadFloat(Ph_Address.getWW4()).Content);
//			Peripheral_Data.setWw5(siemensPLC.ReadBool(Ph_Address.getWW5()).Content);
//			Peripheral_Data.setWw6(siemensPLC.ReadBool(Ph_Address.getWW6()).Content);
//			Peripheral_Data.setWw7(siemensPLC.ReadFloat(Ph_Address.getWW7()).Content);
//			Peripheral_Data.setWw8(siemensPLC.ReadFloat(Ph_Address.getWW8()).Content);
//			Peripheral_Data.setWw9(siemensPLC.ReadFloat(Ph_Address.getWW9()).Content);
//			Peripheral_Data.setWw10(siemensPLC.ReadFloat(Ph_Address.getWW10()).Content);
//			Peripheral_Data.setWw11(siemensPLC.ReadFloat(Ph_Address.getWW11()).Content);
//			Peripheral_Data.setWw12(siemensPLC.ReadBool(Ph_Address.getWW12()).Content);
//			Peripheral_Data.setWw13(siemensPLC.ReadBool(Ph_Address.getWW13()).Content);
//			Peripheral_Data.setWw14(siemensPLC.ReadFloat(Ph_Address.getWW14()).Content);
//			Peripheral_Data.setWw15(siemensPLC.ReadFloat(Ph_Address.getWW15()).Content);
//			Peripheral_Data.setWw16(siemensPLC.ReadFloat(Ph_Address.getWW16()).Content);
//			Peripheral_Data.setWw17(siemensPLC.ReadFloat(Ph_Address.getWW17()).Content);
//			Peripheral_Data.setWw18(siemensPLC.ReadFloat(Ph_Address.getWW18()).Content);
//			Peripheral_Data.setWw19(siemensPLC.ReadBool(Ph_Address.getWW19()).Content);
//			Peripheral_Data.setWw20(siemensPLC.ReadBool(Ph_Address.getWW20()).Content);
//			Peripheral_Data.setWw21(siemensPLC.ReadFloat(Ph_Address.getWW21()).Content);
//			Peripheral_Data.setWw22(siemensPLC.ReadFloat(Ph_Address.getWW22()).Content);
//			Peripheral_Data.setWw23(siemensPLC.ReadFloat(Ph_Address.getWW23()).Content);
//			Peripheral_Data.setWw24(siemensPLC.ReadFloat(Ph_Address.getWW24()).Content);
//			Peripheral_Data.setWw25(siemensPLC.ReadFloat(Ph_Address.getWW25()).Content);
//			Peripheral_Data.setWw26(siemensPLC.ReadFloat(Ph_Address.getWW26()).Content);
//			Peripheral_Data.setWw27(siemensPLC.ReadFloat(Ph_Address.getWW27()).Content);
//			Peripheral_Data.setWw28(siemensPLC.ReadFloat(Ph_Address.getWW28()).Content);
//			Peripheral_Data.setWw29(siemensPLC.ReadFloat(Ph_Address.getWW29()).Content);
//			Peripheral_Data.setWw30(siemensPLC.ReadFloat(Ph_Address.getWW30()).Content);
//			Peripheral_Data.setWw31(siemensPLC.ReadFloat(Ph_Address.getWW31()).Content);
//			Peripheral_Data.setWw32(siemensPLC.ReadFloat(Ph_Address.getWW32()).Content);
//			Peripheral_Data.setWw33(siemensPLC.ReadFloat(Ph_Address.getWW33()).Content);
//			Peripheral_Data.setWw34(siemensPLC.ReadFloat(Ph_Address.getWW34()).Content);
//			Peripheral_Data.setWw35(siemensPLC.ReadBool(Ph_Address.getWW35()).Content);
//			Peripheral_Data.setWw36(siemensPLC.ReadBool(Ph_Address.getWW36()).Content);
//			Peripheral_Data.setWw37(siemensPLC.ReadFloat(Ph_Address.getWW37()).Content);
//			Peripheral_Data.setWw38(siemensPLC.ReadFloat(Ph_Address.getWW38()).Content);
//			Peripheral_Data.setWw39(siemensPLC.ReadFloat(Ph_Address.getWW39()).Content);
//			Peripheral_Data.setWw40(siemensPLC.ReadFloat(Ph_Address.getWW40()).Content);
//			Peripheral_Data.setWw41(siemensPLC.ReadFloat(Ph_Address.getWW41()).Content);
//			Peripheral_Data.setWw42(siemensPLC.ReadBool(Ph_Address.getWW42()).Content);
//			Peripheral_Data.setWw43(siemensPLC.ReadBool(Ph_Address.getWW43()).Content);
//			Peripheral_Data.setWw44(siemensPLC.ReadFloat(Ph_Address.getWW44()).Content);
//			Peripheral_Data.setWw45(siemensPLC.ReadFloat(Ph_Address.getWW45()).Content);
//			Peripheral_Data.setWw46(siemensPLC.ReadFloat(Ph_Address.getWW46()).Content);
//			Peripheral_Data.setWw47(siemensPLC.ReadFloat(Ph_Address.getWW47()).Content);
//			Peripheral_Data.setWw48(siemensPLC.ReadFloat(Ph_Address.getWW48()).Content);
//			Peripheral_Data.setWw49(siemensPLC.ReadBool(Ph_Address.getWW49()).Content);
//			Peripheral_Data.setWw50(siemensPLC.ReadBool(Ph_Address.getWW50()).Content);
//			Peripheral_Data.setWw51(siemensPLC.ReadFloat(Ph_Address.getWW51()).Content);
//			Peripheral_Data.setWw52(siemensPLC.ReadFloat(Ph_Address.getWW52()).Content);
//			Peripheral_Data.setWw53(siemensPLC.ReadFloat(Ph_Address.getWW53()).Content);
//			Peripheral_Data.setWw54(siemensPLC.ReadFloat(Ph_Address.getWW54()).Content);
//			Peripheral_Data.setWw55(siemensPLC.ReadFloat(Ph_Address.getWW55()).Content);
//			Peripheral_Data.setWw56(siemensPLC.ReadBool(Ph_Address.getWW56()).Content);
//			Peripheral_Data.setWw57(siemensPLC.ReadBool(Ph_Address.getWW57()).Content);
//			Peripheral_Data.setWw58(siemensPLC.ReadFloat(Ph_Address.getWW58()).Content);
//			Peripheral_Data.setWw59(siemensPLC.ReadFloat(Ph_Address.getWW59()).Content);
//			Peripheral_Data.setWw60(siemensPLC.ReadFloat(Ph_Address.getWW60()).Content);
//			Peripheral_Data.setWw61(siemensPLC.ReadFloat(Ph_Address.getWW61()).Content);
//			Peripheral_Data.setWw62(siemensPLC.ReadFloat(Ph_Address.getWW62()).Content);
//			Peripheral_Data.setWw63(siemensPLC.ReadBool(Ph_Address.getWW63()).Content);
//			Peripheral_Data.setWw64(siemensPLC.ReadBool(Ph_Address.getWW64()).Content);
//			Peripheral_Data.setWw65(siemensPLC.ReadFloat(Ph_Address.getWW65()).Content);
//			Peripheral_Data.setWw66(siemensPLC.ReadFloat(Ph_Address.getWW66()).Content);
//			Peripheral_Data.setWw67(siemensPLC.ReadFloat(Ph_Address.getWW67()).Content);
//			Peripheral_Data.setWw68(siemensPLC.ReadFloat(Ph_Address.getWW68()).Content);
//			Peripheral_Data.setWw69(siemensPLC.ReadFloat(Ph_Address.getWW69()).Content);
//			Peripheral_Data.setWw70(siemensPLC.ReadBool(Ph_Address.getWW70()).Content);
//			Peripheral_Data.setWw71(siemensPLC.ReadBool(Ph_Address.getWW71()).Content);
//			Peripheral_Data.setWw72(siemensPLC.ReadFloat(Ph_Address.getWW72()).Content);
//			Peripheral_Data.setWw73(siemensPLC.ReadFloat(Ph_Address.getWW73()).Content);
//			Peripheral_Data.setWw74(siemensPLC.ReadFloat(Ph_Address.getWW74()).Content);
//			Peripheral_Data.setWw75(siemensPLC.ReadFloat(Ph_Address.getWW75()).Content);
//			Peripheral_Data.setWw76(siemensPLC.ReadFloat(Ph_Address.getWW76()).Content);
//			Peripheral_Data.setWw77(siemensPLC.ReadBool(Ph_Address.getWW77()).Content);
//			Peripheral_Data.setWw78(siemensPLC.ReadBool(Ph_Address.getWW78()).Content);
//			Peripheral_Data.setWw79(siemensPLC.ReadFloat(Ph_Address.getWW79()).Content);
//			Peripheral_Data.setWw80(siemensPLC.ReadFloat(Ph_Address.getWW80()).Content);
//			Peripheral_Data.setWw81(siemensPLC.ReadFloat(Ph_Address.getWW81()).Content);
//			Peripheral_Data.setWw82(siemensPLC.ReadFloat(Ph_Address.getWW82()).Content);
//			Peripheral_Data.setWw83(siemensPLC.ReadFloat(Ph_Address.getWW83()).Content);
//			Peripheral_Data.setWw84(siemensPLC.ReadBool(Ph_Address.getWW84()).Content);
//			Peripheral_Data.setWw85(siemensPLC.ReadBool(Ph_Address.getWW85()).Content);
//			Peripheral_Data.setWw86(siemensPLC.ReadFloat(Ph_Address.getWW86()).Content);
//			Peripheral_Data.setWw87(siemensPLC.ReadFloat(Ph_Address.getWW87()).Content);
//			Peripheral_Data.setWw88(siemensPLC.ReadBool(Ph_Address.getWW88()).Content);
//			Peripheral_Data.setWw89(siemensPLC.ReadFloat(Ph_Address.getWW89()).Content);
//			Peripheral_Data.setWw90(siemensPLC.ReadFloat(Ph_Address.getWW90()).Content);
//			Peripheral_Data.setWw91(siemensPLC.ReadBool(Ph_Address.getWW91()).Content);
//			Peripheral_Data.setWw92(siemensPLC.ReadFloat(Ph_Address.getWW92()).Content);
//			Peripheral_Data.setWw93(siemensPLC.ReadFloat(Ph_Address.getWW93()).Content);
//			Peripheral_Data.setWw94(siemensPLC.ReadBool(Ph_Address.getWW94()).Content);
//			//QT
//			Peripheral_qt.setWwqt0(siemensPLC.ReadFloat(Ph_Address.getWWQT0()).Content);
//			Peripheral_qt.setWwqt1(siemensPLC.ReadFloat(Ph_Address.getWWQT1()).Content);
//			Peripheral_qt.setWwqt2(siemensPLC.ReadBool(Ph_Address.getWWQT2()).Content);
//			Peripheral_qt.setWwqt3(siemensPLC.ReadFloat(Ph_Address.getWWQT3()).Content);
//			Peripheral_qt.setWwqt4(siemensPLC.ReadFloat(Ph_Address.getWWQT4()).Content);
//			Peripheral_qt.setWwqt5(siemensPLC.ReadBool(Ph_Address.getWWQT5()).Content);
//			Peripheral_qt.setWwqt6(siemensPLC.ReadBool(Ph_Address.getWWQT6()).Content);
//			Peripheral_qt.setWwqt7(siemensPLC.ReadFloat(Ph_Address.getWWQT7()).Content);
//			Peripheral_qt.setWwqt8(siemensPLC.ReadBool(Ph_Address.getWWQT8()).Content);
//			Peripheral_qt.setWwqt9(siemensPLC.ReadBool(Ph_Address.getWWQT9()).Content);
//			Peripheral_serviceimp.setPeripheral_data(Peripheral_Data);
//			Newly_serviceimp.setNewlyData(Peripheral_qt);
//		} else {
//			System.out.println("failed:" + siemensPLC.ConnectServer().Message+"干燥机异常");
//		}
//		siemensPLC.ConnectClose();
//		// 数据读取完毕 获取当前时间
//		System.out.println(Peripheral_Data );
//		System.out.println(Peripheral_qt );
//		System.out.println("干燥机数据持久化+555" + new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
//		System.out.println(" ");
//	}
//
//}
