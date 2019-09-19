package com.ktcn.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * 报警巡查实体类
 * @author Administrator
 *
 */
@Data
public class Alarmpatrol {
	private int ap_id;				// 主键
	private String ap_name;			// 点位名
	private String describe;		// 描述
	private String measured_value;	// 实测值
	private double upDiff;			// 上限差值(上限值减实测值,负值为异常)
	private double lowDiff;			// 下限差值(下限值减实测值,负值为异常)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date ap_time;			// 报警时间
	private int ap_state;			// 状态码
}
