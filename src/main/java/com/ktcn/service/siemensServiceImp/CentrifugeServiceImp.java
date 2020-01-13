package com.ktcn.service.siemensServiceImp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktcn.dao.siemensdao.CentrifugeDao;
import com.ktcn.entity.siemensentity.CentriFuge;
import com.ktcn.service.siemensService.CentrifugeService;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月2日 下午3:28:30
* 类说明  离心机获取数据类
*/
@Service
public class CentrifugeServiceImp implements CentrifugeService {
	
	@Autowired
	CentrifugeDao centrifugeDao;
	
	@Autowired
	CentriFuge centrifuge;
	
	@Override
	public void setCentrifugeData(ArrayList<Float> centrifugeData) {
		// TODO Auto-generated method stub
		//持久化到离心机1
		centrifuge.setLXJ5(centrifugeData.get(0));
		centrifuge.setLXJ7(centrifugeData.get(0));
		centrifuge.setLXJ8(centrifugeData.get(0));
		centrifuge.setLXJ9(centrifugeData.get(0));
		centrifuge.setLXJ10(centrifugeData.get(0));
		centrifuge.setLXJ11(centrifugeData.get(0));
		centrifuge.setLXJ14(centrifugeData.get(0));
		centrifuge.setLXJ15(centrifugeData.get(0));
		centrifuge.setLXJ16(centrifugeData.get(0));
		centrifuge.setLXJ17(centrifugeData.get(0));
		centrifuge.setLXJ18(centrifugeData.get(0));
		centrifuge.setLXJ19(centrifugeData.get(0));
		centrifuge.setLXJ20(centrifugeData.get(0));
		centrifuge.setLXJ21(centrifugeData.get(0));
		centrifuge.setLXJ22(centrifugeData.get(0));
		centrifuge.setLXJ23(centrifugeData.get(0));
		centrifuge.setCentrifuge_name("离心机1");
		centrifugeDao.setsetCentrifugeData(centrifuge);
	}
	
	
}
