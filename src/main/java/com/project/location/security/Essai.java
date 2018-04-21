/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.security;

import com.project.location.dao.HibernateDao;
import com.project.location.model.Client;
import com.project.location.model.ESArgentCaisseModel;
import com.project.location.service.ServiceCaisseQuotient;
import com.project.location.util.NumberTest;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Hobiana
 */
public class Essai {
    public static void main(String[] args){
        ApplicationContext xl = new ClassPathXmlApplicationContext("applicationContext.xml");
        ServiceCaisseQuotient service = xl.getBean("serviceCaisseQuotient", ServiceCaisseQuotient.class);
        try {
            List<ESArgentCaisseModel> object = service.findCaisse("","0","0","","","");
            int i=0;
            
        } catch (Exception ex) {
            Logger.getLogger(Essai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
