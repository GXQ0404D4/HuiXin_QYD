package com.ktcn.entity;

import java.util.Date;

import lombok.Data;

/*
 * 维保记录表
 */
@Data
public class Maintenance {
	private int id;				// 主键
	private Date mt_plan_time;	// 提交计划时间
	private Date mt_time;		// 完成维保时间
	private String mt_content;	// 维保内容
	private String mt_yiliu;	// 维保遗留问题
	private String mt_apply_man;// 申请人员
	private String mt_personnel;// 维保人员
	private String mt_num;		// 维保码
	private int mt_state;		// 机器状态
}
