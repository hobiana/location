/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.service;

import com.project.location.dao.HibernateDao;
import com.project.location.model.Caisse;
import com.project.location.model.EntreeQuotient;
import com.project.location.model.EntreeVola;
import com.project.location.model.Quotient;
import com.project.location.model.SortieQuotient;
import com.project.location.model.SortieVola;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Diary
 */
public class ServiceCaisse extends BaseService {
    private ServiceCommande serviceCommande;

    public ServiceCommande getServiceCommande() {
        return serviceCommande;
    }

    public void setServiceCommande(ServiceCommande serviceCommande) {
        this.serviceCommande = serviceCommande;
    }
  
    private void addCaisse(Caisse caisse, Session session)throws Exception{
        try{
            HibernateDao.save(caisse, session);
        }catch(Exception e){
            throw new Exception("impossible de sauvegarder la caisse");
        }
    }
    
    private void addQuotient(Quotient quotient, Session session)throws Exception{
        try{
            HibernateDao.save(quotient, session);
        }catch(Exception e){
            throw new Exception("impossible de sauvegarder la caisse");
        }
    }
  
    private void deleteCaisse(Caisse caisse, Session session)throws Exception{
        try{
            HibernateDao.delete(caisse, session);
        }catch(Exception e){
            throw new Exception("impossible de mettre à jour la caisse");
        }
    }
    
    private void deleteQuotient(Quotient quotient, Session session)throws Exception{
        try{
            HibernateDao.delete(quotient, session);
        }catch(Exception e){
            throw new Exception("impossible de mettre à jour la caisse");
        }
    }
    
    private void addEntree(EntreeVola entree, Session session)throws Exception{
        try{
            HibernateDao.save(entree, session);
        }catch(Exception e){
            throw new Exception("impossible de sauvegarder l'entrée dans la caisse");
        }
    }
    
    private void addSortie(SortieVola sortie, Session session)throws Exception{
        try{
            HibernateDao.save(sortie, session);
        }catch(Exception e){
            throw new Exception("impossible de sauvegarder la sortie de caisse");
        }
    }
    
    private void addEntreeQuotient(EntreeQuotient entreeQuotient, Session session)throws Exception{
        try{
            HibernateDao.save(entreeQuotient, session);
        }catch(Exception e){
            throw new Exception("impossible de sauvegarder l'entrée dans la caisse");
        }
    }
    
    private void addSortieQuotient(SortieQuotient sortieQuotient, Session session)throws Exception{
        try{
            HibernateDao.save(sortieQuotient, session);
        }catch(Exception e){
            throw new Exception("impossible de sauvegarder l'entrée dans la caisse");
        }
    }
    
    private void cleanCaisse(Session session)throws Exception{
        try{
            List<Caisse> caisses = (List<Caisse>)(Object)HibernateDao.findAll(new Caisse(), session); 
            int size = caisses.size(); 
            for(int i =0; i<size;i++){
                this.deleteCaisse(caisses.get(i), session);
            } 
        }catch(Exception e){
            throw new Exception("impossible de mettre à jour la caisse");
        }
    }
    
    private void cleanQuotient(Session session)throws Exception{
        try{
            List<Quotient> quotient = (List<Quotient>)(Object)HibernateDao.findAll(new Quotient(), session); 
            int size = quotient.size(); 
            for(int i =0; i<size;i++){
                this.deleteQuotient(quotient.get(i), session);
            } 
        }catch(Exception e){
            throw new Exception("impossible de mettre à jour la quotient");
        }
    }
    
