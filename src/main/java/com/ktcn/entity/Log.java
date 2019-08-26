package com.ktcn.entity;

import java.util.Date;

import lombok.Data;

/*
 * 日志表
 */
@Data
public class Log {
	private int id;				// 主键
	private int user_id;		// 操作人id
	private String user;		// 操作人
	private Date operTime;		// 操作时间
	private String operModel;	// 操作模块
	private String operName	;	// 操作功能
}
