/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

import com.opensymphony.xwork2.Action;
import com.project.location.model.Stock;
import com.project.location.service.ServiceStock;
import java.util.List;

/**
 *
 * @author Hobiana
 */
public class ActionStock extends BaseAction {
    private ServiceStock serviceStock;
    
    private int idStock;
    
    private String designation; 
    private double prixAchat; 
    private double prixLocation; 
    private int quantite;
    
    private int quantiteMin;
    private int quantiteMax;
    private int prixLocationMin;
    private int prixLocationMax;
    
    private List<Stock> listeStock;
    private Stock stock;
    
    private String title_page;
    private String title_panel;
    private String refStock;
    private String action;

    // getters setters

    public int getPrixLocationMin() {
        return prixLocationMin;
    }

    public void setPrixLocationMin(int prixLocationMin) {
        this.prixLocationMin = prixLocationMin;
    }

    public int getPrixLocationMax() {
        return prixLocationMax;
    }

    public void setPrixLocationMax(int prixLocationMax) {
        this.prixLocationMax = prixLocationMax;
    }
    
    public int getQuantiteMin() {
        return quantiteMin;
    }

    public void setQuantiteMin(int quantiteMin) {
        this.quantiteMin = quantiteMin;
    }

    public int getQuantiteMax() {
        return quantiteMax;
    }

    public void setQuantiteMax(int quantiteMax) {
        this.quantiteMax = quantiteMax;
    }

    public String getTitle_page() {
        return title_page;
    }

    public void setTitle_page(String title_page) {
        this.title_page = title_page;
    }

    public String getTitle_panel() {
        return title_panel;
    }

    public void setTitle_panel(String title_panel) {
        this.title_panel = title_panel;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public String getRefStock() {
        return refStock;
    }

    public void setRefStock(String refStock) {
        this.refStock = refStock;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public ServiceStock getServiceStock() {
        return serviceStock;
    }

    public void setServiceStock(ServiceStock serviceStock) {
        this.serviceStock = serviceStock;
    }
    
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public double getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(double prixLocation) {
        this.prixLocation = prixLocation;
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
    
    //fin getter setters
    
    
    public String load() throws Exception {
        this.titre="Stock";
        listeStock = serviceStock.find(designation, quantiteMin, quantiteMax, prixLocationMin, prixLocationMax);
        return Action.SUCCESS;
    }
    
    public String inStock() throws Exception {
        this.titre="Entrée de Stock";
        this.refStock="REF"+this.idStock;
        this.title_page="Ajout du stock "+this.refStock;
        this.stock= serviceStock.find(idStock);
        this.title_panel="Ajout du stock > "+this.stock.getDesignation();
        this.action="";// ex addStock
        return Action.SUCCESS;
    }
    
    public String outStock() throws Exception {
        this.titre="Sortie de Stock";
        this.refStock="REF"+this.idStock;
        this.title_page="Sortie du stock "+this.refStock;
        this.stock= serviceStock.find(idStock);
        this.title_panel="Sortie du stock > "+this.stock.getDesignation();
        this.action="";// ex addStock
        return Action.SUCCESS;
    }
    
    public String updateStock() throws Exception {
        this.titre="Modification de Stock";
        this.refStock="REF"+this.idStock;
        this.stock= serviceStock.find(idStock);
        return Action.SUCCESS;
    }
    
    public String listInStock() throws Exception {
        this.titre="Liste entrée de Stock";
        return Action.SUCCESS;
    }
    
    public String listOutStock() throws Exception {
        this.titre="Liste sortie de Stock";
        return Action.SUCCESS;
    }
}
