//package com.ktcn.simens.PLCdata;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.annotation.Order;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.ktcn.entity.siemensentity.ScrewMachine;
//import com.ktcn.service.siemensService.ScrewMachine_service;
//import com.ktcn.simens.utils.SiemensPlcConfig;
//
//import HslCommunication.Profinet.Siemens.SiemensS7Net;
//
///**
// * @author 作者 :Runaway programmer
// * @version 创建时间：2019年12月27日 下午4:39:57 类说明 ScrewMachine 螺杆机数据获取
// */
////@EnableScheduling // 此注解必加,必须要加，重中之重
//@Component // 此注解必加
//@Order(value = 1)
////@Async
//@PropertySource({ "classpath:config/screw_machine.properties" })
//public final class ScrewMachineDatagain {
//	// 低压机1
//	@Value("${PLC0.LGJ0}")
//	private String LGJ0;
//	@Value("${PLC0.LGJ1}")
//	private String LGJ1;
//	@Value("${PLC0.LGJ2}")
//	private String LGJ2;
//	@Value("${PLC0.LGJ3}")
//	private String LGJ3;
//	@Value("${PLC0.LGJ4}")
//	private String LGJ4;
//	@Value("${PLC0.LGJ5}")
//	private String LGJ5;
//	@Value("${PLC0.LGJ6}")
//	private String LGJ6;
//	@Value("${PLC0.LGJ7}")
//	private String LGJ7;
//	@Value("${PLC0.LGJ8}")
//	private String LGJ8;
//	@Value("${PLC0.LGJ9}")
//	private String LGJ9;
//	@Value("${PLC0.LGJ10}")
//	private String LGJ10;
//	@Value("${PLC0.LGJ11}")
//	private String LGJ11;
//	@Value("${PLC0.LGJ12}")
//	private String LGJ12;
//	@Value("${PLC0.LGJ13}")
//	private String LGJ13;
//	@Value("${PLC0.LGJ14}")
//	private String LGJ14;
//	@Value("${PLC0.LGJ15}")
//	private String LGJ15;
//	@Value("${PLC0.LGJ16}")
//	private String LGJ16;
//	@Value("${PLC0.LGJ17}")
//	private String LGJ17;
//	@Value("${PLC0.LGJ18}")
//	private String LGJ18;
//	@Value("${PLC0.LGJ19}")
//	private String LGJ19;
//	@Value("${PLC0.LGJ20}")
//	private String LGJ20;
//	@Value("${PLC0.LGJ21}")
//	private String LGJ21;
//
//	// 低压机2
//	@Value("${PLC1.LGJ0}")
//	private String LGJA0;
//	@Value("${PLC1.LGJ1}")
//	private String LGJA1;
//	@Value("${PLC1.LGJ2}")
//	private String LGJA2;
//	@Value("${PLC1.LGJ3}")
//	private String LGJA3;
//	@Value("${PLC1.LGJ4}")
//	private String LGJA4;
//	@Value("${PLC1.LGJ5}")
//	private String LGJA5;
//	@Value("${PLC1.LGJ6}")
//	private String LGJA6;
//	@Value("${PLC1.LGJ7}")
//	private String LGJA7;
//	@Value("${PLC1.LGJ8}")
//	private String LGJA8;
//	@Value("${PLC1.LGJ9}")
//	private String LGJA9;
//	@Value("${PLC1.LGJ10}")
//	private String LGJA10;
//	@Value("${PLC1.LGJ11}")
//	private String LGJA11;
//	@Value("${PLC1.LGJ12}")
//	private String LGJA12;
//	@Value("${PLC1.LGJ13}")
//	private String LGJA13;
//	@Value("${PLC1.LGJ14}")
//	private String LGJA14;
//	@Value("${PLC1.LGJ15}")
//	private String LGJA15;
//	@Value("${PLC1.LGJ16}")
//	private String LGJA16;
//	@Value("${PLC1.LGJ17}")
//	private String LGJA17;
//	@Value("${PLC1.LGJ18}")
//	private String LGJA18;
//	@Value("${PLC1.LGJ19}")
//	private String LGJA19;
//	@Value("${PLC1.LGJ20}")
//	private String LGJA20;
//	@Value("${PLC1.LGJ21}")
//	private String LGJA21;
//
//	// 高压机1
//	@Value("${PLC2.LGJ0}")
//	private String LGJB0;
//	@Value("${PLC2.LGJ1}")
//	private String LGJB1;
//	@Value("${PLC2.LGJ2}")
//	private String LGJB2;
//	@Value("${PLC2.LGJ3}")
//	private String LGJB3;
//	@Value("${PLC2.LGJ4}")
//	private String LGJB4;
//	@Value("${PLC2.LGJ5}")
//	private String LGJB5;
//	@Value("${PLC2.LGJ6}")
//	private String LGJB6;
//	@Value("${PLC2.LGJ7}")
//	private String LGJB7;
//	@Value("${PLC2.LGJ8}")
//	private String LGJB8;
//	@Value("${PLC2.LGJ9}")
//	private String LGJB9;
//	@Value("${PLC2.LGJ10}")
//	private String LGJB10;
//	@Value("${PLC2.LGJ11}")
//	private String LGJB11;
//	@Value("${PLC2.LGJ12}")
//	private String LGJB12;
//	@Value("${PLC2.LGJ13}")
//	private String LGJB13;
//	@Value("${PLC2.LGJ14}")
//	private String LGJB14;
//	@Value("${PLC2.LGJ15}")
//	private String LGJB15;
//	@Value("${PLC2.LGJ16}")
//	private String LGJB16;
//	@Value("${PLC2.LGJ17}")
//	private String LGJB17;
//	@Value("${PLC2.LGJ18}")
//	private String LGJB18;
//	@Value("${PLC2.LGJ19}")
//	private String LGJB19;
//	@Value("${PLC2.LGJ20}")
//	private String LGJB20;
//	@Value("${PLC2.LGJ21}")
//	private String LGJB21;
//
//	// 高压机2
//	@Value("${PLC3.LGJ0}")
//	private String LGJC0;
//	@Value("${PLC3.LGJ1}")
//	private String LGJC1;
//	@Value("${PLC3.LGJ2}")
//	private String LGJC2;
//	@Value("${PLC3.LGJ3}")
//	private String LGJC3;
//	@Value("${PLC3.LGJ4}")
//	private String LGJC4;
//	@Value("${PLC3.LGJ5}")
//	private String LGJC5;
//	@Value("${PLC3.LGJ6}")
//	private String LGJC6;
//	@Value("${PLC3.LGJ7}")
//	private String LGJC7;
//	@Value("${PLC3.LGJ8}")
//	private String LGJC8;
//	@Value("${PLC3.LGJ9}")
//	private String LGJC9;
//	@Value("${PLC3.LGJ10}")
//	private String LGJC10;
//	@Value("${PLC3.LGJ11}")
//	private String LGJC11;
//	@Value("${PLC3.LGJ12}")
//	private String LGJC12;
//	@Value("${PLC3.LGJ13}")
//	private String LGJC13;
//	@Value("${PLC3.LGJ14}")
//	private String LGJC14;
//	@Value("${PLC3.LGJ15}")
//	private String LGJC15;
//	@Value("${PLC3.LGJ16}")
//	private String LGJC16;
//	@Value("${PLC3.LGJ17}")
//	private String LGJC17;
//	@Value("${PLC3.LGJ18}")
//	private String LGJC18;
//	@Value("${PLC3.LGJ19}")
//	private String LGJC19;
//	@Value("${PLC3.LGJ20}")
//	private String LGJC20;
//	@Value("${PLC3.LGJ21}")
//	private String LGJC21;
//
//	// 高压机3
//	@Value("${PLC4.LGJ0}")
//	private String LGJD0;
//	@Value("${PLC4.LGJ1}")
//	private String LGJD1;
//	@Value("${PLC4.LGJ2}")
//	private String LGJD2;
//	@Value("${PLC4.LGJ3}")
//	private String LGJD3;
//	@Value("${PLC4.LGJ4}")
//	private String LGJD4;
//	@Value("${PLC4.LGJ5}")
//	private String LGJD5;
//	@Value("${PLC4.LGJ6}")
//	private String LGJD6;
//	@Value("${PLC4.LGJ7}")
//	private String LGJD7;
//	@Value("${PLC4.LGJ8}")
//	private String LGJD8;
//	@Value("${PLC4.LGJ9}")
//	private String LGJD9;
//	@Value("${PLC4.LGJ10}")
//	private String LGJD10;
//	@Value("${PLC4.LGJ11}")
//	private String LGJD11;
//	@Value("${PLC4.LGJ12}")
//	private String LGJD12;
//	@Value("${PLC4.LGJ13}")
//	private String LGJD13;
//	@Value("${PLC4.LGJ14}")
//	private String LGJD14;
//	@Value("${PLC4.LGJ15}")
//	private String LGJD15;
//	@Value("${PLC4.LGJ16}")
//	private String LGJD16;
//	@Value("${PLC4.LGJ17}")
//	private String LGJD17;
//	@Value("${PLC4.LGJ18}")
//	private String LGJD18;
//	@Value("${PLC4.LGJ19}")
//	private String LGJD19;
//	@Value("${PLC4.LGJ20}")
//	private String LGJD20;
//	@Value("${PLC4.LGJ21}")
//	private String LGJD21;
//
//	@Autowired
//	SiemensPlcConfig SiemensPlcConfig;
//	
//	@Autowired
//	ScrewMachine_service ScrewMachine_serviceimp;
//	
////	@Async
//	@Scheduled(cron = "0/1 * * * * ?")
//	public void getScrewMachineData() {
//		SiemensS7Net siemensPLC = SiemensPlcConfig.getSiemensPLC();
//		final Map<String, ScrewMachine> DataMap = new HashMap<String, ScrewMachine>();
//		ScrewMachine ScrewMachine1 =new ScrewMachine();
//		ScrewMachine ScrewMachine2 =new ScrewMachine();
//		ScrewMachine ScrewMachine3 =new ScrewMachine();
//		ScrewMachine ScrewMachine4 =new ScrewMachine();
//		ScrewMachine ScrewMachine5 =new ScrewMachine();
//
//		if (siemensPLC.ConnectServer().IsSuccess) {
//			// 低压机1
//			ScrewMachine1.setScrewMachine_name("低压机1");
//			ScrewMachine1.setState(1);
//			((ScrewMachine) ScrewMachine1).setLGJ0(siemensPLC.ReadFloat(LGJ0).Content);
//			((ScrewMachine) ScrewMachine1).setLGJ1(siemensPLC.ReadFloat(LGJ1).Content);
//			((ScrewMachine) ScrewMachine1).setLGJ2(siemensPLC.ReadFloat(LGJ2).Content);
//			((ScrewMachine) ScrewMachine1).setLGJ3(siemensPLC.ReadFloat(LGJ3).Content);
//			((ScrewMachine) ScrewMachine1).setLGJ4(siemensPLC.ReadFloat(LGJ4).Content);
//			((ScrewMachine) ScrewMachine1).setLGJ5(siemensPLC.ReadFloat(LGJ5).Content);
//			((ScrewMachine) ScrewMachine1).setLGJ6(siemensPLC.ReadFloat(LGJ6).Content);
//			((ScrewMachine) ScrewMachine1).setLGJ7(siemensPLC.ReadInt32(LGJ7).Content);
//			((ScrewMachine) ScrewMachine1).setLGJ8(siemensPLC.ReadInt32(LGJ8).Content);
//			((ScrewMachine) ScrewMachine1).setLGJ9(siemensPLC.ReadInt32(LGJ9).Content);
//			((ScrewMachine) ScrewMachine1).setLGJ10(siemensPLC.ReadInt32(LGJ10).Content);
//			((ScrewMachine) ScrewMachine1).setLGJ11(siemensPLC.ReadInt32(LGJ11).Content);
//			((ScrewMachine) ScrewMachine1).setLGJ12(siemensPLC.ReadInt16(LGJ12).Content);
//			((ScrewMachine) ScrewMachine1).setLGJ13(siemensPLC.ReadBool(LGJ13).Content);
//			((ScrewMachine) ScrewMachine1).setLGJ14(siemensPLC.ReadBool(LGJ14).Content);
//			((ScrewMachine) ScrewMachine1).setLGJ15(siemensPLC.ReadBool(LGJ15).Content);
//			((ScrewMachine) ScrewMachine1).setLGJ16(siemensPLC.ReadBool(LGJ16).Content);
//			((ScrewMachine) ScrewMachine1).setLGJ17(siemensPLC.ReadBool(LGJ17).Content);
//			((ScrewMachine) ScrewMachine1).setLGJ18(siemensPLC.ReadBool(LGJ18).Content);
//			((ScrewMachine) ScrewMachine1).setLGJ19(siemensPLC.ReadBool(LGJ19).Content);
//			((ScrewMachine) ScrewMachine1).setLGJ20(siemensPLC.ReadBool(LGJ20).Content);
//			((ScrewMachine) ScrewMachine1).setLGJ21(siemensPLC.ReadBool(LGJ21).Content);
//
//			// 低压机2
//			ScrewMachine2.setScrewMachine_name("低压机2");
//			ScrewMachine2.setState(1);
//			((ScrewMachine) ScrewMachine2).setLGJ0(siemensPLC.ReadFloat(LGJA0).Content);
//			((ScrewMachine) ScrewMachine2).setLGJ1(siemensPLC.ReadFloat(LGJA1).Content);
//			((ScrewMachine) ScrewMachine2).setLGJ2(siemensPLC.ReadFloat(LGJA2).Content);
//			((ScrewMachine) ScrewMachine2).setLGJ3(siemensPLC.ReadFloat(LGJA3).Content);
//			((ScrewMachine) ScrewMachine2).setLGJ4(siemensPLC.ReadFloat(LGJA4).Content);
//			((ScrewMachine) ScrewMachine2).setLGJ5(siemensPLC.ReadFloat(LGJA5).Content);
//			((ScrewMachine) ScrewMachine2).setLGJ6(siemensPLC.ReadFloat(LGJA6).Content);
//			((ScrewMachine) ScrewMachine2).setLGJ7(siemensPLC.ReadInt32(LGJA7).Content);
//			((ScrewMachine) ScrewMachine2).setLGJ8(siemensPLC.ReadInt32(LGJA8).Content);
//			((ScrewMachine) ScrewMachine2).setLGJ9(siemensPLC.ReadInt32(LGJA9).Content);
//			((ScrewMachine) ScrewMachine2).setLGJ10(siemensPLC.ReadInt32(LGJA10).Content);
//			((ScrewMachine) ScrewMachine2).setLGJ11(siemensPLC.ReadInt32(LGJA11).Content);
//			((ScrewMachine) ScrewMachine2).setLGJ12(siemensPLC.ReadInt16(LGJA12).Content);
//			((ScrewMachine) ScrewMachine2).setLGJ13(siemensPLC.ReadBool(LGJA13).Content);
//			((ScrewMachine) ScrewMachine2).setLGJ14(siemensPLC.ReadBool(LGJA14).Content);
//			((ScrewMachine) ScrewMachine2).setLGJ15(siemensPLC.ReadBool(LGJA15).Content);
//			((ScrewMachine) ScrewMachine2).setLGJ16(siemensPLC.ReadBool(LGJA16).Content);
//			((ScrewMachine) ScrewMachine2).setLGJ17(siemensPLC.ReadBool(LGJA17).Content);
//			((ScrewMachine) ScrewMachine2).setLGJ18(siemensPLC.ReadBool(LGJA18).Content);
//			((ScrewMachine) ScrewMachine2).setLGJ19(siemensPLC.ReadBool(LGJA19).Content);
//			((ScrewMachine) ScrewMachine2).setLGJ20(siemensPLC.ReadBool(LGJA20).Content);
//			((ScrewMachine) ScrewMachine2).setLGJ21(siemensPLC.ReadBool(LGJA21).Content);
//
//			// 高压机1
//			ScrewMachine3.setScrewMachine_name("高压机1");
//			ScrewMachine3.setState(1);
//			((ScrewMachine) ScrewMachine3).setLGJ0(siemensPLC.ReadFloat(LGJB0).Content);
//			((ScrewMachine) ScrewMachine3).setLGJ1(siemensPLC.ReadFloat(LGJB1).Content);
//			((ScrewMachine) ScrewMachine3).setLGJ2(siemensPLC.ReadFloat(LGJB2).Content);
//			((ScrewMachine) ScrewMachine3).setLGJ3(siemensPLC.ReadFloat(LGJB3).Content);
//			((ScrewMachine) ScrewMachine3).setLGJ4(siemensPLC.ReadFloat(LGJB4).Content);
//			((ScrewMachine) ScrewMachine3).setLGJ5(siemensPLC.ReadFloat(LGJB5).Content);
//			((ScrewMachine) ScrewMachine3).setLGJ6(siemensPLC.ReadFloat(LGJB6).Content);
//			((ScrewMachine) ScrewMachine3).setLGJ7(siemensPLC.ReadInt32(LGJB7).Content);
//			((ScrewMachine) ScrewMachine3).setLGJ8(siemensPLC.ReadInt32(LGJB8).Content);
//			((ScrewMachine) ScrewMachine3).setLGJ9(siemensPLC.ReadInt32(LGJB9).Content);
//			((ScrewMachine) ScrewMachine3).setLGJ10(siemensPLC.ReadInt32(LGJB10).Content);
//			((ScrewMachine) ScrewMachine3).setLGJ11(siemensPLC.ReadInt32(LGJB11).Content);
//			((ScrewMachine) ScrewMachine3).setLGJ12(siemensPLC.ReadInt16(LGJB12).Content);
//			((ScrewMachine) ScrewMachine3).setLGJ13(siemensPLC.ReadBool(LGJB13).Content);
//			((ScrewMachine) ScrewMachine3).setLGJ14(siemensPLC.ReadBool(LGJB14).Content);
//			((ScrewMachine) ScrewMachine3).setLGJ15(siemensPLC.ReadBool(LGJB15).Content);
//			((ScrewMachine) ScrewMachine3).setLGJ16(siemensPLC.ReadBool(LGJB16).Content);
//			((ScrewMachine) ScrewMachine3).setLGJ17(siemensPLC.ReadBool(LGJB17).Content);
//			((ScrewMachine) ScrewMachine3).setLGJ18(siemensPLC.ReadBool(LGJB18).Content);
//			((ScrewMachine) ScrewMachine3).setLGJ19(siemensPLC.ReadBool(LGJB19).Content);
//			((ScrewMachine) ScrewMachine3).setLGJ20(siemensPLC.ReadBool(LGJB20).Content);
//			((ScrewMachine) ScrewMachine3).setLGJ21(siemensPLC.ReadBool(LGJB21).Content);
//			// 高压机2
//			ScrewMachine4.setScrewMachine_name("高压机2");
//			ScrewMachine4.setState(1);
//			((ScrewMachine) ScrewMachine4).setLGJ0(siemensPLC.ReadFloat(LGJC0).Content);
//			((ScrewMachine) ScrewMachine4).setLGJ1(siemensPLC.ReadFloat(LGJC1).Content);
//			((ScrewMachine) ScrewMachine4).setLGJ2(siemensPLC.ReadFloat(LGJC2).Content);
//			((ScrewMachine) ScrewMachine4).setLGJ3(siemensPLC.ReadFloat(LGJC3).Content);
//			((ScrewMachine) ScrewMachine4).setLGJ4(siemensPLC.ReadFloat(LGJC4).Content);
//			((ScrewMachine) ScrewMachine4).setLGJ5(siemensPLC.ReadFloat(LGJC5).Content);
//			((ScrewMachine) ScrewMachine4).setLGJ6(siemensPLC.ReadFloat(LGJC6).Content);
//			((ScrewMachine) ScrewMachine4).setLGJ7(siemensPLC.ReadInt32(LGJC7).Content);
//			((ScrewMachine) ScrewMachine4).setLGJ8(siemensPLC.ReadInt32(LGJC8).Content);
//			((ScrewMachine) ScrewMachine4).setLGJ9(siemensPLC.ReadInt32(LGJC9).Content);
//			((ScrewMachine) ScrewMachine4).setLGJ10(siemensPLC.ReadInt32(LGJC10).Content);
//			((ScrewMachine) ScrewMachine4).setLGJ11(siemensPLC.ReadInt32(LGJC11).Content);
//			((ScrewMachine) ScrewMachine4).setLGJ12(siemensPLC.ReadInt16(LGJC12).Content);
//			((ScrewMachine) ScrewMachine4).setLGJ13(siemensPLC.ReadBool(LGJC13).Content);
//			((ScrewMachine) ScrewMachine4).setLGJ14(siemensPLC.ReadBool(LGJC14).Content);
//			((ScrewMachine) ScrewMachine4).setLGJ15(siemensPLC.ReadBool(LGJC15).Content);
//			((ScrewMachine) ScrewMachine4).setLGJ16(siemensPLC.ReadBool(LGJC16).Content);
//			((ScrewMachine) ScrewMachine4).setLGJ17(siemensPLC.ReadBool(LGJC17).Content);
//			((ScrewMachine) ScrewMachine4).setLGJ18(siemensPLC.ReadBool(LGJC18).Content);
//			((ScrewMachine) ScrewMachine4).setLGJ19(siemensPLC.ReadBool(LGJC19).Content);
//			((ScrewMachine) ScrewMachine4).setLGJ20(siemensPLC.ReadBool(LGJC20).Content);
//			((ScrewMachine) ScrewMachine4).setLGJ21(siemensPLC.ReadBool(LGJC21).Content);
//			// 高压机3
//			ScrewMachine5.setScrewMachine_name("高压机3");
//			ScrewMachine5.setState(1);
//			((ScrewMachine) ScrewMachine5).setLGJ0(siemensPLC.ReadFloat(LGJD0).Content);
//			((ScrewMachine) ScrewMachine5).setLGJ1(siemensPLC.ReadFloat(LGJD1).Content);
//			((ScrewMachine) ScrewMachine5).setLGJ2(siemensPLC.ReadFloat(LGJD2).Content);
//			((ScrewMachine) ScrewMachine5).setLGJ3(siemensPLC.ReadFloat(LGJD3).Content);
//			((ScrewMachine) ScrewMachine5).setLGJ4(siemensPLC.ReadFloat(LGJD4).Content);
//			((ScrewMachine) ScrewMachine5).setLGJ5(siemensPLC.ReadFloat(LGJD5).Content);
//			((ScrewMachine) ScrewMachine5).setLGJ6(siemensPLC.ReadFloat(LGJD6).Content);
//			((ScrewMachine) ScrewMachine5).setLGJ7(siemensPLC.ReadInt32(LGJD7).Content);
//			((ScrewMachine) ScrewMachine5).setLGJ8(siemensPLC.ReadInt32(LGJD8).Content);
//			((ScrewMachine) ScrewMachine5).setLGJ9(siemensPLC.ReadInt32(LGJD9).Content);
//			((ScrewMachine) ScrewMachine5).setLGJ10(siemensPLC.ReadInt32(LGJD10).Content);
//			((ScrewMachine) ScrewMachine5).setLGJ11(siemensPLC.ReadInt32(LGJD11).Content);
//			((ScrewMachine) ScrewMachine5).setLGJ12(siemensPLC.ReadInt16(LGJD12).Content);
//			((ScrewMachine) ScrewMachine5).setLGJ13(siemensPLC.ReadBool(LGJD13).Content);
//			((ScrewMachine) ScrewMachine5).setLGJ14(siemensPLC.ReadBool(LGJD14).Content);
//			((ScrewMachine) ScrewMachine5).setLGJ15(siemensPLC.ReadBool(LGJD15).Content);
//			((ScrewMachine) ScrewMachine5).setLGJ16(siemensPLC.ReadBool(LGJD16).Content);
//			((ScrewMachine) ScrewMachine5).setLGJ17(siemensPLC.ReadBool(LGJD17).Content);
//			((ScrewMachine) ScrewMachine5).setLGJ18(siemensPLC.ReadBool(LGJD18).Content);
//			((ScrewMachine) ScrewMachine5).setLGJ19(siemensPLC.ReadBool(LGJD19).Content);
//			((ScrewMachine) ScrewMachine5).setLGJ20(siemensPLC.ReadBool(LGJD20).Content);
//			((ScrewMachine) ScrewMachine5).setLGJ21(siemensPLC.ReadBool(LGJD21).Content);
//
//			DataMap.put("ScrewMachine1", ScrewMachine1);
//			DataMap.put("ScrewMachine2", ScrewMachine2);
//			DataMap.put("ScrewMachine3", ScrewMachine3);
//			DataMap.put("ScrewMachine4", ScrewMachine4);
//			DataMap.put("ScrewMachine5", ScrewMachine5);
//			ScrewMachine_serviceimp.setScrewMachineData(DataMap);
//		} else {
//			System.out.println("failed:" + siemensPLC.ConnectServer().Message + "螺杆机异常");
//		}
//		siemensPLC.ConnectClose();
//		// 数据读取完毕 获取当前时间
//		System.out.println(DataMap);
//		System.out.println("螺杆机数据获取+777" + new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
//		System.out.println(" ");
//	}
//}
