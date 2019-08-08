package com.ktcn.entity;

import java.util.Date;

/*
 * 故障记录表
 */
public class Error_recording {
	private int fault_id;			// 主键
	private Date time;				// 时间
	private String fault_machine;	// 故障机器
	private String fault_picture;	// 故障图片
	private String falut_people;	// 维修人员
	private Date Repair_time;		// 维修时间
	private String falut_summary;	// 故障总结
	private String falut_Reporter;	// 故障记录上报人员
	private int falut_state;		// 故障记录状态
	public Error_recording() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Error_recording(int fault_id, Date time, String fault_machine, String fault_picture, String falut_people,
			Date repair_time, String falut_summary, String falut_Reporter, int falut_state) {
		super();
		this.fault_id = fault_id;
		this.time = time;
		this.fault_machine = fault_machine;
		this.fault_picture = fault_picture;
		this.falut_people = falut_people;
		Repair_time = repair_time;
		this.falut_summary = falut_summary;
		this.falut_Reporter = falut_Reporter;
		this.falut_state = falut_state;
	}
	public int getFault_id() {
		return fault_id;
	}
	public void setFault_id(int fault_id) {
		this.fault_id = fault_id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getFault_machine() {
		return fault_machine;
	}
	public void setFault_machine(String fault_machine) {
		this.fault_machine = fault_machine;
	}
	public String getFault_picture() {
		return fault_picture;
	}
	public void setFault_picture(String fault_picture) {
		this.fault_picture = fault_picture;
	}
	public String getFalut_people() {
		return falut_people;
	}
	public void setFalut_people(String falut_people) {
		this.falut_people = falut_people;
	}
	public Date getRepair_time() {
		return Repair_time;
	}
	public void setRepair_time(Date repair_time) {
		Repair_time = repair_time;
	}
	public String getFalut_summary() {
		return falut_summary;
	}
	public void setFalut_summary(String falut_summary) {
		this.falut_summary = falut_summary;
	}
	public String getFalut_Reporter() {
		return falut_Reporter;
	}
	public void setFalut_Reporter(String falut_Reporter) {
		this.falut_Reporter = falut_Reporter;
	}
	public int getFalut_state() {
		return falut_state;
	}
	public void setFalut_state(int falut_state) {
		this.falut_state = falut_state;
	}
	@Override
	public String toString() {
		return "Error_recording [fault_id=" + fault_id + ", time=" + time + ", fault_machine=" + fault_machine
				+ ", fault_picture=" + fault_picture + ", falut_people=" + falut_people + ", Repair_time=" + Repair_time
				+ ", falut_summary=" + falut_summary + ", falut_Reporter=" + falut_Reporter + ", falut_state="
				+ falut_state + "]";
	}
	
}
