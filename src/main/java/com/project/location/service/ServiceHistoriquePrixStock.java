/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.service;

import com.project.location.model.HistoriquePrixStock;
import com.project.location.model.Stock;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Hobiana
 */
public class ServiceHistoriquePrixStock extends BaseService{
    public void insert(HistoriquePrixStock historiquePrixStock) throws Exception{
        try{
            this.hibernateDao.save(historiquePrixStock);
        }catch(Exception e){
            throw new Exception("impossible de sauvegarder l'historique dans la base de donnée");
        }
    }
    public List<HistoriquePrixStock> find() throws Exception{
        List<HistoriquePrixStock> reponse; 
        try{
            reponse = (List<HistoriquePrixStock>)(Object)this.hibernateDao.findAll(new HistoriquePrixStock());
            return reponse;
        }catch(Exception e){
            throw new Exception("impossible d'extraire les historiques");
        }
    }
    public HistoriquePrixStock find(long id) throws Exception{
        HistoriquePrixStock historiquePrixStock = new HistoriquePrixStock(id);
        try{
            this.hibernateDao.findById(historiquePrixStock);
            return historiquePrixStock;
        }catch(Exception e){
            throw new Exception("impossible d'extraire l'historique "+id);
        }
    }
    public List<HistoriquePrixStock> find(Stock stock) throws Exception{
        Session session = null; 
        List<HistoriquePrixStock> reponse;
        try{
           session = this.hibernateDao.getSessionFactory().openSession();
           String sql = "SELECT historique FROM HistoriquePrixStock historique join historique.stock stock where stock.id = :id";
           Query query = session.createQuery(sql);
           query.setParameter("id", stock.getId());
           reponse = query.list();
           return reponse;
        }catch(Exception e){
            throw new Exception("impossible d'extraire les historique du stock "+stock.getRef());
        }finally{
            if(session!=null) session.close();
        }
    }
}
