package com.ktcn.entity;

import lombok.Data;

/*
 * 角色-权限关联表
 */
@Data
public class Tb_role_resource {
	private int rr_id;		// 主键
	private int role_id;	// 角色id
	private int res_id;		// 权限id
}
