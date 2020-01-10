package com.ktcn.service.siemens.serviceimp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ktcn.dao.siemensdao.AmmeterDao;
import com.ktcn.entity.siemensentity.Ammeter;
import com.ktcn.service.AmmeterService;

/**
 * @author 作者 :Runaway programmer
 * @version 创建时间：2020年1月2日 上午10:38:54 类说明
 */
@Component
@Service
public class AmmeterServiceImp implements AmmeterService {

	private final static String ammeter_1 = "烧结电表";
	private final static String ammeter_2 = "离心机电表";
	private final static String ammeter_3 = "空压机电表1";
	private final static String ammeter_4 = "空压机电表2";
	private final static String ammeter_5 = "空压机电表3";
	private final static String ammeter_6 = "空压机电表4";
	private final static String ammeter_7 = "空压机电表5";
	private final static String ammeter_8 = "空压机电表6";
	private final static String ammeter_9 = "空压机电表7";

	@Autowired
	Ammeter ammeter;
	@Autowired
	AmmeterDao ammeterDao;

	@SuppressWarnings("unchecked")
	@Override
	public void setAmmeterData(Map<String, List> dataMap) {
		final List<Float> DataList1 = dataMap.get("DataList1");
		final List<Float> DataList2 = dataMap.get("DataList2");
		final List<Float> DataList3 = dataMap.get("DataList3");
		final List<Float> DataList4 = dataMap.get("DataList4");
		final List<Float> DataList5 = dataMap.get("DataList5");
		final List<Float> DataList6 = dataMap.get("DataList6");
		final List<Float> DataList7 = dataMap.get("DataList7");
		final List<Float> DataList8 = dataMap.get("DataList8");
		final List<Float> DataList9 = dataMap.get("DataList9");
		// 持久化烧结电表
		ammeter.setDB9(DataList1.get(0));
		ammeter.setDB10(DataList1.get(1));
		ammeter.setDB11(DataList1.get(2));
		ammeter.setDB12(DataList1.get(3));
		ammeterDao.setAmmeterData(ammeter, ammeter_1);
		// 持久化离心机电表
		ammeter.setDB9(DataList2.get(0));
		ammeter.setDB10(DataList2.get(1));
		ammeter.setDB11(DataList2.get(2));
		ammeter.setDB12(DataList2.get(3));
		ammeterDao.setAmmeterData(ammeter, ammeter_2);
		// 持久化空压机电表1
		ammeter.setDB9(DataList3.get(0));
		ammeter.setDB10(DataList3.get(1));
		ammeter.setDB11(DataList3.get(2));
		ammeter.setDB12(DataList3.get(3));
		ammeterDao.setAmmeterData(ammeter, ammeter_3);
		// 持久化空压机电表2
		ammeter.setDB9(DataList4.get(0));
		ammeter.setDB10(DataList4.get(1));
		ammeter.setDB11(DataList4.get(2));
		ammeter.setDB12(DataList4.get(3));
		ammeterDao.setAmmeterData(ammeter, ammeter_4);
		// 持久化空压机电表3
		ammeter.setDB9(DataList5.get(0));
		ammeter.setDB10(DataList5.get(1));
		ammeter.setDB11(DataList5.get(2));
		ammeter.setDB12(DataList5.get(3));
		ammeterDao.setAmmeterData(ammeter, ammeter_5);
		// 持久化空压机电表4
		ammeter.setDB9(DataList6.get(0));
		ammeter.setDB10(DataList6.get(1));
		ammeter.setDB11(DataList6.get(2));
		ammeter.setDB12(DataList6.get(3));
		ammeterDao.setAmmeterData(ammeter, ammeter_6);
		// 持久化空压机电表5
		ammeter.setDB9(DataList7.get(0));
		ammeter.setDB10(DataList7.get(1));
		ammeter.setDB11(DataList7.get(2));
		ammeter.setDB12(DataList7.get(3));
		ammeterDao.setAmmeterData(ammeter, ammeter_7);
		// 持久化空压机电表6
		ammeter.setDB9(DataList8.get(0));
		ammeter.setDB10(DataList8.get(1));
		ammeter.setDB11(DataList8.get(2));
		ammeter.setDB12(DataList8.get(3));
		ammeterDao.setAmmeterData(ammeter, ammeter_8);
		// 持久化空压机电表7
		ammeter.setDB9(DataList9.get(0));
		ammeter.setDB10(DataList9.get(1));
		ammeter.setDB11(DataList9.get(2));
		ammeter.setDB12(DataList9.get(3));
		ammeterDao.setAmmeterData(ammeter, ammeter_9);
	}

}
