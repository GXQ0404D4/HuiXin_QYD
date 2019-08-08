package com.ktcn.entity;

import java.util.Date;

/*
 * 维保记录表
 */
public class Maintenance {
	private int id;				// 主键
	private Date mt_plan_time;	// 提交计划时间
	private Date mt_time;		// 完成维保时间
	private String mt_content;	// 维保内容
	private String mt_yiliu;	// 维保遗留问题
	private String mt_apply_man;// 申请人员
	private String mt_personnel;// 维保人员
	private String mt_num;		// 维保码
	private int mt_state;		// 机器状态
	public Maintenance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Maintenance(int id, Date mt_plan_time, Date mt_time, String mt_content, String mt_yiliu, String mt_apply_man,
			String mt_personnel, String mt_num, int mt_state) {
		super();
		this.id = id;
		this.mt_plan_time = mt_plan_time;
		this.mt_time = mt_time;
		this.mt_content = mt_content;
		this.mt_yiliu = mt_yiliu;
		this.mt_apply_man = mt_apply_man;
		this.mt_personnel = mt_personnel;
		this.mt_num = mt_num;
		this.mt_state = mt_state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getMt_plan_time() {
		return mt_plan_time;
	}
	public void setMt_plan_time(Date mt_plan_time) {
		this.mt_plan_time = mt_plan_time;
	}
	public Date getMt_time() {
		return mt_time;
	}
	public void setMt_time(Date mt_time) {
		this.mt_time = mt_time;
	}
	public String getMt_content() {
		return mt_content;
	}
	public void setMt_content(String mt_content) {
		this.mt_content = mt_content;
	}
	public String getMt_yiliu() {
		return mt_yiliu;
	}
	public void setMt_yiliu(String mt_yiliu) {
		this.mt_yiliu = mt_yiliu;
	}
	public String getMt_apply_man() {
		return mt_apply_man;
	}
	public void setMt_apply_man(String mt_apply_man) {
		this.mt_apply_man = mt_apply_man;
	}
	public String getMt_personnel() {
		return mt_personnel;
	}
	public void setMt_personnel(String mt_personnel) {
		this.mt_personnel = mt_personnel;
	}
	public String getMt_num() {
		return mt_num;
	}
	public void setMt_num(String mt_num) {
		this.mt_num = mt_num;
	}
	public int getMt_state() {
		return mt_state;
	}
	public void setMt_state(int mt_state) {
		this.mt_state = mt_state;
	}
	@Override
	public String toString() {
		return "Maintenance [id=" + id + ", mt_plan_time=" + mt_plan_time + ", mt_time=" + mt_time + ", mt_content="
				+ mt_content + ", mt_yiliu=" + mt_yiliu + ", mt_apply_man=" + mt_apply_man + ", mt_personnel="
				+ mt_personnel + ", mt_num=" + mt_num + ", mt_state=" + mt_state + "]";
	}
	
}
