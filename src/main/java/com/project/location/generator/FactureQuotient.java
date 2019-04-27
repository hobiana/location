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
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Diary
 */
public class FactureQuotient {

    private Commande commande;
    private List<CommandeStock> commandeStock;
    private List<HorsSotck> commandeHorsStock;
    private int nombreJour;
    private Client client;
    private Facture facture;
    private HttpServletRequest servletRequest;

    private static final Font boltTableFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
    private static final Font normalBoldTableFont = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD);
    private static final Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL);
    private static final Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD);
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

    private static Font header = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD, GrayColor.BLACK);
    private static Font redFont = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font bold = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);

    private static Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
    private static Font extraSmallFont = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.BOLD);
    private static Font smallFontBold = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD);

    public List<HorsSotck> getCommandeHorsStock() {
        return commandeHorsStock;
    }

    public void setCommandeHorsStock(List<HorsSotck> commandeHorsStock) {
        this.commandeHorsStock = commandeHorsStock;
    }

    public HttpServletRequest getServletRequest() {
        return servletRequest;
    }

    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
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

    public FactureQuotient(Client client, Commande commande, List<CommandeStock> commandeStocks, List<HorsSotck> commandeHorsStock, Facture facture, HttpServletRequest servletRequest) throws Exception {
        this.setCommande(commande);
        this.setCommandeStock(commandeStocks);
        this.setNombreJour(this.commande.nombreJour());
        this.setClient(client);
        this.setFacture(facture);
        this.setServletRequest(servletRequest);
        this.setCommandeHorsStock(commandeHorsStock);
        Document document = new Document(PageSize.A4, 36, 36, 36, 150);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(servletRequest.getSession().getServletContext().getRealPath("/") + PathData.PATH_PDF_BON_QUOTIENT));
        setNumberPage(writer, servletRequest);
        document.open();
        addMetaData(document);
        addContent(document, writer);
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

    private void addContent(Document document, PdfWriter writer) throws DocumentException, BadElementException, IOException, Exception {
        Paragraph information = new Paragraph();

        document.add(information);

        information = new Paragraph();
        information.add(new Phrase(this.client.getPrenom() + " " + this.client.getNom(), normalFont));
        addEmptyLine(information, 1);
        information.add(new Phrase(this.client.getAdresse(), normalFont));
        addEmptyLine(information, 1);
        information.add(new Phrase("CIN : " + this.client.getCIN(), normalFont));
        addEmptyLine(information, 1);
        information.add(new Phrase("Ref. client : " + this.client.getRef(), normalFont));
        information.setAlignment(Element.ALIGN_RIGHT);
        document.add(information);

        information = new Paragraph();
        addEmptyLine(information, 2);

        information.add(new Phrase("Object : Facture de la caution commande N� " + this.commande.getRef(), boldFont));
        addEmptyLine(information, 1);
        information.add(new Phrase("N� Facture " + this.facture.getRef(), boldFont));
        addEmptyLine(information, 2);

        document.add(information);

        PdfPTable table;
        table = new PdfPTable(6);

        table.setWidthPercentage(100);

        table.setWidths(new float[]{5, 2, 2, 2, 2, 2});

        PdfPCell c1;

//        BaseColor myColorpan = WebColors.getRGBColor("#BDBDBD");
        c1 = new PdfPCell(new Phrase("DESIGNATION", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        c1.setBackgroundColor(myColorpan);

        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("QUANTITE", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        c1.setBackgroundColor(myColorpan);

        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Qte. Non Retour", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        c1.setBackgroundColor(myColorpan);

        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("P.U", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        c1.setBackgroundColor(myColorpan);

        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Prix de casse", header));
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
        double somme = 0;
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

            double nmbreNR = cs.getQuantiteCommande() - cs.getQuantiteRetour();
            c1 = new PdfPCell(new Phrase(String.valueOf(nmbreNR), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(cs.getPrixLocation()), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(cs.getStock().getPrixCasse()), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(c1);

            double total = nmbreNR * cs.getPrixCasse();
            c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(total), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(c1);
            somme += total;
        }
        size = this.commandeHorsStock.size();
        for (int i = 0; i < size; i++) {
            HorsSotck cs = this.commandeHorsStock.get(i);
            if (cs.isRetour_HS()) {
                c1 = new PdfPCell(new Phrase(cs.getLibelle(), smallFont));
                c1.setHorizontalAlignment(Element.ALIGN_LEFT);
                c1.setPadding(2);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase(String.valueOf(cs.getQuantite()), smallFont));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(c1);

                double nmbreNR = cs.getQuantite() - cs.getQuantiteRetour();
                c1 = new PdfPCell(new Phrase(String.valueOf(nmbreNR), smallFont));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(cs.getMontant()), smallFont));
                c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
                c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(cs.getMontant()), smallFont));
                c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
                c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(c1);

                double total = nmbreNR * cs.getMontant();
                c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(total), smallFont));
                c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
                c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(c1);
                somme += total;
            }
