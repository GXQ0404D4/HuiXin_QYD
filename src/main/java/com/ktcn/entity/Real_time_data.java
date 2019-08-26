package com.ktcn.entity;

import java.util.Date;

import lombok.Data;

/**
 * 临时数据表
 * @author Administrator
 *
 */
@Data
public class Real_time_data {
	private long dmt_id;				// 主键
	private float VoltageA_1;			// 1#A相电压
	private float Electric_currentA_1;	// 1#A相电流
	private float Host_temperature_1;	// 1#主机温度
	private float Coolant_temperature_1;// 1#冷却剂温度
	private float Sump_Pressure_1;		// 1#分离前压力
	private float Loading_pressure_1;	// 1#加载压力
	private Date Loading_time_1;		// 1#加载时间
	private float Unloading_pressure_1;	// 1#卸载压力
	private int Alarm_number_1;			// 1#报警号
	private float Exhaust_pressure_1;	// 1#排气压力
	private float Exhaust_temperature_1;// 1#排气温度
	private int Control_state_1;		// 1#控制状态字
	private float total_energy_1;		// 1#正向有功总电能
	private int Warning_sign_1;			// 1#警告号
	private Date Running_time_1;		// 1#运行时间
	private int Remote_switch_1;		// 1#远程功能开关 
	private float VoltageA_2;			// 2#A相电压
	private float Electric_currentA_2;	// 2#A相电流
	private float Host_temperature_2;	// 2#主机温度
	private float Coolant_temperature_2;// 2#冷却剂温度
	private float Sump_Pressure_2;		// 2#分离前压力
	private float Loading_pressure_2;	// 2#加载压力
	private Date Loading_time_2;		// 2#加载时间
	private float Unloading_pressure_2;	// 2#卸载压力
	private int Alarm_number_2;			// 2#报警号
	private float Exhaust_pressure_2;	//2#排气压力
	private float Exhaust_temperature_2;// 2#排气温度
	private int Control_state_2;		// 2#控制状态字
	private float total_energy_2;		// 2#正向有功总电能
	private int Warning_sign_2;			// 2#警告号
	private Date Running_time_2;		// 2#运行时间
	private int Remote_switch_2;		// 2#远程功能开关 
	private float VoltageA_3;			// 3#A相电压
	private float Electric_currentA_3;	// 3#A相电流
	private float Host_temperature_3;	// 3#主机温度
	private float Coolant_temperature_3;// 3#冷却剂温度
	private float Sump_Pressure_3;		// 3#分离前压力
	private float Loading_pressure_3;	// 3#加载压力
	private Date Loading_time_3;		// 3#加载时间
	private float Unloading_pressure_3;	// 3#卸载压力
	private int Alarm_number_3;			// 3#报警号
	private float Exhaust_pressure_3;	// 3#排气压力
	private float Exhaust_temperature_3;// 3#排气温度
	private int Control_state_3;		// 3#控制状态字
	private float total_energy_3;		// 3#正向有功总电能
	private int Warning_sign_3;			// 3#警告号
	private Date Running_time_3;		// 3#运行时间
	private int Remote_switch_3	;		// 3#远程功能开关 
	private float Active_Service_Rate1;	// AI-1#有功功率
	private float Active_Service_Rate2;	// AI-2#有功功率
	private float Active_Service_Rate3;	// AI-3#有功功率
	private float pressure;				// 压力
	private float Cumulative_flow;		// 累积流量
}
