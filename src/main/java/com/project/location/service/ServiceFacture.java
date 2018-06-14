/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.service;

import com.project.location.dao.HibernateDao;
import com.project.location.model.Commande;
import com.project.location.model.Facture;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Diary
 */
public class ServiceFacture extends BaseService {
    public void newFacture(Facture facture)throws Exception{
        try{
            this.hibernateDao.save(facture);
        }catch(Exception e){
            throw new Exception("impossible de sauvegarder la facture");
        }
    }
    public static void newFacture(Facture facture, Session session)throws Exception{
        try{
            HibernateDao.save(facture,session);
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("impossible de sauvegarder la facture");
        }
    }
    public Facture findFacture(long id)throws Exception{
        Facture facture = new Facture(id);
        try{
            this.hibernateDao.findById(facture);
        }catch(Exception e){
            throw new Exception("impossible de recuperer la facture");
        }
        return facture;
    }
    public Facture factureByCommande(long idCommande) throws Exception {
        Session session = null; 
        try{
            
            String sql = "SELECT facture FROM Facture facture JOIN facture.commande commande WHERE commande.id = :id";
            session = this.hibernateDao.getSessionFactory().openSession();
            Query query = session.createQuery(sql); 
            query.setParameter("id", idCommande);
            
            if(!query.list().isEmpty()) return (Facture)query.list().get(0);
            Commande commande = new Commande(idCommande);
            throw new Exception("Pas de résulat pour la recherche de la facture de la commande "+commande.getRef());
           
        } catch( HibernateException e) {
            throw e;
        } finally{
            if(session!=null) session.close();
        }
    }
    public Facture factureByCommande(long idCommande, Session session) throws Exception {
        try{
            
            String sql = "SELECT facture FROM Facture facture JOIN facture.commande commande WHERE commande.id = :id";
            Query query = session.createQuery(sql); 
            query.setParameter("id", idCommande);
            
            if(!query.list().isEmpty()) return (Facture)query.list().get(0);
            Commande commande = new Commande(idCommande);
            throw new Exception("Pas de résulat pour la recherche de la facture de la commande "+commande.getRef());
           
        } catch( HibernateException e) {
            throw e;
        }
    }
    public void updateFacture(Facture facture)throws Exception{
        try{
            this.hibernateDao.update(facture);
        }catch(Exception e){
            throw new Exception("impossible de sauvegarder la facture");
        }
    }
    public static void updateFacture(Facture facture, Session session)throws Exception{
        try{
            HibernateDao.update(facture,session);
        }catch(Exception e){
            throw new Exception("impossible de sauvegarder la facture");
        }
    }
}
