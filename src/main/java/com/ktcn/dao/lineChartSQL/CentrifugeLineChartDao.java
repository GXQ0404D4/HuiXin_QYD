package com.ktcn.dao.lineChartSQL;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.siemensentity.CentriFuge;



/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月13日 上午9:05:25
* 类说明
*/
@Repository
@Mapper
public interface CentrifugeLineChartDao {

	@Select("SELECT LXJ8,LXJ9,LXJ10,LXJ16,LXJ17,LXJ18,LXJ19 FROM centrifuge_hour WHERE LXJ_time =CURDATE()")
	public  List<CentriFuge> getCentrifugeLineChartData();

}
