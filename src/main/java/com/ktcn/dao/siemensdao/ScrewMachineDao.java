package com.ktcn.dao.siemensdao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ktcn.entity.siemensentity.ScrewMachine;


/**
* @author 作者 :Runaway programmer
* @version 创建时间：2020年1月3日 上午9:28:07
* 类说明
*/
@Mapper
@Repository
public interface ScrewMachineDao {

	//空压机数据持久化到数据库
	@Insert("INSERT INTO screw_machine (LGJ26,LGJ27,LGJ28,LGJ_time,LGJ_datatime,state,ScrewMachine_name) VALUES"
			+ "(#{sm.LGJ26},#{sm.LGJ27},#{sm.LGJ28},NOW(),NOW(),1,#{sm.ScrewMachine_name})")
	void setScrewMachineData(@Param("sm") ScrewMachine sm);
	//烧结变频数据持久化到数据库
	@Insert("INSERT INTO screw_machine (LGJ5,LGJ6,LGJ25,LGJ26,LGJ27,LGJ_time,LGJ_datatime,state,ScrewMachine_name) VALUES"
			+ "(#{sm.LGJ5},#{sm.LGJ6},#{sm.LGJ25},#{sm.LGJ26},#{sm.LGJ27},NOW(),NOW(),1,#{sm.ScrewMachine_name})")
	void setScrewMachineData_1(@Param("sm") ScrewMachine sm);

}
