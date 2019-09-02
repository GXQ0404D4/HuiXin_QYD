package com.ktcn.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/*
 * 日志表
 */
@Data
public class Log {
	private int id;				// 主键
	private int user_id;		// 操作人id
	private String user;		// 操作人
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date operTime;		// 操作时间
	private String operModel;	// 操作模块
	private String operName	;	// 操作功能
}
