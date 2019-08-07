package com.ktcn.entity;
/**
 * 
 * @author Administrator
 *  1、流量计
	2、电表
	3、空压机
	4、冷干机
	5、变频
	attribute这个是读写属性，1为写；0为读
 */
public class Data_form {
	private int id;           // 主键
	private String name;      // 名称
	private String address;   // 地址
	private String explain;   // 说明
	private int type;         // 种类
	private int attribute;    // 读写属性
	public Data_form() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Data_form(int id, String name, String address, String explain, int type, int attribute) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.explain = explain;
		this.type = type;
		this.attribute = attribute;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getAttribute() {
		return attribute;
	}
	public void setAttribute(int attribute) {
		this.attribute = attribute;
	}
	@Override
	public String toString() {
		return "Data_form [id=" + id + ", name=" + name + ", address=" + address + ", explain=" + explain + ", type="
				+ type + ", attribute=" + attribute + "]";
	}
	
	
}
