package com.ktcn.entity.siemensentity;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
/**
* @author 作者 :Runaway programmer
* @version 创建时间：2019年12月31日 上午8:56:08
* 类说明  ammeter   电表
*/

@Data
@Component
public class Ammeter {
	
	private int id;
	private String ammeter_name;//电表名字
	private Float DB0;  //AB电压               R
	private Float DB1;  //BC电压               R
	private Float DB2;  //CA电压               R
	private Float DB3;  //A电流                R
	private Float DB4;  //B电流                R
	private Float DB5;  //C电流                R
	private Float DB6;  //正向有功功率         R
	private Float DB7;  //正向无功功率         R
	private Float DB8;  //功率因数             R
	private Float DB9;	//正向有功总电能       R
	private Float DB10;  //反向有功总电能      R
	private Float DB11;  //正向无功总电能      R
	private Float DB12;  //反向无功总电能      R
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date  DB_time;  //电表时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date  DB_datatime;  //电表数据时间
	private int state;  //状态
	

}
