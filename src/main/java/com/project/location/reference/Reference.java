/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.reference;

import com.project.location.model.Commande;
import com.project.location.model.Entree;
import com.project.location.model.Facture;
import com.project.location.model.Sortie;
import com.project.location.model.Stock;

/**
 *
 * @author Diary
 */
public class Reference {
    public static final String COMMANDE = "CMD"; 
    public static final String STOCK = "STO"; 
    public static final String FACTURE = "FAC";
    public static final String ENTREE = "ETS";
    public static final String SORTIE = "SRS";
     public static Class getClass(String reference)throws Exception{
        if(reference.compareToIgnoreCase(Reference.COMMANDE)==0)return Commande.class;
        if(reference.compareToIgnoreCase(Reference.STOCK)==0)return Stock.class;
        if(reference.compareToIgnoreCase(Reference.FACTURE)==0)return Facture.class;
        if(reference.compareToIgnoreCase(Reference.ENTREE)==0)return Entree.class;
        if(reference.compareToIgnoreCase(Reference.SORTIE)==0)return Sortie.class;
       
        else throw new Exception("Desole, la reference n'est pas dans la base");
        
    }
}
