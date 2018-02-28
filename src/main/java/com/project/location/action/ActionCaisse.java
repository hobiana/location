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
public class ActionCaisse extends BaseAction{
    public String caisse(){
        this.titre="Caisse";
        return Action.SUCCESS;
    }
    
    public String historiquecaisse(){
        this.titre="Historique Caisse";
        return Action.SUCCESS;
    }
}
