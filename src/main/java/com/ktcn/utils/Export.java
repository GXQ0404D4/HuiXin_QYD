package com.ktcn.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
 * 导出Excel工具类
 */
public class Export {
	
	private static final int PAGE_NUM = 65500;
	/**
	 * 非空判断
	 * @param obj
	 * @return
	 */
	 public static boolean isEmptyOrNull(Object obj){
	    	if(obj == null){
	    		return true;
	    	}
	    	if(obj instanceof Map){
	    		return ((Map) obj).isEmpty();
	    	}else if(obj instanceof List){
	    		return ((List) obj).isEmpty();
	    	}
	    	return obj.toString().isEmpty();
	  }
	
	
	/**
	 * 获取工作簿
	 * @param list
	 * @param columnMap
	 * @return
	 * @throws Exception
	 */
	public static HSSFWorkbook getHSSFWorkbook(List<Map<String,Object>> list, Map<String, String> columnMap){
		
		HSSFWorkbook wb = new HSSFWorkbook();
		//对集合进行非空判断
		if(isEmptyOrNull(list) || isEmptyOrNull(columnMap)){
			wb.createSheet();
			return wb;
		}
		
		int pageNum = PAGE_NUM;//每页数量
		int size = list.size();//数据数量
		int pages = (size % pageNum > 0) ? (size / pageNum + 1) : (size / pageNum);//导出页数
		
		HSSFCellStyle cs = null;//单元格样式
		HSSFSheet sheet = null;//页面
		HSSFFont font = wb.createFont();//字体
		
		font.setFontHeightInPoints((short) 11);//设置字号 
		cs = wb.createCellStyle();
		
		cs.setFont(font);
		cs.setFillPattern(HSSFCellStyle.FINE_DOTS);
		
		Set<String> keySet = columnMap.keySet();
		HSSFRow row = null;//单元格行
		Object columnvalue = null;
		String columnTitle = null;
		Map<String,Object> dataMap = null;
		
		for (int i = 0; i < pages; i++) {
			sheet = wb.createSheet();
			wb.setSheetName(i, (String.valueOf((i + 1))));
			row = sheet.createRow(0);
			for(String keyColumn : keySet){
				columnTitle = columnMap.get(keyColumn);
				createStringCell(row, (short) row.getLastCellNum() == -1 ? 0 : (short) row.getLastCellNum(), columnTitle, cs);
			}
			for(int j = 0; j < size; j++){
				dataMap = list.get(j);
				row = sheet.createRow(j + 1 - (pageNum * i));
				for(String keyColumn : keySet){
					columnvalue = dataMap.get(keyColumn);
					createStringCell(row, (short) row.getLastCellNum() == -1 ? 0 : (short) row.getLastCellNum(), columnvalue, cs);
				}
			}
		}
		return wb;
		
		
	}
	
	/**
	 * 创建单元格
	 * @param row
	 * @param index
	 * @param value
	 * @param cs
	 */
	private static void createStringCell(HSSFRow row, short index, Object value, HSSFCellStyle cs) {
		HSSFCell cell = row.createCell(index);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cs.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cs.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		if(!isEmptyOrNull(value) && value instanceof Date){
			value = doDate2String((Date)value);
		}
		cell.setCellValue(null2Empty(value));
	}
	
	
	/**
	 * 将日期转化为String
	 * @param confirmDate
	 * @param patten
	 * @return
	 */
	public static String doDate2String(Date confirmDate, String... patten) {
		if(confirmDate == null){
			return "";
		}
		SimpleDateFormat sdf = null;
		if(patten == null || patten.length == 0){
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}else{
			sdf = new SimpleDateFormat(patten[0]);
		}
		return sdf.format(new Date(confirmDate.getTime()));
	}
	
	/**
	 * 将null转化为Empty
	 * @param areaId
	 * @return
	 */
	public static String null2Empty(Object areaId) {
		return areaId == null ? "" : areaId.toString();
	}
}
