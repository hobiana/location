/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

import com.opensymphony.xwork2.Action;
import com.project.location.model.Client;
import com.project.location.model.StatModel;
import com.project.location.model.Users;
import com.project.location.reference.ReferenceErreur;
import com.project.location.reference.ReferenceSession;
import com.project.location.service.ServiceClient;
import com.project.location.service.ServiceStat;
import com.project.location.service.ServiceUsers;
import com.project.location.util.DateUtil;
import com.project.location.util.Test;
import com.project.location.util.UtilConvert;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Diary
 */
public class ActionClient extends BaseAction {
    private ServiceStat serviceStat;
    private ServiceClient clientService;
    private ServiceUsers serviceUsers;
    private String email;
    private String password;

    private List<Client> listeClient;

    private String nom;
    private String prenom;
    private String cin;
    private String adresse;
    private String telephone;
    private long idClient;
    private String blacklist;
    private List<String> label; 
    private List<Double> data;
    private String years;
    private List<StatModel> meilleurClient;

    public List<StatModel> getMeilleurClient() {
        return meilleurClient;
    }

    public void setMeilleurClient(List<StatModel> meilleurClient) {
        this.meilleurClient = meilleurClient;
    }
    
    
    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }
    
    
    

    public List<String> getLabel() {
        return label;
    }

    public void setLabel(List<String> label) {
        this.label = label;
    }

    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }
    
    private String caisseMoney; 
    private String quotientMoney;
    private int commandeCount; 
    private int clientCount; 
    private int stockCount;

    public String getCaisseMoney() {
        return caisseMoney;
    }

    public void setCaisseMoney(String caisseMoney) {
        this.caisseMoney = caisseMoney;
    }

    public String getQuotientMoney() {
        return quotientMoney;
    }

    public void setQuotientMoney(String quotientMoney) {
        this.quotientMoney = quotientMoney;
    }

    public int getCommandeCount() {
        return commandeCount;
    }

    public void setCommandeCount(int commandeCount) {
        this.commandeCount = commandeCount;
    }

    public int getClientCount() {
        return clientCount;
    }

    public void setClientCount(int clientCount) {
        this.clientCount = clientCount;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }
    
    

    private Client client;

    public ServiceStat getServiceStat() {
        return serviceStat;
    }

    public void setServiceStat(ServiceStat serviceStat) {
        this.serviceStat = serviceStat;
    }
    
    

    public ServiceUsers getServiceUsers() {
        return serviceUsers;
    }

    public void setServiceUsers(ServiceUsers serviceUsers) {
        this.serviceUsers = serviceUsers;
    }
    

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(String blacklist) {
        this.blacklist = blacklist;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

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

    public void setSessionUser() {
        HttpSession session = ServletActionContext.getRequest().getSession();
        Object object = session.getAttribute(ReferenceSession.USER);
        if (object != null) {
            this.setUser((Users) object);
        }
    }

    public List<Client> getListeClient() {
        return listeClient;
    }

    public void setListeClient(List<Client> listeClient) {
        this.listeClient = listeClient;
    }

    public String load() throws Exception {

        this.setSessionUser();
        if (this.user != null) {
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }

    public String login() {
        this.titre = "Accueil";
        if (!this.checkArgument(this.email) || (!this.checkArgument(this.password))) {
            this.linkError = ReferenceErreur.VISIBLE;
            this.messageError = "Veuillez remplir les champs pseudo et mot de passe";
            return Action.ERROR;
        }
        try {
            this.user = this.clientService.login(email, password);
            HttpSession session = ServletActionContext.getRequest().getSession();
            this.user = this.clientService.login(email, password);
            this.serviceUsers.findAcces(user);
            session.setAttribute(ReferenceSession.USER, this.user);
        } catch (Exception e) {
            e.printStackTrace();
            this.linkError = ReferenceErreur.VISIBLE;
            this.messageError = "Veuillez verifier les champs pseudo et mot de passe";
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }
    
    public String logout() {
         HttpSession session = ServletActionContext.getRequest().getSession();
         session.removeAttribute(ReferenceSession.USER);
        return Action.SUCCESS;
    }
    
    public String dashboard(){
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        try{
            this.setCaisseMoney(UtilConvert.toMoney(this.serviceStat.caisseArgent()));
            this.setQuotientMoney(UtilConvert.toMoney(this.serviceStat.quotientArgent()));
            this.setCommandeCount((int)this.serviceStat.nombreCommandeTotal());
            this.setStockCount((int)this.serviceStat.nombreProduitTotal());
            this.setClientCount((int)this.serviceStat.nombreClientTotal());
            this.setMeilleurClient(this.serviceStat.getBiggerBenificeClient());
            this.years = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
            
            this.label = new ArrayList(); 
            Date now = Calendar.getInstance().getTime();
            for(int i=0;i<7;i++) {
                this.label.add(0, DateUtil.convert(now));
                now.setDate(now.getDate()-1);
                
            }
            Date next = new Date();
            next.setDate(Calendar.getInstance().getTime().getDate()+1);
            this.setData(this.serviceStat.nombreCommandeJour(now, next));
        }catch(Exception e){
            e.printStackTrace();
            this.linkError = ReferenceErreur.VISIBLE; 
            this.messageError = e.getMessage(); 
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }

    public String listclient() throws Exception {
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        this.titre = "Clients";
        listeClient = clientService.find(nom, prenom, cin, adresse);
        if (listeClient == null) {
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }

    public String saveClient() {
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        Client e = new Client();
        try {
            this.titre = "Clients";
            e.setNom(nom);
            e.setPrenom(prenom);
            e.setAdresse(adresse);
            e.setCIN(cin);
            e.setTelephone(telephone);
            clientService.saveClient(e);

            this.linkSuccess = ReferenceErreur.VISIBLE;
            this.messageSuccess = "Le client " + nom + " a été ajouté avec succès";
            
            return Action.SUCCESS;
        } catch (Exception ex) {
            this.linkError = ReferenceErreur.VISIBLE;
            this.messageError = ex.getMessage();
            return Action.ERROR;
        }
    }

    public String loadModifier() {
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        try {
            client = this.clientService.find(idClient);
            if (Test.argmumentNull(nom)) {
                this.setNom(client.getNom());
            }
            if (Test.argmumentNull(prenom)) {
                this.setPrenom(client.getPrenom());
            }
            if (Test.argmumentNull(cin)) {
                this.setCin(client.getCIN());
            }
            if (Test.argmumentNull(adresse)) {
                this.setAdresse(client.getAdresse());
            }
            if (Test.argmumentNull(telephone)) {
                this.setTelephone(client.getTelephone());
            }
            if (Test.argmumentNull(blacklist)) {
                this.setBlacklist(String.valueOf(client.isBlackListe()));
            }

            return Action.SUCCESS;
        } catch (Exception e) {
            this.linkError = ReferenceErreur.VISIBLE;
            this.messageError = e.getMessage();
            return Action.ERROR;
        }
    }
    
    public String ficheClient(){
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
         try {
            client = this.clientService.find(idClient);
            this.years = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
            return Action.SUCCESS;
        } catch (Exception e) {
            this.linkError = ReferenceErreur.VISIBLE;
            this.messageError = e.getMessage();
            return Action.ERROR;
        }
    }
    
    public String modifierModifier() {
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        Client client = null;

        try {
            client = this.clientService.find(idClient);
            client.setAdresse(adresse);
            client.setPrenom(prenom);
            client.setNom(nom);
            client.setCIN(cin);
            client.setTelephone(telephone);
            if (blacklist == null) {
                blacklist = "false";
            }
            client.setBlackListe(blacklist);

            this.clientService.modifier(client);

            this.linkSuccess = ReferenceErreur.VISIBLE;
            this.messageSuccess = "Le client " + nom + " a été modifié avec succès";
            return Action.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            this.linkError = ReferenceErreur.VISIBLE;
            this.messageError = e.getMessage();
            return Action.ERROR;
        }
    }
}
