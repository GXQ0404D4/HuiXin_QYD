package com.ktcn.service.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ktcn.dao.MianNetworkDao;
import com.ktcn.entity.Mian_network;
import com.ktcn.service.MianNetworkService;
import com.ktcn.utils.Export;
/*
 * 总管网报表业务层实现类
 */
@Service
@Transactional
public class MianNetworkServiceImpl implements MianNetworkService {
	@Resource
	private MianNetworkDao mianNetworkDao;
	// 查询全部总管网信息
	@Override
	public List<Mian_network> findAll() {
		return mianNetworkDao.findAll();
	}
	// 查询全部电量报表信息
	@Override
	public List<Mian_network> findAllByTime(String current_timeA, String current_timeB) {
		return mianNetworkDao.findAllByTime(current_timeA,current_timeB);
	}
	/**
	 * 导出excel
	 * @param offlineQueryEntity
	 */
	public HSSFWorkbook downloadExcel(Mian_network isEntity) {
		try {
            //查询数据
		    List<Mian_network> query = this.findAll();
			//标题
			Map<String, String> column = new LinkedHashMap<String, String>();
			column.put("A1","id");
			column.put("A2","压力A");
			column.put("A3","压力B");
			column.put("A4","露点A");
			column.put("A5","露点B");
			column.put("A6","瞬时流量");
			column.put("A7","累计流量");
			column.put("A8","总功率");
			column.put("A9","总电量");
			column.put("A10","机器");
			column.put("A11","时间");
			//excel内容
		    List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
		    if(query!=null && !query.isEmpty()){
		    	
		    	for (Mian_network vo: query) {
		    		Map<String, Object> hashMap = new LinkedHashMap<String, Object>();
		    		hashMap.put("A1",vo.getId());
		    		hashMap.put("A2",vo.getPressureA());
		    		hashMap.put("A3",vo.getPressureB());
		    		hashMap.put("A4",vo.getLU_dianA());
		    		hashMap.put("A5",vo.getLU_dianB());
		    		hashMap.put("A6",vo.getInstantaneous_flow());
		    		hashMap.put("A7",vo.getCumulative_flow());
		    		hashMap.put("A8",vo.getTotal_power());
		    		hashMap.put("A9",vo.getTotal_electricity());
		    		hashMap.put("A10",vo.getMachine());
		    		hashMap.put("A11",vo.getCurrent_time());
		    		
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
