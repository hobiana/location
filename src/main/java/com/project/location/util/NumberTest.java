/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.util;

import java.text.DecimalFormat;

/**
 *
 * @author Diary
 */
public class NumberTest {
    public static double referenceToNumber(String ref) throws Exception{
        String number = ref.substring(3,ref.length()-1);
        double reponse = 0;
        try{
            reponse = Double.parseDouble(number);
            return reponse;
        }catch(Exception e){
            throw new Exception("Format de la reference invalide");
        }
    }
    public static String toRef(double value){
        DecimalFormat nf = new DecimalFormat("00000");
        return nf.format(value);
    }
    public static String toMoney(double value){
        return String.format("%,d", (int)value);
    }
}
