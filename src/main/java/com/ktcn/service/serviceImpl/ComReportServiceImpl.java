package com.ktcn.service.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.ComReportDao;
import com.ktcn.entity.Compressor_report;
import com.ktcn.service.ComReportService;
import com.ktcn.utils.Export;
/*
 * 空压机报表业务层实现类
 */
@Service
@Transactional
public class ComReportServiceImpl implements ComReportService {
	@Resource
	private ComReportDao comReportDao;
	// 查询全部空压机报表信息
	@Override
	public List<Compressor_report> findAll() {
		return comReportDao.findAll();
	}
	// 根据时间区间查询空压机报表信息
	@Override
	public List<Compressor_report> findAllByTime(String current_timeA, String current_timeB) {
		return comReportDao.findAllByTime(current_timeA,current_timeB);
	}
	/**
	 * 导出excel
	 * @param offlineQueryEntity
	 */
	public HSSFWorkbook downloadExcel(Compressor_report isEntity) {
		try {
            //查询数据
		    List<Compressor_report> query = this.findAll();
			//标题
			Map<String, String> column = new LinkedHashMap<String, String>();
			column.put("A1","id");
			column.put("A2","正向有功总电能A");
			column.put("A3","正向有功总电能B");
			column.put("A4","正向有功总电能C");
			column.put("A5","运行时间A");
			column.put("A6","运行时间B");
			column.put("A7","运行时间C");
			column.put("A8","有功公率A");
			column.put("A9","有功公率B");
			column.put("A10","有功公率C");
			column.put("A11","状态");
			column.put("A12","时间");
			//excel内容
		    List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
		    if(query!=null && !query.isEmpty()){
		    	
		    	for (Compressor_report vo: query) {
		    		Map<String, Object> hashMap = new LinkedHashMap<String, Object>();
		    		hashMap.put("A1",vo.getAir_id());
		    		hashMap.put("A2",vo.getElectric_energy_A());
		    		hashMap.put("A3",vo.getElectric_energy_B());
		    		hashMap.put("A4",vo.getElectric_energy_C());
		    		hashMap.put("A5",vo.getRunning_time_A());
		    		hashMap.put("A6",vo.getRunning_time_B());
		    		hashMap.put("A7",vo.getRunning_time_C());
		    		hashMap.put("A8",vo.getActive_powerA());
		    		hashMap.put("A9",vo.getActive_powerB());
		    		hashMap.put("A10",vo.getActive_powerC());
		    		hashMap.put("A11",vo.getAir_state());
		    		hashMap.put("A12",vo.getAir_current_time());
		    		
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
