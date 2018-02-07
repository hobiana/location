/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.service;

import com.project.location.model.Users;
import com.project.location.util.Test;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Diary
 */
public class ServiceUsers extends BaseService{
    public List<Users> findAll() throws Exception{
        try{
        List<Users> reponse = (List<Users>)(Object)this.hibernateDao.findAll(new Users());
        return reponse;
        }catch(Exception e){
            throw new Exception("impossible d'extraire la liste des utilisateurs");
        }       
    }
    public void save(Users users)throws Exception{
        try{
            if(!this.exist(users.getPseudo())){
                this.hibernateDao.save(users);
            }else{
                throw new Exception("le pseudo utilisé existe déjà");
            }
            
        }catch(Exception e){
            throw new Exception("impossible d'enregistrer l'utilisateur dans la base de donnée cause"+e.getMessage());
        }
    }
    public Users find(long id)throws Exception{
        Users reponse;
        try{
            reponse = new Users(id); 
            this.hibernateDao.findById(reponse);
            return reponse;
        }catch(Exception e){
            throw new Exception("impossible d'extraire l'user");
        }
    }
    public void update(Users user) throws Exception{
        Users temp = this.find(user.getId());  
        if(temp.getPseudo().compareTo(user.getPseudo())!=0) if(this.exist(user.getPseudo()))throw new Exception("le pseudo inseré existe déja");             
        if(Test.argmumentNull(user.getMdp()))user.setMdp(temp.getMdp());
        try{
            this.hibernateDao.update(user);
        }catch(Exception e){
            throw new Exception("impossible de metrre à jour l'utilisateur cause "+e.getMessage());
        }
    }
    public Users find(String pseudo)throws Exception{
        Session session = null;
        Query query = null;
        try{
            session = hibernateDao.getSessionFactory().openSession();
            String sql = "from Users u where u.pseudo = :pseudo";
            query = session.createQuery(sql);
            query.setParameter("login", pseudo);
            List<Users> list = query.list();
            if(list.size()>0)return list.get(0);
            else throw new Exception("compte inexistant");  
        }catch(Exception e){
            throw e;
        }finally{
            if(session!=null) session.close();
        }    
    }
    public boolean exist(String pseudo)throws Exception{
        Session session = null;
        Query query = null;
        try{
            session = hibernateDao.getSessionFactory().openSession();
            String sql = "from Users u where u.pseudo = :pseudo";
            query = session.createQuery(sql);
            query.setParameter("pseudo", pseudo);
            List<Users> list = query.list();
            if(list.size()>0)return true;
            return false;  
        }catch(Exception e){
            throw e;
        }finally{
            if(session!=null) session.close();
        }    
    }
}
