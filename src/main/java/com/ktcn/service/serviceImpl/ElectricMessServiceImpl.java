package com.ktcn.service.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.ElectricMessDao;
import com.ktcn.entity.Electric_massage;
import com.ktcn.service.ElectricMessService;
import com.ktcn.utils.Export;
/*
 * 电量报表业务实现层
 */
@Service
@Transactional
public class ElectricMessServiceImpl implements ElectricMessService {

	@Resource
	private ElectricMessDao electricMessDao;
	// 查询全部电量报表信息
	@Override
	public List<Electric_massage> findAll() {
		return electricMessDao.findAll();
	}
	// 根据时间区间查询电量报表信息
	@Override
	public List<Electric_massage> findAllByTime(String current_timeA, String current_timeB) {
		return electricMessDao.findAllByTime(current_timeA,current_timeB);
	}
	/**
	 * 导出excel
	 * @param offlineQueryEntity
	 */
	public HSSFWorkbook downloadExcel(Electric_massage isEntity) {
		try {
            //查询数据
		    List<Electric_massage> query = this.findAll();
			//标题
			Map<String, String> column = new LinkedHashMap<String, String>();
			column.put("A1","id");
			column.put("A2","机器");
			column.put("A3","电压A");
			column.put("A4","电压B");
			column.put("A5","电压C");
			column.put("A6","电流A");
			column.put("A7","电流B");
			column.put("A8","电流C");
			column.put("A9","瞬时功率");
			column.put("A10","电量");
			column.put("A11","功率因数");
			column.put("A12","时间");
			//excel内容
		    List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
		    if(query!=null && !query.isEmpty()){
		    	
		    	for (Electric_massage vo: query) {
		    		Map<String, Object> hashMap = new LinkedHashMap<String, Object>();
		    		hashMap.put("A1",vo.getId());
		    		hashMap.put("A2",vo.getMachine());
		    		hashMap.put("A3",vo.getVoltageA());
		    		hashMap.put("A4",vo.getVoltageB());
		    		hashMap.put("A5",vo.getVoltageC());
		    		hashMap.put("A6",vo.getElectric_currentA());
		    		hashMap.put("A7",vo.getElectric_currentB());
		    		hashMap.put("A8",vo.getElectric_currentC());
		    		hashMap.put("A9",vo.getInstantaneous_power());
		    		hashMap.put("A10",vo.getElectric_quantity());
		    		hashMap.put("A11",vo.getPower_factor());
		    		hashMap.put("A12",vo.getCurrent_time());
		    		
		    		listResult.add(hashMap);
		    	}
		    }
			
            //去调用工具类的方法
			HSSFWorkbook wb = Export.getHSSFWorkbook(listResult, column);
			return wb;
		} catch (Exception e) {
			//TODO处理异常
		}
		return null;
	}
	
}
