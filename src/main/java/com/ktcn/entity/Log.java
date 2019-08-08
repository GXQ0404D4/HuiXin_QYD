package com.ktcn.entity;

import java.util.Date;

/*
 * 日志表
 */
public class Log {
	private int id;				// 主键
	private int user_id;		// 操作人id
	private String user;		// 操作人
	private Date operTime;		// 操作时间
	private String operModel;	// 操作模块
	private String operName	;	// 操作功能
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Log(int id, int user_id, String user, Date operTime, String operModel, String operName) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.user = user;
		this.operTime = operTime;
		this.operModel = operModel;
		this.operName = operName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Date getOperTime() {
		return operTime;
	}
	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}
	public String getOperModel() {
		return operModel;
	}
	public void setOperModel(String operModel) {
		this.operModel = operModel;
	}
	public String getOperName() {
		return operName;
	}
	public void setOperName(String operName) {
		this.operName = operName;
	}
	@Override
	public String toString() {
		return "Log [id=" + id + ", user_id=" + user_id + ", user=" + user + ", operTime=" + operTime + ", operModel="
				+ operModel + ", operName=" + operName + "]";
	}
	
}
