package com.ktcn.entity.siemensentity;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2019年12月31日 上午9:36:40
* 类说明  Communicate 通信状态
*/
@Data
@Component
public class CommunicateState {
	
	private int id;
	private Boolean TX0;  //无线模块之间的通讯状态                     R
	private Boolean TX1;  //烧结端无线模块和从站PLC之间的通讯状态      R
	private Boolean TX2;  //制氧离心机和主站PLC之间的通讯状态          R
	private Boolean TX3;  //制氧端无线模块和主站PLC之间的通讯状态      R
	private Boolean TX4;  //烧结端电表和从站PLC之间的通讯状态          R
	private Boolean TX5;  //烧结端干燥机和从站PLC之间的通讯状态        R
	private Boolean TX6;  //烧结端流量计和从站PLC之间的通讯状态        R
	private Boolean TX7;  //烧结端1#变频机和从站PLC之间的通讯状态      R
	private Boolean TX8;  //烧结端2#变频机和从站PLC之间的通讯状态      R
	private Boolean TX9;  //制氧电表和主站PLC之间的通讯状态            R
	private Boolean TX10; //制氧干燥机和主站PLC之间的通讯状态          R
	private Boolean TX11; //制氧流量计和主站PLC之间的通讯状态          R
	private Date TX_time; //通信时间                               
	private Date TX_data_time;   //数据库通信时间
	private int state;           //状态

}
