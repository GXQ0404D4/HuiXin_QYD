package com.ktcn.pojo;

import java.sql.Date;

public class tb_user {
    private int user_id;      //id
    private String account;   //账号
    private String password;  //密码
    private String name;      //姓名
    private String sex;       //性别
    private int age;          //年龄
    private String phone;     //手机号
    private String user_name; //职位
    private String working_group;//工组
    private Date createTime;  //创建时间
    private int state;        //状态
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getWorking_group() {
		return working_group;
	}
	public void setWorking_group(String working_group) {
		this.working_group = working_group;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "tb_user [user_id=" + user_id + ", account=" + account + ", password=" + password + ", name=" + name
				+ ", sex=" + sex + ", age=" + age + ", phone=" + phone + ", user_name=" + user_name + ", working_group="
				+ working_group + ", createTime=" + createTime + ", state=" + state + "]";
	}
	public tb_user(int user_id, String account, String password, String name, String sex, int age, String phone,
			String user_name, String working_group, Date createTime, int state) {
		super();
		this.user_id = user_id;
		this.account = account;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.user_name = user_name;
		this.working_group = working_group;
		this.createTime = createTime;
		this.state = state;
	}
	public tb_user() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getLocked() {
		// TODO Auto-generated method stub
		return 0;
	}
	public byte[] getCredentialsSalt() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getRoleList() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}
