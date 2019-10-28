package com.ktcn.entity.KYJdatatable;

import java.util.Date;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Component
@ConfigurationProperties(prefix = "oss")
@Data
public class Kyj_data_table {
	private long id;                        //id
	private float Voltage;                  //A相电压 
	private float Electric_current;         //A相电流
	private float Host_temperature;         //主机温度 
	private float Coolant_temperature;      //冷却剂温度
	private float Sump_Pressure;            //分离前压力
	private float Loading_pressure;         //加载压力
	private float Loading_time;             //加载时间
	private float Unloading_pressure;       //卸载压力
	private Object Alarm_number;              //报警号
	private float Exhaust_pressure;         //排气压力
	private float Exhaust_temperature;      //排气温度  
	private Object Control_state;             //控制状态字
	private float total_energy;             //正向有功总电能
	private Object Warning_sign;              //警告号
	private float Running_time;             //运行时间
	private Object Remote_switch;             //远程功能开关
	private float Active_Service_Rate;      //有功功率
	private float pressure;                 //压力
	private float Cumulative_flow;          //累积流量
	private float Compensated_flow;         //瞬时流量
	private float instantaneous_power;      //瞬时功率
	private float dew_point_temperature;      //露点
	private float total_power;              //总功率
	private float total_electricity;        //总电量
	private float electric;                 //电量
	private float power_factor;             //功率因数	
	private String machine_name;            //机器名
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date current_date;              //存入日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date current_time;              //存入时间
	private String state;                   //状态
	
	

}
