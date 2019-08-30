package com.ktcn.entity;

import lombok.Data;

/*
 * 权限表
 */
@Data
public class Tb_resource {
	private int res_id;			// 主键
	private String res_name;	// 权限名
	private int pid;
	private String url;			// 路径
	private String permission;	// 权限内容
}
