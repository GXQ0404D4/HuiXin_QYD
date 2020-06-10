package com.ktcn.service.siemensService;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ktcn.entity.siemensentity.ScrewMachine;
/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月10日 上午10:58:28
* 类说明
*/

public interface ScrewMachine_service {

	void setScrewMachineData(Map<String, ScrewMachine> dataMap);

	void setScrewMachineDataHour();

}
