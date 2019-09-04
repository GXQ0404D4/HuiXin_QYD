package com.ktcn.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
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
}
