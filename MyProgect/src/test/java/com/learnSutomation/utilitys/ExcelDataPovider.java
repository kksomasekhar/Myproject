package com.learnSutomation.utilitys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataPovider {

	XSSFWorkbook workBook;
	
	public ExcelDataPovider() throws IOException {
		
	
		
		File src = new File("/home/somasekhar/Desktop/Myproject/MyProgect/TestData/data.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			workBook = new XSSFWorkbook(fis);	
		}
		catch (Exception e) {
			System.out.println("unable to read excle file :"+ e.getMessage());
		}
		
	}
	
	public String getStringData(int sheetIndux, int row, int column) {
		
		return workBook.getSheetAt(sheetIndux).getRow(row).getCell(column).getStringCellValue();
			
	}
	
	public String getStringData(String sheetName, int row, int column) {
		
		return workBook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
			
	}
	
	public double getNumaricalData(String sheetName, int row, int column) {
		
		return workBook.getSheet(sheetName).getRow(0).getCell(0).getNumericCellValue();

	}
	
	
}
