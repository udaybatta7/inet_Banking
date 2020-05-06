package com.inet_Banking.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteXL {
	@Test
	public void WriteDataInXL() throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\Kande Naresh\\Desktop\\TESTCASE.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Writedata");
		XSSFRow row = sheet.createRow(4);
		XSSFCell cell = row.createCell(6);
		cell.setCellType(CellType.STRING);
		cell.setCellValue("i'm the boss");

		FileOutputStream fos = new FileOutputStream("C:\\Users\\Kande Naresh\\Desktop\\TESTCASE.xlsx");
		workbook.write(fos);
		fos.close();
		System.out.println("Data id entered sucessfully");
	}

}
