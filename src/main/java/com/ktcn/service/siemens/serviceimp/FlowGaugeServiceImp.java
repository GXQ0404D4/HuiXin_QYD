package com.ktcn.service.siemens.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktcn.dao.siemensdao.FlowGaugeDao;
import com.ktcn.entity.siemensentity.FlowGauge;
import com.ktcn.service.FlowGaugeService;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月2日 下午4:51:56
* 类说明
*/
@Service
public class FlowGaugeServiceImp implements FlowGaugeService {
	@Autowired
	FlowGaugeDao flowGaugeDao;

	@Autowired
	FlowGauge flowGauge;
	@Override
	public void setFlowGaugeData(List<Float> flowGaugeData, List<Float> flowGaugeData1) {
		//持久化到冷却剂 制氧总管数据表
		flowGauge.setFlowGauge_name("制氧总管");
		flowGauge.setLLJ2(flowGaugeData.get(0));
		flowGauge.setLLJ3(flowGaugeData.get(1));
		flowGauge.setLLJ4(flowGaugeData.get(2));
		flowGauge.setLLJ5(flowGaugeData.get(3));
		flowGaugeDao.setFlowGaugeData(flowGauge);
		//持久化到冷却剂 烧结总管数据表
		flowGauge.setFlowGauge_name("烧结总管");
		flowGauge.setLLJ2(flowGaugeData1.get(0));
		flowGauge.setLLJ3(flowGaugeData1.get(1));
		flowGauge.setLLJ4(flowGaugeData1.get(2));
		flowGauge.setLLJ5(flowGaugeData1.get(3));
		flowGaugeDao.setFlowGaugeData(flowGauge);
		// TODO Auto-generated method stub
		
	}

}
