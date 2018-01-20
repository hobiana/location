/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.evenementiel.model;

/**
 *
 * @author Diary
 */
public class UsersAcces extends BaseModel {
    private Users user; 
    private Acces acces; 

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Acces getAcces() {
        return acces;
    }

    public void setAcces(Acces acces) {
        this.acces = acces;
    }
    
    
}
