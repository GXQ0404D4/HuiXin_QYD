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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.entity.Compressor_report;
import com.ktcn.service.ComReportService;

/*
 * 空压机报表控制类
 */
@CrossOrigin
@RestController
public class ComReportController {
	@Resource
	private ComReportService comReportService;
	
	// 查询全部空压机报表数据
	@RequestMapping("CompressorReport")
	public List<Compressor_report> CompressorReport() {
		// 查询全部空压机报表信息
		List<Compressor_report> Cm_report = comReportService.findAll();
		return Cm_report;
	}
	
	// 按照时间区间查询空压机报表数据
	@RequestMapping("compressor_time")
	public List<Compressor_report> compressor_time(String current_timeA, String current_timeB){
		// 根据时间区间查询空压机报表信息
		List<Compressor_report> Cm_report = comReportService.findAllByTime(current_timeA,current_timeB);
		return Cm_report;
	}
	
	// Excel导出空压机报表数据
	@RequestMapping(value="compressor_export")
	public void compressor_export(HttpServletRequest request,HttpServletResponse response,Compressor_report isEntity){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append("空压机报表_");
		sbBuffer.append(format.format(new Date()));
		sbBuffer.append(".xls");
		String fileName =  sbBuffer.toString();
		
	    //excel 写入数据 service层 TODO 这个自己注入进来
	    HSSFWorkbook wb = comReportService.downloadExcel(isEntity);
	    
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
