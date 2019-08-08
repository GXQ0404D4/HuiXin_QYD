package com.ktcn.entity;

import java.util.Date;

/**
 * 临时数据表
 * @author Administrator
 *
 */
public class Real_time_data {
	
	private long dmt_id;				// 主键
	private float VoltageA_1;			// 1#A相电压
	private float Electric_currentA_1;	// 1#A相电流
	private float Host_temperature_1;	// 1#主机温度
	private float Coolant_temperature_1;// 1#冷却剂温度
	private float Sump_Pressure_1;		// 1#分离前压力
	private float Loading_pressure_1;	// 1#加载压力
	private Date Loading_time_1;		// 1#加载时间
	private float Unloading_pressure_1;	// 1#卸载压力
	private int Alarm_number_1;			// 1#报警号
	private float Exhaust_pressure_1;	// 1#排气压力
	private float Exhaust_temperature_1;// 1#排气温度
	private int Control_state_1;		// 1#控制状态字
	private float total_energy_1;		// 1#正向有功总电能
	private int Warning_sign_1;			// 1#警告号
	private Date Running_time_1;		// 1#运行时间
	private int Remote_switch_1;		// 1#远程功能开关 
	private float VoltageA_2;			// 2#A相电压
	private float Electric_currentA_2;	// 2#A相电流
	private float Host_temperature_2;	// 2#主机温度
	private float Coolant_temperature_2;// 2#冷却剂温度
	private float Sump_Pressure_2;		// 2#分离前压力
	private float Loading_pressure_2;	// 2#加载压力
	private Date Loading_time_2;		// 2#加载时间
	private float Unloading_pressure_2;	// 2#卸载压力
	private int Alarm_number_2;			// 2#报警号
	private float Exhaust_pressure_2;	//2#排气压力
	private float Exhaust_temperature_2;// 2#排气温度
	private int Control_state_2;		// 2#控制状态字
	private float total_energy_2;		// 2#正向有功总电能
	private int Warning_sign_2;			// 2#警告号
	private Date Running_time_2;		// 2#运行时间
	private int Remote_switch_2;		// 2#远程功能开关 
	private float VoltageA_3;			// 3#A相电压
	private float Electric_currentA_3;	// 3#A相电流
	private float Host_temperature_3;	// 3#主机温度
	private float Coolant_temperature_3;// 3#冷却剂温度
	private float Sump_Pressure_3;		// 3#分离前压力
	private float Loading_pressure_3;	// 3#加载压力
	private Date Loading_time_3;		// 3#加载时间
	private float Unloading_pressure_3;	// 3#卸载压力
	private int Alarm_number_3;			// 3#报警号
	private float Exhaust_pressure_3;	// 3#排气压力
	private float Exhaust_temperature_3;// 3#排气温度
	private int Control_state_3;		// 3#控制状态字
	private float total_energy_3;		// 3#正向有功总电能
	private int Warning_sign_3;			// 3#警告号
	private Date Running_time_3;		// 3#运行时间
	private int Remote_switch_3	;		// 3#远程功能开关 
	private float Active_Service_Rate1;	// AI-1#有功功率
	private float Active_Service_Rate2;	// AI-2#有功功率
	private float Active_Service_Rate3;	// AI-3#有功功率
	private float pressure;				// 压力
	private float Cumulative_flow;		// 累积流量
	public Real_time_data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Real_time_data(long dmt_id, float voltageA_1, float electric_currentA_1, float host_temperature_1,
			float coolant_temperature_1, float sump_Pressure_1, float loading_pressure_1, Date loading_time_1,
			float unloading_pressure_1, int alarm_number_1, float exhaust_pressure_1, float exhaust_temperature_1,
			int control_state_1, float total_energy_1, int warning_sign_1, Date running_time_1, int remote_switch_1,
			float voltageA_2, float electric_currentA_2, float host_temperature_2, float coolant_temperature_2,
			float sump_Pressure_2, float loading_pressure_2, Date loading_time_2, float unloading_pressure_2,
			int alarm_number_2, float exhaust_pressure_2, float exhaust_temperature_2, int control_state_2,
			float total_energy_2, int warning_sign_2, Date running_time_2, int remote_switch_2, float voltageA_3,
			float electric_currentA_3, float host_temperature_3, float coolant_temperature_3, float sump_Pressure_3,
			float loading_pressure_3, Date loading_time_3, float unloading_pressure_3, int alarm_number_3,
			float exhaust_pressure_3, float exhaust_temperature_3, int control_state_3, float total_energy_3,
			int warning_sign_3, Date running_time_3, int remote_switch_3, float active_Service_Rate1,
			float active_Service_Rate2, float active_Service_Rate3, float pressure, float cumulative_flow) {
		super();
		this.dmt_id = dmt_id;
		VoltageA_1 = voltageA_1;
		Electric_currentA_1 = electric_currentA_1;
		Host_temperature_1 = host_temperature_1;
		Coolant_temperature_1 = coolant_temperature_1;
		Sump_Pressure_1 = sump_Pressure_1;
		Loading_pressure_1 = loading_pressure_1;
		Loading_time_1 = loading_time_1;
		Unloading_pressure_1 = unloading_pressure_1;
		Alarm_number_1 = alarm_number_1;
		Exhaust_pressure_1 = exhaust_pressure_1;
		Exhaust_temperature_1 = exhaust_temperature_1;
		Control_state_1 = control_state_1;
		this.total_energy_1 = total_energy_1;
		Warning_sign_1 = warning_sign_1;
		Running_time_1 = running_time_1;
		Remote_switch_1 = remote_switch_1;
		VoltageA_2 = voltageA_2;
		Electric_currentA_2 = electric_currentA_2;
		Host_temperature_2 = host_temperature_2;
		Coolant_temperature_2 = coolant_temperature_2;
		Sump_Pressure_2 = sump_Pressure_2;
		Loading_pressure_2 = loading_pressure_2;
		Loading_time_2 = loading_time_2;
		Unloading_pressure_2 = unloading_pressure_2;
		Alarm_number_2 = alarm_number_2;
		Exhaust_pressure_2 = exhaust_pressure_2;
		Exhaust_temperature_2 = exhaust_temperature_2;
		Control_state_2 = control_state_2;
		this.total_energy_2 = total_energy_2;
		Warning_sign_2 = warning_sign_2;
		Running_time_2 = running_time_2;
		Remote_switch_2 = remote_switch_2;
		VoltageA_3 = voltageA_3;
		Electric_currentA_3 = electric_currentA_3;
		Host_temperature_3 = host_temperature_3;
		Coolant_temperature_3 = coolant_temperature_3;
		Sump_Pressure_3 = sump_Pressure_3;
		Loading_pressure_3 = loading_pressure_3;
		Loading_time_3 = loading_time_3;
		Unloading_pressure_3 = unloading_pressure_3;
		Alarm_number_3 = alarm_number_3;
		Exhaust_pressure_3 = exhaust_pressure_3;
		Exhaust_temperature_3 = exhaust_temperature_3;
		Control_state_3 = control_state_3;
		this.total_energy_3 = total_energy_3;
		Warning_sign_3 = warning_sign_3;
		Running_time_3 = running_time_3;
		Remote_switch_3 = remote_switch_3;
		Active_Service_Rate1 = active_Service_Rate1;
		Active_Service_Rate2 = active_Service_Rate2;
		Active_Service_Rate3 = active_Service_Rate3;
		this.pressure = pressure;
		Cumulative_flow = cumulative_flow;
	}
	public long getDmt_id() {
		return dmt_id;
	}
	public void setDmt_id(long dmt_id) {
		this.dmt_id = dmt_id;
	}
	public float getVoltageA_1() {
		return VoltageA_1;
	}
	public void setVoltageA_1(float voltageA_1) {
		VoltageA_1 = voltageA_1;
	}
	public float getElectric_currentA_1() {
		return Electric_currentA_1;
	}
	public void setElectric_currentA_1(float electric_currentA_1) {
		Electric_currentA_1 = electric_currentA_1;
	}
	public float getHost_temperature_1() {
		return Host_temperature_1;
	}
	public void setHost_temperature_1(float host_temperature_1) {
		Host_temperature_1 = host_temperature_1;
	}
	public float getCoolant_temperature_1() {
		return Coolant_temperature_1;
	}
	public void setCoolant_temperature_1(float coolant_temperature_1) {
		Coolant_temperature_1 = coolant_temperature_1;
	}
	public float getSump_Pressure_1() {
		return Sump_Pressure_1;
	}
	public void setSump_Pressure_1(float sump_Pressure_1) {
		Sump_Pressure_1 = sump_Pressure_1;
	}
	public float getLoading_pressure_1() {
		return Loading_pressure_1;
	}
	public void setLoading_pressure_1(float loading_pressure_1) {
		Loading_pressure_1 = loading_pressure_1;
	}
	public Date getLoading_time_1() {
		return Loading_time_1;
	}
	public void setLoading_time_1(Date loading_time_1) {
		Loading_time_1 = loading_time_1;
	}
	public float getUnloading_pressure_1() {
		return Unloading_pressure_1;
	}
	public void setUnloading_pressure_1(float unloading_pressure_1) {
		Unloading_pressure_1 = unloading_pressure_1;
	}
	public int getAlarm_number_1() {
		return Alarm_number_1;
	}
	public void setAlarm_number_1(int alarm_number_1) {
		Alarm_number_1 = alarm_number_1;
	}
	public float getExhaust_pressure_1() {
		return Exhaust_pressure_1;
	}
	public void setExhaust_pressure_1(float exhaust_pressure_1) {
		Exhaust_pressure_1 = exhaust_pressure_1;
	}
	public float getExhaust_temperature_1() {
		return Exhaust_temperature_1;
	}
	public void setExhaust_temperature_1(float exhaust_temperature_1) {
		Exhaust_temperature_1 = exhaust_temperature_1;
	}
	public int getControl_state_1() {
		return Control_state_1;
	}
	public void setControl_state_1(int control_state_1) {
		Control_state_1 = control_state_1;
	}
	public float getTotal_energy_1() {
		return total_energy_1;
	}
	public void setTotal_energy_1(float total_energy_1) {
		this.total_energy_1 = total_energy_1;
	}
	public int getWarning_sign_1() {
		return Warning_sign_1;
	}
	public void setWarning_sign_1(int warning_sign_1) {
		Warning_sign_1 = warning_sign_1;
	}
	public Date getRunning_time_1() {
		return Running_time_1;
	}
	public void setRunning_time_1(Date running_time_1) {
		Running_time_1 = running_time_1;
	}
	public int getRemote_switch_1() {
		return Remote_switch_1;
	}
	public void setRemote_switch_1(int remote_switch_1) {
		Remote_switch_1 = remote_switch_1;
	}
	public float getVoltageA_2() {
		return VoltageA_2;
	}
	public void setVoltageA_2(float voltageA_2) {
		VoltageA_2 = voltageA_2;
	}
	public float getElectric_currentA_2() {
		return Electric_currentA_2;
	}
	public void setElectric_currentA_2(float electric_currentA_2) {
		Electric_currentA_2 = electric_currentA_2;
	}
	public float getHost_temperature_2() {
		return Host_temperature_2;
	}
	public void setHost_temperature_2(float host_temperature_2) {
		Host_temperature_2 = host_temperature_2;
	}
	public float getCoolant_temperature_2() {
		return Coolant_temperature_2;
	}
	public void setCoolant_temperature_2(float coolant_temperature_2) {
		Coolant_temperature_2 = coolant_temperature_2;
	}
	public float getSump_Pressure_2() {
		return Sump_Pressure_2;
	}
	public void setSump_Pressure_2(float sump_Pressure_2) {
		Sump_Pressure_2 = sump_Pressure_2;
	}
	public float getLoading_pressure_2() {
		return Loading_pressure_2;
	}
	public void setLoading_pressure_2(float loading_pressure_2) {
		Loading_pressure_2 = loading_pressure_2;
	}
	public Date getLoading_time_2() {
		return Loading_time_2;
	}
	public void setLoading_time_2(Date loading_time_2) {
		Loading_time_2 = loading_time_2;
	}
	public float getUnloading_pressure_2() {
		return Unloading_pressure_2;
	}
	public void setUnloading_pressure_2(float unloading_pressure_2) {
		Unloading_pressure_2 = unloading_pressure_2;
	}
	public int getAlarm_number_2() {
		return Alarm_number_2;
	}
	public void setAlarm_number_2(int alarm_number_2) {
		Alarm_number_2 = alarm_number_2;
	}
	public float getExhaust_pressure_2() {
		return Exhaust_pressure_2;
	}
	public void setExhaust_pressure_2(float exhaust_pressure_2) {
		Exhaust_pressure_2 = exhaust_pressure_2;
	}
	public float getExhaust_temperature_2() {
		return Exhaust_temperature_2;
	}
	public void setExhaust_temperature_2(float exhaust_temperature_2) {
		Exhaust_temperature_2 = exhaust_temperature_2;
	}
	public int getControl_state_2() {
		return Control_state_2;
	}
	public void setControl_state_2(int control_state_2) {
		Control_state_2 = control_state_2;
	}
	public float getTotal_energy_2() {
		return total_energy_2;
	}
	public void setTotal_energy_2(float total_energy_2) {
		this.total_energy_2 = total_energy_2;
	}
	public int getWarning_sign_2() {
		return Warning_sign_2;
	}
	public void setWarning_sign_2(int warning_sign_2) {
		Warning_sign_2 = warning_sign_2;
	}
	public Date getRunning_time_2() {
		return Running_time_2;
	}
	public void setRunning_time_2(Date running_time_2) {
		Running_time_2 = running_time_2;
	}
	public int getRemote_switch_2() {
		return Remote_switch_2;
	}
	public void setRemote_switch_2(int remote_switch_2) {
		Remote_switch_2 = remote_switch_2;
	}
	public float getVoltageA_3() {
		return VoltageA_3;
	}
	public void setVoltageA_3(float voltageA_3) {
		VoltageA_3 = voltageA_3;
	}
	public float getElectric_currentA_3() {
		return Electric_currentA_3;
	}
	public void setElectric_currentA_3(float electric_currentA_3) {
		Electric_currentA_3 = electric_currentA_3;
	}
	public float getHost_temperature_3() {
		return Host_temperature_3;
	}
	public void setHost_temperature_3(float host_temperature_3) {
		Host_temperature_3 = host_temperature_3;
	}
	public float getCoolant_temperature_3() {
		return Coolant_temperature_3;
	}
	public void setCoolant_temperature_3(float coolant_temperature_3) {
		Coolant_temperature_3 = coolant_temperature_3;
	}
	public float getSump_Pressure_3() {
		return Sump_Pressure_3;
	}
	public void setSump_Pressure_3(float sump_Pressure_3) {
		Sump_Pressure_3 = sump_Pressure_3;
	}
	public float getLoading_pressure_3() {
		return Loading_pressure_3;
	}
	public void setLoading_pressure_3(float loading_pressure_3) {
		Loading_pressure_3 = loading_pressure_3;
	}
	public Date getLoading_time_3() {
		return Loading_time_3;
	}
	public void setLoading_time_3(Date loading_time_3) {
		Loading_time_3 = loading_time_3;
	}
	public float getUnloading_pressure_3() {
		return Unloading_pressure_3;
	}
	public void setUnloading_pressure_3(float unloading_pressure_3) {
		Unloading_pressure_3 = unloading_pressure_3;
	}
	public int getAlarm_number_3() {
		return Alarm_number_3;
	}
	public void setAlarm_number_3(int alarm_number_3) {
		Alarm_number_3 = alarm_number_3;
	}
	public float getExhaust_pressure_3() {
		return Exhaust_pressure_3;
	}
	public void setExhaust_pressure_3(float exhaust_pressure_3) {
		Exhaust_pressure_3 = exhaust_pressure_3;
	}
	public float getExhaust_temperature_3() {
		return Exhaust_temperature_3;
	}
	public void setExhaust_temperature_3(float exhaust_temperature_3) {
		Exhaust_temperature_3 = exhaust_temperature_3;
	}
	public int getControl_state_3() {
		return Control_state_3;
	}
	public void setControl_state_3(int control_state_3) {
		Control_state_3 = control_state_3;
	}
	public float getTotal_energy_3() {
		return total_energy_3;
	}
	public void setTotal_energy_3(float total_energy_3) {
		this.total_energy_3 = total_energy_3;
	}
	public int getWarning_sign_3() {
		return Warning_sign_3;
	}
	public void setWarning_sign_3(int warning_sign_3) {
		Warning_sign_3 = warning_sign_3;
	}
	public Date getRunning_time_3() {
		return Running_time_3;
	}
	public void setRunning_time_3(Date running_time_3) {
		Running_time_3 = running_time_3;
	}
	public int getRemote_switch_3() {
		return Remote_switch_3;
	}
	public void setRemote_switch_3(int remote_switch_3) {
		Remote_switch_3 = remote_switch_3;
	}
	public float getActive_Service_Rate1() {
		return Active_Service_Rate1;
	}
	public void setActive_Service_Rate1(float active_Service_Rate1) {
		Active_Service_Rate1 = active_Service_Rate1;
	}
	public float getActive_Service_Rate2() {
		return Active_Service_Rate2;
	}
	public void setActive_Service_Rate2(float active_Service_Rate2) {
		Active_Service_Rate2 = active_Service_Rate2;
	}
	public float getActive_Service_Rate3() {
		return Active_Service_Rate3;
	}
	public void setActive_Service_Rate3(float active_Service_Rate3) {
		Active_Service_Rate3 = active_Service_Rate3;
	}
	public float getPressure() {
		return pressure;
	}
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	public float getCumulative_flow() {
		return Cumulative_flow;
	}
	public void setCumulative_flow(float cumulative_flow) {
		Cumulative_flow = cumulative_flow;
	}
	@Override
	public String toString() {
		return "Data_master_table [dmt_id=" + dmt_id + ", VoltageA_1=" + VoltageA_1 + ", Electric_currentA_1="
				+ Electric_currentA_1 + ", Host_temperature_1=" + Host_temperature_1 + ", Coolant_temperature_1="
				+ Coolant_temperature_1 + ", Sump_Pressure_1=" + Sump_Pressure_1 + ", Loading_pressure_1="
				+ Loading_pressure_1 + ", Loading_time_1=" + Loading_time_1 + ", Unloading_pressure_1="
				+ Unloading_pressure_1 + ", Alarm_number_1=" + Alarm_number_1 + ", Exhaust_pressure_1="
				+ Exhaust_pressure_1 + ", Exhaust_temperature_1=" + Exhaust_temperature_1 + ", Control_state_1="
				+ Control_state_1 + ", total_energy_1=" + total_energy_1 + ", Warning_sign_1=" + Warning_sign_1
				+ ", Running_time_1=" + Running_time_1 + ", Remote_switch_1=" + Remote_switch_1 + ", VoltageA_2="
				+ VoltageA_2 + ", Electric_currentA_2=" + Electric_currentA_2 + ", Host_temperature_2="
				+ Host_temperature_2 + ", Coolant_temperature_2=" + Coolant_temperature_2 + ", Sump_Pressure_2="
				+ Sump_Pressure_2 + ", Loading_pressure_2=" + Loading_pressure_2 + ", Loading_time_2=" + Loading_time_2
				+ ", Unloading_pressure_2=" + Unloading_pressure_2 + ", Alarm_number_2=" + Alarm_number_2
				+ ", Exhaust_pressure_2=" + Exhaust_pressure_2 + ", Exhaust_temperature_2=" + Exhaust_temperature_2
				+ ", Control_state_2=" + Control_state_2 + ", total_energy_2=" + total_energy_2 + ", Warning_sign_2="
				+ Warning_sign_2 + ", Running_time_2=" + Running_time_2 + ", Remote_switch_2=" + Remote_switch_2
				+ ", VoltageA_3=" + VoltageA_3 + ", Electric_currentA_3=" + Electric_currentA_3
				+ ", Host_temperature_3=" + Host_temperature_3 + ", Coolant_temperature_3=" + Coolant_temperature_3
				+ ", Sump_Pressure_3=" + Sump_Pressure_3 + ", Loading_pressure_3=" + Loading_pressure_3
				+ ", Loading_time_3=" + Loading_time_3 + ", Unloading_pressure_3=" + Unloading_pressure_3
				+ ", Alarm_number_3=" + Alarm_number_3 + ", Exhaust_pressure_3=" + Exhaust_pressure_3
				+ ", Exhaust_temperature_3=" + Exhaust_temperature_3 + ", Control_state_3=" + Control_state_3
				+ ", total_energy_3=" + total_energy_3 + ", Warning_sign_3=" + Warning_sign_3 + ", Running_time_3="
				+ Running_time_3 + ", Remote_switch_3=" + Remote_switch_3 + ", Active_Service_Rate1="
				+ Active_Service_Rate1 + ", Active_Service_Rate2=" + Active_Service_Rate2 + ", Active_Service_Rate3="
				+ Active_Service_Rate3 + ", pressure=" + pressure + ", Cumulative_flow=" + Cumulative_flow + "]";
	}
	
}
