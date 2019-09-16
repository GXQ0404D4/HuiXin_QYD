package com.ktcn.entity;

import lombok.Data;

/**
 * 报警设置类
 * @author Administrator
 *
 */
@Data
public class Alarmseteings {
	private int ala_id;				// 序号
	private String position_name;   // 点位名
	private String describe;        // 描述
	private String measured_value;  // 实测值
	private String company;         // 单位
	private int ala_state;			// 状态
	private float upperlimit;      // 上限
	private float lowerlimit;      // 下限
	private float ULrange;         // 量程比例
	private float LLlimit;         // 量程零点
}
