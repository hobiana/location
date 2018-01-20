/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.evenementiel.model;

import com.project.location.evenementiel.util.Test;
import java.util.Date;

/**
 *
 * @author Diary
 */
public class Entree extends BaseModel {
    private Stock stock; 
    protected double quantite; 
    private Date date; 

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) throws Exception {
        Test.doubleNegatif(quantite, "La quantit� d'entr�e");
        this.quantite = quantite;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
