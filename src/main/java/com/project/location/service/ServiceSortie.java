/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.service;

import com.project.location.model.Sortie;
import com.project.location.model.Stock;
import com.project.location.util.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Diary
 */
public class ServiceSortie extends BaseService{
    private ServiceStock ServiceStock;
    private ServiceUtil serviceUtil;

    public ServiceUtil getServiceUtil() {
        return serviceUtil;
    }

    public void setServiceUtil(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }
    
    public ServiceStock getServiceStock() {
        return ServiceStock;
    }

    public void setServiceStock(ServiceStock ServiceStock) {
        this.ServiceStock = ServiceStock;
    }
    
    public void insert(Sortie sortie)throws Exception{
        try{
            this.hibernateDao.save(sortie);           
            Stock stock = this.ServiceStock.find(sortie.getStock().getId());
            int value = stock.getQuantite()-sortie.getQuantite();
            if(value<0)throw new Exception("stock insuffisant pour cette sortie");
            stock.setQuantite(value);
            try{
                this.ServiceStock.update(stock);
            }catch(Exception e){
                this.hibernateDao.delete(sortie);
                throw e;
            }          
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Impossible de faire cette sortie cause : "+e.getMessage());
        }
    }
    public Sortie find(long id)throws Exception{
        Sortie sortie = new Sortie(id);
        try{
            this.hibernateDao.findById(sortie);
            return sortie;
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Impossible d'extraire la sortie id : "+id+" cause : "+e.getMessage());
        }
    }
    public List<Sortie> find()throws Exception{
        List<Sortie> reponse = null; 
        try{
            reponse = (List<Sortie>)(Object) this.hibernateDao.findAll(new Sortie());
            return reponse;
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Impossible d'extraire les sortie du stock cause "+e.getMessage());
        }
        
    }
    public List<Sortie> find(String designation, int quantiteMin, int quantiteMax, Date dateMin, Date dateMax) throws Exception{
        List<Object[]> arg = new ArrayList<>(); 
        Object[] des = Test.instance(2);
            des[0] = "stock.designation";
            des[1] = designation;
            if(Test.argmumentNull(designation))des=null;
        Object[] quantite =Test.instance(3) ;
            quantite[0] = "quantite";
        if(quantiteMin<quantiteMax){
            quantite[1] = quantiteMin;
            quantite[2] = quantiteMax;          
        }else if(quantiteMax<quantiteMin){            
            quantite[1] = quantiteMax;  
            quantite[2] = quantiteMin;    
        }else if(quantiteMin==0&&quantiteMax>0){
            quantite = Test.instance(2);
            quantite[0] = "quantite";
            quantite[1] = quantiteMax;
        }else if(quantiteMax==0&&quantiteMin>0){
            quantite = Test.instance(2);
            quantite[0] = "quantite";
            quantite[1] = quantiteMin;
        }else if(quantiteMax==0&&quantiteMin==0){
            quantite = null;
        }else{
            quantite = Test.instance(2);
            quantite[0] = "quantite";
            quantite[1] = quantiteMin;
        }
//        date init 
        Object[] date = Test.instance(3); 
        date[0] = "date";
        if(dateMin.before(dateMax)){
            date[1] = dateMin;
            date[2] = dateMax;
        }else if(dateMax.before(dateMin)){            
            date[1] = dateMax;  
            date[2] = dateMin;    
        }else if(dateMin==null&&dateMax!=null){
            date = Test.instance(2);
            date[0] = "date";
            date[1] = dateMax;
        }else if(dateMax==null&&dateMin!=null){
            date = Test.instance(2);
            date[0] = "date";
            date[1] = dateMin;
        }else if(dateMax==null&&dateMin==null){
            date = null;
        }else{
            date = Test.instance(2);
            date[0] = "date";
            date[1] = dateMin;
        }
        
       
        if(!Test.testNull(des))arg.add(des);
        if(!Test.testNull(quantite))arg.add(quantite);
      
        if(!Test.testNull(date))arg.add(date);
        List<Sortie> reponse = null;
        try{
            reponse = (List<Sortie>)(Object) this.serviceUtil.find(arg, Stock.class);
            return reponse;
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Impossible d'extraire la recherche");
        }
    }
}
