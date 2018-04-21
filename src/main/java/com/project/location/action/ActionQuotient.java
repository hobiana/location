/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

import com.opensymphony.xwork2.Action;
import com.project.location.model.ESArgentQuotientModel;
import com.project.location.model.EntreeQuotient;
import com.project.location.model.SortieQuotient;
import com.project.location.model.Users;
import com.project.location.service.ServiceCaisse;
import com.project.location.service.ServiceCaisseQuotient;
import com.project.location.util.NumberTest;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Hobiana
 */
public class ActionQuotient extends BaseAction{
    private ServiceCaisse serviceCaisse;
    private ServiceCaisseQuotient serviceCaisseQuotient;
    
    private double volaM;
    private String designation;
    private String soldeMin;
    private String soldeMax;
    private String dateMin;
    private String dateMax;
    private String type;
    
    private String soldeQuotient;
    
    private List<ESArgentQuotientModel> listeQuotient;

    public List<ESArgentQuotientModel> getListeQuotient() {
        return listeQuotient;
    }

    public void setListeQuotient(List<ESArgentQuotientModel> listeQuotient) {
        this.listeQuotient = listeQuotient;
    }

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
            this.listeQuotient = this.serviceCaisseQuotient.findQuotient(designation, soldeMin, soldeMax, dateMin, dateMax, type);
            type="";
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return Action.SUCCESS;
    }
    
    public String findquotient(){
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
