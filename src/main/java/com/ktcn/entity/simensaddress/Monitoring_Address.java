package com.ktcn.entity.simensaddress;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月9日 下午3:05:27
* 类说明  实时数据表
*/
@Data
@Configuration
@Component
@ConfigurationProperties(prefix = "plc",ignoreInvalidFields = false)
@PropertySource("classpath:config/PlcRealAddress/monitoringpage.properties")
public class Monitoring_Address {
	private String MD0;
	private String MD1;
	private String MD2;
	private String MD3;
	private String MD4;
	private String MD5;
	private String MD6;
	private String MD7;
	private String MD8;
	private String MD9;
	private String MD10;
	private String MD11;
	private String MD12;
	private String MD13;
	private String MD14;
	private String MD15;
	private String MD16;
	private String MD17;
	private String MD18;
	private String MD19;
	private String MD20;
	private String MD21;
	private String MD22;
	private String MD23;
	private String MD24;
	private String MD25;
	private String MD26;
	private String MD27;
	private String MD28;
	private String MD29;
	private String MD30;
	private String MD31;
	private String MD32;
	private String MD33;
	private String MD34;
	private String MD35;
	private String MD36;
	private String MD37;
	private String MD38;
	private String MD39;
	private String MD40;
	private String MD41;
	

}
