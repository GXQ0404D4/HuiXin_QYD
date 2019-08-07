package com.ktcn.entity;

public class Computer_address {
	private int Id;              // 主键
	private String IP;           // KEPServer所在的电脑IP
	private String region;       // KEPServer所在的域
	private String com_uname;    // KEPServer所在电脑的用户名
	private String com_pwd;      // KEPServer所在电脑的电脑密码
	private String KEPServerId;  // KEPServer在电脑中的注册表ID
	private String content;      // 描述此条数据所拥有的PLC下有什么机器
	public Computer_address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Computer_address(int id, String iP, String region, String com_uname, String com_pwd, String kEPServerId,
			String content) {
		super();
		Id = id;
		IP = iP;
		this.region = region;
		this.com_uname = com_uname;
		this.com_pwd = com_pwd;
		KEPServerId = kEPServerId;
		this.content = content;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCom_uname() {
		return com_uname;
	}
	public void setCom_uname(String com_uname) {
		this.com_uname = com_uname;
	}
	public String getCom_pwd() {
		return com_pwd;
	}
	public void setCom_pwd(String com_pwd) {
		this.com_pwd = com_pwd;
	}
	public String getKEPServerId() {
		return KEPServerId;
	}
	public void setKEPServerId(String kEPServerId) {
		KEPServerId = kEPServerId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Computer_address [Id=" + Id + ", IP=" + IP + ", region=" + region + ", com_uname=" + com_uname
				+ ", com_pwd=" + com_pwd + ", KEPServerId=" + KEPServerId + ", content=" + content + "]";
	}
	
}
