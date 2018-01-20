/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.evenementiel.util;

/**
 *
 * @author Diary
 */
public class Test {
    public static void doubleNegatif(double test, String nameDouble) throws Exception{
        if(test<0)throw new Exception(nameDouble+" ne peut pas être inférieure à 0");
    }
}
