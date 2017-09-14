package de.codecentric.cvgenerator;


import de.nixosoft.jlr.*;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class CV {
	
	private Employee employee;
	
	public CV(Employee employee) {
		this.employee = employee;
	}
	
	/**
	 * Render this CV as PDF file.
	 * @param out
	 */
	public void render(OutputStream out) throws IOException {
		try (PDDocument doc = new PDDocument()) {
			PDPage page = new PDPage();
			doc.addPage(page);
			PDFont font = PDType1Font.HELVETICA;
			try (PDPageContentStream contents = new PDPageContentStream(doc, page)) {
				contents.beginText();
				contents.setFont(font, 12);
				contents.newLineAtOffset(100, 700);
				contents.showText(employee.getFirstname());
				contents.endText();
			}
			doc.save(out);
		}
	}

}
