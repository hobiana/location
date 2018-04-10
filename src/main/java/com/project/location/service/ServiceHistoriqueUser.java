/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.service;

import com.project.location.dao.HibernateDao;
import com.project.location.model.HistoriqueUser;
import com.project.location.model.Users;
import com.project.location.reference.ReferenceSession;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Diary
 */
public class ServiceHistoriqueUser extends BaseService{
    public static void save(String action, Session session)throws Exception{
        HttpSession sessionServlet = ServletActionContext.getRequest().getSession();
        Users user = (Users)sessionServlet.getAttribute(ReferenceSession.USER);
        if(user==null)throw new Exception("Vueillez vous connecter");     
        HistoriqueUser historique = new HistoriqueUser(); 
        historique.setAction(action);
        historique.setDateHU(Calendar.getInstance().getTime());
        historique.setUser(user);
        try{
            HibernateDao.save(historique, session);
        }catch(Exception e){
            throw new Exception("Impossible de sauvegarder l'action cause : "+e.getMessage());       
        }
    }
    public List<HistoriqueUser> getHistorique(Users user)throws Exception{
        Session session = null; 
        Query query = null;
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            String sql = "SELECT historique FROM HistoriqueUser historique where historique.user.id = :id "; 
            query = session.createQuery(sql);
            query.setParameter("id", user.getId()); 
            
            return (List<HistoriqueUser>)(Object)query.list();
            
        }catch(Exception e){
            throw new Exception("impossible d'extraire la liste des action de l'utilisateur cause "+e.getMessage());
        }
    }
}
