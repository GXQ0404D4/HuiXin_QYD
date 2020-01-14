package com.ktcn.service.lineChartServiceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktcn.dao.lineChartSQL.FlowGaugeLineChartDao;
import com.ktcn.service.lineChartService.FlowGaugeLineChartService;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月10日 下午4:43:31
* 类说明 流量计  曲线分析（折线图）serviceimp层  获取当天24小时数据
*/
@Service
public class FlowGaugeLineChartServiceImp implements FlowGaugeLineChartService{

	@Autowired
	FlowGaugeLineChartDao flowGaugeLineChartDao;
	
	@Override
	public Map<String, List> getFlowGaugeLineChartData() {
		// TODO Auto-generated method stub
		String LLJA= "制氧总管";
		String LLJB= "烧结总管";
		Map<String,List> map=new HashMap<String,List>();
		List<Float> fCData1 = flowGaugeLineChartDao.getFlowGaugeLineChartData(LLJA);
		List<Float> fCData2 = flowGaugeLineChartDao.getFlowGaugeLineChartData(LLJB);
		map.put("LLJ1", fCData1);
		map.put("LLJ2", fCData2);
		return map;
		
	}

}
