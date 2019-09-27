package com.ktcn.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/*
 * 故障记录表
 */
@Data
public class Error_recording {
	private int fault_id;			// 主键
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date time;				// 时间
	private String fault_machine;	// 故障机器
	private String fault_picture;	// 故障图片
	private String falut_people;	// 维修人员
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date Repair_time;		// 维修时间
	private String falut_summary;	// 故障总结
	private String falut_Reporter;	// 故障记录上报人员
	private int falut_state;		// 故障记录状态
}
