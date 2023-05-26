package com.ojas.jpawebapplication.config;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.ojas.jpawebapplication.model.Employee;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Stream;

public class PdfGeneration {

	public static String genetatePdf(List<Employee> list) {

		Document document = new Document();
		String pdf_file_path = null;
		Font font1 = FontFactory.getFont(FontFactory.COURIER, 8, BaseColor.BLACK);
		boolean isPdfGenerated = false;
		document.open();

		PdfPTable table = new PdfPTable(4);
		Stream.of("EID", "ENAME", "EADD", "SALARY").forEach(headerTitle -> {
			PdfPCell header = new PdfPCell();
			// Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setVerticalAlignment(Element.ALIGN_MIDDLE);
			header.setHorizontalAlignment(Element.ALIGN_CENTER);
			header.setBorderWidth(1);
			header.setPhrase(new Phrase(headerTitle, font1));
			table.addCell(header);
		});
		pdf_file_path = "D:\\SpringBootMicroservices\\JpaWebapplication\\src\\main\\resources\\employee.pdf";
		try {
			PdfWriter.getInstance(document, new FileOutputStream(pdf_file_path));
			document.open();

			for (Employee emp : list) {

				Font font = FontFactory.getFont(FontFactory.COURIER, 8, BaseColor.BLACK);
				PdfPCell bidCell = new PdfPCell(new Phrase(String.valueOf(emp.getEid()), font));
				bidCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				bidCell.setHorizontalAlignment(Element.ALIGN_CENTER);

				PdfPCell cnameCell = new PdfPCell(new Phrase(emp.getEname(), font));
				cnameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cnameCell.setHorizontalAlignment(Element.ALIGN_CENTER);

				PdfPCell caddCell = new PdfPCell(new Phrase(emp.getEadd(), font));
				caddCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				caddCell.setHorizontalAlignment(Element.ALIGN_CENTER);

				PdfPCell csalCell = new PdfPCell(new Phrase(String.valueOf(emp.getSalary()), font));
				csalCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				csalCell.setHorizontalAlignment(Element.ALIGN_CENTER);

				table.addCell(bidCell);
				table.addCell(cnameCell);
				table.addCell(caddCell);
				table.addCell(csalCell);

			}
			table.setWidthPercentage(100);
			document.add(table);
			isPdfGenerated = true;
			System.out.println("Pdf Created");
			document.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pdf_file_path;

	}

}
