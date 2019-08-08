package com.ktcn.entity;
/*
 * 权限表
 */
public class Tb_resource {
	private int res_id;			// 主键
	private String res_name;	// 权限名
	private int pid;
	private String url;			// 路径
	private String permission;	// 权限内容
	public Tb_resource() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tb_resource(int res_id, String res_name, int pid, String url, String permission) {
		super();
		this.res_id = res_id;
		this.res_name = res_name;
		this.pid = pid;
		this.url = url;
		this.permission = permission;
	}
	public int getRes_id() {
		return res_id;
	}
	public void setRes_id(int res_id) {
		this.res_id = res_id;
	}
	public String getRes_name() {
		return res_name;
	}
	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "Tb_resource [res_id=" + res_id + ", res_name=" + res_name + ", pid=" + pid + ", url=" + url
				+ ", permission=" + permission + "]";
	}
	
}
