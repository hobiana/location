/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.service;

import com.project.location.dao.HibernateDao;
import com.project.location.model.Client;
import com.project.location.model.Commande;
import com.project.location.model.CommandeStock;
import com.project.location.model.Stock;
import com.project.location.reference.ReferenceSession;
import com.project.location.util.DateUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Diary
 */
public class ServiceCommande extends BaseService{
    public ServiceStock serviceStock;

    public ServiceStock getServiceStock() {
        return serviceStock;
    }

    public void setServiceStock(ServiceStock serviceStock) {
        this.serviceStock = serviceStock;
    }
    
    public List<Commande> getCommande(Date debut, Date fin)throws Exception{
        Session session = null;
        List<Commande> reponse = null;
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Commande.class,"commande");
            Criterion rest1 = Restrictions.and(Restrictions.le("commande.dateDebut", debut), 
                        Restrictions.ge("commande.dateFin",debut));
            Criterion rest2 = Restrictions.and(Restrictions.le("commande.dateDebut", fin), 
                        Restrictions.ge("commande.dateFin",fin));

            criteria.add(Restrictions.or(rest1, rest2));
            criteria.add(Restrictions.eq("commande.retour", false));
            criteria.add(Restrictions.eq("commande.annule", false));
            criteria.add(Restrictions.eq("commande.recu", false));
            
