package com.ojas.jpawebapplication.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.ojas.jpawebapplication.model.Employee;

public class ExcelGenerator {

	public static boolean excelReport(List<Employee> list) {

		HSSFWorkbook workbook = new HSSFWorkbook();
		boolean flag = false;
		try {
			FileOutputStream out = new FileOutputStream(new File(
					"D:/SpringBootMicroservices/JpaWebapplication/src/main/resources/employee.xlsx"));

			HSSFSheet sheet = workbook.createSheet("sheet1");

			int rownum = 0;
			for (Employee emp : list) {
				Row row = sheet.createRow(rownum++);

				Cell cell1 = row.createCell(0);
				Cell cell2 = row.createCell(1);
				Cell cell3 = row.createCell(2);
				Cell cell4 = row.createCell(3);

				cell1.setCellValue((Integer) emp.getEid());
				cell2.setCellValue((String) emp.getEname());
				cell3.setCellValue((String) emp.getEadd());
				cell4.setCellValue((Double) emp.getSalary());

			}

			try {
				workbook.write(out);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				out.close();
				flag = true;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Written successfully on disk.");
		return flag;

	}

}
