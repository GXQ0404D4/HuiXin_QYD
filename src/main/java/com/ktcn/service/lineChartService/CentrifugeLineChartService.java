package com.ktcn.service.lineChartService;

import java.util.List;
import java.util.Map;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月13日 上午9:05:49
* 类说明离心机 曲线分析（折线图）service层 获取当天24小时数据
*/

public interface CentrifugeLineChartService {

	Map<String, List> getCentrifugeLineChartData();

}
