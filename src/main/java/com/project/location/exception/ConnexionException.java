/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.exception;

/**
 *
 * @author Diary
 */
public class ConnexionException extends Exception{
    public ConnexionException(String error) {
        super(error);
    }
    
    public ConnexionException(){
        super("probleme lors de la connexion à la base de donnée");
    }
}
