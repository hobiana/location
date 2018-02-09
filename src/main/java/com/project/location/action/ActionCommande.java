/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

import com.opensymphony.xwork2.Action;

/**
 *
 * @author Hobiana
 */
public class ActionCommande extends BaseAction{
    
    public String commande() throws Exception {
        this.titre="Sortie de Stock";
        return Action.SUCCESS;
    }
    
}
