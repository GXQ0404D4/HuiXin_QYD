package com.ktcn.service;

import com.ktcn.entity.siemensentity.ControlValve;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月2日 下午4:23:51
* 类说明
*/

public interface ControlValveService {
	//持久化到调节阀数据表
	void setControlValueData(ControlValve controlValve);

}
