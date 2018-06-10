/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

import com.opensymphony.xwork2.ActionSupport;
import com.project.location.model.HistoriqueUser;
import com.project.location.model.Users;
import com.project.location.model.UsersAcces;
import com.project.location.reference.ReferenceAccesUser;
import com.project.location.reference.ReferenceSession;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author Diary
 */
public class BaseAction extends ActionSupport implements ServletRequestAware{

    protected Users user;
    protected String titre;
    protected String linkError = "none";
    protected String messageError;
    protected String linkSuccess = "none";
    protected String messageSuccess;
    protected HttpServletRequest servletRequest;

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

    protected boolean checkArgument(String arg) {
        return !(arg == null || arg.compareTo("") == 0);
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

    public Users getSessionUser() throws Exception{
        HttpSession session = ServletActionContext.getRequest().getSession();
        if(session.getAttribute(ReferenceSession.USER)==null) throw new Exception("Not Logged => No session");
        return (Users)session.getAttribute(ReferenceSession.USER);
    }
    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.servletRequest = request;
    }
    public boolean getAccesCaisseQuotient() throws Exception{
        Users user = this.getSessionUser();
        for (UsersAcces acces : user.getUserAccess()) {
            if(acces.getAcces().getId()==ReferenceAccesUser.CAISSEQUOTIENT)
                return true;
        }
        return false;
    }
    public boolean getAccesClient() throws Exception{
        Users user = this.getSessionUser();
        for (UsersAcces acces : user.getUserAccess()) {
            if(acces.getAcces().getId()==ReferenceAccesUser.CLIENT)
                return true;
        }
        return false;
    }
    public boolean getAccesCommande() throws Exception{
        Users user = this.getSessionUser();
        for (UsersAcces acces : user.getUserAccess()) {
            if(acces.getAcces().getId()==ReferenceAccesUser.COMMANDE)
                return true;
        }
        return false;
    }
    public boolean getAccesUser() throws Exception{
        Users user = this.getSessionUser();
        for (UsersAcces acces : user.getUserAccess()) {
            if(acces.getAcces().getId()==ReferenceAccesUser.USER)
                return true;
        }
        return false;
    }
    public boolean getAccesStock() throws Exception{
        Users user = this.getSessionUser();
        for (UsersAcces acces : user.getUserAccess()) {
            if(acces.getAcces().getId()==ReferenceAccesUser.STOCK)
                return true;
        }
        return false;
    }
    public boolean getAccesRoot() throws Exception{
        Users user = this.getSessionUser();
        long idroot = user.getUserAccess().get(0).getAcces().getId();
        if(user.getUserAccess().size()==1&&idroot==ReferenceAccesUser.ROOT)
            return true;
        return false;
    }
}
