/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.service;

import com.project.location.model.Users;
import com.project.location.security.Cryptage;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Hobiana
 */
public class ServiceClient extends BaseService{
    public Users login(String matricule, String password)throws Exception{
        Session session = null;
        Query query = null;
        try{
            session = hibernateDao.getSessionFactory().openSession();
            String sql = "from Users u where u.pseudo = :login AND u.password = :password";
            query = session.createQuery(sql);
            query.setParameter("login", matricule);
            String crypt = Cryptage.crypterHashage(password);
            query.setParameter("password",crypt);
            List<Users> list = query.list();
            if(list.size()>0)return list.get(0);
            else throw new Exception("L'email ou le mot de passe est incorrect");  
        }catch(Exception e){
            throw e;
        }finally{
            if(session!=null) session.close();
        }    
    }
}
