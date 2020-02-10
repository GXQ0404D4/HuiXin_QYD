package com.ktcn.service.siemensServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ktcn.dao.siemensdao.FlowGaugeDao;
import com.ktcn.entity.siemensentity.FlowGauge;
import com.ktcn.service.siemensService.FlowGaugeService;

/**
 * @author 作者 :Runaway programmer
 * @version 创建时间：2020年1月2日 下午4:51:56 类说明 流量计 PLC 数据获取
 */
@Service
public class FlowGaugeServiceImp implements FlowGaugeService {
	@Autowired
	FlowGaugeDao flowGaugeDao;

	@Autowired
	FlowGauge flowGauge;

	List<Float> listdata1;

	@Override
	public void setFlowGaugeData(List<Float> flowGaugeData) {
		listdata1 = flowGaugeData;
		// 持久化到冷却剂 制氧总管数据表
		flowGauge.setFlowGauge_name("制氧总管");
		flowGauge.setLLJ2(flowGaugeData.get(0));
		flowGauge.setLLJ3(flowGaugeData.get(1));
		flowGauge.setLLJ4(flowGaugeData.get(2));
		flowGauge.setLLJ5(flowGaugeData.get(3));
		flowGaugeDao.setFlowGaugeData(flowGauge);
		// 持久化到冷却剂 烧结总管数据表
		flowGauge.setFlowGauge_name("烧结总管");
		flowGauge.setLLJ2(flowGaugeData.get(4));
		flowGauge.setLLJ3(flowGaugeData.get(5));
		flowGauge.setLLJ4(flowGaugeData.get(6));
		flowGauge.setLLJ5(flowGaugeData.get(7));
		flowGaugeDao.setFlowGaugeData(flowGauge);
		// TODO Auto-generated method stub

	}

//	@Scheduled(cron = "0/1 * * * * ?")
	@Scheduled(cron = "0 0 * * * ?")
	public void setFlowGaugeDataHour() {
		try {
			// 持久化到冷却剂 制氧总管数据表
			flowGauge.setFlowGauge_name("制氧总管");
			flowGauge.setLLJ2(listdata1.get(0));
			flowGauge.setLLJ3(listdata1.get(1));
			flowGauge.setLLJ4(listdata1.get(2));
			flowGauge.setLLJ5(listdata1.get(3));
			flowGaugeDao.setFlowGaugeDataHour(flowGauge);
			// 持久化到冷却剂 烧结总管数据表
			flowGauge.setFlowGauge_name("烧结总管");
			flowGauge.setLLJ2(listdata1.get(4));
			flowGauge.setLLJ3(listdata1.get(5));
			flowGauge.setLLJ4(listdata1.get(6));
			flowGauge.setLLJ5(listdata1.get(7));
			flowGaugeDao.setFlowGaugeDataHour(flowGauge);
			// TODO Auto-generated method stub
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
//定时删除周报表数据
//	@Scheduled(cron = "0 0 1 ? * L") //每周星期天凌晨1点执行一次
	@Scheduled(cron = "0 0 1 * * ?") //每天凌晨1点执行一次
	public void deleteFlowGaugeData() {
		flowGaugeDao.deleteFlowGaugeData();
	}

}
