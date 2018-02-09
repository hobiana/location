/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

import com.opensymphony.xwork2.Action;

/**
 *
 * @author Hobiana
 */
public class ActionStock extends BaseAction {
    private String designation; 
    private double prixAchat; 
    private double prixLocation; 
    private int quantite;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public double getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(double prixLocation) {
        this.prixLocation = prixLocation;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    public String load() throws Exception {
        this.titre="Stock";
        return Action.SUCCESS;
    }
    
    public String inStock() throws Exception {
        this.titre="Entrée de Stock";
        return Action.SUCCESS;
    }
    
    public String outStock() throws Exception {
        this.titre="Sortie de Stock";
        return Action.SUCCESS;
    }
    
    public String updateStock() throws Exception {
        this.titre="Modification de Stock";
        return Action.SUCCESS;
    }
    
    public String listInStock() throws Exception {
        this.titre="Liste entrée de Stock";
        return Action.SUCCESS;
    }
    
    public String listOutStock() throws Exception {
        this.titre="Liste sortie de Stock";
        return Action.SUCCESS;
    }
}
