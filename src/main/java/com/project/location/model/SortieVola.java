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
public class SortieVola extends ESArgentCaisseModel{
    public void setVolaM(double volaM) throws Exception{
         Test.doubleNegatif(volaM,"La valeur de l'argent sortant");
        this.volaM = volaM;
    }
     
    public SortieVola() {
        super.type="sortie"; 
    }
     
}
