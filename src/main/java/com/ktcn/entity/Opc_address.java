package com.ktcn.entity;

import lombok.Data;

/*
 * 通道，标记，设备的地址都是这个表(配置小黑盒)
 */
@Data
public class Opc_address {
	private int Id;					// 主键
	private String channel_name;	// 通道名称
	private String equipment_name;	// 设备名称
	private String tag_name;		// 标记名称
	private String type;			// 这个地址的数据类型，使用int值代表
	private String content;			// 描述这个地址做什么的
	private int state;				// 状态码
}
