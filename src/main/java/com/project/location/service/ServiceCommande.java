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
import com.project.location.util.Test;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Diary
 */
public class ServiceCommande extends BaseService{
    public ServiceStock serviceStock;
    public ServiceUtil serviceUtil;

    public ServiceUtil getServiceUtil() {
        return serviceUtil;
    }

    public void setServiceUtil(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }
    
    public ServiceStock getServiceStock() {
        return serviceStock;
    }

    public void setServiceStock(ServiceStock serviceStock) {
        this.serviceStock = serviceStock;
    }
    public Commande find(long idCommande)throws Exception{
        try{
            Commande commande = new Commande(idCommande); 
            this.hibernateDao.findById(commande);
            return commande;
        }catch(Exception e){
            throw new Exception("impossible d'extraire la commande");
        }
    }
    private  Stock findStock(CommandeStock commande, Session session) throws Exception{
        Query query = null; 
        try{
            String sql = "SELECT stock FROM CommandeStock commande join commande.stock stock where commande.id = :id";
            query = session.createQuery(sql);
            query.setParameter("id", commande.getId());
            return (Stock)query.list().get(0);
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("impossible d'extraire le stock de la commande");
        }
    }
    public void initStock(List<CommandeStock> commandeStock, Session session) throws Exception{
        try{
            int size = commandeStock.size(); 
            for(int i=0;i<size;i++){
                CommandeStock temp = commandeStock.get(i); 
                temp.setStock(this.findStock(temp, session));
            }
        }catch(Exception e){
            throw e; 
        }
    }
    public List<CommandeStock> fin(Commande commande) throws Exception{
        Session session = null ; 
        Query query = null;
        List<CommandeStock> reponse = null; 
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            String sql = "SELECT commandeStock FROM CommandeStock commandeStock join commandeStock.commande commande WHERE commande.id = :id"; 
            query = session.createQuery(sql); 
            query.setParameter("id", commande.getId()); 
            
            reponse =  query.list();
            this.initStock(reponse, session);
            return reponse;
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Impossible d'extraire les d�tails de la commande "+commande.getRef());
        }finally{
            if(session!=null) session.close();
        }
    }
    public void instanceCommande(List<Commande> commande) throws Exception{
        Session session = null; 
        try{
            session = this.hibernateDao.getSessionFactory().openSession(); 
            int size = commande.size(); 
            for(int i=0;i<size;i++){
                Commande temp = commande.get(i); 
                 HibernateDao.findById(temp,session);
            }
        }catch(Exception e){
            throw new Exception("impossible d'extraire les stocks");
        }finally{
            if(session!=null)session.close();
        }
    }
    
    public List<Commande> find(String nomClient, Date dateMin, Date dateMax, boolean recu, boolean retour, boolean annule) throws Exception{
        List<Object[]> arg = new ArrayList<>(); 
        Object[] des = Test.instance(2);
            des[0] = "client.nom";
            des[1] = nomClient;
        if(Test.argmumentNull(nomClient))des=null;
        
//        date init 
        Object[] date = Test.instance(3); 
        date[0] = "dateCommande";
        if(dateMin==null&&dateMax!=null){
            date = Test.instance(2);
            date[0] = "dateCommande";
            date[1] = dateMax;
        }else if(dateMax==null&&dateMin!=null){
            date = Test.instance(2);
            date[0] = "dateCommande";
            date[1] = dateMin;
        }else if(dateMax==null&&dateMin==null){
            date = null;
        }
        else if(dateMin.before(dateMax)){
            date[1] = dateMin;
            date[2] = dateMax;
        }else if(dateMax.before(dateMin)){            
            date[1] = dateMax;  
            date[2] = dateMin;    
        }else{
            date = Test.instance(2);
            date[0] = "dateCommande";
            date[1] = dateMin;
        }
        Object[] annuleD = Test.instance(2); 
        annuleD[0] = "annule"; 
        annuleD[1] = annule; 
        Object[] recuD = Test.instance(2); 
        recuD[0] = "recu";
        recuD[1] = recu; 
        Object[] retourD = Test.instance(2); 
        retourD[0] = "retour"; 
        retourD[1] = retour;
        
        arg.add(annuleD); 
        arg.add(recuD); 
        arg.add(retourD); 
        if(!Test.testNull(des))arg.add(des);
        if(!Test.testNull(date))arg.add(date);
        List<Commande> reponse = null;
        try{
            reponse = (List<Commande>)(Object) this.serviceUtil.find(arg, Commande.class);
            if(!reponse.isEmpty()) this.instanceCommande(reponse);
            this.populateClient(reponse);
            return reponse;
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Impossible d'extraire la recherche");
        }
    }
    
    private Client findClient(Commande commande, Session session )throws Exception{
        try{
            String sql = "SELECT client FROM Commande commande join commande.client client where commande.id = :id ";
            Query query = session.createQuery(sql); 
            query.setParameter("id", commande.getId()); 
            
            return (Client)query.list().get(0);
        }catch(Exception e){
            throw new Exception("impossible de retouver le client");
        }
    }
    
    private void populateClient(Commande commande,Session session) throws Exception{
        try{
            commande.setClient(this.findClient(commande, session));
        }catch(Exception e){
            throw new Exception("Impossible d'extraire le client de la commande "+commande.getRef());
        }
    }
    
    private void populateClient(List<Commande> commande, Session session)throws Exception{
        int size = commande.size(); 
        for(int i=0;i<size;i++){
            this.populateClient(commande.get(i), session);
        }
    }
    
    private void populateClient(List<Commande> commande)throws Exception{
        Session session = null; 
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            int size = commande.size(); 
            for(int i=0;i<size;i++){
                this.populateClient(commande.get(i), session);
            }
        }catch(Exception e){
            throw new Exception("impossible d'extraire les clients");
        }finally{
            if(session!=null)session.close();
        }
    }
    
    public List<Commande> find(String nomClient, String dateMin, String dateMax,boolean recu, boolean retour, boolean annule ) throws Exception{
       
       Date dateMiD = null;
       Date dateMaD = null; 
       if(!Test.argmumentNull(dateMin))dateMiD = DateUtil.convert(dateMin); 
       if(!Test.argmumentNull(dateMax))dateMaD = DateUtil.convert(dateMax); 
       return this.find(nomClient, dateMiD, dateMaD,recu,retour,annule);
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
            this.populateClient(reponse, session);
            return reponse;
        }catch(Exception e){
            throw new Exception("impossible d'extraire la liste des commandes");
        }finally{
            if(session!=null)session.close();
        }
    }
    
    public List<Commande> getCommande(String client, Date debut, Date fin, Date dateCommandeD, Date dateCommandeF, boolean recu, boolean retour, boolean annule)throws Exception{
        Session session = null;
        List<Commande> reponse = null;
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Commande.class,"commande");
            if(!Test.argmumentNull(client)){
                criteria.createAlias("commande.client", "client"); 
                criteria.add(Restrictions.ilike("client.nom","%"+client+"%"));
            }
            if(debut!=null&&fin!=null){
                Criterion rest1 = Restrictions.and(Restrictions.le("commande.dateDebut", debut), 
                            Restrictions.ge("commande.dateFin",debut));
                Criterion rest2 = Restrictions.and(Restrictions.le("commande.dateDebut", fin), 
                            Restrictions.ge("commande.dateFin",fin));

                criteria.add(Restrictions.or(rest1, rest2));
            }else if(debut!=null&&fin==null){
                criteria.add(Restrictions.eq("commande.dateDebut",debut)); 
                
            }else if(debut==null&&fin!=null){
                criteria.add(Restrictions.eq("commande.dateFin", fin));
            }
            
            if(dateCommandeD!=null&&dateCommandeF!=null){
                criteria.add(Restrictions.between("commande.dateCommande", dateCommandeD,dateCommandeF));
            }
            criteria.add(Restrictions.eq("commande.retour", retour));
            criteria.add(Restrictions.eq("commande.annule", annule));
            criteria.add(Restrictions.eq("commande.recu", recu));
            
            reponse = criteria.list();
            this.populateClient(reponse, session);
            return reponse;
        }catch(Exception e){
            throw new Exception("impossible d'extraire la liste des commandes");
        }finally{
            if(session!=null)session.close();
        }
    }
    
    public List<Commande> getCommande(String client, String debut, String fin, String dateCommandeD, String dateCommandeF, boolean recu, boolean retour, boolean annule)throws Exception{
       Date debutDate = null; 
       Date finDate = null; 
       Date dateCommandeDDate = null; 
       Date dateCommandeFDate = null; 
       
       if(!Test.argmumentNull(debut)) debutDate = DateUtil.convert(debut); 
       if(!Test.argmumentNull(fin)) finDate = DateUtil.convert(fin); 
       if(!Test.argmumentNull(dateCommandeD)) dateCommandeDDate = DateUtil.convert(dateCommandeD); 
       if(!Test.argmumentNull(dateCommandeF)) dateCommandeFDate = DateUtil.convert(dateCommandeF); 
       
       return this.getCommande(client, debutDate, finDate, dateCommandeDDate, dateCommandeFDate, recu, retour, annule);
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
            throw new Exception("impossible de sauvegarder la commande m�re");
        }
    }
    
    public void save(Commande commande, Session session)throws Exception{
        try{
            HibernateDao.save(commande,session);
        }catch(Exception e){
            throw new Exception("impossible de sauvegarder la commande m�re");
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
        if(size==0)throw new Exception("Aucune commande n'a �t� effectu�");
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