package com.ktcn.entity;

import java.util.Date;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/*
 * 总管网表
 */
@Component
@ConfigurationProperties(prefix = "oss")
@Data
public class Mian_network {
	private int id;						// 主键
	private float pressureA;			// 压力A
	private float pressureB;			// 压力B
	private float LU_dianA;				// 露点A
	private float LU_dianB;				// 露点B
	private float Instantaneous_flow;	// 瞬时流量
	private float cumulative_flow;		// 累计流量 
	private float total_power;			// 功率
	private float total_electricity;	// 总电量
	private String machine;				// 机器
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date current_time;			// 当前时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date current_date;			// 写入日期
}
