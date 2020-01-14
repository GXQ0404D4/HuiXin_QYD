package com.ktcn.dao.lineChartSQL;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月13日 下午4:30:43
* 类说明  曲线分析 螺杆机（折线图）dao层数据获取
*/
@Mapper
@Repository
public interface ScrewMachineLineChartDao {

	@Select("SELECT LGJ25 FROM screw_machine_hour WHERE LGJ_time=CURDATE() and ScrewMachine_name=#{LGJname}")
	List<Float> getScrewMachineLineChartData(@Param("LGJname")String LGJname);

}
