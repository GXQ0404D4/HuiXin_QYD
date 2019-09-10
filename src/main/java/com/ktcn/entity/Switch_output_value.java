package com.ktcn.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
* @Title: Switch_output_value.java
* @Package com.ktcn.entity
* @Description: TODOswtich_output 采集数据存放类
* @author GXQ
* @date 2019年9月5日
* @version V1.0
*/
@Component
@ConfigurationProperties(prefix = "oss")
@Data
public class Switch_output_value {
	private Boolean s1;
	private Boolean s2;
	private Boolean s3;
	private Boolean s4;
	private Boolean s5;
	private Boolean s6;
	private Boolean s7;
	private Boolean s8;
	private Boolean s9;
	private Boolean s10;
	private Boolean s11;
	private Boolean s12;	
	private Boolean s13;	
	private Boolean s14;	
	private Boolean s15;	
	private Boolean s16;	
}
