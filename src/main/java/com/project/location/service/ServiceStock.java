/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.service;

import com.project.location.dao.HibernateDao;
import com.project.location.model.Entree;
import com.project.location.model.HistoriquePrixStock;
import com.project.location.model.Stock;
import com.project.location.util.Test;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Diary
 */
public class ServiceStock extends BaseService {

    private ServiceUtil serviceUtil;

    public ServiceUtil getServiceUtil() {
        return serviceUtil;
    }

    public void setServiceUtil(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    public List<Stock> find() throws Exception {
        List<Stock> reponse = null;
        try {
            reponse = (List<Stock>) (Object) this.hibernateDao.findAll(new Stock());
            return reponse;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erreur d'extraction des stocks");
        }
    }

    public List<Stock> find(String designation, int quantiteMin, int quantiteMax, int locationMin, int locationMax) throws Exception {
        List<Object[]> arg = new ArrayList<>();
        Object[] des = Test.instance(2);
        des[0] = "designation";
        des[1] = designation;
        if (Test.argmumentNull(designation)) {
            des = null;
        }
        Object[] quantite = Test.instance(3);
        quantite[0] = "quantite";
        if (quantiteMin < quantiteMax) {
            quantite[1] = quantiteMin;
            quantite[2] = quantiteMax;
        } else if (quantiteMax < quantiteMin) {
            quantite[1] = quantiteMax;
            quantite[2] = quantiteMin;
        } else if (quantiteMin == 0 && quantiteMax > 0) {
            quantite = Test.instance(2);
            quantite[0] = "quantite";
            quantite[1] = quantiteMax;
        } else if (quantiteMax == 0 && quantiteMin > 0) {
            quantite = Test.instance(2);
            quantite[0] = "quantite";
            quantite[1] = quantiteMin;
        } else if (quantiteMax == 0 && quantiteMin == 0) {
            quantite = null;
        } else {
            quantite = Test.instance(2);
            quantite[0] = "quantite";
            quantite[1] = quantiteMin;
        }

        Object[] location = Test.instance(3);
        location[0] = "prixLocation";
        if (locationMin < locationMax) {
            location[1] = locationMin;
            location[2] = locationMax;
        } else if (locationMax < locationMin) {
            location[1] = locationMax;
            location[2] = locationMin;
        } else if (locationMin == 0 && locationMax > 0) {
            location = Test.instance(2);
            location[0] = "prixLocation";
            location[1] = locationMax;
        } else if (locationMax == 0 && locationMin > 0) {
            location = Test.instance(2);
            location[0] = "prixLocation";
            location[1] = locationMin;
        } else if (locationMax == 0 && locationMin == 0) {
            location = null;
        } else {
            location = Test.instance(2);
            location[0] = "prixLocation";
            location[1] = locationMin;
        }

        if (!Test.testNull(des)) {
            arg.add(des);
        }
        if (!Test.testNull(quantite)) {
            arg.add(quantite);
        }
        if (!Test.testNull(location)) {
            arg.add(location);
        }
        List<Stock> reponse = null;
        try {
            reponse = (List<Stock>) (Object) this.serviceUtil.find(arg, Stock.class);
            return reponse;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Impossible d'extraire la recherche");
        }
    }

    public void insert(Stock stock, int prixAchat) throws Exception {
        Entree entree = null;
        HistoriquePrixStock historique = null;
        if (stock != null && stock.getQuantite() > 0) {
            entree = new Entree();
            entree.setStock(stock);
            entree.setDate(Calendar.getInstance().getTime());
            entree.setQuantite(stock.getQuantite());
            entree.setPrixAchat(prixAchat);
        }
        historique = new HistoriquePrixStock();
        historique.setDate(Calendar.getInstance().getTime());
        historique.setPrix(stock.getPrixLocation());
        historique.setStock(stock);
        try {
            if (stock == null) {
                throw new Exception("stock non initialis�");
            }
            this.hibernateDao.save(stock);
            this.hibernateDao.save(historique);
            if (entree != null) {
                this.hibernateDao.save(entree);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Impossible d'inserer le stock cause " + e.getMessage());
        }
    }

    public Stock find(long id) throws Exception {
        Stock stock = new Stock(id);
        try {
            this.hibernateDao.findById(stock);
            return stock;
        } catch (Exception e) {
            throw new Exception("Le stock " + id + " est introuvable cause " + e.getMessage());
        }
    }

    public void update(Stock stock) throws Exception {
        Session session = null;
        Transaction tr = null;
        try {
            session = hibernateDao.getSessionFactory().openSession();
            tr = session.beginTransaction();
            Stock oldStock = this.find(stock.getId());
            if (oldStock.getPrixLocation() != stock.getPrixLocation()) {
                HistoriquePrixStock historique = new HistoriquePrixStock();
                historique.setDate(Calendar.getInstance().getTime());
                historique.setPrix(stock.getPrixLocation());
                historique.setStock(stock);
                HibernateDao.save(historique, session);               
            }
            HibernateDao.update(stock, session);
            tr.commit();
        } catch (Exception ex) {
            if (tr != null) {
                tr.rollback();
            }
            throw new Exception("impossible de d'ajouter dans historique de prix stock ou de modifier le stock : " + stock.getRef());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Stock stock) throws Exception {
        try {
            this.hibernateDao.delete(stock);
        } catch (Exception e) {
            throw new Exception("Impossible de supprimer le stock id : " + stock.getId() + " puisqu'il est en d�pendance avec d'autre object");
        }
    }
}