            reponse = criteria.list();
            return reponse;
        }catch(Exception e){
            throw new Exception("impossible d'extraire la liste des commandes");
        }finally{
            if(session!=null)session.close();
        }
    }
    
    public int getStockRestant(long idStock, Date debut, Date fin)throws Exception{
        Session session = null;
        List<CommandeStock> listeStock = null; 
        Stock stock = null;
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            stock = new Stock(idStock);
            HibernateDao.findById(stock, session);
            Criteria criteria = session.createCriteria(CommandeStock.class,"commandeStock");
            criteria.createAlias("commandeStock.commande","commande");
            criteria.createAlias("commandeStock.stock","stock");
            
            criteria.add(Restrictions.eq("stock.id", idStock));
            Criterion rest1 = Restrictions.and(Restrictions.le("commande.dateDebut", debut), 
                        Restrictions.ge("commande.dateFin",debut));
            Criterion rest2 = Restrictions.and(Restrictions.le("commande.dateDebut", fin), 
                        Restrictions.ge("commande.dateFin",fin));

            criteria.add(Restrictions.or(rest1, rest2));
            criteria.add(Restrictions.eq("commande.retour", false));
            criteria.add(Restrictions.eq("commande.annule", false));
            criteria.add(Restrictions.eq("commande.recu", false));
            
            listeStock = criteria.list();
        }catch(Exception e){
            throw new Exception("impossible d'extraire la liste des commandes");
        }finally{
            if(session!=null)session.close();
        }
        int totalNeg = 0; 
        int size = listeStock.size(); 
        for(int i=0;i<size;i++){
            CommandeStock commandeStockTemp = listeStock.get(i);
            totalNeg += commandeStockTemp.getQuantiteCommande();
        }
        int restant = stock.getQuantite() - totalNeg;
        return restant;
    }
    
    public int getStockRestant(long idStock, Date debut, Date fin, Session session)throws Exception{
        
        List<CommandeStock> listeStock = null; 
        Stock stock = null;
        try{
            
            stock = new Stock(idStock);
            HibernateDao.findById(stock, session);
            Criteria criteria = session.createCriteria(CommandeStock.class,"commandeStock");
            criteria.createAlias("commandeStock.commande","commande");
            criteria.createAlias("commandeStock.stock","stock");
            
            criteria.add(Restrictions.eq("stock.id", idStock));
            Criterion rest1 = Restrictions.and(Restrictions.le("commande.dateDebut", debut), 
                        Restrictions.ge("commande.dateFin",debut));
            Criterion rest2 = Restrictions.and(Restrictions.le("commande.dateDebut", fin), 
                        Restrictions.ge("commande.dateFin",fin));

            criteria.add(Restrictions.or(rest1, rest2));
            criteria.add(Restrictions.eq("commande.retour", false));
            criteria.add(Restrictions.eq("commande.annule", false));
            criteria.add(Restrictions.eq("commande.recu", false));
            
            listeStock = criteria.list();
        }catch(Exception e){
            throw new Exception("impossible d'extraire la liste des commandes");
        }
        int totalNeg = 0; 
        int size = listeStock.size(); 
        for(int i=0;i<size;i++){
            CommandeStock commandeStockTemp = listeStock.get(i);
            totalNeg += commandeStockTemp.getQuantiteCommande();
        }
        int restant = stock.getQuantite() - totalNeg;
        return restant;
    }

    public int dispo(long idStock,int quantite, Date debut, Date fin) throws Exception{
        int restant = this.getStockRestant(idStock, debut, fin);
        return restant - quantite; 
    }
    
    public int dispo(long idStock,int quantite, Date debut, Date fin, Session session) throws Exception{
        int restant = this.getStockRestant(idStock, debut, fin,session);
        return restant - quantite; 
    }
    
    public boolean checkDispo(Date debut, Date fin, CommandeStock commande) throws Exception{
        return this.dispo(commande.getStock().getId(), (int)commande.getQuantiteCommande(), debut, fin)>=0;
    }
    
    public boolean checkDispo(Date debut, Date fin, CommandeStock commande, Session session) throws Exception{
        return this.dispo(commande.getStock().getId(), (int)commande.getQuantiteCommande(), debut, fin, session)>0;
    }
    
    public void addCommand(long idStock, int quantite, Date debut, Date fin) throws Exception{
        HttpSession session = ServletActionContext.getRequest().getSession();
        List<CommandeStock> commandes = (List<CommandeStock>)(Object)session.getAttribute(ReferenceSession.COMMANDE);
        if(commandes==null){
            commandes = new ArrayList();
        }
        int size = commandes.size();
        Stock stock =  this.serviceStock.find(idStock);        
        CommandeStock commandeStock = new CommandeStock(); 
        commandeStock.setQuantiteCommande(quantite);
        commandeStock.setStock(stock);
        commandeStock.setQuantiteRetour(0);
        commandeStock.setDescription("");
        boolean test = false;
        for(int i=0;i<size;i++){
            CommandeStock temp = commandes.get(i);
            if(temp.getStock().getId()==idStock){
                test=true; 
                temp.setQuantiteCommande(temp.getQuantiteCommande()+quantite);
            }
        }
        if(!test)commandes.add(commandeStock);  
        session.removeAttribute(ReferenceSession.COMMANDE);
        session.setAttribute(ReferenceSession.COMMANDE, commandes);
        this.checkAll(debut, fin);
    }
    
    public void addCommand(long idStock, int quantite, String debut, String fin) throws Exception{
        Date debutD = DateUtil.convert(debut);
        Date finD = DateUtil.convert(fin); 
        
        this.addCommand(idStock, quantite, debutD, finD);
    }
    
    public List<CommandeStock> getCommande(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        
        List<CommandeStock> commandes = (List<CommandeStock>)(Object)session.getAttribute(ReferenceSession.COMMANDE);
        if(commandes==null){
            commandes = new ArrayList();
        }
        return commandes;
    }
    
    public void setCommande(List<CommandeStock> commandes){
        this.clearSession();
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.setAttribute(ReferenceSession.COMMANDE,commandes);
    }
    
    public void deleteCommand(long idCommande){
      HttpSession session = ServletActionContext.getRequest().getSession();
        List<CommandeStock> commandes = (List<CommandeStock>)(Object)session.getAttribute(ReferenceSession.COMMANDE);
        int size = commandes.size();
        
        for(int i=0; i<size;i++){
            if(i==idCommande) commandes.remove(i);
        }
      
        session.removeAttribute(ReferenceSession.COMMANDE);
        session.setAttribute(ReferenceSession.COMMANDE, commandes);  
    }
    
    public void modifierCommand(long idCommande, int quantite, Date debut, Date fin) throws Exception{
        HttpSession session = ServletActionContext.getRequest().getSession();
        List<CommandeStock> commandes = (List<CommandeStock>)(Object)session.getAttribute(ReferenceSession.COMMANDE);
        int size = commandes.size();
        if(quantite>=1){
            for(int i=0; i<size;i++){
                if(i==idCommande) commandes.get(i).setQuantiteCommande(quantite);
            }
        }
        session.removeAttribute(ReferenceSession.COMMANDE);
        session.setAttribute(ReferenceSession.COMMANDE, commandes);
        this.checkAll(debut, fin);
    }
    
    public void modifierCommand(long idCommande, int quantite, String debut, String fin) throws Exception{
        Date debutD = DateUtil.convert(debut); 
        Date finD = DateUtil.convert(fin); 
        this.modifierCommand(idCommande, quantite, debutD, finD);
    }
    
    public void save(CommandeStock commandeStock)throws Exception{
        try{
            this.hibernateDao.save(commandeStock);
        }catch(Exception e){
            throw new Exception("impossible de sauvegarder la commande");
        }
    }
    
    public void save(CommandeStock commandeStock,Session session)throws Exception{
        try{
            HibernateDao.save(commandeStock,session);
        }catch(Exception e){
            throw new Exception("impossible de sauvegarder la commande");
        }
    }
    
    public void save(Commande commande)throws Exception{
        try{
            this.hibernateDao.save(commande);
        }catch(Exception e){
            throw new Exception("impossible de sauvegarder la commande mère");
        }
    }
    
    public void save(Commande commande, Session session)throws Exception{
        try{
            HibernateDao.save(commande,session);
        }catch(Exception e){
            throw new Exception("impossible de sauvegarder la commande mère");
        }
    }
   
    public void checkAll(Date debut, Date fin) throws Exception{
        List<CommandeStock> commande = this.getCommande(); 
        int size = commande.size(); 
        Session session = null; 
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            
            for(int i=0;i<size;i++){
                CommandeStock temp = commande.get(i);
                boolean test = this.checkDispo(debut, fin, temp); 
                if(!test) temp.setDescription("stock insuffisant");      
                else{
                    temp.setDescription("");
                }
            }
            this.setCommande(commande);
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Une erreur s'est produite "+e.getMessage());
        }finally{
            if(session!=null)session.close();
        }
        
    }
    
    public void checkAll(String debut, String fin)throws Exception{
        Date debutD = DateUtil.convert(debut);
        Date finD = DateUtil.convert(fin);
        this.checkAll(debutD, finD);
    }
    
    public boolean saveCommande(long idClient, Date debut, Date fin) throws Exception{
        boolean reponse = true;
        Commande commande = new Commande(); 
        Client client = new Client(idClient);
        commande.setAnnule(false);
        commande.setRecu(false);
        commande.setRetour(false);
        commande.setDateDebut(debut);
        commande.setDateFin(fin);
        commande.setClient(client);
        commande.setDateCommande(Calendar.getInstance().getTime());
       
        List<CommandeStock> commandes = this.getCommande();
        int size = commandes.size();
        if(size==0)throw new Exception("Aucune commande n'a été effectué");
        Session session = null; 
        Transaction tr = null; 
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            tr = session.beginTransaction();
            HibernateDao.save(commande, session);
            for(int i=0;i<size;i++){
                CommandeStock temp = commandes.get(i);
                temp.setCommande(commande);
                boolean disponible = this.checkDispo(debut, fin, temp); 
                if(disponible==false){
                    reponse = false;
                    temp.setDescription("stock insuffisant");
                }
                HibernateDao.save(temp, session);
            }
            if(reponse==true){
                this.clearSession();
                tr.commit();
            }else{
                this.setCommande(commandes);
                tr.rollback();
            }          
        }catch(Exception e){
            e.printStackTrace();
            tr.rollback();
            reponse = false;
        }finally{
            if(session!=null) session.close();
        }
        return reponse;
    }
    
    public boolean saveCommande(long idClient, String debut, String fin) throws Exception{
        Date debutD = DateUtil.convert(debut);
        Date finD = DateUtil.convert(fin);
        return this.saveCommande(idClient,debutD, finD);
    }
    
    public void clearSession(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.removeAttribute(ReferenceSession.COMMANDE);
    }
}
