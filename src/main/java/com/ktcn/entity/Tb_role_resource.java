package com.ktcn.entity;
/*
 * 角色-权限关联表
 */
public class Tb_role_resource {
	private int rr_id;		// 主键
	private int role_id;	// 角色id
	private int res_id;		// 权限id
	public Tb_role_resource() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tb_role_resource(int rr_id, int role_id, int res_id) {
		super();
		this.rr_id = rr_id;
		this.role_id = role_id;
		this.res_id = res_id;
	}
	public int getRr_id() {
		return rr_id;
	}
	public void setRr_id(int rr_id) {
		this.rr_id = rr_id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getRes_id() {
		return res_id;
	}
	public void setRes_id(int res_id) {
		this.res_id = res_id;
	}
	@Override
	public String toString() {
		return "Tb_role_resource [rr_id=" + rr_id + ", role_id=" + role_id + ", res_id=" + res_id + "]";
	}
	
}
