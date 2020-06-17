package com.ktcn.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月17日 下午3:40:37
* 类说明   外围报警数据表
*/
@Data
@Component
public class Peripheral_Alarm {

	private int id;
	private String pdjname;
	private Object pbj0;
	private Object pbj1;
	private Object pbj2;
	private Object pbj3;
	private Object pbj4;
	private Object pbj5;
	private Object pbj6;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date pdjtime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date pdjdatetime;
}
