package com.ktcn.entity;
/*
 * 角色表
 */
public class Tb_role {
	private int role_id;		// 主键
	private String role_name;	// 角色名
	private String role_desc;	// 角色说明
	public Tb_role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tb_role(int role_id, String role_name, String role_desc) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_desc = role_desc;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_desc() {
		return role_desc;
	}
	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}
	@Override
	public String toString() {
		return "Tb_role [role_id=" + role_id + ", role_name=" + role_name + ", role_desc=" + role_desc + "]";
	}
	
}
