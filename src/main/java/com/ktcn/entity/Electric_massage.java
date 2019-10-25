package com.ktcn.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
/*
 * 电量报表
 */
@Component
@ConfigurationProperties(prefix = "oss")
@Data
public class Electric_massage {
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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date current_time;		// 当前时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date current_date;		// 存入日期
	
}