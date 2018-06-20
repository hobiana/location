/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

import com.opensymphony.xwork2.Action;
import com.project.location.data.PathData;
import com.project.location.model.Commande;
import com.project.location.model.CommandeStock;
import com.project.location.model.Facture;
import com.project.location.model.ProduitRetour;
import com.project.location.model.Stock;
import com.project.location.model.Users;
import com.project.location.reference.ReferenceErreur;
import com.project.location.reference.ReferenceSession;
import com.project.location.service.ServiceCaisse;
import com.project.location.service.ServiceCommande;
import com.project.location.service.ServiceFacture;
import com.project.location.service.ServiceStock;
import com.project.location.util.DateUtil;
import com.project.location.util.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Hobiana
 */
public class ActionCommande extends BaseAction {

    private List<Stock> listeStock;
    private List<CommandeStock> listeCommandeStock;
    private ServiceStock serviceStock;
    private ServiceCommande serviceCommande;
    private ServiceCaisse serviceCaisse;
    private ServiceFacture serviceFacture;
    private List<Commande> listeCommande;
    private Commande commande;
    
    private List<ProduitRetour> listProduitRetour;
    
    private double total;
    
    private int idCommande;
    private int idCommandeStock;
    private int idStock;
    private int idClient;
    private int quantite;
    private double prixLivraison;

    private String dateDebut;
    private String dateFin;
    private String dateAquisition;
    private String dateRetour;
    private String dateDebutCommande; 
    private String dateFinCommande; 
    private String action;
    
    private String client;
    private String recu; 
    private String retour; 
    private String annule;
    private String paye;
    private String reference; 
    private double quotient;
    private InputStream fileInputStream;
    private String fileName;

    public ServiceFacture getServiceFacture() {
        return serviceFacture;
    }

    public void setServiceFacture(ServiceFacture serviceFacture) {
        this.serviceFacture = serviceFacture;
    }

    public double getPrixLivraison() {
        return prixLivraison;
    }

    public void setPrixLivraison(double prixLivraison) {
        this.prixLivraison = prixLivraison;
    }

    public List<ProduitRetour> getListProduitRetour() {
        return listProduitRetour;
    }

    public void setListProduitRetour(List<ProduitRetour> listProduitRetour) {
        this.listProduitRetour = listProduitRetour;
    }

    public ServiceCaisse getServiceCaisse() {
        return serviceCaisse;
    }

    public void setServiceCaisse(ServiceCaisse serviceCaisse) {
        this.serviceCaisse = serviceCaisse;
    }

    public double getQuotient() {
        return quotient;
    }

    public void setQuotient(double quotient) {
        this.quotient = quotient;
    }
    
    public double getTotal() {
        return total;
    }
    public String getTotalS() {
        BigDecimal d = new BigDecimal(this.total);
        return d.toPlainString();
    }

