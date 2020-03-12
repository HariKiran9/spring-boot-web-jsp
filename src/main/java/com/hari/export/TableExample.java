package com.hari.export;

import java.io.File;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.Background;
import com.itextpdf.layout.renderer.CellRenderer;

public class TableExample {

	public static final String DEST = "C:\\HK\\Examples\\spring-boot-web-jsp\\src\\main\\results\\chapter01\\image.pdf";

	public static void main(String[] args) {

		try {
			File file = new File(DEST);
			file.getParentFile().mkdirs();

			// Initialize PDF writer
			PdfWriter writer = new PdfWriter(DEST);

			// Initialize PDF document
			PdfDocument pdf = new PdfDocument(writer);

			// Initialize document
			Document document = new Document(pdf);

//			document.open();

//			PdfPTable table = new PdfPTable(3); // 3 columns.

			

			Cell cell1 = new Cell(5, 2);
			CellRenderer cRender = new CellRenderer(cell1);
			cRender.setProperty(1, "Cell 1");
			


			ImageData iData = ImageDataFactory.create("C:\\HK\\Personal\\Photo.jpg");
			Image image = new Image(iData);
			image.scale(0.3f, 0.3f);
			cell1.add(image);
			
			Table table = new Table(1);
			table.setWidth(100);
			Style style = new Style();
			 
			table.addStyle(style);
			table.addCell(cell1);
			
			Paragraph para = new Paragraph();
			para.add(image);
			document.add(para);

			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
