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
public class HistoriqueUser extends BaseModel{
    private Users user; 
    private String action; 
    private Date dateHU; 

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getDateHU() {
        return dateHU;
    }

    public void setDateHU(Date dateHU) {
        this.dateHU = dateHU;
    }
   
    
}
