package com.inet_Banking.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadXL {
	@Test
	public void ReadDataXL() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Kande Naresh\\Desktop\\TESTCASE.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		int rowcount = sheet.getLastRowNum();
		int colmcount = sheet.getRow(0).getLastCellNum();

		for (int i = 0; i < rowcount; i++) {
			XSSFRow curntRow = sheet.getRow(i);

			for (int j = 0; j < colmcount; j++) {
				String cellValue = curntRow.getCell(j).toString();

				System.out.print("             " + cellValue);
			}
			System.out.println();
		}
	}

}
