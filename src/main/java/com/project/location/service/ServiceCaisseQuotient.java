/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.service;

import com.project.location.model.ESArgentCaisseModel;
import com.project.location.model.ESArgentQuotientModel;
import com.project.location.model.EntreeQuotient;
import com.project.location.model.EntreeVola;
import com.project.location.util.DateUtil;
import com.project.location.util.NumberTest;
import com.project.location.util.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Diary
 */
public class ServiceCaisseQuotient extends BaseService{
    public ServiceUtil serviceUtil;

    public ServiceUtil getServiceUtil() {
        return serviceUtil;
    }

    public void setServiceUtil(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }
    
    private List<ESArgentCaisseModel> findCaisse(String designation,double volaMin, double volaMax, String dateMin, String dateMax,String type) throws Exception{
        List<Object[]> arg = new ArrayList<>(); 
        Object[] des = Test.instance(2);
            des[0] = "description";
            des[1] = designation;
        if(Test.argmumentNull(designation))des=null;
        Object[] quantite =Test.instance(3) ;
            quantite[0] = "volaM";
        if(volaMin<volaMax){
            quantite[1] = volaMin;
            quantite[2] = volaMax;          
        }else if(volaMax<volaMin){            
            quantite[1] = volaMax;  
            quantite[2] = volaMin;    
        }else if(volaMin==0&&volaMax>0){
            quantite[1] = 0;
            quantite[2] = volaMax;
        }else if(volaMax==0&&volaMin>0){
            quantite[1] = 0;
            quantite[2] = volaMin;
        }else if(volaMax==0&&volaMin==0){
            quantite = null;
        }else{
            quantite = Test.instance(2);
            quantite[0] = "volaM";
            quantite[1] = volaMin;
        }
//        date init 
        Object[] date = Test.instance(3); 
        date[0] = "date";
        Date dateMinD = null;
        Date dateMaxD = null;
        if(!Test.argmumentNull(dateMin)) dateMinD = DateUtil.convert(dateMin);
        if(!Test.argmumentNull(dateMax)) dateMaxD = DateUtil.convert(dateMax);
        if(dateMaxD!=null&&dateMinD!=null&&dateMinD.before(dateMaxD)){
            date[1] = dateMinD;
            date[2] = dateMaxD;
        }else if(dateMaxD!=null&&dateMinD!=null&&dateMaxD.before(dateMinD)){            
            date[1] = dateMaxD;  
            date[2] = dateMinD;    
        }else if(dateMinD==null&&dateMaxD!=null){
            date = Test.instance(2);
            date[0] = "date";
            date[1] = dateMaxD;
        }else if(dateMaxD==null&&dateMinD!=null){
            date = Test.instance(2);
            date[0] = "date";
            date[1] = dateMinD;
        }else if(dateMaxD==null&&dateMinD==null){
            date = null;
        }else{
            date = Test.instance(2);
            date[0] = "date";
            date[1] = dateMin;
        }
        
        Object[] types = Test.instance(2);
            types[0] = "type";
            types[1] = type;
        if(Test.argmumentNull(type))type=null;
        
        if(!Test.testNull(types))arg.add(types);
        if(!Test.testNull(des))arg.add(des);
        if(!Test.testNull(quantite))arg.add(quantite);
        if(!Test.testNull(date))arg.add(date);
        List<ESArgentCaisseModel> reponse = null;
        try{
            reponse = (List<ESArgentCaisseModel>)(Object) this.serviceUtil.find(arg, EntreeVola.class);
            return reponse;
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Impossible d'extraire la recherche");
        }
    }
    
    private List<ESArgentQuotientModel> findQuotient(String designation,double volaMin, double volaMax, String dateMin, String dateMax,String type) throws Exception{
        List<Object[]> arg = new ArrayList<>(); 
        Object[] des = Test.instance(2);
            des[0] = "description";
            des[1] = designation;
        if(Test.argmumentNull(designation))des=null;
        Object[] quantite =Test.instance(3) ;
            quantite[0] = "volaM";
        if(volaMin<volaMax){
            quantite[1] = volaMin;
            quantite[2] = volaMax;          
        }else if(volaMax<volaMin){            
            quantite[1] = volaMax;  
            quantite[2] = volaMin;    
        }else if(volaMin==0&&volaMax>0){
            quantite[1] = 0;
            quantite[2] = volaMax;
        }else if(volaMax==0&&volaMin>0){
            quantite[1] = 0;
            quantite[2] = volaMin;
        }else if(volaMax==0&&volaMin==0){
            quantite = null;
        }else{
            quantite = Test.instance(2);
            quantite[0] = "volaM";
            quantite[1] = volaMin;
        }
//        date init 
        Object[] date = Test.instance(3); 
        date[0] = "date";
        Date dateMinD = null;
        Date dateMaxD = null;
        if(!Test.argmumentNull(dateMin)) dateMinD = DateUtil.convert(dateMin);
        if(!Test.argmumentNull(dateMax)) dateMaxD = DateUtil.convert(dateMax);
        if(dateMaxD!=null&&dateMinD!=null&&dateMinD.before(dateMaxD)){
            date[1] = dateMinD;
            date[2] = dateMaxD;
        }else if(dateMaxD!=null&&dateMinD!=null&&dateMaxD.before(dateMinD)){            
            date[1] = dateMaxD;  
            date[2] = dateMinD;    
        }else if(dateMinD==null&&dateMaxD!=null){
            date = Test.instance(2);
            date[0] = "date";
            date[1] = dateMaxD;
        }else if(dateMaxD==null&&dateMinD!=null){
            date = Test.instance(2);
            date[0] = "date";
            date[1] = dateMinD;
        }else if(dateMaxD==null&&dateMinD==null){
            date = null;
        }else{
            date = Test.instance(2);
            date[0] = "date";
            date[1] = dateMin;
        }
        
        Object[] types = Test.instance(2);
            types[0] = "type";
            types[1] = type;
        if(Test.argmumentNull(type))type=null;
        
        if(!Test.testNull(types))arg.add(types);
        if(!Test.testNull(des))arg.add(des);
        if(!Test.testNull(quantite))arg.add(quantite);
        if(!Test.testNull(date))arg.add(date);
        List<ESArgentQuotientModel> reponse = null;
        try{
            reponse = (List<ESArgentQuotientModel>)(Object) this.serviceUtil.find(arg, EntreeQuotient.class);
            return reponse;
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Impossible d'extraire la recherche");
        }
    }
    
    
    public List<ESArgentCaisseModel> findCaisse(String designation,String quantiteMin, String quantiteMax, String dateMin, String dateMax,String type) throws Exception{
        return this.findCaisse(designation,NumberTest.toDouble(quantiteMin),NumberTest.toDouble(quantiteMax), dateMin, dateMax, type);
    }
    
    public List<ESArgentQuotientModel> findQuotient(String designation,String quantiteMin, String quantiteMax, String dateMin, String dateMax,String type) throws Exception{
        return this.findQuotient(designation,NumberTest.toDouble(quantiteMin),NumberTest.toDouble(quantiteMax), dateMin, dateMax, type);
    }
    
}
