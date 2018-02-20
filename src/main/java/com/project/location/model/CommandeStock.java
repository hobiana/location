/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.model;

import com.project.location.util.NumberTest;

/**
 *
 * @author Diary
 */
public class CommandeStock extends BaseModel {
    private Stock stock; 
    private Commande commande; 
    private double quantiteCommande; 
    private double quantiteRetour;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public String quantiteCommande(){
        return NumberTest.toMoney(quantiteCommande);
    }
    public String quantiteRetour(){
        return NumberTest.toMoney(quantiteRetour);
    }
    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public double getQuantiteCommande() {
        return quantiteCommande;
    }

    public void setQuantiteCommande(double quantiteCommande) {
        this.quantiteCommande = quantiteCommande;
    }

    public double getQuantiteRetour() {
        return quantiteRetour;
    }

    public void setQuantiteRetour(double quantiteRetour) {
        this.quantiteRetour = quantiteRetour;
    }
    
    
}
