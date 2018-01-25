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
public class Client extends BaseModel {
    private String nom; 
    private String prenom; 
    private String CIN; 
    private String adresse; 
    private Date dateNaissance;
    private boolean blackListe; 

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

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) throws Exception {
        if(CIN.length()!=12)throw new Exception("CIN invalide");
        this.CIN = CIN;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public boolean isBlackListe() {
        return blackListe;
    }

    public void setBlackListe(boolean blackListe) {
        this.blackListe = blackListe;
    }
    
    
}
