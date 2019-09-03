package com.ktcn.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.aspect.SysLog;
import com.ktcn.entity.Mian_network;
import com.ktcn.service.MianNetworkService;

/*
 * 总管网报表控制层
 */
@RestController
public class MianNetworkController {
	@Resource
	private MianNetworkService mianNetworkService;
	// 查询全部总管网信息
	@RequestMapping("TotalReport")
	@SysLog(logModule = "总管网报表", logName = "查看全部")
	public List<Mian_network> TotalReport() {
		// 查询全部总管网信息
		List<Mian_network> network = mianNetworkService.findAll();
		return network;
	}
	// 按照时间区间查询电量报表信息
	@RequestMapping("TotalReport_time")
	@SysLog(logModule = "总管网报表", logName = "时间区间查询")
	public List<Mian_network> TotalReport_time(String current_timeA, String current_timeB) {
		// 查询全部电量报表信息
		List<Mian_network> network = mianNetworkService.findAllByTime(current_timeA,current_timeB);
		return network;
	}
	
	// Excel导出空压机报表数据
	@RequestMapping(value="TotalReport_export")
	@SysLog(logModule = "总管网报表", logName = "导出Excel")
	public void TotalReport_export(HttpServletRequest request,HttpServletResponse response,Mian_network isEntity){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append("总管网报表_");
		sbBuffer.append(format.format(new Date()));
		sbBuffer.append(".xls");
		String fileName =  sbBuffer.toString();
		
	    //excel 写入数据 service层 TODO 这个自己注入进来
	    HSSFWorkbook wb = mianNetworkService.downloadExcel(isEntity);
	    
	    this.setResponseHeader(response, fileName);
	    try {
            OutputStream os = response.getOutputStream();
	        wb.write(os);
	        os.flush();
	        os.close();
		} catch (IOException e) {
			//TODO 处理异常
		}
	}
    //发送响应流方法
    private void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                //TODO 处理异常
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            //TODO 处理异常
        }
    }
	
}
