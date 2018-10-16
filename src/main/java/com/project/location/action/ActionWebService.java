/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

/**
 *
 * @author Diary
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.Action;
import com.project.location.model.JsonResult;
import com.project.location.service.ServiceStat;
import com.project.location.util.DateUtil;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ActionWebService extends BaseAction{
    private ServiceStat serviceStat;
    private String debut;
    private String fin;
    private String jsonResult;
    private JsonResult objectResult;
    private long idClient; 
    
    public String getArticlePreferer(){
        JsonResult result = null;
        try {
            Date debutD = DateUtil.convert(debut);
            Date finD = DateUtil.convert(fin); 
            Object resultQuery =  (Object)this.serviceStat.getPreferencePerMonth(debutD, finD);
            result = new JsonResult(true,resultQuery);
           
        } catch (Exception ex) {
            result = new JsonResult(false, ex.getMessage());
        } 
        this.objectResult = result;
        return Action.SUCCESS;
    }
    public String getArticleCasse(){
        JsonResult result = null;
        try {
            Date debutD = DateUtil.convert(debut);
            Date finD = DateUtil.convert(fin); 
            Object resultQuery =  (Object)this.serviceStat.getArticleCassePerMonth(debutD, finD);
            result = new JsonResult(true,resultQuery);        
        } catch (Exception ex) {
            result = new JsonResult(false, ex.getMessage());
        } 
        this.objectResult = result;
        return Action.SUCCESS;
    }
    
    public String getArcticleCasse(){
        return Action.SUCCESS;
    }

    public ServiceStat getServiceStat() {
        return serviceStat;
    }

    public void setServiceStat(ServiceStat serviceStat) {
        this.serviceStat = serviceStat;
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(String jsonResult) {
        this.jsonResult = jsonResult;
    }

    public JsonResult getObjectResult() {
        return objectResult;
    }

    public void setObjectResult(JsonResult objectResult) {
        this.objectResult = objectResult;
    }
    
    
    
    
}
