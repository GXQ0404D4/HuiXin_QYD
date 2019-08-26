package com.ktcn.entity;

import lombok.Data;

/*
 * 用户-角色关联表
 */
@Data
public class Tb_user_role {
	private int ur_id;		// 主键
	private int user_id;	// 用户id
	private int role_id;	// 角色id
}
