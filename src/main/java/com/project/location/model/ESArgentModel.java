/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.model;

import java.util.Date;

/**
 *
 * @author Diary
 */
public class ESArgentModel extends BaseModel{
    protected double volaM; 
    protected Date date; 
    protected String designation; 
    protected String reference; 

    public double getVolaM() {
        return volaM;
    }

    public void setVolaM(double volaM) throws Exception {
        this.volaM = volaM;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
    
    
}
