package com.ktcn.service.lineChartServiceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktcn.dao.lineChartSQL.ScrewMachineLineChartDao;
import com.ktcn.service.lineChartService.ScrewMachineLineChartService;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月13日 下午4:32:04
* 类说明
*/
@Service
public class ScrewMachineLineChartServiceImp implements ScrewMachineLineChartService{
	
	@Autowired
	ScrewMachineLineChartDao screwMachineLineChartDao;
	
	private final String LGJNAME1="烧结1变频";
	private final String LGJNAME2="烧结2变频";

	@Override
	public Map<String, List> getScrewMachineLineChartData() {
		// TODO Auto-generated method stub
		Map<String, List> mapdata=new HashMap<String, List>();
		List<Float> screwMachineLineChartData1 = screwMachineLineChartDao.getScrewMachineLineChartData(LGJNAME1);
		List<Float> screwMachineLineChartData2 = screwMachineLineChartDao.getScrewMachineLineChartData(LGJNAME2);
		mapdata.put("screwMachine1", screwMachineLineChartData1);
		mapdata.put("screwMachine2", screwMachineLineChartData2);
		return mapdata;
	}

}
