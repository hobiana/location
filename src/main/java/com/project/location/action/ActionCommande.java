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
import com.project.location.model.HorsSotck;
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
import com.project.location.util.NumberTest;
import com.project.location.util.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    private List<HorsSotck> listeHorsStock;
    private ServiceStock serviceStock;
    private ServiceCommande serviceCommande;
    private ServiceCaisse serviceCaisse;
    private ServiceFacture serviceFacture;
    private List<Commande> listeCommande;
    private Commande commande;
    
    private List<ProduitRetour> listProduitRetour;
    
    private double[] total;
    private int nombre_jour;
    private double pourcentage_reste_a_payer;
    
    private int idCommande;
    private int idCommandeStock;
    private int idStock;
    private int idClient;
    private int quantite;
    private double remiseGlobal;

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
    private String prepare;
    private String reference; 
    private double quotient;
    private InputStream fileInputStream;
    private String fileName;
    
    private String designation_HS;
    private double prix_HS;
    private int quantite_HS;
    private int indiceHorsStock;
    
    private double remiseArticle;
    private Facture facture;

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public int getNombre_jour() {
        return nombre_jour;
    }

    public void setNombre_jour(int nombre_jour) {
        this.nombre_jour = nombre_jour;
    }

    public double getPourcentage_reste_a_payer() {
        return pourcentage_reste_a_payer;
    }

    public void setPourcentage_reste_a_payer(double pourcentage_reste_a_payer) {
        this.pourcentage_reste_a_payer = pourcentage_reste_a_payer;
    }

    public double getRemiseArticle() {
        return remiseArticle;
    }

    public void setRemiseArticle(double remiseArticle) {
        this.remiseArticle = remiseArticle;
    }

    public int getIndiceHorsStock() {
        return indiceHorsStock;
    }

    public void setIndiceHorsStock(int indiceHorsStock) {
        this.indiceHorsStock = indiceHorsStock;
    }

    public String getDesignation_HS() {
        return designation_HS;
    }

    public void setDesignation_HS(String designation_HS) {
        this.designation_HS = designation_HS;
    }

    public double getPrix_HS() {
        return prix_HS;
    }

    public void setPrix_HS(double prix_HS) {
        this.prix_HS = prix_HS;
    }

    public int getQuantite_HS() {
        return quantite_HS;
    }

    public void setQuantite_HS(int quantite_HS) {
        this.quantite_HS = quantite_HS;
    }

    public List<HorsSotck> getListeHorsStock() {
        return listeHorsStock;
    }

    public void setListeHorsStock(List<HorsSotck> listeHorsStock) {
        this.listeHorsStock = listeHorsStock;
    }

    public String getPrepare() {
        return prepare;
    }

    public void setPrepare(String prepare) {
        this.prepare = prepare;
    }

    public ServiceFacture getServiceFacture() {
        return serviceFacture;
    }

    public void setServiceFacture(ServiceFacture serviceFacture) {
        this.serviceFacture = serviceFacture;
    }

    public double getRemiseGlobal() {
        return remiseGlobal;
    }

    public void setRemiseGlobal(double remiseGlobal) {
        this.remiseGlobal = remiseGlobal;
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
    
    public double[] getTotal() {
        return total;
    }
    public String doubleToString(double n) {
        return NumberTest.toMoney(n);
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

    public void setTotal(double[] total) {
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
            Date debut = Calendar.getInstance().getTime();
            Date fin = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(fin);
            c.add(Calendar.DATE, 1);
            fin = c.getTime();
            if (Test.argmumentNull(dateDebut)) {
                dateDebut = DateUtil.convert(debut);
            }
            if (Test.argmumentNull(dateFin)) {
                dateFin = DateUtil.convert(fin);
            }
            if (Test.argmumentNull(dateAquisition)) {
                dateAquisition = DateUtil.convert(debut);
            }
            if (Test.argmumentNull(dateRetour)) {
                dateRetour = DateUtil.convert(fin);
            }
            nombre_jour = DateUtil.nombreJ(dateDebut, dateFin);
        }else{
            HttpSession session = ServletActionContext.getRequest().getSession();          
            long idCommandeSession =0;
            if(session.getAttribute(ReferenceSession.IDCOMMANDE)!=null){
                idCommandeSession = (long) session.getAttribute(ReferenceSession.IDCOMMANDE);
                if(idCommandeSession!=this.idCommande){
                    session.removeAttribute(ReferenceSession.COMMANDE);
                    session.removeAttribute(ReferenceSession.IDCOMMANDE);
                    idCommandeSession = 0;
                }
            }
            if(idCommandeSession==0) idCommandeSession = this.idCommande;
            Commande commande = this.serviceCommande.find(idCommandeSession);
            this.idCommande = 0; 
            session.setAttribute(ReferenceSession.IDCOMMANDE,idCommandeSession);
            dateDebut = DateUtil.convert(commande.getDateDebut()); 
            dateFin = DateUtil.convert(commande.getDateFin());
            dateAquisition = DateUtil.convert(commande.getDateAcquisition());
            dateRetour = DateUtil.convert(commande.getDateRetour());
            remiseGlobal = commande.getRemiseGlobal();
            nombre_jour = DateUtil.nombreJ(commande.getDateDebut(), commande.getDateRetour());
            Facture facture = this.serviceFacture.factureByCommande(commande.getId());
            quotient = facture.getQuotient();
            this.serviceCommande.setCommande(this.serviceCommande.find(commande));
            this.serviceCommande.setCommandeHS(this.serviceCommande.findListHorsStock(commande));
        }
        listeCommandeStock = serviceCommande.getCommande();
        listeHorsStock = serviceCommande.getCommandeHS();
        this.total = this.serviceCommande.getTotal(remiseGlobal,dateDebut, dateFin);
        return Action.SUCCESS;
    }

    public String addSessionCommande() throws Exception {
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        serviceCommande.addCommand(idStock, quantite, remiseArticle, dateDebut, dateFin);
        return Action.SUCCESS;
    }

    public String deleteSessionCommande() throws Exception {
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        serviceCommande.deleteCommand(idCommandeStock);
        return Action.SUCCESS;
    }

    public String modifSessionCommande() throws Exception {
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        serviceCommande.modifierCommand(idCommandeStock, quantite, remiseArticle, dateDebut, dateFin);
        return Action.SUCCESS;
    }

    public String verifSessionCommande() throws Exception {
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        serviceCommande.checkAll(dateDebut, dateFin);
        return Action.SUCCESS;
    }

    public String validerSessionCommande() throws Exception {
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        if (action.equals("save")) {
            if (
                serviceCommande.saveCommande(idClient, dateDebut, dateFin,this.dateAquisition,this.dateRetour,this.remiseGlobal,this.quotient)) {
                return Action.SUCCESS;
            }
        }
        else if(!action.equals("save")){
            // ito fonction update ito ilay ataon la
            if (serviceCommande.updateCommande(dateDebut, dateFin, this.dateAquisition,this.dateRetour,this.remiseGlobal, this.quotient)) {
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
            this.listeCommande = this.serviceCommande.getCommande(client,dateDebutCommande,dateFinCommande,this.dateDebut, this.dateFin,!Test.argmumentNull(recu),!Test.argmumentNull(retour),!Test.argmumentNull(annule),!Test.argmumentNull(paye),!Test.argmumentNull(prepare));
        }catch(Exception e){
            e.printStackTrace();
        }
        this.titre = "Liste Commande";
        return Action.SUCCESS;
    }
    
    public String listCommande1() throws Exception {
        try {
            Users u = this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        try {
            if (reference != null) {
                Commande commande = new Commande();
                long idcommande = commande.getId(reference);
                commande = serviceCommande.find(idcommande);
                this.listeCommande = new ArrayList<>();
                this.listeCommande.add(commande);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            this.listeCommande = new ArrayList<>();
            return Action.SUCCESS;
        }
        this.titre = "Liste Commande";
        return Action.SUCCESS;
    }
    
    public String retourcommande(){
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        try{
            Commande commande = new Commande(this.idCommande);
            this.serviceCommande.retour(listProduitRetour,commande.getRef());
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
        facture = serviceFacture.findByCommande(idCommande);
        commande = this.serviceCommande.find(idCommande);
        this.total = this.serviceCommande.getTotal(idCommande);
        double total_paye = this.serviceFacture.totalPayer(idCommande);
        double totalQuotient = facture.getQuotient();
        double totalToPaye = totalQuotient +total[0] + total[3];
        this.pourcentage_reste_a_payer = (int)((100*total_paye)/totalToPaye);
        
        this.listeCommandeStock = this.serviceCommande.find(commande);
        this.listeHorsStock = serviceCommande.findListHorsStock(commande);
        Facture facture = this.serviceFacture.factureByCommande(idCommande);
        quotient = facture.getQuotient();
        this.titre = "Fiche Commande";
        return Action.SUCCESS;
    }
    public String annulecommande() throws Exception {
        try {
            Users u = this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        this.commande = this.serviceCommande.find(idCommande);
        boolean annulee = annule.equals("true");
        this.serviceCommande.updateEtatAnnulee(idCommande, annulee);
        return Action.SUCCESS;
    }
    
    public String addhorsStock() throws Exception {
        try {
            Users u = this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        HorsSotck hs =  new HorsSotck();
        hs.setLibelle(designation_HS);
        hs.setQuantite(quantite_HS);
        hs.setMontant(prix_HS);
        serviceCommande.addHorsStockSession(hs);
        return Action.SUCCESS;
    }
    
    public String delhorsStock()throws Exception {
        try {
            Users u = this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        serviceCommande.deleteHorsStockSession(indiceHorsStock);
        return Action.SUCCESS;
    }
}
