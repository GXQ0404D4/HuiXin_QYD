package com.ktcn.entity;

import java.util.Date;

import lombok.Data;

/*
 * 开关量输出
 */
@Data
public class Switch_output {
	private int output_id;		// 主键
	private String switch_name;
	private int switch_ouput;
	private int state;
	private String introduce;
	private Date time;
}
