/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

import com.opensymphony.xwork2.Action;
import com.project.location.model.Users;
import com.project.location.reference.ReferenceErreur;
import com.project.location.reference.ReferenceSession;
import com.project.location.service.ServiceClient;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Diary
 */
public class ActionClient extends BaseAction {
    private ServiceClient clientService;
    private String email; 
    private String password; 

    public ServiceClient getClientService() {
        return clientService;
    }

    public void setClientService(ServiceClient clientService) {
        this.clientService = clientService;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setSessionUser(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        Object object = session.getAttribute(ReferenceSession.USER);
        if (object != null) {
            this.setUser((Users) object);
        }     
    }    
    public String load() throws Exception { 
       
        this.setSessionUser();
        if (this.user != null) {
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }
    public String login(){
       
        this.titre="Accueil";
        if(!this.checkArgument(this.email)||(!this.checkArgument(this.password))){
            this.linkError = ReferenceErreur.VISIBLE;
            this.messageError = "Veuillez remplir les champs pseudo et mot de passe"; 
            return Action.ERROR;
        }
        try{
            this.user = this.clientService.login(email, password);
        }catch(Exception e){
            e.printStackTrace();
            this.linkError = ReferenceErreur.VISIBLE;
            this.messageError = "Veuillez verifier les champs pseudo et mot de passe"; 
            return Action.ERROR;
        }
        
        return Action.SUCCESS;
    }
   
}
