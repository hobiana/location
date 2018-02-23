/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

import com.opensymphony.xwork2.Action;
import com.project.location.model.Commande;
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
public class ActionCommande extends BaseAction {

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
    private String action;

    private List<Commande> listeCommande;
    // getter setter

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<Commande> getListeCommande() {
        return listeCommande;
    }

    public void setListeCommande(List<Commande> listeCommande) {
        this.listeCommande = listeCommande;
    }

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
        this.titre = "Commande";
        listeStock = serviceStock.find();
        if (Test.argmumentNull(dateDebut)) {
            dateDebut = DateUtil.convert(Calendar.getInstance().getTime());
        }
        if (Test.argmumentNull(dateFin)) {
            Date d = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            c.add(Calendar.DATE, 1);
            d = c.getTime();
            dateFin = DateUtil.convert(d);
        }
        listeCommandeStock = serviceCommande.getCommande();
        return Action.SUCCESS;
    }

    public String addSessionCommande() throws Exception {
        serviceCommande.addCommand(idStock, quantite, dateDebut, dateFin);
        return Action.SUCCESS;
    }

    public String deleteSessionCommande() throws Exception {
        serviceCommande.deleteCommand(idCommandeStock);
        return Action.SUCCESS;
    }

    public String modifSessionCommande() throws Exception {
        serviceCommande.modifierCommand(idCommandeStock, quantite, dateDebut, dateFin);
        return Action.SUCCESS;
    }

    public String verifSessionCommande() throws Exception {
        serviceCommande.checkAll(dateDebut, dateFin);
        return Action.SUCCESS;
    }

    public String validerSessionCommande() throws Exception {
        if (action.equals("save")) {
            if (serviceCommande.saveCommande(idClient, dateDebut, dateFin)) {
                return Action.SUCCESS;
            }
        }
        else if(!action.equals("save")){
            // ito fonction update ito ilay ataon la
            /*
            if (serviceCommande.updateCommande(idClient, dateDebut, dateFin)) {
                return Action.SUCCESS;
            }*/
        }
        return Action.ERROR;
    }

    public String listCommande() throws Exception {
        this.titre = "Liste Commande";
        return Action.SUCCESS;
    }

    public String ficheCommande() throws Exception {
        this.titre = "Fiche Commande";
        return Action.SUCCESS;
    }
}
