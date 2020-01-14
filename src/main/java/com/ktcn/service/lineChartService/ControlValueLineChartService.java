package com.ktcn.service.lineChartService;

import java.util.List;
import java.util.Map;

import com.ktcn.entity.siemensentity.ControlValue;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月10日 下午3:11:50
* 类说明 类说明 调节阀(曲线分析) 折线图service层  获取当天24小时数据
*/

public interface ControlValueLineChartService {
	
	public Map<String, Object> getControlValueData();

}
