package com.hari.export;

import java.io.File;
import java.io.IOException;

import com.hari.export.ColumnWidthExample.Header;
import com.hari.export.ColumnWidthExample.PageXofY;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;

public class TableExample2 {

	public static final String DEST = "C:\\HK\\Examples\\spring-boot-web-jsp\\src\\main\\results\\chapter01\\image2.pdf";

	public static void main(String[] args) {
		try {
			File file = new File(DEST);
			file.getParentFile().mkdirs();
			new TableExample2().createPdf(DEST);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Cell getCell(int cm) {
		Cell cell = new Cell(1, cm);
		Paragraph p = new Paragraph(String.format("%smm", 10 * cm)).setFontSize(8);
		p.setTextAlignment(TextAlignment.CENTER);
		cell.add(p);
		return cell;
	}

	public void createPdf(String dest) throws IOException {

		// Initialize PDF writer
		PdfWriter writer = new PdfWriter(dest);

		// Initialize PDF document
		PdfDocument pdfDoc = new PdfDocument(writer);
		pdfDoc.addEventHandler(PdfDocumentEvent.START_PAGE, new Header("The Strange Case of Dr. Jekyll and Mr. Hyde"));

		PageXofY event = new PageXofY(pdfDoc);
		pdfDoc.addEventHandler(PdfDocumentEvent.END_PAGE, event);

		// Initialize document
		Document document = new Document(pdfDoc);

		float[] columnWidths = { 5, 5, 5 };
		Table table = new Table(6);
		table.setKeepTogether(true);
		document.add(table);
		int rowCounter = 0;
		for (int i = 0; i < 100; i++) {
			Cell cell1 = new Cell(1, 0);
			Paragraph paragraph = new Paragraph(String.valueOf(i + 1) + " ").setTextAlignment(TextAlignment.RIGHT);
			paragraph.setBorder(new SolidBorder(1));
			paragraph.setWidth(40);
			cell1.add(paragraph);

			PdfFont font1 = PdfFontFactory.createFont(FontConstants.HELVETICA, "UTF-8");
			cell1.setFont(font1);
			cell1.add(new Paragraph("Name :").add(" Sarvani").setTextAlignment(TextAlignment.LEFT));
			cell1.add(new Paragraph("Husband Name :").add("Bala Hari Kiran").setTextAlignment(TextAlignment.LEFT));
			cell1.add(new Paragraph("Door No :").add("2-22-310/154A/A-101").setTextAlignment(TextAlignment.LEFT));
			cell1.add(new Paragraph("Age :").add("40").add(" Gender : ").add("M").setTextAlignment(TextAlignment.LEFT));
			cell1.setFontSize(8);
			cell1.setBorderRight(Border.NO_BORDER);
			table.addCell(cell1);

			Cell cImage1 = new Cell();
			cImage1.add(new Paragraph("ZAF1827724").setTextAlignment(TextAlignment.RIGHT));
			cImage1.setFontSize(8);
			ImageData iData = ImageDataFactory.create("C:\\HK\\Personal\\Photo.jpg");
			Image image = new Image(iData);
			image.setWidth(50);
			image.setHeight(50);
			image.setHorizontalAlignment(HorizontalAlignment.RIGHT);
			cImage1.add(image);
			cImage1.setBorderLeft(Border.NO_BORDER);
			table.addCell(cImage1);

			rowCounter = rowCounter + 1;
			if (rowCounter % 30 == 0) {
				System.out.println("index : " + i + " Row Counter : " + rowCounter);
				pdfDoc.addNewPage();
				rowCounter = 0;
			}
		} // for

//		document.add(new AreaBreak());

		Cell cell = new Cell().add(new Paragraph(" 1,1 "));
//		table.addCell(cell);

		cell = new Cell().add(new Paragraph(" 1,2 "));
//		table.addCell(cell);

		Cell cell23 = new Cell(2, 2).add(new Paragraph("multi 1,3 and 1,4"));
//		table.addCell(cell23);

		cell = new Cell().add(new Paragraph(" 2,1 "));
//		table.addCell(cell);

		cell = new Cell().add(new Paragraph(" 2,2 "));
//		table.addCell(cell);

		Cell cell2 = new Cell(1, 0);
		Paragraph paragraph2 = new Paragraph("S/N");
		paragraph2.setBorder(new SolidBorder(1));
		cell2.add(paragraph2);
		cell2.add(new Paragraph("Name :").add(" Sarvani").setTextAlignment(TextAlignment.LEFT));
		cell2.add(new Paragraph("Husband Name :").add("Bala Hari Kiran").setTextAlignment(TextAlignment.LEFT));
		cell2.add(new Paragraph("Door No :").add("2-22-310/154A/A-101, Elagans Pride, Addagutta, Hyderabad")
				.setTextAlignment(TextAlignment.LEFT));
		cell2.add(new Paragraph("Age :").add("40").add(" Gender : ").add("M").setTextAlignment(TextAlignment.LEFT));
		cell2.setFontSize(8);
		cell2.setBorderRight(Border.NO_BORDER);
		PdfFont font2 = PdfFontFactory.createFont(FontConstants.HELVETICA, "UTF-8");
		cell2.setFont(font2);
//		table.addCell(cell2);

		Cell cImage2 = new Cell();
		cImage2.add(new Paragraph("ZAF1827724").setTextAlignment(TextAlignment.RIGHT));
		cImage2.setFontSize(8);
		ImageData iData2 = ImageDataFactory.create("C:\\HK\\Personal\\Photo.jpg");
		Image image2 = new Image(iData2);
		image2.setWidth(25);
		image2.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		cImage2.add(image2);
		cImage2.setBorderLeft(Border.NO_BORDER);
//		table.addCell(cImage2);

		Cell cell3 = new Cell(1, 0);
		cell3.setBorderRight(Border.NO_BORDER);
		Paragraph paragraph3 = new Paragraph("S/N");
		paragraph3.setBorder(new SolidBorder(1));
		cell3.add(paragraph3);
		PdfFont font3 = PdfFontFactory.createFont(FontConstants.HELVETICA, "UTF-8");
		cell3.setFont(font3);
		cell3.add(new Paragraph("Name :").add(" Sarvani").setTextAlignment(TextAlignment.LEFT));
		cell3.add(new Paragraph("Husband Name :").add("Bala Hari Kiran").setTextAlignment(TextAlignment.LEFT));
		cell3.add(new Paragraph("Door No :").add("2-22-310/154A/A-101").setTextAlignment(TextAlignment.LEFT));
		cell3.add(new Paragraph("Age :").add("40").add(" Gender : ").add("M").setTextAlignment(TextAlignment.LEFT));
		cell3.setFontSize(8);
//		cell3.setBorderTop(new SolidBorder(ColorConstants.RED, 1));
//		cell3.setBorderBottom(new SolidBorder(ColorConstants.BLUE, 1));
//		table.addCell(cell3);

		Cell cImage3 = new Cell();
		cImage3.add(new Paragraph("ZAF1827724").setTextAlignment(TextAlignment.RIGHT));
		cImage3.setFontSize(8);
		ImageData iData3 = ImageDataFactory.create("C:\\HK\\Personal\\Photo.jpg");
		Image image3 = new Image(iData3);
		image3.setWidth(25);
		image3.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		image3.setBorder(new SolidBorder(1));
		cImage3.add(image3);
		cImage3.setBorderLeft(Border.NO_BORDER);
//		table.addCell(cImage3);

		table.complete();
		event.writeTotal(pdfDoc);
//		document.add(table);

		// Close document
		document.close();
	}

	// Header event handler
	protected class Header implements IEventHandler {

		String header;

		public Header(String header) {
			this.header = header;
		}

		@Override
		public void handleEvent(Event event) {
			// Retrieve document and
			PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
			PdfDocument pdf = docEvent.getDocument();
			PdfPage page = docEvent.getPage();
			Rectangle pageSize = page.getPageSize();
			PdfCanvas pdfCanvas = new PdfCanvas(page.getLastContentStream(), page.getResources(), pdf);
			Canvas canvas = new Canvas(pdfCanvas, pdf, pageSize);
			canvas.setFontSize(18f);
			// Write text at position
			canvas.showTextAligned(header, pageSize.getWidth() / 2, pageSize.getTop() - 30, TextAlignment.CENTER);
		}
	}

	protected class PageXofY implements IEventHandler {
		protected PdfFormXObject placeholder;
		protected float side = 20;
		protected float x = 300;
		protected float y = 25;
		protected float space = 4.5f;
		protected float descent = 3;

		public PageXofY() {
		}

		public PageXofY(PdfDocument pdf) {
			placeholder = new PdfFormXObject(new Rectangle(0, 0, side, side));
		}

		@Override
		public void handleEvent(Event event) {
			PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
			PdfDocument pdf = docEvent.getDocument();
			PdfPage page = docEvent.getPage();
			int pageNumber = pdf.getPageNumber(page);
			Rectangle pageSize = page.getPageSize();
			PdfCanvas pdfCanvas = new PdfCanvas(page.getLastContentStream(), page.getResources(), pdf);
			Canvas canvas = new Canvas(pdfCanvas, pdf, pageSize);
			Paragraph p = new Paragraph().add("Page ").add(String.valueOf(pageNumber)).add(" of");
			canvas.showTextAligned(p, x, y, TextAlignment.RIGHT);
			pdfCanvas.addXObject(placeholder, x + space, y - descent);
			pdfCanvas.release();
		}

		public void writeTotal(PdfDocument pdf) {
			System.out.println(" [writeTotal] " + pdf.getNumberOfPages());
			Canvas canvas = new Canvas(placeholder, pdf);
			canvas.showTextAligned(String.valueOf(pdf.getNumberOfPages()), 0, descent, TextAlignment.LEFT);
		}
	}

}
