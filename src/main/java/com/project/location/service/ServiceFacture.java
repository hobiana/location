/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.service;

import com.project.location.dao.HibernateDao;
import com.project.location.exception.ConnexionException;
import com.project.location.exception.FactureAlreadyPayException;
import com.project.location.exception.NotFacturedException;
import com.project.location.generator.FactureFilleGenerator;
import com.project.location.model.Client;
import com.project.location.model.Commande;
import com.project.location.model.CommandeStock;
import javax.servlet.http.HttpServletRequest;
import com.project.location.model.EntreeQuotient;
import com.project.location.model.EntreeVola;
import com.project.location.model.Facture;
import com.project.location.model.FactureFille;
import com.project.location.model.HorsSotck;
import com.project.location.util.DateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
            e.printStackTrace();
            throw new Exception("impossible de recuperer la facture");
        }
        return facture;
    }
    public static Facture findByCommande(long id, Session session) throws Exception{
        return ServiceFacture.findFacture(new Commande(id), session);
    }
    public Facture findByCommande(long id) throws Exception {
        Session session = null; 
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            return ServiceFacture.findByCommande(id, session);
        } catch (Exception e){
            throw e;
        }
        
    }
    public static  Facture findFacture(Commande commande, Session session) throws NotFacturedException, ConnexionException{
        Query query = null; 
        try{
            String sql = "SELECT facture FROM Facture facture join facture.commande commande where commande.id = :id";
            query = session.createQuery(sql);
            query.setParameter("id", commande.getId());
            return (Facture)query.list().get(0);
            
        }catch(IndexOutOfBoundsException out){
            throw new NotFacturedException();
        }catch(HibernateException hibernate) {
            throw new ConnexionException(hibernate.getMessage());
        }
    }
    public static Commande findCommande(FactureFille factureFille, Session session ) throws ConnexionException, Exception {
        try{
            String sql = "SELECT commande FROM Commande commande WHERE commande.id = :id"; 
            Query query = session.createQuery(sql); 
            query.setParameter("id",factureFille.getCommande().getId());
            return (Commande)query.list().get(0);
            
        } catch(IndexOutOfBoundsException e){
            throw new Exception("Commande not found"); 
        }catch(HibernateException e) {
            e.printStackTrace();
            throw new ConnexionException();
        }
    }
    public static void payement(FactureFille fille, double totalToPaye, Session session ) throws Exception{
        Commande commande = ServiceFacture.findCommande(fille, session);
        long idCommande = commande.getId();
        Facture facture = ServiceFacture.findByCommande(idCommande, session);
        double totalPaye = ServiceFacture.totalPayer(idCommande, session);
        double paye = fille.getValeur();
        double quotient = facture.getQuotient();
        if(!commande.isPaye()){
            ServiceCommande.payer(commande, session);
        }
        if(paye > totalToPaye) throw new Exception("le montant insérer est supérieur au montant total à payer");
        ServiceCaisse serviceCaisse = new ServiceCaisse();
        
        ServiceHistoriqueUser.save("Paiement de "+paye+" AR de la commande n° "+commande.getRef(), session);
        if(totalPaye >= quotient ) {
            EntreeVola entree = new EntreeVola();
            entree.setVolaM(paye);
            entree.setDate(fille.getDate());
            entree.setDesignation("Paiement de la commande n° "+commande.getRef());
            serviceCaisse.addVolaCaisse(entree,session);

        } else {
            double restePayeQuotient = quotient-totalPaye;
            double rest = -1;
            double payeInQuotient = 0;
            if(paye>restePayeQuotient){
                payeInQuotient = restePayeQuotient;
                rest = paye - restePayeQuotient;
            } else {
                 payeInQuotient = paye;
            }
            EntreeQuotient entreeQuotient = new EntreeQuotient();
            entreeQuotient.setVolaM(payeInQuotient);
            entreeQuotient.setDate(fille.getDate());
            entreeQuotient.setDesignation("Paiement de la caution de la commande n° "+commande.getRef());
            serviceCaisse.addVolaQuotient(entreeQuotient, session);
            if(rest>0) {
                EntreeVola entreeVola = new EntreeVola();
                entreeVola.setDate(fille.getDate());
                entreeVola.setVolaM(rest);
                entreeVola.setDesignation("Paiement de la commande n° "+commande.getRef());
                serviceCaisse.addVolaCaisse(entreeVola, session);
            }
        }
        /*
        totalPaye+=fille.getValeur();
        if(totalToPaye==totalPaye) {
            ServiceCommande.payer(commande, session);
        }*/
        HibernateDao.save(fille, session);
        
        
    }
    
    public void payement(FactureFille fille, double totalToPaye) throws Exception{
        Session session = null; 
        Transaction tr = null;
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            tr = session.beginTransaction();
            ServiceFacture.payement(fille, totalToPaye, session);
            tr.commit();
        }catch(Exception e){
            if(tr!=null) tr.rollback();  
            throw e;
        } finally {
            if(session!=null) session.close();
        }
    }
    
    public void payement(long idCommande, double valeur, Date  date, double totalToPaye) throws Exception{     
        FactureFille fille = new FactureFille();
        fille.setCommande(new Commande(idCommande));
        fille.setDate(date);
        fille.setValeur(valeur);
        this.payement(fille, totalToPaye);
    }
    
    public void payement(long idCommande, double valeur, String date, double totalToPaye) throws Exception{     
        Date dateD = DateUtil.convert(date);
       this.payement(idCommande, valeur, dateD, totalToPaye);
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
    
    public static List<FactureFille> factureFilleByCommande(long idCommande, Session session) throws ConnexionException{
        try{
            String sql = "SELECT factureFille FROM FactureFille factureFille JOIN factureFille.commande commande where commande.id = :id";
            Query query = session.createQuery(sql);
            query.setParameter("id", idCommande);
            return (List<FactureFille>) (Object) query.list();
        } catch (HibernateException e){
            throw new ConnexionException();
        } 
    } 
    
    public List<FactureFille> factureFilleByCommande(long idCommande) throws ConnexionException{
        Session session = null; 
        try{
           session = this.hibernateDao.getSessionFactory().openSession();
           return ServiceFacture.factureFilleByCommande(idCommande, session);
        } catch (ConnexionException e){
            throw e;
        } finally {
            if(session!=null) session.close();
        }
    } 
    
    public static double totalPayer(long idCommande, Session session) throws ConnexionException {
        List<FactureFille> factures = ServiceFacture.factureFilleByCommande(idCommande, session);
        return ServiceFacture.totalPayer(factures);
    }
    
    public double totalPayer(long idCommande) throws ConnexionException {
        Session session = null;
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            List<FactureFille> factures = ServiceFacture.factureFilleByCommande(idCommande, session);
            return ServiceFacture.totalPayer(factures);
            
        } catch (HibernateException e) {
            throw new ConnexionException();
        } catch(ConnexionException e){
            throw e;
        }finally{
            if(session!=null) session.close();
        }
       
    }
    
    public static double totalPayer(List<FactureFille> factures) {
       double somme = 0; 
       for(FactureFille facture : factures) {
           somme+=facture.getValeur();
       }
       return somme;
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

    public static FactureFille findFactureFille(long id, Session session)throws Exception{
        FactureFille factureFille = new FactureFille(id);
        HibernateDao.findById(factureFille, session);
        return factureFille;
    }
    public void generatPdfFille(long idFactureFille,long idCommande,HttpServletRequest servletRequest) throws Exception {
        Session session = null; 
        try {
            session = this.hibernateDao.getSessionFactory().openSession(); 
            FactureFille factureFille = ServiceFacture.findFactureFille(idFactureFille, session); 
            ServiceCommande serviceCommande = new ServiceCommande();
            Commande com = serviceCommande.find(idCommande, session);
            List<CommandeStock> commandeStock = serviceCommande.find(com,session);
            Client client = serviceCommande.findClient(com, session);
            Facture factureF = ServiceFacture.findFacture(com, session);
            serviceCommande.initStock(commandeStock, session);
            
            List<FactureFille> factureFilles = ServiceFacture.factureFilleByCommande(idCommande, session);
            double totaPaye =0 ; 
            for(FactureFille factFille : factureFilles){
                if(factFille.getId()==idFactureFille) break; 
                totaPaye+=factFille.getValeur();
            }
            List<HorsSotck> hors_stock = serviceCommande.findListHorsStock(com, session);
            
            //creer une session pour get total: sinon erreur A different object with the same identifier value was already associated with the session : [com.project.location.model.Commande#1]
            HibernateDao hibernate = new HibernateDao();
            hibernate.setSessionFactory(new Configuration().configure().buildSessionFactory());
            Session s = hibernate.getSessionFactory().openSession();
            double[] total = serviceCommande.getTotal(idCommande, s);
            if(s!=null)s.close();
            FactureFilleGenerator facture = new FactureFilleGenerator(client,com,commandeStock,hors_stock,factureF ,totaPaye,factureFille.getValeur(),factureFille.getRef(),total, servletRequest);
            
        } catch( NullPointerException npe) {
            npe.printStackTrace();
            throw new Exception("Les données de la commande sont vide");
        } catch ( NotFacturedException e) {
            throw new Exception("La commande n'est pas payé");
        } catch( ConnexionException ce) {
            throw new Exception("Probleme de connexion à la base de donnée");
        } catch( Exception e){
            e.printStackTrace();
            throw e;
        }finally { 
            if(session!=null) session.close();
        }
         
    }
}
