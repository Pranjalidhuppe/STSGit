package com.example.demo.service;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Teacher;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
@Service
public class PdfGenerator {
	// list to hold all teacher data
	private List<Teacher> list;

	public PdfGenerator(List<Teacher> list) {
		this.list = list;
	}
	public PdfGenerator() {
		
	}

	public void exportpdf(List < Teacher > studentList,HttpServletResponse response) throws IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
	         
		
		document.open();
		
        Font font = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC);
        font.setSize(20);
        font.setColor(Color.BLACK);
        
        Paragraph pa = new Paragraph("list of Teachers",font);
        pa.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(pa);
        
        PdfPTable pTable = new PdfPTable(4);
        
        pTable.setWidthPercentage(100f);
        pTable.setWidths(new int[] {3,3,3,3});
        pTable.setSpacingBefore(5);
        
        
    	PdfPCell pc = new PdfPCell();
    	
		pc.setBackgroundColor(Color.DARK_GRAY);
		pc.setPadding(5);

		Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC);
		font.setColor(Color.white);

		pc.setPhrase(new Phrase("id", font));

		pTable.addCell(pc);

		pc.setPhrase(new Phrase("Name", font));
		
		pTable.addCell(pc);
		
		pc.setPhrase(new Phrase("Departent", font));
		
		pTable.addCell(pc);
		
		pc.setPhrase(new Phrase("salary", font));
		
		pTable.addCell(pc);
        
		
		for (Teacher t : list) {
			pTable.addCell(String.valueOf(t.getId()));
			pTable.addCell(t.getName());
			pTable.addCell(t.getDepartment());
			pTable.addCell(String.valueOf(t.getSalary()));
		}
		
        document.add(pTable);
        document.close();
	}

	
	
	
	
}
