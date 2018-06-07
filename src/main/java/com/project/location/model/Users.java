/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Access;

/**
 *
 * @author Diary
 */
public class Users extends BaseModel {
    private String nom; 
    private String prenom; 
    private String phone; 
    private String adresse; 
    private String pseudo;
    private String mdp;
    private List<UsersAcces> userAccess;

    public List<UsersAcces> getUserAccess() {
        return userAccess;
    }

    public void setUserAccess(List<UsersAcces> userAccess) {
        this.userAccess = userAccess;
    }

    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public Users(){
        this.userAccess = new ArrayList();}
    public Users(long id){
        super.setId(id);
        this.userAccess = new ArrayList();
    }
    
    
}
