/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

import com.opensymphony.xwork2.Action;
import com.project.location.model.Entree;
import com.project.location.model.Sortie;
import com.project.location.model.Stock;
import com.project.location.service.ServiceEntree;
import com.project.location.service.ServiceSortie;
import com.project.location.service.ServiceStock;
import com.project.location.util.DateUtil;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Hobiana
 */
public class ActionStock extends BaseAction {
    private ServiceStock serviceStock;
    private ServiceEntree serviceEntree;
    private ServiceSortie serviceSortie;
    
    private int idStock;
    
    private String designation; 
    private int prixAchat; 
    private int prixLocation; 
    private int quantite;
    
    private int quantiteMin;
    private int quantiteMax;
    private int prixLocationMin;
    private int prixLocationMax;
    private int prixAchatMin;
    private int prixAchatMax;
    
    private List<Stock> listeStock;
    private List<Entree> listeEntree;
    private List<Sortie> listeSortie;
    private String dateMin;
    private String dateMax;
    private Stock stock;
    
    private String title_page;
    private String title_panel;
    private String refStock;
    private String action;

    // getters setters

    public List<Sortie> getListeSortie() {
        return listeSortie;
    }

    public void setListeSortie(List<Sortie> listeSortie) {
        this.listeSortie = listeSortie;
    }

    public ServiceSortie getServiceSortie() {
        return serviceSortie;
    }

    public void setServiceSortie(ServiceSortie serviceSortie) {
        this.serviceSortie = serviceSortie;
    }

    public List<Entree> getListeEntree() {
        return listeEntree;
    }

    public void setListeEntree(List<Entree> listeEntree) {
        this.listeEntree = listeEntree;
    }

    public int getPrixAchatMin() {
        return prixAchatMin;
    }

    public void setPrixAchatMin(int prixAchatMin) {
        this.prixAchatMin = prixAchatMin;
    }

    public int getPrixAchatMax() {
        return prixAchatMax;
    }

    public void setPrixAchatMax(int prixAchatMax) {
        this.prixAchatMax = prixAchatMax;
    }
    
    public ServiceEntree getServiceEntree() {
        return serviceEntree;
    }

    public void setServiceEntree(ServiceEntree serviceEntree) {
        this.serviceEntree = serviceEntree;
    }

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

    public String getDateMin() {
        return dateMin;
    }

    public void setDateMin(String dateMin) {
        this.dateMin = dateMin;
    }

    public String getDateMax() {
        return dateMax;
    }

    public void setDateMax(String dateMax) {
        this.dateMax = dateMax;
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

    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }

    public int getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(int prixLocation) {
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
        this.titre="Entr�e de Stock";        
        this.stock= serviceStock.find(idStock);
        this.title_page="Ajout du stock "+stock.getRef();
        this.title_panel="Ajout du stock > "+this.stock.getDesignation();
        this.action="ajoutStock";// ex addStock
        return Action.SUCCESS;
    }
    
    public String outStock() throws Exception {
        this.titre="Sortie de Stock";
        this.stock= serviceStock.find(idStock);
        this.title_page="Sortie du stock "+stock.getRef();
        this.title_panel="Sortie du stock > "+this.stock.getDesignation();
        this.action="sortieStock";// ex addStock
        return Action.SUCCESS;
    }
    
    public String ajoutStock() throws Exception{
        Entree entree=new Entree();
        entree.setStock(new Stock(idStock));
        entree.setQuantite(quantite);
        entree.setDate(Calendar.getInstance().getTime());
        entree.setPrixAchat(prixAchat);
        serviceEntree.insert(entree);
        return Action.SUCCESS;
    }
    
    public String newStock() throws Exception{
        Entree entree=new Entree();
        Stock stock = new Stock();
        stock.setPrixLocation(prixLocation);
        stock.setDesignation(designation);
        stock.setQuantite(quantite);
        serviceStock.insert(stock,prixAchat);
        return Action.SUCCESS;
    }
    
    public String sortieStock() throws Exception{
        Sortie sortie= new Sortie();
        sortie.setStock(new Stock(idStock));
        sortie.setQuantite(quantite);
        sortie.setDate(Calendar.getInstance().getTime());
        serviceSortie.insert(sortie);
        return Action.SUCCESS;
    }
    
    public String toupdateStock() throws Exception {
        this.titre="Modification de Stock";
        this.stock= serviceStock.find(idStock);
        this.refStock=stock.getRef();
        return Action.SUCCESS;
    }
    
    public String modifStock() throws Exception {
        Stock stock=serviceStock.find(idStock);
        stock.setDesignation(designation);
        stock.setPrixLocation(prixLocation);
        serviceStock.update(stock);
        return Action.SUCCESS;
    }
    
    public String listInStock() throws Exception {
        this.titre="Liste entr�e de Stock";
        listeEntree = serviceEntree.find(designation, prixAchatMin, prixAchatMax, quantiteMin, quantiteMax, dateMin, dateMax);
        return Action.SUCCESS;
    }
    
    public String listOutStock() throws Exception {
        this.titre="Liste sortie de Stock";
        listeSortie= serviceSortie.find(designation, quantiteMin, quantiteMax, dateMin, dateMax);
        return Action.SUCCESS;
    }
}
