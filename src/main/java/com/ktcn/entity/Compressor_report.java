package com.ktcn.entity;

import java.util.Date;

/**
 * 空压机数据报表
 * @author Administrator
 *
 */
public class Compressor_report {
	private int Air_id;                // 主键
	private float electric_energy_A;   // 正向有功总电能A
	private float electric_energy_B;   // 正向有功总电能B
	private float electric_energy_C;   // 正向有功总电能C
	private Date running_time_A;       // 运行时间A
	private Date running_time_B;       // 运行时间B
	private Date running_time_C;       // 运行时间C
	private float active_powerA;       // 有功公率A
	private float active_powerB;       // 有功公率B
	private float active_powerC;       // 有功公率C
	private int Air_state;             // 状态
	private Date Air_current_time;     // 当前时间
	public Compressor_report() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compressor_report(int air_id, float electric_energy_A, float electric_energy_B, float electric_energy_C,
			Date running_time_A, Date running_time_B, Date running_time_C, float active_powerA, float active_powerB,
			float active_powerC, int air_state, Date air_current_time) {
		super();
		Air_id = air_id;
		this.electric_energy_A = electric_energy_A;
		this.electric_energy_B = electric_energy_B;
		this.electric_energy_C = electric_energy_C;
		this.running_time_A = running_time_A;
		this.running_time_B = running_time_B;
		this.running_time_C = running_time_C;
		this.active_powerA = active_powerA;
		this.active_powerB = active_powerB;
		this.active_powerC = active_powerC;
		Air_state = air_state;
		Air_current_time = air_current_time;
	}
	public int getAir_id() {
		return Air_id;
	}
	public void setAir_id(int air_id) {
		Air_id = air_id;
	}
	public float getElectric_energy_A() {
		return electric_energy_A;
	}
	public void setElectric_energy_A(float electric_energy_A) {
		this.electric_energy_A = electric_energy_A;
	}
	public float getElectric_energy_B() {
		return electric_energy_B;
	}
	public void setElectric_energy_B(float electric_energy_B) {
		this.electric_energy_B = electric_energy_B;
	}
	public float getElectric_energy_C() {
		return electric_energy_C;
	}
	public void setElectric_energy_C(float electric_energy_C) {
		this.electric_energy_C = electric_energy_C;
	}
	public Date getRunning_time_A() {
		return running_time_A;
	}
	public void setRunning_time_A(Date running_time_A) {
		this.running_time_A = running_time_A;
	}
	public Date getRunning_time_B() {
		return running_time_B;
	}
	public void setRunning_time_B(Date running_time_B) {
		this.running_time_B = running_time_B;
	}
	public Date getRunning_time_C() {
		return running_time_C;
	}
	public void setRunning_time_C(Date running_time_C) {
		this.running_time_C = running_time_C;
	}
	public float getActive_powerA() {
		return active_powerA;
	}
	public void setActive_powerA(float active_powerA) {
		this.active_powerA = active_powerA;
	}
	public float getActive_powerB() {
		return active_powerB;
	}
	public void setActive_powerB(float active_powerB) {
		this.active_powerB = active_powerB;
	}
	public float getActive_powerC() {
		return active_powerC;
	}
	public void setActive_powerC(float active_powerC) {
		this.active_powerC = active_powerC;
	}
	public int getAir_state() {
		return Air_state;
	}
	public void setAir_state(int air_state) {
		Air_state = air_state;
	}
	public Date getAir_current_time() {
		return Air_current_time;
	}
	public void setAir_current_time(Date air_current_time) {
		Air_current_time = air_current_time;
	}
	@Override
	public String toString() {
		return "Compressor_report [Air_id=" + Air_id + ", electric_energy_A=" + electric_energy_A
				+ ", electric_energy_B=" + electric_energy_B + ", electric_energy_C=" + electric_energy_C
				+ ", running_time_A=" + running_time_A + ", running_time_B=" + running_time_B + ", running_time_C="
				+ running_time_C + ", active_powerA=" + active_powerA + ", active_powerB=" + active_powerB
				+ ", active_powerC=" + active_powerC + ", Air_state=" + Air_state + ", Air_current_time="
				+ Air_current_time + "]";
	}
	
}
