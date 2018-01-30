/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.model;

import com.project.location.util.Test;
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
    private boolean blackListe; 

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws Exception {
        Test.argmumentTest(nom,"nom");
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom)throws Exception {
        Test.argmumentTest(prenom,"prenom");
        this.prenom = prenom;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) throws Exception {
        if(CIN.length()!=12)throw new Exception("inserer les 12 chiffres de la CIN");
        Test.castInt(CIN,"la CIN");
        this.CIN = CIN;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) throws Exception {
        Test.argmumentTest(adresse,"l'adresse");
        this.adresse = adresse;
    }

    public boolean isBlackListe() {
        return blackListe;
    }

    public void setBlackListe(boolean blackListe) {
        this.blackListe = blackListe;
    }
    public void setBlackListe(String blackListe)throws Exception {
        Test.argmumentTest(blackListe,"blacklist");
        if(blackListe.compareTo("true")==0){
            this.blackListe = true;
        }else{
            this.blackListe = false;
        }
        
    }
    
    public Client(){}
    public Client(long id){
        this.setId(id);
    }
    
}
