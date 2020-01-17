package com.ktcn.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月17日 下午2:46:38
* 类说明 抄表模块 实体类
*/
@Component
@Data
public class Reading_Ammeter {

	private int id;
	private Float amDB1; //烧结电表
	private Float amDB2; //离心机电表
	private Float amDB3; //空压机电表1
	private Float amDB4; //空压机电表2
	private Float amDB5; //空压机电表3
	private Float amDB6; //空压机电表4
	private Float amDB7; //空压机电表5
	private Float amDB8; //空压机电表6
	private Float amDB9; //空压机电表7
	private Date amDB_time;
	private Date amDB_date;
}
