/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.model;

import com.project.location.util.Test;

/**
 *
 * @author Diary
 */
public class Sortie extends Entree{
    @Override
    public void setQuantite(int quantite) throws Exception {
        Test.doubleNegatif(quantite, "La quantité de sortie");
        this.quantite = quantite;
    }

    public Sortie() {
    }

    public Sortie(long id) {
        super.setId(id);
    }
    
}
