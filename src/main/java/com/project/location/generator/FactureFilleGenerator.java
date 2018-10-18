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
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.project.location.data.PathData;
import com.project.location.model.Client;
import com.project.location.model.Commande;
import com.project.location.model.CommandeStock;
import com.project.location.model.Facture;
import com.project.location.model.HorsSotck;
import com.project.location.util.ConvertionLettre;
import com.project.location.util.DateUtil;
import com.project.location.util.UtilConvert;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Diary
 */
public class FactureFilleGenerator {
    private Commande commande;
    private List<CommandeStock> commandeStock;
    private int nombreJour;
    private Client client;
    private Facture facture;
    private double readyPaye;
    private double paye;
    private String refFille;
    private List<HorsSotck> hors_stock;
    private double[] total;
    
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

    public List<HorsSotck> getHors_stock() {
        return hors_stock;
    }

    public void setHors_stock(List<HorsSotck> hors_stock) {
        this.hors_stock = hors_stock;
    }

    public double[] getTotal() {
        return total;
    }

    public void setTotal(double[] total) {
        this.total = total;
    }

    public double getReadyPaye() {
        return readyPaye;
    }

    public void setReadyPaye(double readyPaye) {
        this.readyPaye = readyPaye;
    }

    public double getPaye() {
        return paye;
    }

    public void setPaye(double paye) {
        this.paye = paye;
    }

    
    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
    
    public List<CommandeStock> getCommandeStock() {
        return commandeStock;
    }

    public void setCommandeStock(List<CommandeStock> commandeStock) {
        this.commandeStock = commandeStock;
    }

    public int getNombreJour() {
        return nombreJour;
    }

