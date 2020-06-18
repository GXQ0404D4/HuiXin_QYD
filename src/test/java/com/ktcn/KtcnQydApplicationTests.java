package com.ktcn;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KtcnQydApplicationTests {

	@Test
	public void contextLoads() throws IOException, RowsExceededException, WriteException {
//		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("1", "id");
//		map.put("2", "name");
//		map.put("3", "age");
//		for (int i = 0; i < 10000; i++) {			
//			list.add(map);
//		}
//		for (int j = 0; j < 2; j++) {
//			
//			File file = new File("e:/abc"+j+".xls");
//			
//			if (!file.exists()) {
//				file.createNewFile();
//			}
//			WritableWorkbook wr = Workbook.createWorkbook(file);
//			WritableSheet ws = wr.createSheet("test", 0);
//			
//			for (int i = 0; i < 100; i++) {			
//				Label lable1 = new Label(0,i,"id");
//				Label lable2 = new Label(1,i,"name");
//				Label lable3 = new Label(2,i,"age");
//				ws.addCell(lable1);
//				ws.addCell(lable2);
//				ws.addCell(lable3);
//			}
//			wr.write();
//			wr.close();
//		}
	}
	
}