//            TacheModel tache = this.offre.getTacheinitials().getTravaux().get(i);

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

        c1 = new PdfPCell(new Phrase("TOTAL ", boldFont));
        c1.setBorder(Rectangle.NO_BORDER);
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(somme), boldFont));
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

        c1 = new PdfPCell(new Phrase("Caution ", boldFont));
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

        String message = "Total � r�cup�rer";
        if (this.facture.getQuotient() - somme < 0) {
            message = "Total � payer";
        }
        c1 = new PdfPCell(new Phrase(message, boldFont));
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setBorder(Rectangle.NO_BORDER);
        table.addCell(c1);
        double sommeToPay = Math.abs(this.facture.getQuotient() - somme);
        c1 = new PdfPCell(new Phrase(UtilConvert.toMoney(sommeToPay), boldFont));
        c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(c1);

        document.add(table);

        float leftPage = 842 - (document.getPageSize().getHeight() - writer.getVerticalPosition(false));
        if (leftPage < 300) {
            sautPage(document, 1);
        }

        information = new Paragraph();
        information.add(new Phrase("Arr�t� la pr�sente facture � la somme de : " + ConvertionLettre.getLettre(sommeToPay) + " Ariary ", smallFontBold));
        document.add(information);

        information = new Paragraph();
        information.add(new Phrase("Antananarivo le, " + DateUtil.toLettre(Calendar.getInstance().getTime()), smallFont));
        addEmptyLine(information, 1);

        document.add(information);

    }

    public void setNumberPage(PdfWriter writer, final HttpServletRequest servletRequest) {
        writer.setPageEvent(new PdfPageEventHelper() {
            @Override
            public void onStartPage(PdfWriter writer, Document document) {
                try {
                    Paragraph information = new Paragraph();
                    Rectangle rect = document.getPageSize();
                    Image img = Image.getInstance(servletRequest.getSession().getServletContext().getRealPath("/") + "data/logo/logo.png");
                    img.scaleAbsolute(150, 50);
//                    img.setAbsolutePosition((rect.getLeft() + rect.getRight()) / 2 - 45, rect.getTop() - 50);
                    img.setAlignment(Element.ALIGN_CENTER);

                    information.add(img);
                    addEmptyLine(information, 1);
                    document.add(information);

                } catch (BadElementException ex) {
                    Logger.getLogger(FactureGenerator.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FactureGenerator.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(FactureGenerator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onEndPage(PdfWriter writer, Document document) {

                try {

                    Paragraph information = new Paragraph();
                    Rectangle rect = document.getPageSize();
                    Image img = Image.getInstance(servletRequest.getSession().getServletContext().getRealPath("/") + "data/logo/pied.jpg");
                    img.scaleAbsolute(300, 50);
                    float x = (PageSize.A4.getWidth() - img.getScaledWidth()) / 2;
                    img.setAbsolutePosition(x, rect.getBottom() + 50);
                    img.setAlignment(Element.ALIGN_CENTER);
                    information.add(img);
                    addEmptyLine(information, 1);
                    document.add(information);

//                    writer.getDirectContent().addImage(img);
                    int pageNumber = writer.getPageNumber();
                    String text = "" + pageNumber;
                    Rectangle page = document.getPageSize();
                    PdfPTable structure = new PdfPTable(1);
                    PdfPCell c2 = new PdfPCell(new Paragraph(text));
                    c2.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    c2.setBorder(PdfPCell.NO_BORDER);

                    structure.addCell(c2);
                    structure.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());
                    structure.writeSelectedRows(0, -1, document.leftMargin(), document.bottomMargin(), writer.getDirectContent());
                } catch (BadElementException ex) {
                    Logger.getLogger(FactureGenerator.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FactureGenerator.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(FactureGenerator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
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
