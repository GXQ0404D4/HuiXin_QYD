package com.ktcn.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/*
 * 开关量输入
 */
@Data
public class Switch_input {
	private int iput_id;		// 主键
	private String switch_name;
	private int switch_input;
	private int state;
	private String introduce;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date time;
}
