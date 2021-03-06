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
    private int prixLocation; 
    private int quantite; 
    private int prixCasse;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrixCasse() {
        return prixCasse;
    }

    public void setPrixCasse(int prixCasse) {
        this.prixCasse = prixCasse;
    }
    

    public Stock() { }
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
        if(designation.compareTo("")==0)throw new Exception("Vueillez inserer une d�signation");
        this.designation = designation;
    }
    
    public int getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(int prixLocation) throws Exception {
        if(prixLocation<0)throw new Exception("le prix du location ne peut pas �tre inf�rieure � 0");
        this.prixLocation = prixLocation;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) throws Exception {
        if(quantite<0)throw new Exception("la quantite du stock ne peut pas �tre inf�rieure � 0");
        this.quantite = quantite;
    }

    public Stock(long id) {
        super.setId(id);
        super.reference = Reference.STOCK;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        super.reference = reference;
    }
    
    
    
}
