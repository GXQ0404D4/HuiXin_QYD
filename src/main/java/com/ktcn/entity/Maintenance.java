package com.ktcn.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/*
 * 维保记录表
 */
@Data
public class Maintenance {
	private int id;				// 主键
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date mt_time;		// 完成维保时间
	private String mt_content;	// 维保内容
	private String mt_man;		// 申请人员
	private String mt_num;		// 维保码
	private int state;		// 数据状态码 0:可修改 1:不可修改
}
