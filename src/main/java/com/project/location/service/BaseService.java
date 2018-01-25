/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.service;
import com.project.location.dao.HibernateDao;

/**
 *
 * @author diary
 */
public class BaseService {
    protected HibernateDao hibernateDao;

    public HibernateDao getHibernateDao() {
        return hibernateDao;
    }
    public void setHibernateDao(HibernateDao hibernateDao) {
        this.hibernateDao = hibernateDao;
    }
    
}
