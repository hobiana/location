/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

import com.opensymphony.xwork2.Action;
import com.project.location.model.Client;
import com.project.location.model.Users;
import com.project.location.reference.ReferenceErreur;
import com.project.location.reference.ReferenceSession;
import com.project.location.service.ServiceClient;
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

    private ServiceClient clientService;
    private String email;
    private String password;

    private List<Client> listeClient;

    private String nom;
    private String prenom;
    private String cin;
    private String adresse;
    private long idClient;
    private String blacklist;

    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        } catch (Exception e) {
            e.printStackTrace();
            this.linkError = ReferenceErreur.VISIBLE;
            this.messageError = "Veuillez verifier les champs pseudo et mot de passe";
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }

    public String listclient() {
        this.titre = "Clients";
        listeClient = clientService.getListClient();
        if (listeClient == null) {
            return Action.ERROR;
        }
        return Action.SUCCESS;
    }

    public String modifClient() {
        this.titre = "Modifier un client";
        return Action.SUCCESS;
    }

    public String saveClient() {
        Client e = new Client();
        try {
            this.titre = "Clients";
            e.setNom(nom);
            e.setPrenom(prenom);
            e.setAdresse(adresse);
            e.setCIN(cin);
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
            client = this.clientService.find(idClient);
            return Action.SUCCESS;
        } catch (Exception e) {
            this.linkError = ReferenceErreur.VISIBLE;
            this.messageError = e.getMessage();
            return Action.ERROR;
        }
    }

    public String modifierModifier() {
        Client client = null;

        try {
            client = this.clientService.find(idClient);
            client.setAdresse(adresse);
            client.setPrenom(prenom);
            client.setNom(nom);
            client.setCIN(cin);
            if(blacklist==null) blacklist="false";
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
