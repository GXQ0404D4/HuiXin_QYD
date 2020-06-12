package com.ktcn.entity.simensaddress;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月11日 下午7:11:31
* 类说明
*/
@Data
@Configuration
@Component
@ConfigurationProperties(prefix = "plc",ignoreInvalidFields = false)
@PropertySource("classpath:config/PlcRealAddress/monitoringpageB.properties")
public class Monitoring_AddressB {
	
	private String QT0;
	private String QT1;
	private String QT2;
	private String QT3;
	private String QT4;
	private String QT5;
	private String QT6;
	private String QT7;
	private String QT8;
	private String QT9;
	private String QT10;
	private String QT11;
	private String QT12;

}
