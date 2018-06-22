/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.service;

import com.project.location.exception.ConnexionException;
import com.project.location.model.Caisse;
import com.project.location.model.Client;
import com.project.location.model.Commande;
import com.project.location.model.Quotient;
import com.project.location.model.Stock;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Diary
 */
public class ServiceStat extends BaseService{
    public double caisseArgent() throws Exception{
        List<Caisse> caisses = (List<Caisse>)(Object)this.hibernateDao.findAll(new Caisse());
        if(!caisses.isEmpty()) return caisses.get(0).getVolaM();
        return 0; 
    }
    public double quotientArgent() throws Exception{
        List<Quotient> quotients = (List<Quotient>)(Object)this.hibernateDao.findAll(new Quotient());
        if(!quotients.isEmpty()) return quotients.get(0).getVolaM();
        return 0; 
    }
    public double nombreCommandeTotal() throws ConnexionException, Exception{
        try{
            return this.hibernateDao.findAll(new Commande()).size();
        } catch(HibernateException e){
            e.printStackTrace();
            throw new ConnexionException("probleme de base de donnée");
        } catch (Exception ex) {
            throw new Exception("problème interne cause : "+ex.getMessage());
        }
    }
    public double nombreClientTotal() throws ConnexionException, Exception{
        try{
            return this.hibernateDao.findAll(new Client()).size();
        } catch(HibernateException e){
            throw new ConnexionException("probleme de base de donnée");
        } catch (Exception ex) {
            throw new Exception("problème interne cause : "+ex.getMessage());
        }
    }
    public double nombreProduitTotal() throws ConnexionException, Exception{
        try{
            return this.hibernateDao.findAll(new Stock()).size();
        } catch(HibernateException e){
            throw new ConnexionException("probleme de base de donnée");
        } catch (Exception ex) {
            throw new Exception("problème interne cause : "+ex.getMessage());
        }
    }
    public List<Double> nombreCommandeJour(Date debut, Date fin) throws ConnexionException {
        Session session = null; 
        List<Double> reponse = new ArrayList();
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            debut.setDate(debut.getDate()+1);   
            while(debut.before(fin)){
                reponse.add(this.nombreCommandeJjour(debut, session));
                debut.setDate(debut.getDate()+1);   
            }
            return reponse;
        }catch(HibernateException ex){
            throw new ConnexionException();
        }catch(ConnexionException e){
            throw e;
        }finally{
            if(session!=null) session.close();
        }
    }
    public double nombreCommandeJjour(Date debut, Session session) throws ConnexionException {
        try{
            Criteria criteria = session.createCriteria(Commande.class, "commande"); 
            criteria.add(Restrictions.eq("commande.dateCommande", debut));
            return criteria.list().size();
        }catch (HibernateException ex){
            throw new ConnexionException();
        }
    }
    
}
