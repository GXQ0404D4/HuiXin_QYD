package com.ktcn.entity.AlarmEntity;

import java.util.Date;

import lombok.Data;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年2月20日 下午5:05:40
* 类说明
*/
@Data
public class AlarmInsert {

	private int id;
	private String alarm_name;
	private String alarm_pt;
	private String alarm_value;
	private Date am_date;
	private Date am_datetime;
	
}
