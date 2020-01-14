package com.ktcn.service.lineChartService;

import java.util.List;
import java.util.Map;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月10日 下午4:43:07
* 类说明   曲线分析（折线图）service层  获取当天24小时数据
*/

public interface FlowGaugeLineChartService {

	Map<String, List> getFlowGaugeLineChartData();

}
