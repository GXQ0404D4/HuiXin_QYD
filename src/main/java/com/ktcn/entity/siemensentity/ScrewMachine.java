package com.ktcn.entity.siemensentity;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2019年12月31日 上午10:29:02
* 类说明 screw machine   螺杆机
*/
@Data
@Component
public class ScrewMachine {

	private int id;
	private String ScrewMachine_name;//螺杆机名字
	private String LGJ0;   //控制状态  位地址，每一数据位代表不同意义，具体说明见下表1   R/W
	private String LGJ1;   //运行状态  位地址，每一数据位代表不同意义，具体说明见下表2    R
	private String LGJ2;   //报警信息  辅助设备报警  每一数据位代表不同意义，具体说明见下表3 R
	private Float LGJ3;    //排气压力                                                     R
	private Float LGJ4;    //排气温度                                                     R
	private Float LGJ5;    //主机压力                                                     R
	private Float LGJ6;    //主机温度                                                     R
	private Float LGJ7;    //电流                                                         R
	private Float LGJ8;    //2级排气压力                                                  R
	private Float LGJ9;    //2级排气温度                                                  R
	private Float LGJ10;   //2级主机压力                                                  R
	private Float LGJ11;   //2级主机温度                                                  R
	private Float LGJ12;   //进气口压力                                                   R
	private Float LGJ13;   //油滤压力                                                     R
	private Float LGJ14;   //运行时间                                                     R
	private Float LGJ15;   //加载时间                                                     R
	private Float LGJ16;   //电机启动次数                                                 R
	private Float LGJ17;   //齿轮箱油压                                                   R
	private Float LGJ18;   //空气过滤器差压                                               R
	private Float LGJ19;   //油过滤器差压                                                 R
	private Float LGJ20;   //驱动电机温度                                                 R
	private Float LGJ21;   //齿轮箱供油温度                                               R
	private Float LGJ22;   //冷却水进水温度                                               R
	private Float LGJ23;   //冷却水回水温度                                               R
	private Float LGJ24;   //后冷冷却温差                                                 R
	private Float LGJ25;   //运行频率                                                     R
	private Byte LGJ26;   //运行                                                         R
	private Byte LGJ27;   //加卸载                                                       R
	private Byte LGJ28;   //故障                                                         R
	private Date LGJ_time; //空压机时间
	private Date LGJ_datatime;//空压机数据时间
	private int state;//状态
}
