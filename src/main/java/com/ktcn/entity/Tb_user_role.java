package com.ktcn.entity;
/*
 * 用户-角色关联表
 */
public class Tb_user_role {
	private int ur_id;		// 主键
	private int user_id;	// 用户id
	private int role_id;	// 角色id
	public Tb_user_role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tb_user_role(int ur_id, int user_id, int role_id) {
		super();
		this.ur_id = ur_id;
		this.user_id = user_id;
		this.role_id = role_id;
	}
	public int getUr_id() {
		return ur_id;
	}
	public void setUr_id(int ur_id) {
		this.ur_id = ur_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	@Override
	public String toString() {
		return "Tb_user_role [ur_id=" + ur_id + ", user_id=" + user_id + ", role_id=" + role_id + "]";
	}
	
}
