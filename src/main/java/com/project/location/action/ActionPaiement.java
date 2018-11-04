/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

import com.opensymphony.xwork2.Action;
import com.project.location.data.PathData;
import com.project.location.model.Commande;
import com.project.location.model.FactureFille;
import com.project.location.model.Users;
import com.project.location.reference.ReferenceErreur;
import com.project.location.service.ServiceCommande;
import com.project.location.service.ServiceFacture;
import com.project.location.util.DateUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Hobiana
 */
public class ActionPaiement extends BaseAction{
    private int idCommande;
    private int idFactureFille;
    private ServiceFacture serviceFacture;
    private ServiceCommande serviceCommande;
    private List<FactureFille> listePaiement;
    private double totalToPaye; 
    private double totalPaye;
    private double reste;
    private String datepaiement;
    private double valeur;
    
    private InputStream fileInputStream;
    private String fileName;

    public int getIdFactureFille() {
        return idFactureFille;
    }

    public void setIdFactureFille(int idFactureFille) {
        this.idFactureFille = idFactureFille;
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
    
    
    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
    
    public String getDatepaiement() {
        return datepaiement;
    }

    public void setDatepaiement(String datepaiement) {
        this.datepaiement = datepaiement;
    }
    
    public List<FactureFille> getListePaiement() {
        return listePaiement;
    }

    public void setListePaiement(List<FactureFille> listePaiement) {
        this.listePaiement = listePaiement;
    }

    
    public ServiceFacture getServiceFacture() {
        return serviceFacture;
    }

    public void setServiceFacture(ServiceFacture serviceFacture) {
        this.serviceFacture = serviceFacture;
    }

    public ServiceCommande getServiceCommande() {
        return serviceCommande;
    }

    public void setServiceCommande(ServiceCommande serviceCommande) {
        this.serviceCommande = serviceCommande;
    }

    
    public double getTotalToPaye() {
        return totalToPaye;
    }

    public void setTotalToPaye(double totalToPaye) {
        this.totalToPaye = totalToPaye;
    }

    public double getTotalPaye() {
        return totalPaye;
    }

    public void setTotalPaye(double totalPaye) {
        this.totalPaye = totalPaye;
    }

    public double getReste() {
        return reste;
    }

    public void setReste(double reste) {
        this.reste = reste;
    }
    
    

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }
    public String generatPdf(){
        try{
            this.serviceFacture.generatPdfFille(idFactureFille, idCommande, servletRequest);
            File fileToDownload = new File(this.servletRequest.getSession().getServletContext().getRealPath("/")+PathData.PATH_PDF_FACTURE_FILLE);
            fileName = fileToDownload.getName();
            fileInputStream = new FileInputStream(fileToDownload);
            return Action.SUCCESS;
        }catch(Exception e){
            this.linkError = ReferenceErreur.VISIBLE;
            this.messageError = e.getMessage();
            return Action.ERROR;
        }
        
    }
    public String toPaiement(){
        if(this.idCommande == 0 ) return Action.NONE;
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        try{
            this.datepaiement = DateUtil.convert(Calendar.getInstance().getTime());
            this.listePaiement = this.serviceFacture.factureFilleByCommande(idCommande);
            Commande commande = this.serviceCommande.find(idCommande);
            double totalQuotient = this.serviceFacture.findByCommande(idCommande).getQuotient();
            double total[] = this.serviceCommande.getTotal(idCommande);
            double somme = totalQuotient+ total[0] + total[3] - commande.getRemiseGlobal();
            double tPay = this.serviceFacture.totalPayer(idCommande);
            this.setTotalToPaye(somme);
            this.setTotalPaye(tPay);
            this.setReste(somme - tPay);         
            
        }catch(Exception e) {
            e.printStackTrace();
            this.linkError = ReferenceErreur.VISIBLE;
            this.messageError = e.getMessage(); 
            return Action.ERROR;
        }
        
        
        return Action.SUCCESS;
    }
    
    public String payer(){
         try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        try{
            double totalQuotient = this.serviceFacture.findByCommande(idCommande).getQuotient();
            double total[] = this.serviceCommande.getTotal(idCommande);
            double remiseGlobal = this.serviceCommande.find(idCommande).getRemiseGlobal();
            double somme = totalQuotient+ total[0] +total[3] - remiseGlobal;
            this.serviceFacture.payement(idCommande, valeur, datepaiement, somme);
            return Action.SUCCESS;
        }catch(Exception e){
            this.linkError = ReferenceErreur.VISIBLE; 
            this.messageError = e.getMessage();
            return Action.ERROR;
        } 
        
        
    }
}
