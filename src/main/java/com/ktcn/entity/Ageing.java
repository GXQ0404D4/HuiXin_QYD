package com.ktcn.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * 系统运行时效类
 * @author Administrator
 *
 */
@Data
public class Ageing {
	private int id;			// 主键id
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date ageTime;	// 写入时间
}
