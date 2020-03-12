package com.hari.export;

import java.io.File;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

public class SimpleTable10 {

	public static final String DEST = "C:\\\\HK\\\\Examples\\\\spring-boot-web-jsp\\\\src\\\\main\\\\results\\\\chapter01\\simple_table10.pdf";

	public static void main(String[] args) throws Exception {
		File file = new File(DEST);
		file.getParentFile().mkdirs();
		new SimpleTable10().manipulatePdf(DEST);
	}

	protected void manipulatePdf(String dest) throws Exception {

		PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
		Document doc = new Document(pdfDoc);

		Table table = new Table(5);

		Cell sn = new Cell(2, 1);
		sn.add(new Paragraph("S/N"));
		sn.setBackgroundColor(ColorConstants.YELLOW);
		table.addCell(sn);

		Cell name = new Cell(1, 3);
		name.add(new Paragraph("Name"));
		name.setBackgroundColor(ColorConstants.CYAN);
		table.addCell(name);

		Cell age = new Cell(2, 1);
		age.add(new Paragraph("Age"));
		age.setBackgroundColor(ColorConstants.GRAY);
		table.addCell(age);

		Cell surname = new Cell();
		surname.add(new Paragraph("SURNAME"));
		surname.setBackgroundColor(ColorConstants.BLUE);
		table.addCell(surname);

		Cell firstname = new Cell();
		firstname.add(new Paragraph("FIRST NAME"));
		firstname.setBackgroundColor(ColorConstants.RED);
		table.addCell(firstname);

		Cell middlename = new Cell();
		middlename.add(new Paragraph("MIDDLE NAME"));
		middlename.setBackgroundColor(ColorConstants.GREEN);
		table.addCell(middlename);

		Cell f1 = new Cell();
		f1.add(new Paragraph("1"));
		f1.setBackgroundColor(ColorConstants.PINK);
		table.addCell(f1);

		Cell f2 = new Cell();
		f2.add(new Paragraph("James"));
		f2.setBackgroundColor(ColorConstants.MAGENTA);
		table.addCell(f2);

		Cell f3 = new Cell();
		f3.add(new Paragraph("Fish"));
		f3.setBackgroundColor(ColorConstants.ORANGE);
		table.addCell(f3);

		Cell f4 = new Cell();
		f4.add(new Paragraph("Stone"));
		f4.setBackgroundColor(ColorConstants.DARK_GRAY);
		table.addCell(f4);

		Cell f5 = new Cell();
		f5.add(new Paragraph("17"));
		f5.setBackgroundColor(ColorConstants.LIGHT_GRAY);

		Color headerBg = new DeviceRgb(0xA6, 0xCB, 0x0B);
		f5.setBackgroundColor(headerBg);

		table.addCell(f5);

		doc.add(table);
		doc.close();
	}

}
