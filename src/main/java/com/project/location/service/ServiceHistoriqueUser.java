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
import com.project.location.util.DateUtil;
import com.project.location.util.Test;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    private ServiceUtil serviceUtil;

    public ServiceUtil getServiceUtil() {
        return serviceUtil;
    }

    public void setServiceUtil(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }
    
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
    
    public List<HistoriqueUser> find(String action, String dateMin, String dateMax, String adresse) throws Exception {
        Date dateMins = null;
        Date dateMaxs = null;
        if(!Test.argmumentNull(dateMin)){
            dateMins = DateUtil.convert(dateMin);
        }
        if(!Test.argmumentNull(dateMax)){
            dateMaxs = DateUtil.convert(dateMax);
        }
        return this.find(action, dateMins, dateMaxs, adresse);
    }
    
    public List<HistoriqueUser> find(String action, Date dateMin, Date dateMax, String adresse) throws Exception {
        List<Object[]> arg = new ArrayList<>();
        Object[] actionUsers = Test.instance(2);
        actionUsers[0] = "action";
        actionUsers[1] = action;
        if (Test.argmumentNull(action)) {
            actionUsers = null;
        }
        Object[] date = Test.instance(3); 
        date[0] = "dateHU";
        if(dateMin==null&&dateMax!=null){
            date = Test.instance(2);
            date[0] = "dateHU";
            date[1] = dateMax;
        }else if(dateMax==null&&dateMin!=null){
            date = Test.instance(2);
            date[0] = "dateHU";
            date[1] = dateMin;
        }else if(dateMax==null&&dateMin==null){
            date = null;
        }else if(dateMin.before(dateMax)){
            date[1] = dateMin;
            date[2] = dateMax;
        }else if(dateMax.before(dateMin)){            
            date[1] = dateMax;  
            date[2] = dateMin;    
        } else{
            date = Test.instance(2);
            date[0] = "dateHU";
            date[1] = dateMin;
        }

        if (!Test.testNull(actionUsers)) {
            arg.add(actionUsers);
        }
        List<HistoriqueUser> reponse = null;
        try {
            reponse = (List<HistoriqueUser>) (Object) this.serviceUtil.find(arg, HistoriqueUser.class);
            return reponse;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Impossible d'extraire la recherche");
        }
    }

}
