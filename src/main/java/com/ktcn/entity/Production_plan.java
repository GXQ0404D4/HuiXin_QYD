package com.ktcn.entity;

import java.util.Date;

/*
 * 生产管理表
 */
public class Production_plan {
	private int id;				// 主键
	private Date pdt_time;		// 生产管理时间
	private String pdt_content;	// 生产管理内容
	private String pdt_people;	// 生产管理布置人
	private String pdt_Executor;// 生产管理执行人
	private int pdt_state;		// 状态
	private String pdt_report;	// 汇报内容
	private int op_state;		// 操作状态
	public Production_plan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Production_plan(int id, Date pdt_time, String pdt_content, String pdt_people, String pdt_Executor,
			int pdt_state, String pdt_report, int op_state) {
		super();
		this.id = id;
		this.pdt_time = pdt_time;
		this.pdt_content = pdt_content;
		this.pdt_people = pdt_people;
		this.pdt_Executor = pdt_Executor;
		this.pdt_state = pdt_state;
		this.pdt_report = pdt_report;
		this.op_state = op_state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getPdt_time() {
		return pdt_time;
	}
	public void setPdt_time(Date pdt_time) {
		this.pdt_time = pdt_time;
	}
	public String getPdt_content() {
		return pdt_content;
	}
	public void setPdt_content(String pdt_content) {
		this.pdt_content = pdt_content;
	}
	public String getPdt_people() {
		return pdt_people;
	}
	public void setPdt_people(String pdt_people) {
		this.pdt_people = pdt_people;
	}
	public String getPdt_Executor() {
		return pdt_Executor;
	}
	public void setPdt_Executor(String pdt_Executor) {
		this.pdt_Executor = pdt_Executor;
	}
	public int getPdt_state() {
		return pdt_state;
	}
	public void setPdt_state(int pdt_state) {
		this.pdt_state = pdt_state;
	}
	public String getPdt_report() {
		return pdt_report;
	}
	public void setPdt_report(String pdt_report) {
		this.pdt_report = pdt_report;
	}
	public int getOp_state() {
		return op_state;
	}
	public void setOp_state(int op_state) {
		this.op_state = op_state;
	}
	@Override
	public String toString() {
		return "Production_plan [id=" + id + ", pdt_time=" + pdt_time + ", pdt_content=" + pdt_content + ", pdt_people="
				+ pdt_people + ", pdt_Executor=" + pdt_Executor + ", pdt_state=" + pdt_state + ", pdt_report="
				+ pdt_report + ", op_state=" + op_state + "]";
	}
	
}
