/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.service;

import com.project.location.dao.HibernateDao;
import com.project.location.model.Facture;
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
            throw new Exception("impossible de sauvegarder la facture");
        }
    }
}
