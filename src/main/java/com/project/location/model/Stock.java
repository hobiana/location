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
public class Stock extends BaseModel {
    private String designation; 
    private double prixAchat; 
    private double prixLocation; 
    private int quantite; 

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) throws Exception {
        if(designation.compareTo("")==0)throw new Exception("Vueillez inserer une d�signation");
        this.designation = designation;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) throws Exception {
        if(prixAchat<0)throw new Exception("le prix d'achat ne peut pas �tre inf�rieure � 0");
        this.prixAchat = prixAchat;
    }

    public double getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(double prixLocation) throws Exception {
        if(prixLocation<0)throw new Exception("le prix du location ne peut pas �tre inf�rieure � 0");
        this.prixLocation = prixLocation;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) throws Exception {
        if(quantite<1)throw new Exception("la quantite du stock ne peut pas �tre inf�rieure � 0");
        this.quantite = quantite;
    }
    
}