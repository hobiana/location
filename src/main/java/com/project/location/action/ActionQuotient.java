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
public class ActionQuotient extends BaseAction{
    public String quotient(){
        this.titre="Quotient";
        return Action.SUCCESS;
    }
    
    public String historiquequotient(){
        this.titre="Historique Quotient";
        return Action.SUCCESS;
    }
}
