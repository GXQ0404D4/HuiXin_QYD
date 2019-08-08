package com.ktcn.entity;

import java.util.Date;
/*
 * 电量报表
 */
public class Electric_massage {
	private int id;					// 主键
	private String machine;			// 机器
	private float voltageA;			// 电压A
	private float voltageB;			// 电压B
	private float voltageC;			// 电压C
	private float electric_currentA;// 电流A
	private float electric_currentB;// 电流B
	private float electric_currentC;// 电流C
	private float instantaneous_power;// 瞬时功率
	private float electric_quantity;// 电量
	private float power_factor;		// 功率因数
	private Date current_time;		// 当前时间
	public Electric_massage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Electric_massage(int id, String machine, float voltageA, float voltageB, float voltageC,
			float electric_currentA, float electric_currentB, float electric_currentC, float instantaneous_power,
			float electric_quantity, float power_factor, Date current_time) {
		super();
		this.id = id;
		this.machine = machine;
		this.voltageA = voltageA;
		this.voltageB = voltageB;
		this.voltageC = voltageC;
		this.electric_currentA = electric_currentA;
		this.electric_currentB = electric_currentB;
		this.electric_currentC = electric_currentC;
		this.instantaneous_power = instantaneous_power;
		this.electric_quantity = electric_quantity;
		this.power_factor = power_factor;
		this.current_time = current_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMachine() {
		return machine;
	}
	public void setMachine(String machine) {
		this.machine = machine;
	}
	public float getVoltageA() {
		return voltageA;
	}
	public void setVoltageA(float voltageA) {
		this.voltageA = voltageA;
	}
	public float getVoltageB() {
		return voltageB;
	}
	public void setVoltageB(float voltageB) {
		this.voltageB = voltageB;
	}
	public float getVoltageC() {
		return voltageC;
	}
	public void setVoltageC(float voltageC) {
		this.voltageC = voltageC;
	}
	public float getElectric_currentA() {
		return electric_currentA;
	}
	public void setElectric_currentA(float electric_currentA) {
		this.electric_currentA = electric_currentA;
	}
	public float getElectric_currentB() {
		return electric_currentB;
	}
	public void setElectric_currentB(float electric_currentB) {
		this.electric_currentB = electric_currentB;
	}
	public float getElectric_currentC() {
		return electric_currentC;
	}
	public void setElectric_currentC(float electric_currentC) {
		this.electric_currentC = electric_currentC;
	}
	public float getInstantaneous_power() {
		return instantaneous_power;
	}
	public void setInstantaneous_power(float instantaneous_power) {
		this.instantaneous_power = instantaneous_power;
	}
	public float getElectric_quantity() {
		return electric_quantity;
	}
	public void setElectric_quantity(float electric_quantity) {
		this.electric_quantity = electric_quantity;
	}
	public float getPower_factor() {
		return power_factor;
	}
	public void setPower_factor(float power_factor) {
		this.power_factor = power_factor;
	}
	public Date getCurrent_time() {
		return current_time;
	}
	public void setCurrent_time(Date current_time) {
		this.current_time = current_time;
	}
	@Override
	public String toString() {
		return "Electric_massage [id=" + id + ", machine=" + machine + ", voltageA=" + voltageA + ", voltageB="
				+ voltageB + ", voltageC=" + voltageC + ", electric_currentA=" + electric_currentA
				+ ", electric_currentB=" + electric_currentB + ", electric_currentC=" + electric_currentC
				+ ", instantaneous_power=" + instantaneous_power + ", electric_quantity=" + electric_quantity
				+ ", power_factor=" + power_factor + ", current_time=" + current_time + "]";
	}
	
}
