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
public class ActionPaiement extends BaseAction{
    private int idCommande;

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }
    
    public String toPaiement(){
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        
        
        return Action.SUCCESS;
    }
    
    public String payer(){
        return Action.SUCCESS;
    }
}
