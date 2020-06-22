package com.ktcn.service.siemensService;

import com.ktcn.entity.Peripheral_Alarm;
import com.ktcn.entity.siemensentity.Peripheral_entity;
import com.ktcn.entity.siemensentity.Peripheral_qt;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月10日 上午10:57:29
* 类说明  外围数据service
*/

public interface Peripheral_service {

	//外围实时数据持久化到数据库
	void setPeripheral_data(Peripheral_entity p_da);
	//外围小时数据持久化到数据库
	void setPeripheral_data_hour(Peripheral_entity p_da);
	//外围报警信息持久化到数据库
	void setBJPeripheral_data(Peripheral_Alarm pp_Alarm);
	//删除当前一个月之前的数据
	void deletePeripheralReamlData();

}
