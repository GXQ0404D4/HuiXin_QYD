package com.ktcn.entity.simensaddress;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月16日 上午11:42:23
* 类说明
*/

@Data
@Configuration
@Component
@ConfigurationProperties(prefix = "plc",ignoreInvalidFields = false)
@PropertySource("classpath:config/PlcRealAddress/monitoringpageC.properties")
public class Monitoring_AddressC {
//外围数据
	private String DATA0;
	private String DATA1;
	private String DATA2;
	private String DATA3;
	private String DATA4;
	private String DATA5;
	private String DATA6;
	private String DATA7;
	private String DATA8;
	private String DATA9;
	private String DATA10;
	private String DATA11;
	private String DATA12;
	private String DATA13;
	private String DATA14;
	private String DATA15;
	private String DATA16;
	private String DATA17;
	private String DATA18;
	private String DATA19;
	private String DATA20;
	private String DATA21;
	private String DATA22;
	private String DATA23;
	private String DATA24;
	private String DATA25;
	private String DATA26;
	private String DATA27;
	private String DATA28;
	private String DATA29;
	private String DATA30;
	private String DATA31;
	private String DATA32;
	private String DATA33;
	private String DATA34;
	private String DATA35;
	private String DATA36;
	private String DATA37;
	private String DATA38;
	private String DATA39;
	private String DATA40;
	private String DATA41;
	private String DATA42;
	private String DATA43;
	private String DATA44;
	private String DATA45;
	private String DATA46;
	private String DATA47;
	private String DATA48;
	private String DATA49;
	private String DATA50;
	private String DATA51;
	private String DATA52;
	private String DATA53;
	private String DATA54;
	private String DATA55;
	private String DATA56;
	private String DATA57;
	private String DATA58;
	private String DATA59;
	private String DATA60;
	private String DATA61;
	private String DATA62;
	private String DATA63;
//	五台空压机数据
	private String SMDATA1;
	private String SMDATA2;
	private String SMDATA3;
	private String SMDATA4;
	private String SMDATA5;
	private String SMDATA6;
	private String SMDATA7;
	private String SMDATA8;
	private String SMDATA9;
	private String SMDATA10;
	private String SMDATA11;
	private String SMDATA12;
	private String SMDATA13;
	private String SMDATA14;
	private String SMDATA15;
	private String SMDATA16;
	private String SMDATA17;
	private String SMDATA18;
	private String SMDATA19;
	private String SMDATA20;
	private String SMDATA21;
	private String SMDATA22;
	private String SMDATA23;
	private String SMDATA24;
	private String SMDATA25;
	private String SMDATA26;
	private String SMDATA27;
	private String SMDATA28;
	private String SMDATA29;
	private String SMDATA30;
	private String SMDATA31;
	private String SMDATA32;
	private String SMDATA33;
	private String SMDATA34;
	private String SMDATA35;
	private String SMDATA36;
	private String SMDATA37;
	private String SMDATA38;
	private String SMDATA39;
	private String SMDATA40;
	private String SMDATA41;
	private String SMDATA42;
	private String SMDATA43;
	private String SMDATA44;
	private String SMDATA45;
	private String SMDATA46;
	private String SMDATA47;
	private String SMDATA48;
	private String SMDATA49;
	private String SMDATA50;
	private String SMDATA51;
	private String SMDATA52;
	private String SMDATA53;
	private String SMDATA54;
	private String SMDATA55;
	private String SMDATA56;
	private String SMDATA57;
	private String SMDATA58;
	private String SMDATA59;
	private String SMDATA60;
//干燥机数据	
	private String DMDATA0;
	private String DMDATA1;
	private String DMDATA2;
	private String DMDATA3;
	private String DMDATA4;
	private String DMDATA5;
	private String DMDATA6;
	private String DMDATA7;
}
