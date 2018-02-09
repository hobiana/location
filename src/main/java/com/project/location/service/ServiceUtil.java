/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.service;

import com.project.location.model.BaseModel;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Diary
 */
public class ServiceUtil extends BaseService{
    
    public List<BaseModel> find(List<Object[]> arg,Class classe)throws Exception{
        List<BaseModel> reponse = null; 
        Session session = null;
        try{
            Criteria criteria = session.createCriteria(classe,"object");
            for(int i=0;i<arg.size();i++){
                Object[] temp = arg.get(i);
                if(temp.length==2){
                    Object object = temp[1];
                    if(object.getClass()==String.class){
                        criteria.add(Restrictions.ilike("object."+(String)temp[0], "%"+(String)temp[1]+"%"));
                    }else{
                         criteria.add(Restrictions.eq("object."+(String)temp[0],temp[1]));                
                    }
                   
                }else if(temp.length == 3){
                    criteria.add(Restrictions.between("object."+(String)temp[0], temp[1], temp[2]));
                }
            }
            reponse = criteria.list();
            return reponse;
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Impossible d'extraire la recherche cause "+e.getMessage());
        } 
    }
}
