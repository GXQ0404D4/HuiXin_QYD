package com.ktcn.entity;

import java.util.Date;

import lombok.Data;

/*
 * 生产管理表
 */
@Data
public class Production_plan {
	private int id;				// 主键
	private Date pdt_time;		// 生产管理时间
	private String pdt_content;	// 生产管理内容
	private String pdt_people;	// 生产管理布置人
	private String pdt_Executor;// 生产管理执行人
	private int pdt_state;		// 状态
	private String pdt_report;	// 汇报内容
	private int op_state;		// 操作状态
}
