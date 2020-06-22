package com.ktcn.service.siemensService;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ktcn.entity.siemensentity.ScrewMachine;
/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月10日 上午10:58:28
* 类说明   空压机数据持久service层
*/

public interface ScrewMachine_service {

	//空压机实时数据持久化到数据库
	void setScrewMachineData(Map<String, ScrewMachine> dataMap);
    //空压机小时数据持久化到数据库
	void setScrewMachineDataHour(Map<String, ScrewMachine> dataMap);
    //空压机报警数据持久化到数据库
	void setBJScrewMachineData( ScrewMachine dataMap);
	//删除当前一个月时间之前的数据 实时数据库
	void deleteScrewMachineReamlData();

}
