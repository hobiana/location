/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.service;

import com.project.location.dao.HibernateDao;
import com.project.location.model.BaseModel;
import com.project.location.model.Client;
import com.project.location.model.Users;
import com.project.location.security.Cryptage;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            String sql = "from Users u where u.pseudo = :login AND u.mdp = :password";
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
    
    public List<Client> getListClient(){
        List<Client> clients=null;
        try {
            clients = (List<Client>)(Object) this.hibernateDao.findAll(new Client());
        } catch (Exception ex) {
            ex.printStackTrace();
            clients=null;
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clients;
    }
    
    public void saveClient(Client e){
        try {
            this.hibernateDao.save(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void modifier(Client client) throws Exception{
        try{
            this.hibernateDao.update(client);
        }catch(Exception e){
            throw new Exception("impossible de modifier le client cause "+e.getMessage());
        }
    }
    public Client find(long id) throws Exception{
        Client client = null; 
        try{
            client = new Client();
            client.setId(id);           
            this.hibernateDao.findById(client);
            return client;
        }catch(Exception e){
            throw new Exception("impossible d'extraire les données du client "+id);
        }
    }
    public void delete(Client client) throws Exception{
        try{
            this.hibernateDao.delete(client);
        }catch(Exception e){
            throw new Exception("impossible de supprimer le client dans la base de donnée");
        }
    }
    public void delete(long id) throws Exception{
        try{
            this.hibernateDao.delete(new Client(id));
        }catch(Exception e){
            throw new Exception("impossible de supprimer le client dans la base de donnée");
        }
    }
}
