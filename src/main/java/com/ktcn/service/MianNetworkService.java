package com.ktcn.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ktcn.entity.Mian_network;

/*
 * 总管网报表业务层
 */
public interface MianNetworkService {
	// 查询全部总管网信息
	List<Mian_network> findAll();
	// 查询全部电量报表信息
	List<Mian_network> findAllByTime(String current_timeA, String current_timeB);
	// 导出Excel
	HSSFWorkbook downloadExcel(Mian_network isEntity);

}
