/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

import com.opensymphony.xwork2.Action;
import com.project.location.model.EntreeVola;
import com.project.location.model.SortieVola;
import com.project.location.model.Users;
import com.project.location.service.ServiceCaisse;
import com.project.location.util.NumberTest;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hobiana
 */
public class ActionCaisse extends BaseAction{
    private ServiceCaisse serviceCaisse;
    
    private double volaM;
    private String designation;
    
    private String soldeCaisse;

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
        return Action.SUCCESS;
    }
}
