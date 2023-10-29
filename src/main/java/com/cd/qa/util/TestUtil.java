package com.cd.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	
	
	
	public static Object[][] dataSupplier(String sheetName) {		
			
		
		  File excelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\cd\\qa\\testdata\\WaterpikOnlineCreateAnAccountTestData.xlsx");
		  
		  try { 
			  fis = new FileInputStream(excelFile); 
			  }catch (FileNotFoundException e) {
				  e.printStackTrace(); }
		  
		  try { 
			  workbook = new XSSFWorkbook(fis); 
			  }catch (IOException e) {
				  e.printStackTrace(); }
		  
		  XSSFSheet sheet = workbook.getSheet(sheetName);
		  
		  int rownum = sheet.getLastRowNum(); 
		  int colnum = sheet.getRow(0).getLastCellNum();
		  
		  Object[][] data = new Object[rownum][colnum];
		  
		  for(int r=0; r<rownum; r++) { 
			  for(int c=0; c<colnum; c++) { 
				  data[r][c] = sheet.getRow(r+1).getCell(c).toString();
		  
		  }
		  
		  } return data;
		 
	}
		
			
}