    public void addVolaCaisse(EntreeVola vola) throws Exception{
        Caisse caisse = new Caisse();       
        Session session = null; 
        Transaction tr = null; 
        double solde = 0;
        
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            solde = this.getSoldeCaisse(session);
            caisse.setVolaM(solde+vola.getVolaM());
            tr = session.beginTransaction();
            this.cleanCaisse(session);
            this.addCaisse(caisse, session);
            this.addEntree(vola, session);
            ServiceHistoriqueUser.save("ajout de la somme "+vola.getVolaM()+" Ar dans la caisse", session);
            tr.commit();
        }catch(Exception e){
            if(tr!=null) tr.rollback();
            throw e;
        }finally{
            if(session!=null)session.close();
        }
    }
    
    public void addVolaCaisse(EntreeVola vola,Session session) throws Exception{
        Caisse caisse = new Caisse();              
        double solde = 0; 
        try{
            solde = this.getSoldeCaisse(session);
            caisse.setVolaM(solde+vola.getVolaM());
            this.cleanCaisse(session);
            this.addCaisse(caisse, session);
            this.addEntree(vola, session);
            ServiceHistoriqueUser.save("ajout de la somme "+vola.getVolaM()+" Ar dans la caisse", session);
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Impossible de sauvegarder l'argent dans la caisse cause "+e.getMessage());
        }
    }
    
    public void addVolaQuotient(EntreeQuotient vola) throws Exception{
        Quotient quotient = new Quotient();       
        Session session = null; 
        Transaction tr = null; 
        double solde = 0;
        
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            solde = this.getSoldeQuotient(session);
            quotient.setVolaM(solde+vola.getVolaM());
            tr = session.beginTransaction();
            this.cleanQuotient(session);
            this.addQuotient(quotient, session);
            this.addEntreeQuotient(vola, session);
            ServiceHistoriqueUser.save("ajout de la somme "+vola.getVolaM()+" Ar dans la caisse des cautions", session);
            tr.commit();
        }catch(Exception e){
            if(tr!=null) tr.rollback();
            throw e;
        }finally{
            if(session!=null)session.close();
        }
    }
    
    public void addVolaQuotient(EntreeQuotient vola,Session session) throws Exception{
        Quotient quotient = new Quotient();       
        double solde = 0;
        
        try{
            solde = this.getSoldeQuotient(session);
            quotient.setVolaM(solde+vola.getVolaM());
            this.cleanQuotient(session);
            this.addQuotient(quotient, session);
            this.addEntreeQuotient(vola, session);
            ServiceHistoriqueUser.save("ajout de la somme "+vola.getVolaM()+" Ar dans la caisse des cautions", session);
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("impossible de sauvegarder l'argent dans le caution cause "+e.getMessage());
        }
    }
    
    public void sortieVolaCaisse(SortieVola vola) throws Exception{
        Caisse caisse = new Caisse();       
        Session session = null; 
        Transaction tr = null; 
        double solde = 0;
        
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            solde = this.getSoldeCaisse(session);
            if(solde-vola.getVolaM()<0)throw new Exception("solde insuffisant pour cette transaction");
            caisse.setVolaM(solde-vola.getVolaM());
            tr = session.beginTransaction();
            this.cleanCaisse(session);
            this.addCaisse(caisse, session);
            this.addSortie(vola, session);
            ServiceHistoriqueUser.save("retrait de la somme de "+vola.getVolaM()+" Ar dans la caisse ", session);
            tr.commit();
        }catch(Exception e){
            if(tr!=null) tr.rollback();
            throw e;
        }finally{
            if(session!=null)session.close();
        }
    }
    
    public void sortieVolaQuotient(SortieQuotient vola) throws Exception{
        Quotient quotient = new Quotient();       
        Session session = null; 
        Transaction tr = null; 
        double solde = 0;
        
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            solde = this.getSoldeQuotient(session);
            if(solde-vola.getVolaM()<0)throw new Exception("solde insuffisant pour cette transaction");
            quotient.setVolaM(solde-vola.getVolaM());
            tr = session.beginTransaction();
            this.cleanQuotient(session);
            this.addQuotient(quotient, session);
            this.addSortieQuotient(vola, session);
            ServiceHistoriqueUser.save("retrait de la somme de "+vola.getVolaM()+ "dans la caisse des cautions", session);
            tr.commit();
        }catch(Exception e){
            if(tr!=null) tr.rollback();
            throw e;
        }finally{
            if(session!=null)session.close();
        }
    }
    
    public double getSoldeCaisse() throws Exception{
        List<Caisse> caisses = (List<Caisse>)(Object)this.hibernateDao.findAll(new Caisse()); 
        if(caisses.isEmpty()){
            return 0; 
        }
        return caisses.get(caisses.size()-1).getVolaM();       
    }
    
    public double getSoldeQuotient() throws Exception{
        List<Quotient> quotients = (List<Quotient>)(Object)this.hibernateDao.findAll(new Quotient()); 
        if(quotients.isEmpty()){
            return 0; 
        }
        return quotients.get(quotients.size()-1).getVolaM();       
    }
    
    private double getSoldeCaisse(Session session) throws Exception{
        List<Caisse> caisses = (List<Caisse>)(Object)HibernateDao.findAll(new Caisse(),session); 
        if(caisses.isEmpty()){
            return 0; 
        }
        return caisses.get(caisses.size()-1).getVolaM();       
    }
    
    private double getSoldeQuotient(Session session) throws Exception{
        List<Quotient> quotients = (List<Quotient>)(Object)HibernateDao.findAll(new Quotient(),session); 
        if(quotients.isEmpty()){
            return 0; 
        }
        return quotients.get(quotients.size()-1).getVolaM();       
    }
}
