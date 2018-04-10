/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

import com.opensymphony.xwork2.Action;
import com.project.location.model.Users;

/**
 *
 * @author Hobiana
 */
public class ActionQuotient extends BaseAction{
    public String quotient(){
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        this.titre="Quotient";
        return Action.SUCCESS;
    }
    
    public String historiquequotient(){
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        this.titre="Historique Quotient";
        return Action.SUCCESS;
    }
}
