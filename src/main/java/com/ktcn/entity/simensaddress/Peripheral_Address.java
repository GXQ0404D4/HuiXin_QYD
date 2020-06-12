package com.ktcn.entity.simensaddress;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月12日 下午3:56:05
* 类说明
*/
@Data
@Configuration
@Component
@ConfigurationProperties(prefix = "plc",ignoreInvalidFields = false)
@PropertySource("classpath:config/peripheral_data.properties")
public class Peripheral_Address {
	private String WW0;
	private String WW1;	
	private String WW2;	
	private String WW3;
	private String WW4;
	private String WW5;
	private String WW6;
	private String WW7;
	private String WW8;
	private String WW9;
	private String WW10;
	private String WW11;
	private String WW12;
	private String WW13;
	private String WW14;
	private String WW15;
	private String WW16;
	private String WW17;
	private String WW18;
	private String WW19;
	private String WW20;
	private String WW21;
	private String WW22;
	private String WW23;
	private String WW24;
	private String WW25;
	private String WW26;
	private String WW27;
	private String WW28;
	private String WW29;
	private String WW30;
	private String WW31;
	private String WW32;
	private String WW33;
	private String WW34;
	private String WW35;
	private String WW36;
	private String WW37;
	private String WW38;
	private String WW39;
	private String WW40;
	private String WW41;
	private String WW42;
	private String WW43;
	private String WW44;
	private String WW45;
	private String WW46;
	private String WW47;
	private String WW48;
	private String WW49;
	private String WW50;
	private String WW51;
	private String WW52;
	private String WW53;
	private String WW54;
	private String WW55;
	private String WW56;
	private String WW57;
	private String WW58;
	private String WW59;
	private String WW60;
	private String WW61;
	private String WW62;
	private String WW63;
	private String WW64;
	private String WW65;
	private String WW66;
	private String WW67;
	private String WW68;
	private String WW69;
	private String WW70;
	private String WW71;
	private String WW72;
	private String WW73;
	private String WW74;
	private String WW75;
	private String WW76;
	private String WW77;
	private String WW78;
	private String WW79;
	private String WW80;
	private String WW81;
	private String WW82;
	private String WW83;
	private String WW84;
	private String WW85;
	private String WW86;
	private String WW87;
	private String WW88;
	private String WW89;
	private String WW90;
	private String WW91;
	private String WW92;
	private String WW93;
	private String WW94;
	
	//QT数据
	private String WWQT0;
	private String WWQT1;
	private String WWQT2;
	private String WWQT3;
	private String WWQT4;
	private String WWQT5;
	private String WWQT6;
	private String WWQT7;
	private String WWQT8;
	private String WWQT9;

}
