/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author diary
 */
public class DateUtil {
    public static int nombreJ(Date debut, Date fin)throws Exception{
        final long MILLISECONDS_PER_DAY = 1000 * 60 * 60 * 24; 
        long delta = fin.getTime() - debut.getTime();
        return (int)(delta / (MILLISECONDS_PER_DAY))+1;
    }
    public static String convert(Date date)throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
        String reponse; 
        try{
            reponse = sdf.format(date);
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("La date inserer n'est pas valide");
        }
        return reponse; 
    }
    public static String convertNormal(Date date)throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); 
        String reponse; 
        try{
            reponse = sdf.format(date);
        }catch(Exception e){
            throw new Exception("La date inserer n'est pas valide");
        }
        return reponse; 
    }
    public static String convertAllNormal(Date date)throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm"); 
        String reponse; 
        try{
            reponse = sdf.format(date);
        }catch(Exception e){
            throw new Exception("La date inserer n'est pas valide");
        }
        return reponse; 
    }
    public static String toLettre(Date date)throws Exception{
       
        SimpleDateFormat dateFormat;

        dateFormat = new SimpleDateFormat("EEEE dd MMMMM yyyy");
        return dateFormat.format(date);
    }
    public static String toLettreWithoutDay(Date date){
       
        SimpleDateFormat dateFormat;

        dateFormat = new SimpleDateFormat("dd MMMMM yyyy");
        return dateFormat.format(date);
    }
  
   
    public static Date convert(String date)throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date reponse ;
        try{
            reponse = sdf.parse(date);
        }catch(Exception e){
            throw new Exception("Impossible d'extraire la date, veuillez utiliser le format YYYY-MM-dd (ex : 2017-01-31)");
        }
        return reponse; 
    }
}
