package com.ktcn.entity;

import lombok.Data;

/**
 *  报警故障类
 * @author Administrator
 *
 */
@Data
public class Alarm_input {
	private int alarm_id;
	private String alarm_name;
	private int alarm_input;
	private int state;
	private int introduce;
}
