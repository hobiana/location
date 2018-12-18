/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.model;

/**
 *
 * @author Diary
 */
public class HorsSotck extends BaseModel{
    private Commande commande;
    private String libelle; 
    private int quantite; 
    private int quantiteRetour; 
    private double montant;
    private boolean retour_HS;

    public int getQuantiteRetour() {
        return quantiteRetour;
    }

    public void setQuantiteRetour(int quantiteRetour) {
        this.quantiteRetour = quantiteRetour;
    }

    public boolean isRetour_HS() {
        return retour_HS;
    }

    public void setRetour_HS(boolean retour_HS) {
        this.retour_HS = retour_HS;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public HorsSotck() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
    
}
