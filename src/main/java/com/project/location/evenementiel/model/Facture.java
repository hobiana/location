/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.evenementiel.model;

import java.util.Date;

/**
 *
 * @author Diary
 */
public class Facture extends BaseModel {
    private Commande commande; 
    private Date dateFature; 
    private double quotient; 
    private double TVA; 
    private double remise; 

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) throws Exception {
        if(commande==null||commande.getId()==0)throw new Exception("La facture ne possède pas de commande"); 
        this.commande = commande;
    }

    public Date getDateFature() {
        return dateFature;
    }

    public void setDateFature(Date dateFature) {
        this.dateFature = dateFature;
    }

    public double getQuotient() {
        return quotient;
    }

    public void setQuotient(double quotient) {
        this.quotient = quotient;
    }

    public double getTVA() {
        return TVA;
    }

    public void setTVA(double TVA) throws Exception{
        if(TVA>100|TVA<0) throw new Exception("TVA invalide, veuillez vérifier que le TVA ne dépasse les 100% ou ne soit pas inférieure à 0%");
        this.TVA = TVA;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) throws Exception {
        if(remise>100|remise<0) throw new Exception("remise invalide, veuillez vérifier que la remise ne dépasse les 100% ou ne soit pas inférieure à 0%");
        this.remise = remise;
    }
    
    
}
