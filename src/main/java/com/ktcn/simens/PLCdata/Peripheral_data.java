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
//import com.ktcn.entity.siemensentity.Peripheral_Data;
//import com.ktcn.entity.siemensentity.Peripheral_qt;
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
//@PropertySource({ "classpath:config/peripheral_data.properties" })
//public final class Peripheral_data {
//	
//	@Value("${PLC.WW0}")
//	private String WW0;
//	@Value("${PLC.WW1}")
//	private String WW1;	
//	@Value("${PLC.WW2}")
//	private String WW2;	
//	@Value("${PLC.WW3}")
//	private String WW3;
//	@Value("${PLC.WW4}")
//	private String WW4;
//	@Value("${PLC.WW5}")
//	private String WW5;
//	@Value("${PLC.WW6}")
//	private String WW6;
//	@Value("${PLC.WW7}")
//	private String WW7;
//	@Value("${PLC.WW8}")
//	private String WW8;
//	@Value("${PLC.WW9}")
//	private String WW9;
//	@Value("${PLC.WW10}")
//	private String WW10;
//	@Value("${PLC.WW11}")
//	private String WW11;
//	@Value("${PLC.WW12}")
//	private String WW12;
//	@Value("${PLC.WW13}")
//	private String WW13;
//	@Value("${PLC.WW14}")
//	private String WW14;
//	@Value("${PLC.WW15}")
//	private String WW15;
//	@Value("${PLC.WW16}")
//	private String WW16;
//	@Value("${PLC.WW17}")
//	private String WW17;
//	@Value("${PLC.WW18}")
//	private String WW18;
//	@Value("${PLC.WW19}")
//	private String WW19;
//	@Value("${PLC.WW20}")
//	private String WW20;
//	@Value("${PLC.WW21}")
//	private String WW21;
//	@Value("${PLC.WW22}")
//	private String WW22;
//	@Value("${PLC.WW23}")
//	private String WW23;
//	@Value("${PLC.WW24}")
//	private String WW24;
//	@Value("${PLC.WW25}")
//	private String WW25;
//	@Value("${PLC.WW26}")
//	private String WW26;
//	@Value("${PLC.WW27}")
//	private String WW27;
//	@Value("${PLC.WW28}")
//	private String WW28;
//	@Value("${PLC.WW29}")
//	private String WW29;
//	@Value("${PLC.WW30}")
//	private String WW30;
//	@Value("${PLC.WW31}")
//	private String WW31;
//	@Value("${PLC.WW32}")
//	private String WW32;
//	@Value("${PLC.WW33}")
//	private String WW33;
//	@Value("${PLC.WW34}")
//	private String WW34;
//	@Value("${PLC.WW35}")
//	private String WW35;
//	@Value("${PLC.WW36}")
//	private String WW36;
//	@Value("${PLC.WW37}")
//	private String WW37;
//	@Value("${PLC.WW38}")
//	private String WW38;
//	@Value("${PLC.WW39}")
//	private String WW39;
//	@Value("${PLC.WW40}")
//	private String WW40;
//	@Value("${PLC.WW41}")
//	private String WW41;
//	@Value("${PLC.WW42}")
//	private String WW42;
//	@Value("${PLC.WW43}")
//	private String WW43;
//	@Value("${PLC.WW44}")
//	private String WW44;
//	@Value("${PLC.WW45}")
//	private String WW45;
//	@Value("${PLC.WW46}")
//	private String WW46;
//	@Value("${PLC.WW47}")
//	private String WW47;
//	@Value("${PLC.WW48}")
//	private String WW48;
//	@Value("${PLC.WW49}")
//	private String WW49;
//	@Value("${PLC.WW50}")
//	private String WW50;
//	@Value("${PLC.WW51}")
//	private String WW51;
//	@Value("${PLC.WW52}")
//	private String WW52;
//	@Value("${PLC.WW53}")
//	private String WW53;
//	@Value("${PLC.WW54}")
//	private String WW54;
//	@Value("${PLC.WW55}")
//	private String WW55;
//	@Value("${PLC.WW56}")
//	private String WW56;
//	@Value("${PLC.WW57}")
//	private String WW57;
//	@Value("${PLC.WW58}")
//	private String WW58;
//	@Value("${PLC.WW59}")
//	private String WW59;
//	@Value("${PLC.WW60}")
//	private String WW60;
//	@Value("${PLC.WW61}")
//	private String WW61;
//	@Value("${PLC.WW62}")
//	private String WW62;
//	@Value("${PLC.WW63}")
//	private String WW63;
//	@Value("${PLC.WW64}")
//	private String WW64;
//	@Value("${PLC.WW65}")
//	private String WW65;
//	@Value("${PLC.WW66}")
//	private String WW66;
//	@Value("${PLC.WW67}")
//	private String WW67;
//	@Value("${PLC.WW68}")
//	private String WW68;
//	@Value("${PLC.WW69}")
//	private String WW69;
//	@Value("${PLC.WW70}")
//	private String WW70;
//	@Value("${PLC.WW71}")
//	private String WW71;
//	@Value("${PLC.WW72}")
//	private String WW72;
//	@Value("${PLC.WW73}")
//	private String WW73;
//	@Value("${PLC.WW74}")
//	private String WW74;
//	@Value("${PLC.WW75}")
//	private String WW75;
//	@Value("${PLC.WW76}")
//	private String WW76;
//	@Value("${PLC.WW77}")
//	private String WW77;
//	@Value("${PLC.WW78}")
//	private String WW78;
//	@Value("${PLC.WW79}")
//	private String WW79;
//	@Value("${PLC.WW80}")
//	private String WW80;
//	@Value("${PLC.WW81}")
//	private String WW81;
//	@Value("${PLC.WW82}")
//	private String WW82;
//	@Value("${PLC.WW83}")
//	private String WW83;
//	@Value("${PLC.WW84}")
//	private String WW84;
//	@Value("${PLC.WW85}")
//	private String WW85;
//	@Value("${PLC.WW86}")
//	private String WW86;
//	@Value("${PLC.WW87}")
//	private String WW87;
//	@Value("${PLC.WW88}")
//	private String WW88;
//	@Value("${PLC.WW89}")
//	private String WW89;
//	@Value("${PLC.WW90}")
//	private String WW90;
//	@Value("${PLC.WW91}")
//	private String WW91;
//	@Value("${PLC.WW92}")
//	private String WW92;
//	@Value("${PLC.WW93}")
//	private String WW93;
//	@Value("${PLC.WW94}")
//	private String WW94;
//	
//	//QT数据
//	@Value("${PLC.WWQT0}")
//	private String WWQT0;
//	@Value("${PLC.WWQT1}")
//	private String WWQT1;
//	@Value("${PLC.WWQT2}")
//	private String WWQT2;
//	@Value("${PLC.WWQT3}")
//	private String WWQT3;
//	@Value("${PLC.WWQT4}")
//	private String WWQT4;
//	@Value("${PLC.WWQT5}")
//	private String WWQT5;
//	@Value("${PLC.WWQT6}")
//	private String WWQT6;
//	@Value("${PLC.WWQT7}")
//	private String WWQT7;
//	@Value("${PLC.WWQT8}")
//	private String WWQT8;
//	@Value("${PLC.WWQT9}")
//	private String WWQT9;
//	
//	@Autowired
//	SiemensPlcConfig SiemensPlcConfig;	 	
//	@Autowired
//	Peripheral_Data Peripheral_Data;
//	@Autowired
//	Peripheral_qt Peripheral_qt;
//	@Autowired
//	Newly_serviceimp Newly_serviceimp;
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
//			Peripheral_Data.setWW0(siemensPLC.ReadFloat(WW0).Content);
//			Peripheral_Data.setWW1(siemensPLC.ReadFloat(WW1).Content);
//			Peripheral_Data.setWW2(siemensPLC.ReadFloat(WW2).Content);
//			Peripheral_Data.setWW3(siemensPLC.ReadFloat(WW3).Content);
//			Peripheral_Data.setWW4(siemensPLC.ReadFloat(WW4).Content);
//			Peripheral_Data.setWW5(siemensPLC.ReadBool(WW5).Content);
//			Peripheral_Data.setWW6(siemensPLC.ReadBool(WW6).Content);
//			Peripheral_Data.setWW7(siemensPLC.ReadFloat(WW7).Content);
//			Peripheral_Data.setWW8(siemensPLC.ReadFloat(WW8).Content);
//			Peripheral_Data.setWW9(siemensPLC.ReadFloat(WW9).Content);
//			Peripheral_Data.setWW10(siemensPLC.ReadFloat(WW10).Content);
//			Peripheral_Data.setWW11(siemensPLC.ReadFloat(WW11).Content);
//			Peripheral_Data.setWW12(siemensPLC.ReadBool(WW12).Content);
//			Peripheral_Data.setWW13(siemensPLC.ReadBool(WW13).Content);
//			Peripheral_Data.setWW14(siemensPLC.ReadFloat(WW14).Content);
//			Peripheral_Data.setWW15(siemensPLC.ReadFloat(WW15).Content);
//			Peripheral_Data.setWW16(siemensPLC.ReadFloat(WW16).Content);
//			Peripheral_Data.setWW17(siemensPLC.ReadFloat(WW17).Content);
//			Peripheral_Data.setWW18(siemensPLC.ReadFloat(WW18).Content);
//			Peripheral_Data.setWW19(siemensPLC.ReadBool(WW19).Content);
//			Peripheral_Data.setWW20(siemensPLC.ReadBool(WW20).Content);
//			Peripheral_Data.setWW21(siemensPLC.ReadFloat(WW21).Content);
//			Peripheral_Data.setWW22(siemensPLC.ReadFloat(WW22).Content);
//			Peripheral_Data.setWW23(siemensPLC.ReadFloat(WW23).Content);
//			Peripheral_Data.setWW24(siemensPLC.ReadFloat(WW24).Content);
//			Peripheral_Data.setWW25(siemensPLC.ReadFloat(WW25).Content);
//			Peripheral_Data.setWW26(siemensPLC.ReadFloat(WW26).Content);
//			Peripheral_Data.setWW27(siemensPLC.ReadFloat(WW27).Content);
//			Peripheral_Data.setWW28(siemensPLC.ReadFloat(WW28).Content);
//			Peripheral_Data.setWW29(siemensPLC.ReadFloat(WW29).Content);
//			Peripheral_Data.setWW30(siemensPLC.ReadFloat(WW30).Content);
//			Peripheral_Data.setWW31(siemensPLC.ReadFloat(WW31).Content);
//			Peripheral_Data.setWW32(siemensPLC.ReadFloat(WW32).Content);
//			Peripheral_Data.setWW33(siemensPLC.ReadFloat(WW33).Content);
//			Peripheral_Data.setWW34(siemensPLC.ReadFloat(WW34).Content);
//			Peripheral_Data.setWW35(siemensPLC.ReadBool(WW35).Content);
//			Peripheral_Data.setWW36(siemensPLC.ReadBool(WW36).Content);
//			Peripheral_Data.setWW37(siemensPLC.ReadFloat(WW37).Content);
//			Peripheral_Data.setWW38(siemensPLC.ReadFloat(WW38).Content);
//			Peripheral_Data.setWW39(siemensPLC.ReadFloat(WW39).Content);
//			Peripheral_Data.setWW40(siemensPLC.ReadFloat(WW40).Content);
//			Peripheral_Data.setWW41(siemensPLC.ReadFloat(WW41).Content);
//			Peripheral_Data.setWW42(siemensPLC.ReadBool(WW42).Content);
//			Peripheral_Data.setWW43(siemensPLC.ReadBool(WW43).Content);
//			Peripheral_Data.setWW44(siemensPLC.ReadFloat(WW44).Content);
//			Peripheral_Data.setWW45(siemensPLC.ReadFloat(WW45).Content);
//			Peripheral_Data.setWW46(siemensPLC.ReadFloat(WW46).Content);
//			Peripheral_Data.setWW47(siemensPLC.ReadFloat(WW47).Content);
//			Peripheral_Data.setWW48(siemensPLC.ReadFloat(WW48).Content);
//			Peripheral_Data.setWW49(siemensPLC.ReadBool(WW49).Content);
//			Peripheral_Data.setWW50(siemensPLC.ReadBool(WW50).Content);
//			Peripheral_Data.setWW51(siemensPLC.ReadFloat(WW51).Content);
//			Peripheral_Data.setWW52(siemensPLC.ReadFloat(WW52).Content);
//			Peripheral_Data.setWW53(siemensPLC.ReadFloat(WW53).Content);
//			Peripheral_Data.setWW54(siemensPLC.ReadFloat(WW54).Content);
//			Peripheral_Data.setWW55(siemensPLC.ReadFloat(WW55).Content);
//			Peripheral_Data.setWW56(siemensPLC.ReadBool(WW56).Content);
//			Peripheral_Data.setWW57(siemensPLC.ReadBool(WW57).Content);
//			Peripheral_Data.setWW58(siemensPLC.ReadFloat(WW58).Content);
//			Peripheral_Data.setWW59(siemensPLC.ReadFloat(WW59).Content);
//			Peripheral_Data.setWW60(siemensPLC.ReadFloat(WW60).Content);
//			Peripheral_Data.setWW61(siemensPLC.ReadFloat(WW61).Content);
//			Peripheral_Data.setWW62(siemensPLC.ReadFloat(WW62).Content);
//			Peripheral_Data.setWW63(siemensPLC.ReadBool(WW63).Content);
//			Peripheral_Data.setWW64(siemensPLC.ReadBool(WW64).Content);
//			Peripheral_Data.setWW65(siemensPLC.ReadFloat(WW65).Content);
//			Peripheral_Data.setWW66(siemensPLC.ReadFloat(WW66).Content);
//			Peripheral_Data.setWW67(siemensPLC.ReadFloat(WW67).Content);
//			Peripheral_Data.setWW68(siemensPLC.ReadFloat(WW68).Content);
//			Peripheral_Data.setWW69(siemensPLC.ReadFloat(WW69).Content);
//			Peripheral_Data.setWW70(siemensPLC.ReadBool(WW70).Content);
//			Peripheral_Data.setWW71(siemensPLC.ReadBool(WW71).Content);
//			Peripheral_Data.setWW72(siemensPLC.ReadFloat(WW72).Content);
//			Peripheral_Data.setWW73(siemensPLC.ReadFloat(WW73).Content);
//			Peripheral_Data.setWW74(siemensPLC.ReadFloat(WW74).Content);
//			Peripheral_Data.setWW75(siemensPLC.ReadFloat(WW75).Content);
//			Peripheral_Data.setWW76(siemensPLC.ReadFloat(WW76).Content);
//			Peripheral_Data.setWW77(siemensPLC.ReadBool(WW77).Content);
//			Peripheral_Data.setWW78(siemensPLC.ReadBool(WW78).Content);
//			Peripheral_Data.setWW79(siemensPLC.ReadFloat(WW79).Content);
//			Peripheral_Data.setWW80(siemensPLC.ReadFloat(WW80).Content);
//			Peripheral_Data.setWW81(siemensPLC.ReadFloat(WW81).Content);
//			Peripheral_Data.setWW82(siemensPLC.ReadFloat(WW82).Content);
//			Peripheral_Data.setWW83(siemensPLC.ReadFloat(WW83).Content);
//			Peripheral_Data.setWW84(siemensPLC.ReadBool(WW84).Content);
//			Peripheral_Data.setWW85(siemensPLC.ReadBool(WW85).Content);
//			Peripheral_Data.setWW86(siemensPLC.ReadFloat(WW86).Content);
//			Peripheral_Data.setWW87(siemensPLC.ReadFloat(WW87).Content);
//			Peripheral_Data.setWW88(siemensPLC.ReadBool(WW88).Content);
//			Peripheral_Data.setWW89(siemensPLC.ReadFloat(WW89).Content);
//			Peripheral_Data.setWW90(siemensPLC.ReadFloat(WW90).Content);
//			Peripheral_Data.setWW91(siemensPLC.ReadBool(WW91).Content);
//			Peripheral_Data.setWW92(siemensPLC.ReadFloat(WW92).Content);
//			Peripheral_Data.setWW93(siemensPLC.ReadFloat(WW93).Content);
//			Peripheral_Data.setWW94(siemensPLC.ReadBool(WW94).Content);
//			//QT
//			Peripheral_qt.setWWQT0(siemensPLC.ReadFloat(WWQT0).Content);
//			Peripheral_qt.setWWQT1(siemensPLC.ReadFloat(WWQT1).Content);
//			Peripheral_qt.setWWQT2(siemensPLC.ReadBool(WWQT2).Content);
//			Peripheral_qt.setWWQT3(siemensPLC.ReadFloat(WWQT3).Content);
//			Peripheral_qt.setWWQT4(siemensPLC.ReadFloat(WWQT4).Content);
//			Peripheral_qt.setWWQT5(siemensPLC.ReadBool(WWQT5).Content);
//			Peripheral_qt.setWWQT6(siemensPLC.ReadBool(WWQT6).Content);
//			Peripheral_qt.setWWQT7(siemensPLC.ReadFloat(WWQT7).Content);
//			Peripheral_qt.setWWQT8(siemensPLC.ReadBool(WWQT8).Content);
//			Peripheral_qt.setWWQT9(siemensPLC.ReadBool(WWQT9).Content);
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
