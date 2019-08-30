package com.ktcn.entity;

import java.util.Date;

import lombok.Data;

/*
 * 总管网表
 */
@Data
public class Mian_network {
	private int id;						// 主键
	private float pressureA;			// 压力A
	private float pressureB;			// 压力B
	private float LU_dianA;				// 露点A
	private float LU_dianB;				// 露点B
	private float Instantaneous_flow;	// 瞬时流量
	private float cumulative_flow;		// 累计流量
	private float total_power;			// 总功率
	private float total_electricity;	// 总电量
	private String machine;				// 机器
	private Date current_time;			// 当前时间
	private Date current_date;			// 写入日期
}
