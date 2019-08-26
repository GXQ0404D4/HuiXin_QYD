package com.ktcn.entity;

import java.util.Date;

import lombok.Data;
/*
 * 临时电量表
 */
@Data
public class Electric_massage_temp {
	private int id;					// 主键
	private String machine;			// 机器
	private float voltageA;			// 电压A
	private float voltageB;			// 电压B
	private float voltageC;			// 电压C
	private float electric_currentA;// 电流A
	private float electric_currentB;// 电流B
	private float electric_currentC;// 电流C
	private float instantaneous_power;// 瞬时功率
	private float electric_quantity;// 电量
	private float power_factor;		// 功率因数
	private Date current_time;		// 当前时间
	private Date current_date;		// 存入日期
}
