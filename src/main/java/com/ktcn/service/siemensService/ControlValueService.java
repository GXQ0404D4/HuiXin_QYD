package com.ktcn.service.siemensService;

import com.ktcn.entity.siemensentity.ControlValue;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月2日 下午4:23:51
* 类说明 调节阀PLC 数据获取
*/

public interface ControlValueService {
	//持久化到调节阀数据表
	void setControlValueData(ControlValue controlValve);

}
