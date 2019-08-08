package com.ktcn.entity;

import java.util.Date;

/*
 * 开关量输入
 */
public class Switch_input {
	private int iput_id;		// 主键
	private String switch_name;
	private int switch_input;
	private int state;
	private String introduce;
	private Date time;
	public Switch_input() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Switch_input(int iput_id, String switch_name, int switch_input, int state, String introduce, Date time) {
		super();
		this.iput_id = iput_id;
		this.switch_name = switch_name;
		this.switch_input = switch_input;
		this.state = state;
		this.introduce = introduce;
		this.time = time;
	}
	public int getIput_id() {
		return iput_id;
	}
	public void setIput_id(int iput_id) {
		this.iput_id = iput_id;
	}
	public String getSwitch_name() {
		return switch_name;
	}
	public void setSwitch_name(String switch_name) {
		this.switch_name = switch_name;
	}
	public int getSwitch_input() {
		return switch_input;
	}
	public void setSwitch_input(int switch_input) {
		this.switch_input = switch_input;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Switch_input [iput_id=" + iput_id + ", switch_name=" + switch_name + ", switch_input=" + switch_input
				+ ", state=" + state + ", introduce=" + introduce + ", time=" + time + "]";
	}
	
}
