package com.ktcn.entity;

import java.util.Date;

/*
 * 总管网表
 */
public class Mian_network {
	private int id;					// 主键
	private float pressureA;			// 压力A
	private float pressureB;			// 压力B
	private float LU_dianA;			// 露点A
	private float LU_dianB;			// 露点B
	private float Instantaneous_flow;	// 瞬时流量
	private float cumulative_flow;		// 累计流量
	private float total_power;			// 总功率
	private float total_electricity;	// 总电量
	private String machine;			// 机器
	private Date current_time;			// 当前时间
	public Mian_network() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mian_network(int id, float pressureA, float pressureB, float lU_dianA, float lU_dianB,
			float instantaneous_flow, float cumulative_flow, float total_power, float total_electricity, String machine,
			Date current_time) {
		super();
		this.id = id;
		this.pressureA = pressureA;
		this.pressureB = pressureB;
		LU_dianA = lU_dianA;
		LU_dianB = lU_dianB;
		Instantaneous_flow = instantaneous_flow;
		this.cumulative_flow = cumulative_flow;
		this.total_power = total_power;
		this.total_electricity = total_electricity;
		this.machine = machine;
		this.current_time = current_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPressureA() {
		return pressureA;
	}
	public void setPressureA(float pressureA) {
		this.pressureA = pressureA;
	}
	public float getPressureB() {
		return pressureB;
	}
	public void setPressureB(float pressureB) {
		this.pressureB = pressureB;
	}
	public float getLU_dianA() {
		return LU_dianA;
	}
	public void setLU_dianA(float lU_dianA) {
		LU_dianA = lU_dianA;
	}
	public float getLU_dianB() {
		return LU_dianB;
	}
	public void setLU_dianB(float lU_dianB) {
		LU_dianB = lU_dianB;
	}
	public float getInstantaneous_flow() {
		return Instantaneous_flow;
	}
	public void setInstantaneous_flow(float instantaneous_flow) {
		Instantaneous_flow = instantaneous_flow;
	}
	public float getCumulative_flow() {
		return cumulative_flow;
	}
	public void setCumulative_flow(float cumulative_flow) {
		this.cumulative_flow = cumulative_flow;
	}
	public float getTotal_power() {
		return total_power;
	}
	public void setTotal_power(float total_power) {
		this.total_power = total_power;
	}
	public float getTotal_electricity() {
		return total_electricity;
	}
	public void setTotal_electricity(float total_electricity) {
		this.total_electricity = total_electricity;
	}
	public String getMachine() {
		return machine;
	}
	public void setMachine(String machine) {
		this.machine = machine;
	}
	public Date getCurrent_time() {
		return current_time;
	}
	public void setCurrent_time(Date current_time) {
		this.current_time = current_time;
	}
	@Override
	public String toString() {
		return "Mian_network [id=" + id + ", pressureA=" + pressureA + ", pressureB=" + pressureB + ", LU_dianA="
				+ LU_dianA + ", LU_dianB=" + LU_dianB + ", Instantaneous_flow=" + Instantaneous_flow
				+ ", cumulative_flow=" + cumulative_flow + ", total_power=" + total_power + ", total_electricity="
				+ total_electricity + ", machine=" + machine + ", current_time=" + current_time + "]";
	}
	
}
