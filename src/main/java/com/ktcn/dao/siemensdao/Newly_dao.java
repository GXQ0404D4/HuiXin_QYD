package com.ktcn.dao.siemensdao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.siemensentity.Peripheral_qt;

/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年6月10日 上午10:36:08
* 类说明  QT其他数据操作
*/

@Mapper
@Repository
public interface Newly_dao {

	@Insert("INSERT INTO peripheral_qt VALUES (NULL,#{newlyData.WWQT0},#{newlyData.WWQT1},#{newlyData.WWQT2},#{newlyData.WWQT3},#{newlyData.WWQT4},"
			+ "#{newlyData.WWQT5},#{newlyData.WWQT6},#{newlyData.WWQT7},#{newlyData.WWQT8},#{newlyData.WWQT9},NOW(),NOW())")
	void setNewlyData(@Param("newlyData") Peripheral_qt newlyData);

}
