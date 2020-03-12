package com.hari.export;

import java.io.File;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

public class ColumnWidthExample {

	public static final String DEST = "C:/HK/Examples/spring-boot-web-jsp/src/main/results/chapter01/column_width_example.pdf";

	public static void main(String[] args) throws Exception {
		File file = new File(DEST);
		file.getParentFile().mkdirs();
		new ColumnWidthExample().manipulatePdf(DEST);
	}

	protected void manipulatePdf(String dest) throws Exception {
		// Initialize PDF writer
		PdfWriter writer = new PdfWriter(dest);
		PdfDocument pdfDoc = new PdfDocument(writer);

		pdfDoc.addEventHandler(PdfDocumentEvent.START_PAGE, new Header("The Strange Case of Dr. Jekyll and Mr. Hyde"));

		PageXofY event = new PageXofY(pdfDoc);
		pdfDoc.addEventHandler(PdfDocumentEvent.END_PAGE, event);

		// Note that it is not necessary to create new PageSize object,
		// but for testing reasons (connected to parallelization) we call constructor
		// here

		Document doc = new Document(pdfDoc, new PageSize(PageSize.A4).rotate());

		float[] columnWidths = { 1, 5, 5 };
		Table table = new Table(columnWidths);
//		table.setWidth(100);

		PdfFont f = PdfFontFactory.createFont(FontConstants.HELVETICA, "UTF-8");

		Cell cell = new Cell(1, 3).add(new Paragraph("This is a header")).setFont(f).setFontSize(13)
				.setFontColor(DeviceGray.WHITE).setBackgroundColor(DeviceGray.BLACK)
				.setTextAlignment(TextAlignment.CENTER);
		table.addHeaderCell(cell);

		for (int i = 0; i < 2; i++) {
			Cell[] headerFooter = new Cell[] {
					new Cell().setBackgroundColor(new DeviceGray(0.75f)).add(new Paragraph("#")),
					new Cell().setBackgroundColor(new DeviceGray(0.75f)).add(new Paragraph("Key")),
					new Cell().setBackgroundColor(new DeviceGray(0.75f)).add(new Paragraph("Value")) };

			for (Cell hfCell : headerFooter) {
				if (i == 0) {
					table.addHeaderCell(hfCell);
				} else {
					table.addFooterCell(hfCell);
				}
			} // for
		} // for

		int rowCounter = 0;
		for (int counter = 1; counter < 101; counter++) {
			String count = String.valueOf(counter);
			table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph(count)));
			table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph("key " + counter)));
			table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph("value " + counter)));
			rowCounter++;
			if (0 == rowCounter % 10) {
				pdfDoc.addNewPage();
				rowCounter = 0;
			}
		} // for

//		table.complete();
		event.writeTotal(pdfDoc);
		doc.add(table);
		doc.close();
//		pdfDoc.close();
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
