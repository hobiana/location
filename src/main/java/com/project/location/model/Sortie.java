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
    public void setQuantite(double quantite) throws Exception {
        Test.doubleNegatif(quantite, "La quantit� de sortie");
        this.quantite = quantite;
    }
}