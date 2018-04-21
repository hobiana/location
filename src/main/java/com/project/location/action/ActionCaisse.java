/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

import com.opensymphony.xwork2.Action;
import com.project.location.model.Caisse;
import com.project.location.model.ESArgentCaisseModel;
import com.project.location.model.ESArgentModel;
import com.project.location.model.EntreeVola;
import com.project.location.model.SortieVola;
import com.project.location.model.Users;
import com.project.location.service.ServiceCaisse;
import com.project.location.service.ServiceCaisseQuotient;
import com.project.location.util.NumberTest;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hobiana
 */
public class ActionCaisse extends BaseAction{
    private ServiceCaisse serviceCaisse;
    private ServiceCaisseQuotient serviceCaisseQuotient;
    
    private double volaM;
    private String designation;
    private String soldeMin;
    private String soldeMax;
    private String dateMin;
    private String dateMax;
    private String type;
    
    private String soldeCaisse;
    
    private List<ESArgentCaisseModel> listeCaisse;

    public String getSoldeMin() {
        return soldeMin;
    }

    public void setSoldeMin(String soldeMin) {
        this.soldeMin = soldeMin;
    }

    public String getSoldeMax() {
        return soldeMax;
    }

    public void setSoldeMax(String soldeMax) {
        this.soldeMax = soldeMax;
    }

    public String getQuantiteMin() {
        return soldeMin;
    }

    public void setQuantiteMin(String quantiteMin) {
        this.soldeMin = quantiteMin;
    }

    public String getQuantiteMax() {
        return soldeMax;
    }

    public void setQuantiteMax(String quantiteMax) {
        this.soldeMax = quantiteMax;
    }

    public String getDateMin() {
        return dateMin;
    }

    public void setDateMin(String dateMin) {
        this.dateMin = dateMin;
    }

    public String getDateMax() {
        return dateMax;
    }

    public void setDateMax(String dateMax) {
        this.dateMax = dateMax;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ServiceCaisseQuotient getServiceCaisseQuotient() {
        return serviceCaisseQuotient;
    }

    public void setServiceCaisseQuotient(ServiceCaisseQuotient serviceCaisseQuotient) {
        this.serviceCaisseQuotient = serviceCaisseQuotient;
    }

    public List<ESArgentCaisseModel> getListeCaisse() {
        return listeCaisse;
    }

    public void setListeCaisse(List<ESArgentCaisseModel> listeCaisse) {
        this.listeCaisse = listeCaisse;
    }

    public String getSoldeCaisse() {
        return soldeCaisse;
    }

    public void setSoldeCaisse(String soldeCaisse) {
        this.soldeCaisse = soldeCaisse;
    }

    public double getVolaM() {
        return volaM;
    }

    public void setVolaM(double volaM) {
        this.volaM = volaM;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public ServiceCaisse getServiceCaisse() {
        return serviceCaisse;
    }

    public void setServiceCaisse(ServiceCaisse serviceCaisse) {
        this.serviceCaisse = serviceCaisse;
    }
    
    public String caisse(){
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        
        try {
            this.soldeCaisse=NumberTest.toMoney((int)serviceCaisse.getSoldeCaisse());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.titre="Caisse";
        return Action.SUCCESS;
    }
    
    public String inCaisse(){
        try {
            EntreeVola entree = new EntreeVola();
            entree.setDate(Calendar.getInstance().getTime());
            entree.setVolaM(volaM);
            entree.setDesignation(designation);
            serviceCaisse.addVolaCaisse(entree);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }
    
    public String outCaisse(){
        try {
            SortieVola sortie = new SortieVola();
            sortie.setDate(Calendar.getInstance().getTime());
            sortie.setVolaM(volaM);
            sortie.setDesignation(designation);
            serviceCaisse.sortieVolaCaisse(sortie);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }
    
    public String historiquecaisse(){
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        this.titre="Historique Caisse";
        
        try{
            designation=this.setDefaultValue(designation);
            dateMin=this.setDefaultValue(dateMin);
            dateMax=this.setDefaultValue(dateMax);
            type=this.setDefaultValue(type);
            if(soldeMin.equals("")||soldeMin==null)
            {
                soldeMin="0";
            }
            if(soldeMax.equals("")||soldeMax==null)
            {
                soldeMax="0";
            }
            this.listeCaisse = this.serviceCaisseQuotient.findCaisse(designation, soldeMin, soldeMax, dateMin, dateMax, type);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return Action.SUCCESS;
    }
    
    public String findcaisse(){
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        return Action.SUCCESS;
    }
    
    private String setDefaultValue(String val){
        if(val==null||val==""){
            val="";
            return val;
        }else{
            return val;
        }
    }
}
