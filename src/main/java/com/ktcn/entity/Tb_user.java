package com.ktcn.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/*
 * 用户表
 */
@Data
public class Tb_user {
	private int user_id;		// 主键
	private String account;		// 用户名_工号
	private String password;	// 密码
	private String name;		// 用户姓名
	private String sex;			// 性别
	private int age;			// 年龄
	private String phone;		// 联系电话
	private String user_name;	// 职位
	private String working_group;// 工组
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;	// 用户创建时间
	private int state;			// 状态码
	private int userPower;		// 权限码
}
