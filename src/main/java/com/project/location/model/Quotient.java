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
public class Quotient extends BaseModel {
    private double volaM; 

    public double getVolaM() {
        return volaM;
    }

    public void setVolaM(double volaM) throws Exception {
        Test.doubleNegatif(volaM, "l'argent du quotient");
        this.volaM = volaM;
    }
}
