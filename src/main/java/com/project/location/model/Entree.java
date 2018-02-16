/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.model;

import com.project.location.reference.Reference;
import com.project.location.util.DateUtil;
import com.project.location.util.NumberTest;
import com.project.location.util.Test;
import java.util.Date;

/**
 *
 * @author Diary
 */
public class Entree extends ESStockModel {
    
    private double prixAchat;
    
    
    public String prixAchat(){
        return NumberTest.toMoney(prixAchat);
    }
  
    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }
    @Override
    public void setQuantite(int quantite) throws Exception {
        Test.doubleNegatif(quantite, "La quantité d'entrée");
        this.quantite = quantite;
    }

    public Entree(long id) {
        super.setReference(Reference.ENTREE);
        super.setId(id);
    }

    public Entree() {
        super.setReference(Reference.ENTREE);
    }
    
    
    
}
