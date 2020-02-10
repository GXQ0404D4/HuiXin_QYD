package com.ktcn.controller.reportController.yearReport;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.aspect.SysLog;
import com.ktcn.entity.siemensentity.FlowGauge;
import com.ktcn.service.reportService.yearReport.MainReportyService;
import com.ktcn.utils.PageReade;

/*
 * 总管网年报表控制层
 */
@RestController
public class MainReportyController {
	
	@Resource
	private MainReportyService mainReportyService;
	
	// 查看全部
	@RequestMapping("yfindAllmr")
	@SysLog(logModule = "总官网年报表", logName = "查看全部")
	public Map<String, Object> findAll(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			session.removeAttribute("TimeAmry");
			session.removeAttribute("TimeBmry");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return this.findEM("0", null, null, request);
	}

	// 查看电量报表数据
	@RequestMapping("yfindmr")
	@SysLog(logModule = "总官网年报表", logName = "条件查询")
	public Map<String, Object> findEM(String pageSize, String current_timeA, String current_timeB,
			HttpServletRequest request) {
		// 判断如果pageSize为NULL则pageSize为0
		if (pageSize == null) {
			pageSize = "1";
		}
		// 转换页数参数类型
		int i = Integer.parseInt(pageSize);
		// 获取session域对象
		HttpSession session = request.getSession();
		// 获取查询起始条数
		int x = 0;
		// 查询数据总条数
		int count = 0;
		// 获取总页数
		int countPage = 0;
		// 定义一个map集合用来保存返回值
		Map<String, Object> map = new HashMap<String, Object>();
		// 定义一个集合用来存入返回数据;
		List<FlowGauge> list = null;
		// 判断查询方式
		if ((current_timeA == null && current_timeB == null) || (current_timeA.equals("") && current_timeB.equals(""))) {
			if (session.getAttribute("TimeAmry") == null && session.getAttribute("TimeBmry") == null) {
				// 查询数据总条数
				count = mainReportyService.findTotal();
				// 获取总页数
				countPage = PageReade.getCountPage(count, 10);
				// 获取查询起始条数
				x = PageReade.getPageSize(i, count, 10);
				// 获取查询数据
				list = mainReportyService.findAllByIndex(x);
			} else {
				// 获取日期查询信息
				String a1 = (String) session.getAttribute("TimeAmry");
				String a2 = (String) session.getAttribute("TimeBmry");
				// 查询数据总条数
				count = mainReportyService.findCountByTime(a1, a2);
				// 获取总页数
				countPage = PageReade.getCountPage(count, 10);
				// 获取查询起始条数
				x = PageReade.getPageSize(i, count, 10);
				// 获取查询数据
				list = mainReportyService.findByTime(a1, a2, x);
			}
		} else {
			// 写入查询值
			session.setAttribute("TimeAmry", current_timeA);
			session.setAttribute("TimeBmry", current_timeB);
			// 查询数据总条数
			count = mainReportyService.findCountByTime(current_timeA, current_timeB);
			// 获取总页数
			countPage = PageReade.getCountPage(count, 10);
			// 获取查询起始条数
			x = PageReade.getPageSize(i, count, 10);
			// 获取查询数据
			list = mainReportyService.findByTime(current_timeA, current_timeB, x);
		}

		// 写入返回值
		map.put("code", "0000"); // 返回码
		map.put("message", "success"); // 操作提示
		map.put("totalpage", countPage); // 总页数
		map.put("totalmess", count); // 总条数
		map.put("pageSize", PageReade.getPageNum(i, count, 10)); // 当前页数
		map.put("data", list); // 查询内容
		return map;
	}

	// Excel导出_总管网年报表数据
	@RequestMapping(value = "yexport_mr")
	public void ElectricityReport_export(HttpServletRequest request, HttpServletResponse response,
			FlowGauge isEntity) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append("总管网年报表_");
		sbBuffer.append(format.format(new Date()));
		sbBuffer.append(".xls");
		String fileName = sbBuffer.toString();

		// excel 写入数据 service层 TODO 这个自己注入进来
		HSSFWorkbook wb = mainReportyService.downloadExcel(isEntity);

		this.setResponseHeader(response, fileName);
		try {
			OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (IOException e) {
			// TODO 处理异常
		}
	}

	// 发送响应流方法
	private void setResponseHeader(HttpServletResponse response, String fileName) {
		try {
			try {
				fileName = new String(fileName.getBytes(), "ISO8859-1");
			} catch (UnsupportedEncodingException e) {
				// TODO 处理异常
			}
			response.setContentType("application/octet-stream;charset=ISO8859-1");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
		} catch (Exception ex) {
			// TODO 处理异常
		}
	}
}