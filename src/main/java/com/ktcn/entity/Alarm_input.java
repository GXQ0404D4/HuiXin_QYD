package com.ktcn.entity;
/**
 *  报警故障类
 * @author Administrator
 *
 */
public class Alarm_input {
	private int alarm_id;
	private String alarm_name;
	private int alarm_input;
	private int state;
	private int introduce;
	public Alarm_input() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alarm_input(int alarm_id, String alarm_name, int alarm_input, int state, int introduce) {
		super();
		this.alarm_id = alarm_id;
		this.alarm_name = alarm_name;
		this.alarm_input = alarm_input;
		this.state = state;
		this.introduce = introduce;
	}
	public int getAlarm_id() {
		return alarm_id;
	}
	public void setAlarm_id(int alarm_id) {
		this.alarm_id = alarm_id;
	}
	public String getAlarm_name() {
		return alarm_name;
	}
	public void setAlarm_name(String alarm_name) {
		this.alarm_name = alarm_name;
	}
	public int getAlarm_input() {
		return alarm_input;
	}
	public void setAlarm_input(int alarm_input) {
		this.alarm_input = alarm_input;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getIntroduce() {
		return introduce;
	}
	public void setIntroduce(int introduce) {
		this.introduce = introduce;
	}
	@Override
	public String toString() {
		return "Alarm_input [alarm_id=" + alarm_id + ", alarm_name=" + alarm_name + ", alarm_input=" + alarm_input
				+ ", state=" + state + ", introduce=" + introduce + "]";
	}
	
}
