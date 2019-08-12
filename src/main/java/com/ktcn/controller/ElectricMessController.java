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

import com.ktcn.entity.Electric_massage;
import com.ktcn.service.ElectricMessService;

/*
 * 电量报表控制层
 */
@RestController
public class ElectricMessController {
	@Resource
	private ElectricMessService electricMessService;
	// 查询请求
	@RequestMapping("ElectricityReport")
	public List<Electric_massage> ElectricityReportt() {
		// 查询全部电量报表信息
		List<Electric_massage> electric = electricMessService.findAll();
		return electric;
	}
	// 按照时间区间查询电量报表信息
	@RequestMapping("ElectricityReport_time")
	public List<Electric_massage> ElectricityReport_time(String current_timeA, String current_timeB) {
		// 查询全部电量报表信息
		List<Electric_massage> electric = electricMessService.findAllByTime(current_timeA,current_timeB);
		return electric;
	}
	
	// Excel导出电量报表数据
	@RequestMapping(value="ElectricityReport_export")
	public void ElectricityReport_export(HttpServletRequest request,HttpServletResponse response,Electric_massage isEntity){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append("电量报表_");
		sbBuffer.append(format.format(new Date()));
		sbBuffer.append(".xls");
		String fileName =  sbBuffer.toString();
		
	    //excel 写入数据 service层 TODO 这个自己注入进来
	    HSSFWorkbook wb = electricMessService.downloadExcel(isEntity);
	    
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
