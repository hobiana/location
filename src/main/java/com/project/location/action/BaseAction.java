/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

import com.opensymphony.xwork2.ActionSupport;
import com.project.location.model.Users;

/**
 *
 * @author Diary
 */
public class BaseAction extends ActionSupport{
    protected Users user;
    protected String titre; 
    protected String linkError ="none";
    protected String messageError;
    protected String linkSuccess ="none";
    protected String messageSuccess;

    public String getLinkSuccess() {
        return linkSuccess;
    }

    public void setLinkSuccess(String linkSuccess) {
        this.linkSuccess = linkSuccess;
    }

    public String getMessageSuccess() {
        return messageSuccess;
    }

    public void setMessageSuccess(String messageSuccess) {
        this.messageSuccess = messageSuccess;
    }

    public String getLinkError() {
        return linkError;
    }

    public void setLinkError(String linkError) {
        this.linkError = linkError;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }
    
    
    
    protected boolean checkArgument(String arg){
        return !(arg==null||arg.compareTo("")==0);
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    
}