    public void setNombreJour(int nombreJour) {
        this.nombreJour = nombreJour;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
    
    
    
    public static void main(String[] arg) throws Exception {
//        Test test = new Test();
//        FactureGenerator g = new FactureGenerator();
    }

    public FactureFilleGenerator(Client client,Commande commande,List<CommandeStock> commandeStocks, List<HorsSotck> hors_stock,Facture facture, double readyPaye, double paye, String refFille,double[] total,HttpServletRequest servletRequest) throws Exception {
        this.setCommande(commande);
        this.setCommandeStock(commandeStocks);
        this.setNombreJour(this.commande.nombreJour());
        this.setClient(client);
        this.setFacture(facture);
        this.setReadyPaye(readyPaye);
        this.setPaye(paye);
        this.refFille = refFille;
        this.setHors_stock(hors_stock);
        this.setTotal(total);
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(servletRequest.getSession().getServletContext().getRealPath("/")+PathData.PATH_PDF_FACTURE_FILLE));
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
        information.add(new Phrase(this.client.getPrenom()+" "+this.client.getNom(), normalFont));
        addEmptyLine(information, 1);
        information.add(new Phrase(this.client.getAdresse(), normalFont));
        addEmptyLine(information, 1);
        information.add(new Phrase("CIN : "+this.client.getCIN(), normalFont));
        addEmptyLine(information, 1);
        information.add(new Phrase("Ref. client : "+this.client.getRef(), normalFont));
        information.setAlignment(Element.ALIGN_RIGHT);
        document.add(information);

        information = new Paragraph();
        addEmptyLine(information, 2);
        
        information.add(new Phrase("Object : Facture de la commande N° "+ this.commande.getRef(),boldFont));
        addEmptyLine(information,1);
        information.add(new Phrase("N° Facture : "+ this.facture.getRef(),boldFont));
        addEmptyLine(information,1);
        information.add(new Phrase("N° de Paiement : "+ this.refFille,boldFont));
        addEmptyLine(information,2);
            
       
       
        document.add(information);
        
        PdfPCell c1;
        
        PdfPTable hors_stock = new PdfPTable(4);
        hors_stock.setWidthPercentage(100);
        hors_stock.setWidths(new float[]{5, 2, 2,2});
        
        c1 = new PdfPCell(new Phrase("DESIGNATION", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        hors_stock.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("PU", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        hors_stock.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("QUANTITE", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        hors_stock.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("MONTANT", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        hors_stock.addCell(c1);
        
        for (HorsSotck hs: this.hors_stock) {
            c1 = new PdfPCell(new Phrase(hs.getLibelle(), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            c1.setPadding(2);
            hors_stock.addCell(c1);
            
            c1 = new PdfPCell(new Phrase(String.valueOf(hs.getQuantite()), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            c1.setPadding(2);
            hors_stock.addCell(c1);
            
            c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(hs.getMontant()), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            c1.setPadding(2);
            hors_stock.addCell(c1);
            
            c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(hs.getMontant()*hs.getQuantite()), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            c1.setPadding(2);
            hors_stock.addCell(c1);
        }
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        hors_stock.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        hors_stock.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Total Hors Stock", boldFont));
        c1.setBorder(Rectangle.NO_BORDER);
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        hors_stock.addCell(c1);
        
        c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(total[3]), boldFont));
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        hors_stock.addCell(c1);
         // end
        
        document.add(hors_stock);
        //end hors stock
        
        information = new Paragraph();
        addEmptyLine(information, 2);
        document.add(information);

        PdfPTable table = new PdfPTable(7);

        table.setWidthPercentage(100);

        table.setWidths(new float[]{5, 2, 2, 2, 2, 2, 2});

//        BaseColor myColorpan = WebColors.getRGBColor("#BDBDBD");
        c1 = new PdfPCell(new Phrase("DESIGNATION", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        c1.setBackgroundColor(myColorpan);
        
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("QUANTITE", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);    
//        c1.setBackgroundColor(myColorpan);
        
        table.addCell(c1);
        

        c1 = new PdfPCell(new Phrase("P.U", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        c1.setBackgroundColor(myColorpan);
        
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Rem.Art", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        c1.setBackgroundColor(myColorpan);
        
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Prix de casse", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        c1.setBackgroundColor(myColorpan);
        
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Tot.Rem.Art", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        c1.setBackgroundColor(myColorpan);
        
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("MONTANT", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        c1.setBackgroundColor(myColorpan);
        
        table.addCell(c1);
//        List<TacheModel> taches; 
//        taches = offre.getTacheinitials().getTravaux();
        int size = this.commandeStock.size();
        for (int i = 0; i < size; i++) {
            CommandeStock cs = this.commandeStock.get(i);
//            TacheModel tache = this.offre.getTacheinitials().getTravaux().get(i);

            c1 = new PdfPCell(new Phrase(cs.getStock().getDesignation(), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            c1.setPadding(2);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase(String.valueOf(cs.getQuantiteCommande()), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(cs.getPrixLocation()), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(cs.getRemise()), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(cs.getStock().getPrixCasse()), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(cs.getRemise()*cs.getQuantiteCommande()), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(cs.getPrixLocation()*cs.getQuantiteCommande()), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(c1);

        }
         
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Total brute", boldFont));
        c1.setBorder(Rectangle.NO_BORDER);
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(total[1]), boldFont));
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(c1);
         // end
         
         c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Total remise article", boldFont));
        c1.setBorder(Rectangle.NO_BORDER);
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(total[2]), boldFont));
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(c1);
         // end
         
         c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Remise de la commande", boldFont));
        c1.setBorder(Rectangle.NO_BORDER);
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(commande.getRemiseGlobal()), boldFont));
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(c1);
         // end
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT); 
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Quotient ", boldFont));
        c1.setBorder(Rectangle.NO_BORDER);
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(this.facture.getQuotient()), boldFont));
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(c1);
         // end
         
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT); 
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Total net", boldFont));
        c1.setBorder(Rectangle.NO_BORDER);
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(total[0]+facture.getQuotient()), boldFont));
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(c1);
         // end
         
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);     
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);       
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);       
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Nombre de jour", boldFont));       
        c1.setBorder(Rectangle.NO_BORDER);
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);     
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase(String.valueOf(this.nombreJour), boldFont));        
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(c1);
        // end
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);        
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);        
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);        
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);        
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);        
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
         c1 = new PdfPCell(new Phrase("Total payé auparavant", boldFont));
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);        
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(this.getReadyPaye()), boldFont));       
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(c1);
        //end  
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);        
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);        
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);        
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);        
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);        
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
         c1 = new PdfPCell(new Phrase("Payé", boldFont));
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);        
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(this.getPaye()), boldFont));       
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(c1);
        //end  
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);        
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);        
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);        
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);        
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell();
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);        
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
         c1 = new PdfPCell(new Phrase("Reste à payer", boldFont));
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);        
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(total[0]+facture.getQuotient()-this.getPaye()-this.getReadyPaye()), boldFont));       
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(c1);
        //end  
        
        document.add(table);
        
        float leftPage = 842-(document.getPageSize().getHeight()- writer.getVerticalPosition(false));        
        if(leftPage<300)sautPage(document,1);
        
        information = new Paragraph(); 
        information.add(new Phrase("Arrété la présente facture à  la somme de : "+ConvertionLettre.getLettre(total[0]+this.facture.getQuotient()-paye)+" Ariary ",smallFontBold));
        document.add(information);
        
        information = new Paragraph();
        information.add(new Phrase("Antananarivo le, "+DateUtil.toLettre(Calendar.getInstance().getTime()),smallFont));
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
