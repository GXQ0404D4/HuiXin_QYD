package com.ktcn.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * 空压机数据报表
 * @author Administrator
 *
 */
@Data
public class Compressor_report {
	private int Air_id;                // 主键
	private float electric_energy_A;   // 正向有功总电能A
	private float electric_energy_B;   // 正向有功总电能B
	private float electric_energy_C;   // 正向有功总电能C
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date running_time_A;       // 运行时间A
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date running_time_B;       // 运行时间B
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date running_time_C;       // 运行时间C
	private float active_powerA;       // 有功公率A
	private float active_powerB;       // 有功公率B
	private float active_powerC;       // 有功公率C
	private int Air_state;             // 状态
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date Air_current_time;     // 当前时间
}
