package com.ktcn.service.lineChartServiceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktcn.dao.lineChartSQL.CentrifugeLineChartDao;
import com.ktcn.entity.siemensentity.CentriFuge;
import com.ktcn.service.lineChartService.CentrifugeLineChartService;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月13日 上午9:06:06
* 类说明 离心机 曲线分析（折线图）serviceimp层 获取当天24小时数据
*/
@Service
public class CentrifugeLineChartServiceImp implements CentrifugeLineChartService {

	@Autowired
	CentrifugeLineChartDao centrifugeLineChartDao;
	
	@Override
	public Map<String, List> getCentrifugeLineChartData() {
		// TODO Auto-generated method stub
		Map<String, List> datamap =new HashMap<String, List>();
		List<Float> listdata=new ArrayList<Float>();
		List<Float> listdata1=new ArrayList<Float>();
		List<Float> listdata2=new ArrayList<Float>();
		List<Float> listdata3=new ArrayList<Float>();
		List<Float> listdata4=new ArrayList<Float>();
		List<Float> listdata5=new ArrayList<Float>();
		List<Float> listdata6=new ArrayList<Float>();
		List<CentriFuge> cfLineChartData = centrifugeLineChartDao.getCentrifugeLineChartData();
        for (CentriFuge centriFuge : cfLineChartData) {
        	if (centriFuge !=null) {
        		listdata.add(centriFuge.getLXJ8());
        		listdata1.add(centriFuge.getLXJ9());
        		listdata2.add(centriFuge.getLXJ10());
        		listdata3.add(centriFuge.getLXJ16());
        		listdata4.add(centriFuge.getLXJ17());
        		listdata5.add(centriFuge.getLXJ18());
        		listdata6.add(centriFuge.getLXJ19());
			}
			
		}		
        datamap.put("LXJ8", listdata);
        datamap.put("LXJ9", listdata1);
        datamap.put("LXJ10", listdata2);
        datamap.put("LXJ16", listdata3);
        datamap.put("LXJ17", listdata4);
        datamap.put("LXJ18", listdata5);
        datamap.put("LXJ19", listdata6);
        
        System.out.println(datamap);
		return datamap;
	}

}
