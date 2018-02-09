/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.model;

import com.project.location.util.Test;
import java.util.Date;

/**
 *
 * @author Diary
 */
public class Entree extends BaseModel {
    private Stock stock; 
    protected int quantite; 
    private Date date; 

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) throws Exception {
        Test.doubleNegatif(quantite, "La quantité d'entrée");
        this.quantite = quantite;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Entree(long id) {
        super.setId(id);
    }

    public Entree() {
    }
    
    
    
}
