/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.security;

import com.project.location.dao.HibernateDao;
import com.project.location.model.Client;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hobiana
 */
public class Essai {
    public static void main(String[] args){
        try {
            HibernateDao dao = new HibernateDao();
            List<Client> clients = (List<Client>)(Object) dao.findAll(new Client());
            System.out.println(clients);
        } catch (Exception ex) {
            Logger.getLogger(Essai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}