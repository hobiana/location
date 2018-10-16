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
public class NotFacturedException extends Exception{
     public NotFacturedException(){
        super("La commande n'a pas encore été facturé");
    }
}
