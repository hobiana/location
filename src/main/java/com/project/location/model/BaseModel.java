/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.model;

import com.project.location.util.NumberTest;

/**
 *
 * @author diary
 */
public class BaseModel {
    protected long id;
    protected String reference;

    protected String getReference() {
        return reference;
    }

    protected void setReference(String reference) {
        this.reference = reference;
    }
    public String getRef(){
        return this.getReference()+NumberTest.toRef(id);
    }
    public long getId(String reference) throws Exception{
        return (long) NumberTest.referenceToNumber(reference);
    }

    public BaseModel() {
    }
  
    public BaseModel(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
}
