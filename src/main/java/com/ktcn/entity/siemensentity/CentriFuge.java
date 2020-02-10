package com.ktcn.entity.siemensentity;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2019年12月31日 上午9:15:08
* 类说明 centrifuge   离心机
*/
@Data
@Component
public class CentriFuge {
 
	private int id;
	private String centrifuge_name; //离心机名字
	private String LXJ0;	//位地址，每一数据位代表不同意义，具体说明见下表1  R/W
	private String LXJ1;	//位地址，每一数据位代表不同意义，具体说明见下表2  R
	private String LXJ2;	//每一数据位代表不同意义，具体说明见下表3          R
	private Float LXJ3;   //三级排气压力                                       R
	private Float LXJ4;   //三级排气温度                                       R
	private Float LXJ5;   //主机压力                                           R
	private Float LXJ6;   //主机温度                                           R
	private Float LXJ7;   //主机电流                                           R
	private Float LXJ8;   //IGV位置（打开）                                    R
	private Float LXJ9;   //BOV位置（关闭）                                    R
	private Float LXJ10;  //主电机轴承“DE”温度                                 R
	private Float LXJ11;  //主电机轴承“NDE”温度                                R
	private Float LXJ12;  //振动电机轴承的“DE”            R
	private Float LXJ13;  //振动电机轴承“NDE”            R
	private Float LXJ14;  //润滑油压（入口）                                   R
	private Float LXJ15;  //润滑油压（出口）                                   R
	private Float LXJ16;  //润滑油温                                           R
	private Float LXJ17;  //一级振动                                           R
	private Float LXJ18;  //二级振动                                           R
	private Float LXJ19;  //三级振动                                           R
	private Float LXJ20;  //电机定子温度U相                                    R
	private Float LXJ21;  //电机定子温度V相                                    R
	private Float LXJ22;  //电机定子温度W相                                    R
	private Float LXJ23;  //运行时间                                           R
	private Float LXJ24;  //加载时间                                           R
	private Float LXJ25;  //控制器运行时间                                     R
	private Float LXJ26;  //电机启动次数                                       R
	private Float LXJ27;  //空气过滤器差压                                     R
	private Float LXJ28;  //冷却水进水温度                                     R
	private Float LXJ29;  //冷却水回水温度                                     R
	private Float LXJ30;  //后冷冷却温差                                       R
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date LXJ_time;  //离心机时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date LXJ_datatime;  //离心机数据时间
	private int state;  //状态
}
