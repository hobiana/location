/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.service;

import com.project.location.dao.HibernateDao;
import com.project.location.model.Users;
import com.project.location.model.UsersAcces;
import com.project.location.util.Test;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Diary
 */
public class ServiceUsers extends BaseService{
    private ServiceUtil serviceUtil;

    public ServiceUtil getServiceUtil() {
        return serviceUtil;
    }

    public void setServiceUtil(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }
    
    public List<Users> findAll() throws Exception{
        try{
        List<Users> reponse = (List<Users>)(Object)this.hibernateDao.findAll(new Users());
        return reponse;
        }catch(Exception e){
            throw new Exception("impossible d'extraire la liste des utilisateurs");
        }       
    }
    
    public void save(Users users)throws Exception{
        Session session = null; 
        Transaction tr = null; 
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            tr = session.beginTransaction();
            if(!this.exist(users.getPseudo())){
                HibernateDao.save(users,session);
            }else{
                throw new Exception("le pseudo utilisé existe déjà");
            }
            ServiceHistoriqueUser.save("ajout d'un nouveau user "+users.getPrenom()+" "+users.getNom(),session);
            tr.commit();
        }catch(Exception e){
            if(tr!=null)tr.rollback();
            throw new Exception("impossible d'enregistrer l'utilisateur dans la base de donnée cause"+e.getMessage());
        }finally{
            if(session!=null)session.close();
        }
    }
    public void saveUsers(Users users,List<Integer> idAcces)throws Exception{
        Session session = null; 
        Transaction tr = null; 
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            tr = session.beginTransaction();
            if(!this.exist(users.getPseudo())){
                HibernateDao.save(users,session);
                int size = idAcces.size();
                List<UsersAcces> idAccess= new ArrayList();
                for (int i = 0; i < size; i++) {
                    idAccess.add(new UsersAcces(users.getId(), idAcces.get(i)));
                }
                ServiceUsers.insertAccess(idAccess, session);
            }else{
                throw new Exception("le pseudo utilisé existe déjà");
            }
            ServiceHistoriqueUser.save("ajout d'un nouveau user "+users.getPrenom()+" "+users.getNom(),session);
            tr.commit();
        }catch(Exception e){
            if(tr!=null)tr.rollback();
            e.printStackTrace();
            throw new Exception("impossible d'enregistrer l'utilisateur dans la base de donnée cause"+e.getMessage());
        }finally{
            if(session!=null)session.close();
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
        Session session = null; 
        Transaction tr= null;
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            tr = session.beginTransaction();
            HibernateDao.update(user,session);
            ServiceHistoriqueUser.save("mise à jour de l'user "+user.getPseudo(), session);
            tr.commit();
        }catch(Exception e){
            if(tr!=null)tr.rollback();
            throw new Exception("impossible de metrre à jour l'utilisateur cause "+e.getMessage());
        }finally{
            if(session!=null)session.close();
        }
    }
    
    public void update(Users user,List<UsersAcces> userAccess) throws Exception{
        Users temp = this.find(user.getId());  
        if(temp.getPseudo().compareTo(user.getPseudo())!=0) if(this.exist(user.getPseudo()))throw new Exception("le pseudo inseré existe déja");             
        if(Test.argmumentNull(user.getMdp()))user.setMdp(temp.getMdp());
        Session session = null; 
        Transaction tr= null;
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            tr = session.beginTransaction();
            ServiceUsers.clearAccess(user, session);
            ServiceUsers.insertAccess(userAccess, session);
            HibernateDao.update(user,session);
            ServiceHistoriqueUser.save("mise à jour de l'user "+user.getPseudo(), session);
            tr.commit();
        }catch(Exception e){
            if(tr!=null)tr.rollback();
            throw new Exception("impossible de metrre à jour l'utilisateur cause "+e.getMessage());
        }finally{
            if(session!=null)session.close();
        }
    }
    public void updateUsers(Users user, List<Integer> idAcces) throws Exception{
        Users temp = this.find(user.getId());  
        if(temp.getPseudo().compareTo(user.getPseudo())!=0) if(this.exist(user.getPseudo()))throw new Exception("le pseudo inseré existe déja");             
        if(Test.argmumentNull(user.getMdp()))user.setMdp(temp.getMdp());
        Session session = null; 
        Transaction tr= null;
        int size = idAcces.size();
        List<UsersAcces> idAccess= new ArrayList();
        for (int i = 0; i < size; i++) {
            idAccess.add(new UsersAcces(user.getId(), idAcces.get(i)));
        }
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            tr = session.beginTransaction();
            ServiceUsers.clearAccess(user, session);
            ServiceUsers.insertAccess(idAccess, session);
            HibernateDao.update(user,session);
            ServiceHistoriqueUser.save("mise à jour de l'user "+user.getPseudo(), session);
            tr.commit();
        }catch(Exception e){
            if(tr!=null)tr.rollback();
            e.printStackTrace();
            throw new Exception("impossible de metrre à jour l'utilisateur cause "+e.getMessage());
        }finally{
            if(session!=null)session.close();
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
    public static void findAcces(Users user, Session session) throws HibernateException {
        try{
            String sql = "SELECT usersAccess FROM UsersAcces usersAccess join usersAccess.user user WHERE user.id = :id";
            Query query = session.createQuery(sql); 
            query.setParameter("id", user.getId()); 
            if(!query.list().isEmpty()){
                user.setUserAccess((List<UsersAcces>)(Object)query.list());
            }
            
        } catch(HibernateException he) {
            throw he;
        }
    }
    public void findAcces(Users user) throws HibernateException {
        Session session = null;
        try{
            session = hibernateDao.getSessionFactory().openSession();
            ServiceUsers.findAcces(user, session);
        }catch(Exception ex){
            throw ex;
        }finally{
            if(session!=null) session.close();
        }
    }
    public static void clearAccess(Users user, Session session) throws HibernateException, Exception {
        try{
            String sql = "DELETE FROM UsersAcces usersAcces WHERE usersAcces.user.id = :id"; 
            Query query = session.createQuery(sql); 
            query.setParameter("id", user.getId());
            query.executeUpdate();
            
        } catch(HibernateException he) {
            he.printStackTrace();
            throw he;
        }
    }
    public static void insertAccess(UsersAcces userAcces, Session session) throws HibernateException {
        try{
            HibernateDao.save(userAcces, session);
        } catch(Exception he) {
            he.printStackTrace();
            throw new HibernateException(he.getMessage());
        }
    }
    public static void insertAccess(List<UsersAcces> userAcces, Session session) throws HibernateException {
        try{
            for (UsersAcces userA : userAcces) {
                ServiceUsers.insertAccess(userA, session);
            }
        } catch(HibernateException he) {
            throw he;
        }
    }
    public void insertAccess(List<UsersAcces> userAcces) throws Exception{
        Session session = null; 
        Transaction tr= null;
        try{
            session = this.hibernateDao.getSessionFactory().openSession();
            tr = session.beginTransaction();
            ServiceUsers.insertAccess(userAcces, session);
            tr.commit();
        }catch(HibernateException ex){
            if(tr!=null) tr.rollback();
            throw new Exception("erreur de connexion à la base de données");
        }catch(Exception ex){
            ex.printStackTrace();
            if(tr!=null) tr.rollback();
            throw new Exception("erreur interne sur l'insertion des access de l'utilisateur");
        }finally{
            if(session!=null) session.close();
        }
    }
    public List<Users> find(String nom, String prenom, String pseudo, String adresse) throws Exception {
        List<Object[]> arg = new ArrayList<>();
        Object[] nomUser = Test.instance(2);
        nomUser[0] = "nom";
        nomUser[1] = nom;
        if (Test.argmumentNull(nom)) {
            nomUser = null;
        }
        Object[] prenomUser = Test.instance(2);
        prenomUser[0] = "prenom";
        prenomUser[1] = prenom;
        if (Test.argmumentNull(prenom)) {
            prenomUser = null;
        }
        Object[] pseudoUser = Test.instance(2);
        pseudoUser[0] = "pseudo";
        pseudoUser[1] = pseudo;
        if (Test.argmumentNull(pseudo)) {
            pseudoUser = null;
        }
        Object[] adresseUser = Test.instance(2);
        adresseUser[0] = "adresse";
        adresseUser[1] = adresse;
        if (Test.argmumentNull(adresse)) {
            adresseUser = null;
        }

        if (!Test.testNull(nomUser)) {
            arg.add(nomUser);
        }
        if (!Test.testNull(prenomUser)) {
            arg.add(prenomUser);
        }
        if (!Test.testNull(pseudoUser)) {
            arg.add(pseudoUser);
        }
        if (!Test.testNull(adresseUser)) {
            arg.add(adresseUser);
        }
        List<Users> reponse = null;
        try {
            reponse = (List<Users>) (Object) this.serviceUtil.find(arg, Users.class);
            return reponse;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Impossible d'extraire la recherche");
        }
    }
}
