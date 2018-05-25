/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.generator;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author diary
 */
public class FactureGenerator {

    
    private static final Font boltTableFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
    private static final Font normalBoldTableFont = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD);
    private static final Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL);
    private static final Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD);
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);

    private static Font header = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD, GrayColor.BLACK);
    private static Font redFont = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font bold = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);

    private static Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
    private static Font extraSmallFont = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.BOLD);
    private static Font smallFontBold = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD);

    public static void main(String[] arg) throws Exception {
//        Test test = new Test();
        FactureGenerator g = new FactureGenerator();
    }

    public FactureGenerator() throws Exception {
        
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/Projet/location/pdfTest/facture.pdf"));
        document.open();
        addMetaData(document);
        addContent(document,writer);
        document.close();
    }

    // iText allows to add metadata to the PDF which can be viewed in your Adobe
    // Reader
    // under File -> Properties
    private static void addMetaData(Document document) {
        document.addTitle("Facture_generator");
        document.addSubject("Facturation");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Location System");
        document.addCreator("Location System");
    }

    private void addContent(Document document,PdfWriter writer) throws DocumentException, BadElementException, IOException, Exception {
        Paragraph information = new Paragraph();

        
        document.add(information);

        information = new Paragraph();
        information.add(new Phrase("Lot 101 G 133 B 123", normalFont));
        addEmptyLine(information, 1);
        information.add(new Phrase("101 Antananarivo MADAGASCAR", normalFont));
        information.setAlignment(Element.ALIGN_RIGHT);
        document.add(information);

        information = new Paragraph();
        addEmptyLine(information, 2);
        
        information.add(new Phrase("Object : Faturation N� FAC0000001",boldFont));
        addEmptyLine(information,2);
            
       
       
        document.add(information);

        PdfPTable table;
        table = new PdfPTable(4);

        table.setWidthPercentage(100);

        table.setWidths(new float[]{5, 2, 2, 2});

        PdfPCell c1;

//        BaseColor myColorpan = WebColors.getRGBColor("#BDBDBD");
        c1 = new PdfPCell(new Phrase("DESIGNATION", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        c1.setBackgroundColor(myColorpan);
        c1.setPadding(5);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("QUANTITE", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);    
//        c1.setBackgroundColor(myColorpan);
        c1.setPadding(5);
        table.addCell(c1);
        

        c1 = new PdfPCell(new Phrase("P.U", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        c1.setBackgroundColor(myColorpan);
        c1.setPadding(5);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("MONTANT", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        c1.setBackgroundColor(myColorpan);
        c1.setPadding(5);
        table.addCell(c1);
//        List<TacheModel> taches; 
//        taches = offre.getTacheinitials().getTravaux();
        for (int i = 0; i < 4; i++) {
            
//            TacheModel tache = this.offre.getTacheinitials().getTravaux().get(i);

            c1 = new PdfPCell(new Phrase("Assiette", smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            c1.setPadding(2);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("10", smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("10 000", smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("100 000", smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(c1);

        }
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setPadding(5);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setPadding(5);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("TOTAL ", boldFont));
        c1.setColspan(2);
        c1.setBorder(Rectangle.NO_BORDER);
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("400 000", smallFont));
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(c1);
        
        
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setPadding(5);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setPadding(5);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);

        

        
        document.add(table);
        
        float leftPage = 842-(document.getPageSize().getHeight()- writer.getVerticalPosition(false));        
        if(leftPage<300)sautPage(document,1);
        
//        information = new Paragraph(); 
//        information.add(new Phrase("Arrêté la présente facture à la somme de : "+ConvertionLettre.getLettre(offre.getStatInitial().getTotalTTC())+" Ariary ",smallFontBold));
//        document.add(information);
        
        information = new Paragraph();
        information.add(new Phrase("Antananarivo le,",smallFont));
        addEmptyLine(information,1);
        
        
        document.add(information);
        
        
        
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
    private static void sautPage(Document document, int saut) throws DocumentException {
        for (int i = 0; i < saut; i++) {
            document.add(Chunk.NEXTPAGE);
        }
    }

}
