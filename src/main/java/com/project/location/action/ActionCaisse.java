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
public class ActionCaisse extends BaseAction{
    public String caisse(){
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        this.titre="Caisse";
        return Action.SUCCESS;
    }
    
    public String historiquecaisse(){
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        this.titre="Historique Caisse";
        return Action.SUCCESS;
    }
}
