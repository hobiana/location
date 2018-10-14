/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.model;

/**
 *
 * @author Diary
 */
public class JsonResult {
    private boolean success; 
    private Object message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object messages) {
        if(messages == null) {
            this.message = "Verifier les champs, null pointer";
        }
        else if (messages.getClass() == Exception.class) {
            Exception ex = (Exception)messages;
            this.message = "Une erreur s'est produite "+ex.getMessage();
        }
        else this.message = messages;
    }
    
    public JsonResult(){ 
      
    } 
    public JsonResult(boolean success, Object result){
        this.setSuccess(success);
        this.setMessage(result);
    }
}
