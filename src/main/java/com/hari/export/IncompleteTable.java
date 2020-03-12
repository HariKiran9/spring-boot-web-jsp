package com.hari.export;

import java.io.File;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

public class IncompleteTable {

	public static final String DEST = "./target/test/resources/sandbox/tables/incomplete_table.pdf";

	public static void main(String[] args) throws Exception {
		File file = new File(DEST);
		file.getParentFile().mkdirs();
		new IncompleteTable().manipulatePdf(DEST);
	}

	protected void manipulatePdf(String dest) throws Exception {
		PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
		Document doc = new Document(pdfDoc);

		Table table = new Table(5, true);

		for (int i = 0; i < 5; i++) {
			table.addHeaderCell(new Cell().setKeepTogether(true).add(new Paragraph("Header " + i)));
		}
		doc.add(table);

		for (int i = 0; i < 500; i++) {
			if (i % 5 == 0) {
				table.flush();
			}
			table.addCell(new Cell().setKeepTogether(true).add(new Paragraph("Test " + i).setMargins(0, 0, 0, 0)));
		}
		table.complete();
		doc.close();
	}

}
