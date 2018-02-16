/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.model;

import com.project.location.util.DateUtil;
import com.project.location.util.NumberTest;
import java.util.Date;

/**
 *
 * @author Diary
 */
public class ESStockModel extends BaseModel{
    protected Stock stock; 
    protected int quantite; 
    protected Date date; 

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
        this.quantite = quantite;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getDateString() throws Exception{
        return DateUtil.convert(date);
    }
    
    public String quantite(){
        return NumberTest.toMoney(quantite);
    }
}
