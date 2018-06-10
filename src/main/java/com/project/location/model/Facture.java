/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.model;

import com.project.location.reference.Reference;
import com.project.location.util.NumberTest;
import java.util.Date;

/**
 *
 * @author Diary
 */
public class Facture extends BaseModel {
    private Commande commande; 
    private Date dateFacture; 
    private double quotient; 

    public String quotient(){
        return NumberTest.toMoney(quotient);
    }
    
    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) throws Exception {
        if(commande==null||commande.getId()==0)throw new Exception("La facture ne possède pas de commande"); 
        this.commande = commande;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFature) {
        this.dateFacture = dateFature;
    }

    public double getQuotient() {
        return quotient;
    }

    public void setQuotient(double quotient) {
        this.quotient = quotient;
    }

    public Facture(){
        super.reference = Reference.FACTURE;
    }
    public Facture(long id){
        super.id = id;
        super.reference = Reference.FACTURE;
    }
    
}
