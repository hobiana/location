/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.model;

import com.project.location.reference.Reference;
import java.util.Date;

/**
 *
 * @author Hobiana
 */
public class FactureFille extends BaseModel{
    private Commande commande;
    private double valeur;
    private Date date;

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public FactureFille(){
        super.setReference(Reference.FACTURE_FILLE);
    }
    public FactureFille(long id) {
        super.setId(id);
        super.setReference(Reference.FACTURE_FILLE);
    }
    
}
