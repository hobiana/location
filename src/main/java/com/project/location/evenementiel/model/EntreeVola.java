/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.evenementiel.model;

import com.project.location.evenementiel.util.Test;

/**
 *
 * @author Diary
 */
public class EntreeVola extends ESArgentModel{
    
    public void setVolaM(double volaM) throws Exception {
         Test.doubleNegatif(volaM,"La valeur de l'argent entrant ");
        this.volaM = volaM;
    }
}
