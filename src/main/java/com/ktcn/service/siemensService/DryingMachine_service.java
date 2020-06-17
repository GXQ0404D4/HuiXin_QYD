package com.ktcn.service.siemensService;

import com.ktcn.entity.siemensentity.DryingMachine;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月10日 上午10:56:24
* 类说明 干燥机数据操作
*/
public interface DryingMachine_service {

	//干燥机实时历史数据存储
	void setDryingMachineData(DryingMachine dryingMachine);

	//干燥机小时数据持久化到数据库
	void setDryingMachineDataHour(DryingMachine dryingMachine);

	//干燥机报警监测 持久化到数据库
	void setBJDryingMachineData(DryingMachine dryingMachine);

}
