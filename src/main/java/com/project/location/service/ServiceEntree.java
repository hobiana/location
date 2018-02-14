/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.service;

import com.project.location.model.Entree;
import com.project.location.model.Stock;
import com.project.location.util.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Diary
 */
public class ServiceEntree extends BaseService{
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
    
    public void insert(Entree entree)throws Exception{
        try{
            this.hibernateDao.save(entree);           
            Stock stock = this.ServiceStock.find(entree.getStock().getId());
            stock.setQuantite(stock.getQuantite()+entree.getQuantite());
            try{
                this.ServiceStock.update(stock);
            }catch(Exception e){
                this.hibernateDao.delete(entree);
                throw e;
            }                    
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Impossible d'inserer l'entree dans la BDD cause "+e.getMessage());
        }
    }
    public List<Entree> find()throws Exception{
        List<Entree> reponse= null; 
        try{
            reponse = (List<Entree>)(Object) this.hibernateDao.findAll(new Entree());
            return reponse; 
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Impossible d'extraire tout les entr�es cause : "+e.getMessage());
        }
    }
    public Entree find(long id)throws Exception{
        Entree entree = new Entree(id); 
        try{
            this.hibernateDao.findById(entree);
            return entree; 
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Impossible d'extraire l'entr�es "+id+" cause : "+e.getMessage());
        }
    }
    public List<Entree> find(String designation, int paMin, int paMax, int quantiteMin, int quantiteMax, Date dateMin, Date dateMax) throws Exception{
        List<Object[]> arg = new ArrayList<>(); 
        Object[] des = Test.instance(2);
            des[0] = "stock.designation";
            des[1] = designation;
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
        
        Object[] pa =Test.instance(3) ;
            pa[0] = "stock.prixAchat";
        if(paMin<paMax){
            pa[1] = paMin;
            pa[2] = paMax;          
        }else if(paMax<paMin){            
            pa[1] = paMax;  
            pa[2] = paMin;    
        }else if(paMin==0&&paMax>0){
            pa = Test.instance(2);
            pa[0] = "prixLocation";
            pa[1] = paMax;
        }else if(paMax==0&&paMin>0){
            pa = Test.instance(2);
            pa[0] = "prixLocation";
            pa[1] = paMin;
        }else if(paMax==0&&paMin==0){
            pa = null;
        }else{
            pa = Test.instance(2);
            pa[0] = "prixLocation";
            pa[1] = paMin;
        }     
        if(!Test.testNull(des))arg.add(des);
        if(!Test.testNull(quantite))arg.add(quantite);
        if(!Test.testNull(pa))arg.add(pa);
        if(!Test.testNull(date))arg.add(date);
        List<Entree> reponse = null;
        try{
            reponse = (List<Entree>)(Object) this.serviceUtil.find(arg, Stock.class);
            return reponse;
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Impossible d'extraire la recherche");
        }
    }
}