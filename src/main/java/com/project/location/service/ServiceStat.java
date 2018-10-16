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
import com.project.location.model.StatModel;
import com.project.location.model.Stock;
import com.project.location.util.DateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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
    public static List<StatModel> getCommandeUser(Date debut, Date fin, Client client, Session session) throws ConnexionException, Exception{
        List<StatModel> result;
        try{
            String sql = "SELECT COUNT(*) as nombre, commande.dateCommande, commande.client.id FROM Commande commande where (commande.client.id = :idClient) "
                    + "and (commande.dateCommande BETWEEN :debut AND :fin)" +
                    " group by commande.dateCommande, commande.client.id" +
                    " ORDER BY commande.dateCommande asc";
            Query query = session.createQuery(sql); 
            query.setParameter("idClient", client.getId());
            query.setParameter("debut", debut);
            query.setParameter("fin", fin);
            List<Object> resultQuery = query.list();
            result = new ArrayList();
            
            List<Date> dates = DateUtil.allDate(debut, fin);
            for(int i=0; i<dates.size();i++) {
                StatModel tempStat = new StatModel();
                boolean test = false;
                int indice = 0;
                for(int j=0;j<resultQuery.size();j++) {
                    Object[] temp =  (Object[]) resultQuery.get(j);
                    if(temp[1].equals(dates.get(i))){
                        test = true; 
                        indice = j;
                        break;
                    }
                }
                if(test==true){
                   Object[] temp =  (Object[]) resultQuery.get(indice);
                   Long value = (Long)temp[0];
                   double doubleValue = value;
                   tempStat.setValue(Double.valueOf(doubleValue));
                } else {
                    tempStat.setValue(0.0);
                }
                tempStat.setDate(dates.get(i));
                tempStat.setOther(client);
                result.add(tempStat);
            }
            return result;
        } catch(Exception e) {
            throw e;
        }
    }
    
    public List<StatModel> getCommandeUser(Date debut, Date fin, Client client) throws ConnexionException, Exception{
        Session session = null; 
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            return ServiceStat.getCommandeUser(debut, fin, client, session);
        }catch(Exception e) {
            throw e;
        } finally{
            if(session!=null) session.close();
        }
    }
    
    public static List<StatModel> getBenificeClientPerDay(Date debut, Date fin, Client client, Session session) throws ConnexionException, Exception{
        List<StatModel> result;
        try{
            String sql = "SELECT SUM(factureFille.valeur) as argentEntree, factureFille.date "
                    + "FROM FactureFille factureFille WHERE (factureFille.commande.client.id = :idClient) "
                    + "AND (factureFille.date BETWEEN :debut AND :fin)" 
                    + " group by factureFille.date " 
                    + " ORDER BY factureFille.date asc";
            Query query = session.createQuery(sql); 
            query.setParameter("idClient", client.getId());
            query.setParameter("debut", debut);
            query.setParameter("fin", fin);
            List<Object> resultQuery = query.list();
            result = new ArrayList();
            
            List<Date> dates = DateUtil.allDate(debut, fin);
            for(int i=0; i<dates.size();i++) {
                StatModel tempStat = new StatModel();
                boolean test = false;
                int indice = 0;
                for(int j=0;j<resultQuery.size();j++) {
                    Object[] temp =  (Object[]) resultQuery.get(j);
                    if(temp[1].equals(dates.get(i))){
                        test = true; 
                        indice = j;
                        break;
                    }
                }
                if(test==true){
                   Object[] temp =  (Object[]) resultQuery.get(indice);
                   Double doubleValue = (Double)temp[0];
                   tempStat.setValue(doubleValue);
                } else {
                    tempStat.setValue(0.0);
                }
                tempStat.setDate(dates.get(i));
                result.add(tempStat);
            }
            return result;
        } catch(Exception e) {
            throw e;
        }
    }
    
    public List<StatModel> getBenificeClientPerDay(Date debut, Date fin, Client client) throws ConnexionException, Exception{
        Session session = null; 
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            return ServiceStat.getBenificeClientPerDay(debut, fin, client, session);
        }catch(Exception e) {
            throw e;
        } finally{
            if(session!=null) session.close();
        }
     }
    
    public static List<StatModel> getBenificeClientPerMouth(Date debut, Date fin, Client client, Session session) throws ConnexionException, Exception{
        List<StatModel> result;
        try{
            String sql = "SELECT SUM(factureFille.valeur) as argentEntree, to_char(factureFille.date, 'YYYY-MM') as year_month "
                    + "FROM FactureFille factureFille WHERE (factureFille.commande.client.id = :idClient) "
                    + "AND (factureFille.date BETWEEN :debut AND :fin)" 
                    + " group by to_char(factureFille.date, 'YYYY-MM') " 
                    + " ORDER BY to_char(factureFille.date, 'YYYY-MM') asc";
            Query query = session.createQuery(sql); 
            query.setParameter("idClient", client.getId());
            query.setParameter("debut", debut);
            query.setParameter("fin", fin);
            List<Object> resultQuery = query.list();
            result = new ArrayList();
            
            List<Date> dates = DateUtil.allDateMonth(debut, fin);
            for(int i=0; i<dates.size();i++) {
                StatModel tempStat = new StatModel();
                boolean test = false;
                int indice = 0;
                for(int j=0;j<resultQuery.size();j++) {
                    Object[] temp =  (Object[]) resultQuery.get(j);
                    if(DateUtil.convert((String)temp[1]).equals(dates.get(i))){
                        test = true; 
                        indice = j;
                        break;
                    }
                }
                if(test==true){
                   Object[] temp =  (Object[]) resultQuery.get(indice);
                   Double doubleValue = (Double)temp[0];
                   tempStat.setValue(doubleValue);
                } else {
                    tempStat.setValue(0.0);
                }
                tempStat.setDate(dates.get(i));
                result.add(tempStat);
            }
            return result;
        } catch(Exception e) {
            throw e;
        }
    }
    
    public List<StatModel> getBenificeClientPerMouth(Date debut, Date fin, Client client) throws ConnexionException, Exception{
        Session session = null; 
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            return ServiceStat.getBenificeClientPerMouth(debut, fin, client, session);
        }catch(Exception e) {
            throw e;
        } finally{
            if(session!=null) session.close();
        }
    }
    
    
    public static List<StatModel> getPreferenceClientOnMouth(Date month, Client client, Session session) throws ConnexionException, Exception{
        List<StatModel> result;
        try{
            String sql = "SELECT COUNT(*) as nombre,commandeStock.stock.id, commandeStock.stock.designation, to_char(commandeStock.commande.dateCommande, 'YYYY-MM') as year_month "
                    + "FROM CommandeStock commandeStock "
                    + "WHERE (commandeStock.commande.client.id = :idClient) "
                    + "AND (to_char(commandeStock.commande.dateCommande, 'YYYY-MM') = :month)" 
                    + " GROUP BY to_char(commandeStock.commande.dateCommande, 'YYYY-MM'),commandeStock.stock.id, commandeStock.stock.designation " 
                    + " ORDER BY COUNt(*) DESC";
            Query query = session.createQuery(sql); 
            query.setParameter("idClient", client.getId());
            query.setParameter("month", DateUtil.convertMonth(month));
            List<Object> resultQuery = query.list();
            result = new ArrayList();
            
            for(int i=0;i<resultQuery.size();i++){
                Object[] queryTemp = (Object[]) resultQuery.get(i);
                StatModel temp = new StatModel();
                long nombreLong = (long) queryTemp[0];
                double nombreDouble = nombreLong;
                temp.setValue(nombreDouble);
                temp.setDate(month);
                Stock stock = new Stock();
                stock.setId((long) queryTemp[1]);
                stock.setDesignation((String) queryTemp[2]);
                temp.setOther(stock);
                result.add(temp);
            }
            
            return result;
        } catch(Exception e) {
            throw e;
        }
    }
    
    public static List<List<StatModel>> getPreferenceClientPerMonth(Date debut, Date fin, Client client, Session session)throws ConnexionException, Exception{
        List<List<StatModel>> firstD = new ArrayList();
        List<Date> months = DateUtil.allDateMonth(debut, debut);
        int monthsSize = months.size();
        for(int i=0;i<monthsSize;i++){
            Date month = months.get(i);
            firstD.add(ServiceStat.getPreferenceClientOnMouth(month, client, session));
        }
        return firstD;
    }
    
    public List<List<StatModel>> getPreferenceClientPerMonth(Date debut, Date fin, Client client)throws ConnexionException, Exception{
        Session session = null; 
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            return ServiceStat.getPreferenceClientPerMonth(debut, fin, client, session);
        }catch(Exception e) {
            throw e;
        } finally{
            if(session!=null) session.close();
        }
    }
    
    public static List<StatModel> getPreferenceOnMouth(Date month, Session session) throws ConnexionException, Exception{
        List<StatModel> result;
        try{
            String sql = "SELECT COUNT(*) as nombre,commandeStock.stock.id, commandeStock.stock.designation, to_char(commandeStock.commande.dateCommande, 'YYYY-MM') as year_month "
                    + "FROM CommandeStock commandeStock "
                    + "WHERE  (to_char(commandeStock.commande.dateCommande, 'YYYY-MM') = :month)" 
                    + " GROUP BY to_char(commandeStock.commande.dateCommande, 'YYYY-MM'),commandeStock.stock.id, commandeStock.stock.designation " 
                    + " ORDER BY COUNT(*) DESC";
            Query query = session.createQuery(sql); 
            query.setParameter("month", DateUtil.convertMonth(month));
            List<Object> resultQuery = query.list();
            result = new ArrayList();
            int resultQuerySize = resultQuery.size();
            if(resultQuerySize == 0){
                StatModel temp = new StatModel();
                temp.setDate(month);
                result.add(temp);
            }
            for(int i=0;i<resultQuerySize;i++){
                Object[] queryTemp = (Object[]) resultQuery.get(i);
                StatModel temp = new StatModel();
                long nombreLong = (long) queryTemp[0];
                double nombreDouble = nombreLong;
                temp.setValue(nombreDouble);
                temp.setDate(month);
                Stock stock = new Stock();
                stock.setId((long) queryTemp[1]);
                stock.setDesignation((String) queryTemp[2]);
                temp.setOther(stock);
                result.add(temp);
            }
            
            return result;
        } catch(Exception e) {
            throw e;
        }
    }
    
    public static List<List<StatModel>> getPreferencePerMouth(Date debut, Date fin, Session session)throws ConnexionException, Exception{
        List<List<StatModel>> firstD = new ArrayList();
        List<Date> months = DateUtil.allDateMonth(debut, fin);
        int monthsSize = months.size();
        for(int i=0;i<monthsSize;i++){
            Date month = months.get(i);
            firstD.add(ServiceStat.getPreferenceOnMouth(month, session));
        }
        return firstD;
    }
    
    public List<List<StatModel>> getPreferencePerMonth(Date debut, Date fin)throws ConnexionException, Exception{
        Session session = null; 
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            return ServiceStat.getPreferencePerMouth(debut, fin, session);
        }catch(Exception e) {
            throw e;
        } finally{
            if(session!=null) session.close();
        }
    }
    
    public static List<StatModel> getArticleCasse(Date month, Session session) throws ConnexionException, Exception{
        List<StatModel> result;
        try{
            String sql = "SELECT SUM(commandeStock.quantiteCommande-commandeStock.quantiteRetour) as casse, "
                    + "commandeStock.stock.id, commandeStock.stock.designation, to_char(commandeStock.commande.dateCommande, 'YYYY-MM') as year_month "
                    + "FROM CommandeStock commandeStock "
                    + "WHERE  (to_char(commandeStock.commande.dateCommande, 'YYYY-MM') = :month) " 
                    + "GROUP BY to_char(commandeStock.commande.dateCommande, 'YYYY-MM'),commandeStock.stock.id, commandeStock.stock.designation " 
                    + "ORDER BY SUM(commandeStock.quantiteCommande-commandeStock.quantiteRetour) DESC";
           Query query = session.createQuery(sql); 
            query.setParameter("month", DateUtil.convertMonth(month));
            List<Object> resultQuery = query.list();
            result = new ArrayList();
            
            for(int i=0;i<resultQuery.size();i++){
                Object[] queryTemp = (Object[]) resultQuery.get(i);
                StatModel temp = new StatModel();
                double nombreDouble = (double) queryTemp[0];
                temp.setValue(nombreDouble);
                temp.setDate(month);
                Stock stock = new Stock();
                stock.setId((long) queryTemp[1]);
                stock.setDesignation((String) queryTemp[2]);
                temp.setOther(stock);
                result.add(temp);
            }
            return result;
        } catch(Exception e) {
            throw e;
        }
    }
    
    public static List<List<StatModel>> getArticlePerMonth(Date debut, Date fin, Session session)throws ConnexionException, Exception{
        List<List<StatModel>> firstD = new ArrayList();
        List<Date> months = DateUtil.allDateMonth(debut, debut);
        int monthsSize = months.size();
        for(int i=0;i<monthsSize;i++){
            Date month = months.get(i);
            firstD.add(ServiceStat.getArticleCasse(month, session));
        }
        return firstD;
    }
    
    public List<List<StatModel>> getArticlePerMonth(Date debut, Date fin)throws ConnexionException, Exception{
       Session session = null; 
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            return ServiceStat.getArticlePerMonth(debut, fin, session);
        }catch(Exception e) {
            throw e;
        } finally{
            if(session!=null) session.close();
        }
    }
    
   
}
