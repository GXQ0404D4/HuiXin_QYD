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

	@Insert("INSERT INTO peripheral_qt VALUES (NULL,#{newlyData.wwqt0},#{newlyData.wwqt1},#{newlyData.wwqt2},#{newlyData.wwqt3},#{newlyData.wwqt4},"
			+ "#{newlyData.wwqt5},#{newlyData.wwqt6},#{newlyData.wwqt7},#{newlyData.wwqt8},#{newlyData.wwqt9},NOW(),NOW())")
	void setNewlyData(@Param("newlyData") Peripheral_qt newlyData);

}
