package com.ktcn.service.siemensService;

import org.springframework.stereotype.Service;

import com.ktcn.entity.siemensentity.ControlValue;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月10日 上午10:55:43
* 类说明
*/

public interface ControlValue_service {

	void setControlValueData(ControlValue CValue);

	void setControlValueDataHour(ControlValue CValue);

}
