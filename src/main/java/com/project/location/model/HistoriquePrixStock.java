/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.model;

import java.util.Date;

/**
 *
 * @author Hobiana
 */
public class HistoriquePrixStock extends BaseModel{
    private Stock stock; 
    private int prix; 
    private Date date; 

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public HistoriquePrixStock() {
    }

    public HistoriquePrixStock(long id) {
        super.setId(id);
    }
    
    
}
