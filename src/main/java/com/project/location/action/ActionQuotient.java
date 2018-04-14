/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

import com.opensymphony.xwork2.Action;
import com.project.location.model.EntreeQuotient;
import com.project.location.model.SortieQuotient;
import com.project.location.model.Users;
import com.project.location.service.ServiceCaisse;
import com.project.location.util.NumberTest;
import java.util.Calendar;

/**
 *
 * @author Hobiana
 */
public class ActionQuotient extends BaseAction{
    private ServiceCaisse serviceCaisse;
    
    private double volaM;
    private String designation;
    
    private String soldeQuotient;

    public String getSoldeQuotient() {
        return soldeQuotient;
    }

    public void setSoldeQuotient(String soldeQuotient) {
        this.soldeQuotient = soldeQuotient;
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
    
    public String quotient(){
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        try{
            this.soldeQuotient=NumberTest.toMoney((int)serviceCaisse.getSoldeQuotient());
            this.titre="Quotient";
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
       
        return Action.SUCCESS;
    }
    
    public String inQuotient(){
        try {
            EntreeQuotient entree = new EntreeQuotient();
            entree.setDate(Calendar.getInstance().getTime());
            entree.setVolaM(volaM);
            entree.setDesignation(designation);
            serviceCaisse.addVolaQuotient(entree);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }
    
    public String outQuotient(){
        try {
            SortieQuotient sortie = new SortieQuotient();
            sortie.setDate(Calendar.getInstance().getTime());
            sortie.setVolaM(volaM);
            sortie.setDesignation(designation);
            serviceCaisse.sortieVolaQuotient(sortie);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }
    
    public String historiquequotient(){
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        this.titre="Historique Quotient";
        return Action.SUCCESS;
    }
}
