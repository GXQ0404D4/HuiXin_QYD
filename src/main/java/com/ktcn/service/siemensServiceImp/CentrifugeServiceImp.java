package com.ktcn.service.siemensServiceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ktcn.dao.siemensdao.CentrifugeDao;
import com.ktcn.entity.siemensentity.CentriFuge;
import com.ktcn.service.siemensService.CentrifugeService;

/**
 * @author 作者 :Runaway programmer
 * @version 创建时间：2020年1月2日 下午3:28:30 类说明 离心机获取数据类
 */
@Service
public class CentrifugeServiceImp implements CentrifugeService {

	@Autowired
	CentrifugeDao centrifugeDao;

	@Autowired
	CentriFuge centrifuge;
	
	ArrayList<Float> listdata;

	@Override
	public void setCentrifugeData(ArrayList<Float> centrifugeData) {
		// TODO Auto-generated method stub
		listdata = centrifugeData;

		// 持久化到离心机1
		centrifuge.setLXJ5(centrifugeData.get(0));
		centrifuge.setLXJ7(centrifugeData.get(1));
		centrifuge.setLXJ8(centrifugeData.get(2));
		centrifuge.setLXJ9(centrifugeData.get(3));
		centrifuge.setLXJ10(centrifugeData.get(4));
		centrifuge.setLXJ11(centrifugeData.get(5));
		centrifuge.setLXJ14(centrifugeData.get(6));
		centrifuge.setLXJ15(centrifugeData.get(7));
		centrifuge.setLXJ16(centrifugeData.get(8));
		centrifuge.setLXJ17(centrifugeData.get(9));
		centrifuge.setLXJ18(centrifugeData.get(10));
		centrifuge.setLXJ19(centrifugeData.get(11));
		centrifuge.setLXJ20(centrifugeData.get(12));
		centrifuge.setLXJ21(centrifugeData.get(13));
		centrifuge.setLXJ22(centrifugeData.get(14));
		centrifuge.setCentrifuge_name("离心机1");
		centrifugeDao.setsetCentrifugeData(centrifuge);
	}

//	@Scheduled(cron = "0/1 * * * * ?")
	@Scheduled(cron = "0 0 * * * ?")
	public void setCentrifugeDataHour() {
		// 持久化到离心机1 小时数据
		try {
			centrifuge.setLXJ5(listdata.get(0));
			centrifuge.setLXJ7(listdata.get(1));
			centrifuge.setLXJ8(listdata.get(2));
			centrifuge.setLXJ9(listdata.get(3));
			centrifuge.setLXJ10(listdata.get(4));
			centrifuge.setLXJ11(listdata.get(5));
			centrifuge.setLXJ14(listdata.get(6));
			centrifuge.setLXJ15(listdata.get(7));
			centrifuge.setLXJ16(listdata.get(8));
			centrifuge.setLXJ17(listdata.get(9));
			centrifuge.setLXJ18(listdata.get(10));
			centrifuge.setLXJ19(listdata.get(11));
			centrifuge.setLXJ20(listdata.get(12));
			centrifuge.setLXJ21(listdata.get(13));
			centrifuge.setLXJ22(listdata.get(14));
			centrifuge.setCentrifuge_name("离心机1");
			centrifugeDao.setsetCentrifugeDataHour(centrifuge);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//删除当前7天前的数据
//	@Scheduled(cron = "0 0 1 ? * L") //每周星期天凌晨1点执行一次
	@Scheduled(cron = "0 0 1 * * ?") //每天凌晨1点执行一次
	public void deleteCentrifugeData() {
		centrifugeDao.deleteCentrifugeData();
	}

}
