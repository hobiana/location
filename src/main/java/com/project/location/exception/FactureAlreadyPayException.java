/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.exception;

import com.project.location.model.Commande;

/**
 *
 * @author Diary
 */
public class FactureAlreadyPayException extends Exception {
    public FactureAlreadyPayException(Commande commande) {
        super("La commande "+commande.getRef()+" a déjà été payé en totalité");
    }
    public FactureAlreadyPayException(String e){
        super(e);  
    }
}
