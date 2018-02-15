/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.model;

import com.project.location.reference.Reference;
import com.project.location.util.NumberTest;

/**
 *
 * @author Diary
 */
public class Stock extends BaseModel {
    private String designation; 
    private double prixLocation; 
    private int quantite; 

    public Stock() {
        this.reference = Reference.STOCK;
    }
    public String quantite(){
        return NumberTest.toMoney(quantite);
    }
    public String getPL(){
        return NumberTest.toMoney(prixLocation);
    }
    
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) throws Exception {
        if(designation.compareTo("")==0)throw new Exception("Vueillez inserer une désignation");
        this.designation = designation;
    }
    
    public double getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(double prixLocation) throws Exception {
        if(prixLocation<0)throw new Exception("le prix du location ne peut pas être inférieure à 0");
        this.prixLocation = prixLocation;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) throws Exception {
        if(quantite<0)throw new Exception("la quantite du stock ne peut pas être inférieure à 0");
        this.quantite = quantite;
    }

    public Stock(long id) {
        super.setId(id);;
    }
    
}
