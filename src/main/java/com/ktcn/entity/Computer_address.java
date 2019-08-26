package com.ktcn.entity;

import lombok.Data;

@Data
public class Computer_address {
	private int Id;              // 主键
	private String IP;           // KEPServer所在的电脑IP
	private String region;       // KEPServer所在的域
	private String com_uname;    // KEPServer所在电脑的用户名
	private String com_pwd;      // KEPServer所在电脑的电脑密码
	private String KEPServerId;  // KEPServer在电脑中的注册表ID
	private String content;      // 描述此条数据所拥有的PLC下有什么机器
}