    public InputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(InputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setTotal(double total) {
        this.total = total;
    }
 
    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
    
    public String getDateAquisition() {
        return dateAquisition;
    }

    public void setDateAquisition(String dateAquisition) {
        this.dateAquisition = dateAquisition;
    }

    public String getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(String dateRetour) {
        this.dateRetour = dateRetour;
    }
    
    public String getPaye() {
        return paye;
    }

    public void setPaye(String paye) {
        this.paye = paye;
    }
    
    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    
    public String getDateDebutCommande() {
        return dateDebutCommande;
    }

    public void setDateDebutCommande(String dateDebutCommande) {
        this.dateDebutCommande = dateDebutCommande;
    }

    public String getDateFinCommande() {
        return dateFinCommande;
    }

    public void setDateFinCommande(String dateFinCommande) {
        this.dateFinCommande = dateFinCommande;
    }

    public String getRecu() {
        return recu;
    }

    public void setRecu(String recu) {
        this.recu = recu;
    }

    public String getRetour() {
        return retour;
    }

    public void setRetour(String retour) {
        this.retour = retour;
    }

    public String getAnnule() {
        return annule;
    }

    public void setAnnule(String annule) {
        this.annule = annule;
    }
    
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<Commande> getListeCommande() {
        return listeCommande;
    }

    public void setListeCommande(List<Commande> listeCommande) {
        this.listeCommande = listeCommande;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public int getIdCommandeStock() {
        return idCommandeStock;
    }

    public void setIdCommandeStock(int idCommandeStock) {
        this.idCommandeStock = idCommandeStock;
    }

    public List<CommandeStock> getListeCommandeStock() {
        return listeCommandeStock;
    }

    public void setListeCommandeStock(List<CommandeStock> listeCommande) {
        this.listeCommandeStock = listeCommande;
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public List<Stock> getListeStock() {
        return listeStock;
    }

    public void setListeStock(List<Stock> listeStock) {
        this.listeStock = listeStock;
    }

    public ServiceStock getServiceStock() {
        return serviceStock;
    }

    public void setServiceStock(ServiceStock serviceStock) {
        this.serviceStock = serviceStock;
    }

    public ServiceCommande getServiceCommande() {
        return serviceCommande;
    }

    public void setServiceCommande(ServiceCommande serviceCommande) {
        this.serviceCommande = serviceCommande;
    }

    // getter setters
    public String commande() throws Exception {
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        
        this.titre = "Commande";
        listeStock = serviceStock.find();
        if(idCommande<=0){
            if (Test.argmumentNull(dateDebut)) {
                dateDebut = DateUtil.convert(Calendar.getInstance().getTime());
            }
            if (Test.argmumentNull(dateFin)) {
                Date d = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(d);
                c.add(Calendar.DATE, 1);
                d = c.getTime();
                dateFin = DateUtil.convert(d);
            }
            if (Test.argmumentNull(dateAquisition)) {
                dateAquisition = DateUtil.convert(Calendar.getInstance().getTime());
            }
            if (Test.argmumentNull(dateRetour)) {
                Date d = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(d);
                c.add(Calendar.DATE, 1);
                d = c.getTime();
                dateRetour = DateUtil.convert(d);
            }
        }else{
            HttpSession session = ServletActionContext.getRequest().getSession();          
            long idCommandeSession =0;
            if(session.getAttribute(ReferenceSession.IDCOMMANDE)!=null) idCommandeSession = (long) session.getAttribute(ReferenceSession.IDCOMMANDE);
            if(idCommandeSession==0) idCommandeSession = this.idCommande;
            Commande commande = this.serviceCommande.find(idCommandeSession);
            this.idCommande = 0; 
            session.setAttribute(ReferenceSession.IDCOMMANDE,idCommandeSession);
            dateDebut = DateUtil.convert(commande.getDateDebut()); 
            dateFin = DateUtil.convert(commande.getDateFin());
            dateAquisition = DateUtil.convert(commande.getDateAcquisition());
            dateRetour = DateUtil.convert(commande.getDateRetour());
            prixLivraison = commande.getPrixLivraison();
            Facture facture = this.serviceFacture.factureByCommande(commande.getId());
            quotient = facture.getQuotient();
            this.serviceCommande.setCommande(this.serviceCommande.find(commande)); 
        }
        listeCommandeStock = serviceCommande.getCommande();
        this.total = this.serviceCommande.getTotal(dateDebut, dateFin);
        return Action.SUCCESS;
    }

    public String addSessionCommande() throws Exception {
        serviceCommande.addCommand(idStock, quantite, dateDebut, dateFin);
        return Action.SUCCESS;
    }

    public String deleteSessionCommande() throws Exception {
        serviceCommande.deleteCommand(idCommandeStock);
        return Action.SUCCESS;
    }

    public String modifSessionCommande() throws Exception {
        serviceCommande.modifierCommand(idCommandeStock, quantite, dateDebut, dateFin);
        return Action.SUCCESS;
    }

    public String verifSessionCommande() throws Exception {
        serviceCommande.checkAll(dateDebut, dateFin);
        return Action.SUCCESS;
    }

    public String validerSessionCommande() throws Exception {
        if (action.equals("save")) {
            if (
                serviceCommande.saveCommande(idClient, dateDebut, dateFin,this.dateAquisition,this.dateRetour,this.prixLivraison,this.quotient)) {
                return Action.SUCCESS;
            }
        }
        else if(!action.equals("save")){
            // ito fonction update ito ilay ataon la
            if (serviceCommande.updateCommande(dateDebut, dateFin, this.dateAquisition,this.dateRetour,this.prixLivraison, this.quotient)) {
                return Action.SUCCESS;
            }
        }
        return Action.ERROR;
    }
   
    public String listCommande() throws Exception {
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        try{
            this.listeCommande = this.serviceCommande.getCommande(client,dateDebutCommande,dateFinCommande,this.dateDebut, this.dateFin,!Test.argmumentNull(recu),!Test.argmumentNull(retour),!Test.argmumentNull(annule),!Test.argmumentNull(paye));
        }catch(Exception e){
            e.printStackTrace();
        }
        this.titre = "Liste Commande";
        return Action.SUCCESS;
    }
    
    public String retourcommande(){
        try{
            this.serviceCommande.retour(listProduitRetour);
            this.serviceCommande.updateEtat(idCommande);
            this.linkSuccess = ReferenceErreur.VISIBLE;
            this.messageSuccess = "mise à jour effectué avec succes";
            return Action.SUCCESS;
        }catch(Exception e){
            this.linkError=ReferenceErreur.VISIBLE;
            this.messageError = e.getMessage();
            return Action.ERROR;
        }
        
    }
    public String updateEtat(){
        boolean recuB  = this.recu!=null;
        boolean annuleB = this.annule!=null;
        try{
            this.serviceCommande.updateEtat(idCommande, recuB, annuleB);
            this.linkSuccess = ReferenceErreur.VISIBLE;
            this.messageSuccess = "mise à jour effectué avec succes";
            return Action.SUCCESS;
        }catch(Exception e){
            this.linkError=ReferenceErreur.VISIBLE;
            this.messageError = e.getMessage();
            return Action.ERROR;
        }
        
    }
    public String generateFacture() {
        try {
            this.serviceCommande.generatPdfFacture(idCommande,this.servletRequest);
            File fileToDownload = new File(this.servletRequest.getSession().getServletContext().getRealPath("/")+PathData.PATH_PDF_FACTURE);
            fileName = fileToDownload.getName();
            fileInputStream = new FileInputStream(fileToDownload);
            return Action.SUCCESS;
        }catch (Exception e ) {
            e.printStackTrace();
            this.linkError=ReferenceErreur.VISIBLE;
            this.messageError = e.getMessage();
            return Action.ERROR;
        }
    }
    public String generateBS() {
        try {
            this.serviceCommande.generatPdfBS(idCommande,this.servletRequest);
            File fileToDownload = new File(this.servletRequest.getSession().getServletContext().getRealPath("/")+PathData.PATH_PDF_BON_SORTIE);
            fileName = fileToDownload.getName();
            fileInputStream = new FileInputStream(fileToDownload);
            return Action.SUCCESS;
        }catch (Exception e ) {
            e.printStackTrace();
            this.linkError=ReferenceErreur.VISIBLE;
            this.messageError = e.getMessage();
            return Action.ERROR;
        }
    }
    public String generateBR() {
        try {
            this.serviceCommande.generatPdfBR(idCommande,this.servletRequest);
            File fileToDownload = new File(this.servletRequest.getSession().getServletContext().getRealPath("/")+PathData.PATH_PDF_BON_RECEPTION);
            fileName = fileToDownload.getName();
            fileInputStream = new FileInputStream(fileToDownload);
            return Action.SUCCESS;
        }catch (Exception e ) {
            e.printStackTrace();
            this.linkError=ReferenceErreur.VISIBLE;
            this.messageError = e.getMessage();
            return Action.ERROR;
        }
    }
    public String generatPdfQuotient() {
        try {
            this.serviceCommande.generatPdfQuotient(idCommande,this.servletRequest);
            File fileToDownload = new File(this.servletRequest.getSession().getServletContext().getRealPath("/")+PathData.PATH_PDF_BON_QUOTIENT);
            fileName = fileToDownload.getName();
            fileInputStream = new FileInputStream(fileToDownload);
            return Action.SUCCESS;
        }catch (Exception e ) {
            e.printStackTrace();
            this.linkError=ReferenceErreur.VISIBLE;
            this.messageError = e.getMessage();
            return Action.ERROR;
        }
    }
    public String ficheCommande() throws Exception {
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        
        commande = this.serviceCommande.find(idCommande);
        this.total = this.serviceCommande.getTotal(idCommande);
        this.listeCommandeStock = this.serviceCommande.find(commande);
        Facture facture = this.serviceFacture.factureByCommande(idCommande);
        quotient = facture.getQuotient();
        this.titre = "Fiche Commande";
        return Action.SUCCESS;
    }
}
