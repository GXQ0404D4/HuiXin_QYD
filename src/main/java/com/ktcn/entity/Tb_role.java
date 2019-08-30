package com.ktcn.entity;

import lombok.Data;

/*
 * 角色表
 */
@Data
public class Tb_role {
	private int role_id;		// 主键
	private String role_name;	// 角色名
	private String role_desc;	// 角色说明
}
