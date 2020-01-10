package com.ktcn.service.lineChartServiceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktcn.dao.lineChartSQL.ControlValueLineChartDao;
import com.ktcn.entity.siemensentity.ControlValue;
import com.ktcn.service.lineChartService.ControlValueLineChartService;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月10日 下午3:12:09
* 类说明 类说明  调节阀(曲线分析) 折线图controller层
*/
@Service
public class ControlValueLineChartServiceImp implements ControlValueLineChartService{

	@Autowired
	ControlValueLineChartDao controlValueLineChartDao;
	private String TJFA="TJF5";
	private String TJFB="TJF6";
	@Override
	public Map<String, Object> getControlValueData() {
		Map <String,Object> map =new HashMap<String,Object>();
		// TODO Auto-generated method stub
		List<Float> cVData1 = controlValueLineChartDao.getControlValueData(TJFA);
		List<Float> cVData2 = controlValueLineChartDao.getControlValueData(TJFB);
		map.put("TJF5", cVData1);
		map.put("TJF6", cVData2);
		return map;

	}

	

}
