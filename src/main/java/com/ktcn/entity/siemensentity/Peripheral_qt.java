package com.ktcn.entity.siemensentity;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月9日 下午1:42:01
* 类说明    其他 点位
*/
@Data
@Component
public class Peripheral_qt {
	private Object WWQT0;   //低压端压力低
	private Object WWQT1;   //低压端压力高
	private Object WWQT2;   //低压端手自动
	private Object WWQT3;   //高压端压力低
	private Object WWQT4;   //高压端压力高
	private Object WWQT5;   //高压端手自动
	private Object WWQT6;   //通讯复位
	private Object WWQT7;   //变频频率反馈
	private Object WWQT8;   //低压机1变频
	private Object WWQT9;   //低压机2变频
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date QTdata;  
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date QTdatatime;

}
