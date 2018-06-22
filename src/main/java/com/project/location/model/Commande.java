/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.model;

import com.project.location.reference.Reference;
import com.project.location.util.DateUtil;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Diary
 */
public class Commande extends BaseModel {
    private Date dateCommande;
    private Date dateAcquisition; 
    private Date dateRetour; 
    private Date dateDebut; 
    private Date dateFin; 
    private boolean annule; 
    private boolean retour;
    private boolean recu;
    private boolean paye; 
    private boolean prepare;
    private Double prixLivraison;
    private Client client;
    private List<CommandeStock> commandeStock;

    public boolean isPrepare() {
        return prepare;
    }

    public void setPrepare(boolean prepare) {
        this.prepare = prepare;
    }

    public double getPrixLivraison() {
        return prixLivraison;
    }
    public void setPrixLivraison(Double prixLivraison) {
        if(prixLivraison==null) this.prixLivraison = 0.0; 
        else this.prixLivraison = prixLivraison;
    }

    public List<CommandeStock> getCommandeStock() {
        return commandeStock;
    }

    public void setCommandeStock(List<CommandeStock> commandeStock) {
        this.commandeStock = commandeStock;
    }
    
    public Date getDateAcquisition() {
        return dateAcquisition;
    }

    public void setDateAcquisition(Date dateAcquisition) {
        this.dateAcquisition = dateAcquisition;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public boolean isPaye() {
        return paye;
    }

    public void setPaye(boolean paye) {
        this.paye = paye;
    }

     
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
    public String dateDebut() throws Exception{
        return DateUtil.convert(dateDebut);
    }
    public String dateFin() throws Exception{
        return DateUtil.convert(dateFin);
    }
    
    public String dateCommande() throws Exception{
        return DateUtil.convert(dateCommande);
    }
    
    public String dateAcquisition() throws Exception{
        return DateUtil.convert(dateAcquisition);
    }
    
    public String dateRetour() throws Exception{
        return DateUtil.convert(dateRetour);
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
    public int getTotal(List<CommandeStock> commandeStock) throws Exception{
        int total = 0; 
        int jour = DateUtil.nombreJ(dateDebut, dateFin);
        int size= commandeStock.size(); 
        for(int i=0;i<size;i++){
            CommandeStock temp = commandeStock.get(i); 
           total+= temp.getQuantiteCommande()*temp.getPrixLocation()*jour;
        }      
        return total; 
    }
    public int nombreJour() throws Exception {
        return DateUtil.nombreJ(dateDebut, dateFin);
    }
}
