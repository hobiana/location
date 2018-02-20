/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

import com.opensymphony.xwork2.Action;
import com.project.location.model.CommandeStock;
import com.project.location.model.Stock;
import com.project.location.service.ServiceCommande;
import com.project.location.service.ServiceStock;
import com.project.location.util.DateUtil;
import com.project.location.util.Test;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Hobiana
 */
public class ActionCommande extends BaseAction{
    private List<Stock> listeStock;
    private List<CommandeStock> listeCommandeStock;
    private ServiceStock serviceStock;
    private ServiceCommande serviceCommande;
    
    private int idCommandeStock;
    private int idStock;
    private int idClient;
    private int quantite;
    
    private String dateDebut;
    private String dateFin;
    // getter setter

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public int getIdCommandeStock() {
        return idCommandeStock;
    }

    public void setIdCommandeStock(int idCommandeStock) {
        this.idCommandeStock = idCommandeStock;
    }

    public List<CommandeStock> getListeCommandeStock() {
        return listeCommandeStock;
    }

    public void setListeCommandeStock(List<CommandeStock> listeCommande) {
        this.listeCommandeStock = listeCommande;
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public List<Stock> getListeStock() {
        return listeStock;
    }

    public void setListeStock(List<Stock> listeStock) {
        this.listeStock = listeStock;
    }

    public ServiceStock getServiceStock() {
        return serviceStock;
    }

    public void setServiceStock(ServiceStock serviceStock) {
        this.serviceStock = serviceStock;
    }

    public ServiceCommande getServiceCommande() {
        return serviceCommande;
    }

    public void setServiceCommande(ServiceCommande serviceCommande) {
        this.serviceCommande = serviceCommande;
    }
    
    
    // getter setters
    public String commande() throws Exception {
        this.titre="Commande";
        listeStock = serviceStock.find();
        if(Test.argmumentNull(dateDebut)) dateDebut=DateUtil.convert(Calendar.getInstance().getTime());
        if(Test.argmumentNull(dateFin)){
            Date d = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            c.add(Calendar.DATE, 1);
            d=c.getTime();
            dateFin=DateUtil.convert(d);
        }
        listeCommandeStock = serviceCommande.getCommande();
        return Action.SUCCESS;
    }
    
    public String addCommande() throws Exception {
        serviceCommande.addCommand(idStock, quantite,dateDebut,dateFin);
        return Action.SUCCESS;
    }
    
    public String deleteCommande() throws Exception {
        serviceCommande.deleteCommand(idCommandeStock);
        return Action.SUCCESS;
    }
    
    public String modifCommande() throws Exception {
        serviceCommande.modifierCommand(idCommandeStock, quantite,dateDebut,dateFin);
        return Action.SUCCESS;
    }
    
    public String verifCommande() throws Exception {
        serviceCommande.checkAll(dateDebut, dateFin);
        return Action.SUCCESS;
    }
    
    public String validerCommande() throws Exception {
        if (serviceCommande.saveCommande(idClient, dateDebut, dateFin)){
            return Action.SUCCESS;
        }
        return Action.ERROR;
    }
}
