/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.util;

/**
 *
 * @author Diary
 */
public class Test {
    public static void doubleNegatif(double test, String nameDouble) throws Exception{
        if(test<0)throw new Exception(nameDouble+" ne peut pas être inférieure à 0");
    }
    public static void argmumentTest(String arg, String nomArgument) throws Exception{
        if(arg.compareTo("")==0)throw new Exception(nomArgument+" ne peut pas être vide");
    }
    public static boolean argmumentNull(String arg){
        return arg==null||arg.compareTo("")==0;
    }
    public static void castInt(String arg, String nomArgument) throws Exception{
        try{
            Double.parseDouble(arg);
        }catch(Exception e){
            throw new Exception(nomArgument+" ne doit contenir que des chiffres");
        }
        
    }
}
