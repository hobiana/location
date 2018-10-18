/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.model;

import com.project.location.util.NumberTest;
import java.util.Date;

/**
 *
 * @author Diary
 */
public class StatModel {
    private Double value; 
    private Date date;
    private Object other;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Object getOther() {
        return other;
    }

    public void setOther(Object other) {
        this.other = other;
    }
    public String toMoney(){
        return NumberTest.toMoney(this.value);
    }
    
}
