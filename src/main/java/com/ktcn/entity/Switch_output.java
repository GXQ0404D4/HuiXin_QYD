package com.ktcn.entity;

import java.util.Date;

/*
 * 开关量输出
 */
public class Switch_output {
	private int output_id;		// 主键
	private String switch_name;
	private int switch_ouput;
	private int state;
	private String introduce;
	private Date time;
	public Switch_output() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Switch_output(int output_id, String switch_name, int switch_ouput, int state, String introduce, Date time) {
		super();
		this.output_id = output_id;
		this.switch_name = switch_name;
		this.switch_ouput = switch_ouput;
		this.state = state;
		this.introduce = introduce;
		this.time = time;
	}
	public int getOutput_id() {
		return output_id;
	}
	public void setOutput_id(int output_id) {
		this.output_id = output_id;
	}
	public String getSwitch_name() {
		return switch_name;
	}
	public void setSwitch_name(String switch_name) {
		this.switch_name = switch_name;
	}
	public int getSwitch_ouput() {
		return switch_ouput;
	}
	public void setSwitch_ouput(int switch_ouput) {
		this.switch_ouput = switch_ouput;
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
		return "Switch_output [output_id=" + output_id + ", switch_name=" + switch_name + ", switch_ouput="
				+ switch_ouput + ", state=" + state + ", introduce=" + introduce + ", time=" + time + "]";
	}
	
}
