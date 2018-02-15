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
 * @author Diary
 */
public class Commande extends BaseModel {
    private Date dateCommande;
    private Date dateDebut; 
    private Date dateFin; 
    private boolean annule; 
    private boolean retour;
    private boolean recu;
    private Client client;

    public boolean isRecu() {
        return recu;
    }

    public void setRecu(boolean recu) {
        this.recu = recu;
    }
    
    public Date getDateCommande() {
        return dateCommande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public boolean isAnnule() {
        return annule;
    }

    public void setAnnule(boolean annule) {
        this.annule = annule;
    }

    public boolean isRetour() {
        return retour;
    }

    public void setRetour(boolean retour) {
        this.retour = retour;
    }

    public Commande() {
        super.setReference(Reference.COMMANDE);    
    }
    public Commande(long id){
        super.setId(id);
        super.setReference(Reference.COMMANDE);    
    }
}
