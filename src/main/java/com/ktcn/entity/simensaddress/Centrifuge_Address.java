package com.ktcn.entity.simensaddress;

import java.util.Date;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月9日 下午4:30:05
* 类说明 Properties 文件获取配置PLC地址
*/
@Data
@Configuration
@Component
@ConfigurationProperties(prefix = "centrifuge",ignoreInvalidFields = false)
@PropertySource("classpath:config/centrifuge.properties")
public class Centrifuge_Address {
	private String LXJ0;	//位地址，每一数据位代表不同意义，具体说明见下表1  R/W
	private String LXJ1;	//位地址，每一数据位代表不同意义，具体说明见下表2  R
	private String LXJ2;	//每一数据位代表不同意义，具体说明见下表3          R
	private String LXJ3;   //三级排气压力                                       R
	private String LXJ4;   //三级排气温度                                       R
	private String LXJ5;   //主机压力                                           R
	private String LXJ6;   //主机温度                                           R
	private String LXJ7;   //主机电流                                           R
	private String LXJ8;   //IGV位置（打开）                                    R
	private String LXJ9;   //BOV位置（关闭）                                    R
	private String LXJ10;  //主电机轴承“DE”温度                                 R
	private String LXJ11;  //主电机轴承“NDE”温度                                R
	private String LXJ12;  //振动电机轴承的“DE”            R
	private String LXJ13;  //振动电机轴承“NDE”            R
	private String LXJ14;  //润滑油压（入口）                                   R
	private String LXJ15;  //润滑油压（出口）                                   R
	private String LXJ16;  //润滑油温                                           R
	private String LXJ17;  //一级振动                                           R
	private String LXJ18;  //二级振动                                           R
	private String LXJ19;  //三级振动                                           R
	private String LXJ20;  //电机定子温度U相                                    R
	private String LXJ21;  //电机定子温度V相                                    R
	private String LXJ22;  //电机定子温度W相                                    R
	private String LXJ23;  //运行时间                                           R
	private String LXJ24;  //加载时间                                           R
	private String LXJ25;  //控制器运行时间                                     R
	private String LXJ26;  //电机启动次数                                       R
	private String LXJ27;  //空气过滤器差压                                     R
	private String LXJ28;  //冷却水进水温度                                     R
	private String LXJ29;  //冷却水回水温度                                     R
	private String LXJ30;  //后冷冷却温差                                       R
}
