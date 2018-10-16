/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.main;

import com.project.location.dao.HibernateDao;
import com.project.location.model.Client;
import com.project.location.service.ServiceStat;
import com.project.location.util.DateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Diary
 */
public class Main {
    public static void main(String[] main){
       HibernateDao hibernate = new HibernateDao();
       hibernate.setSessionFactory(new Configuration().configure().buildSessionFactory());
       Session session = null;
       try{
           session = hibernate.getSessionFactory().openSession();
           ServiceStat.getArticleCasse(DateUtil.convert("2018-03-01"), session);
       }catch (Exception he) {
           he.printStackTrace();
       } finally {
           if(session!=null) session.close();
       }
       
       
    }
}
