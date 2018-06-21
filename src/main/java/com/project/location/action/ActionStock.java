/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

import com.opensymphony.xwork2.Action;
import com.project.location.model.Commande;
import com.project.location.model.CommandeStock;
import com.project.location.model.Entree;
import com.project.location.model.Sortie;
import com.project.location.model.Stock;
import com.project.location.model.Users;
import com.project.location.service.ServiceCommande;
import com.project.location.service.ServiceEntree;
import com.project.location.service.ServiceSortie;
import com.project.location.service.ServiceStock;
import com.project.location.util.DateUtil;
import java.util.ArrayList;
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
    private ServiceCommande serviceCommande;

    private int idStock;

    private String reference;
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
    private int prixCasse;

    private Commande commande;

    private List<Stock> listeStock;
    private List<Entree> listeEntree;
    private List<Sortie> listeSortie;
    private List<Commande> listeCommande;
    private List<CommandeStock> listeCommandeStock;
    private String dateMin;
    private String dateMax;
    private Stock stock;

    private int idCommande;

    private String title_page;
    private String title_panel;
    private String refStock;
    private String action;
    private String description;

    private boolean prepare;
    private boolean recu;

    // getters setters
    public boolean getPrepare() {
        return prepare;
    }

    public void setPrepare(boolean prepare) {
        this.prepare = prepare;
    }

    public boolean isRecu() {
        return recu;
    }

    public void setRecu(boolean recu) {
        this.recu = recu;
    }

    public ServiceCommande getServiceCommande() {
        return serviceCommande;
    }

    public void setServiceCommande(ServiceCommande serviceCommande) {
        this.serviceCommande = serviceCommande;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public List<Commande> getListeCommande() {
        return listeCommande;
    }

    public void setListeCommande(List<Commande> listeCommande) {
        this.listeCommande = listeCommande;
    }

    public List<CommandeStock> getListeCommandeStock() {
        return listeCommandeStock;
    }

    public void setListeCommandeStock(List<CommandeStock> listeCommandeStock) {
        this.listeCommandeStock = listeCommandeStock;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrixCasse() {
        return prixCasse;
    }

    public void setPrixCasse(int prixCasse) {
        this.prixCasse = prixCasse;
    }

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
        try {
            Users u = this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        this.titre = "Stock";
        listeStock = serviceStock.find(reference, designation, quantiteMin, quantiteMax, prixLocationMin, prixLocationMax);
        return Action.SUCCESS;
    }

    public String inStock() throws Exception {
        this.titre = "Entrée de Stock";
        this.stock = serviceStock.find(idStock);
        this.title_page = "Ajout du stock " + stock.getReference();
        this.title_panel = "Ajout du stock > " + this.stock.getDesignation();
        this.action = "ajoutStock";// ex addStock
        return Action.SUCCESS;
    }

    public String outStock() throws Exception {
        this.titre = "Sortie de Stock";
        this.stock = serviceStock.find(idStock);
        this.title_page = "Sortie du stock " + stock.getReference();
        this.title_panel = "Sortie du stock > " + this.stock.getDesignation();
        this.action = "sortieStock";// ex addStock
        return Action.SUCCESS;
    }

    public String ajoutStock() throws Exception {
        Entree entree = new Entree();
        entree.setStock(new Stock(idStock));
        entree.setQuantite(quantite);
        entree.setDate(Calendar.getInstance().getTime());
        entree.setPrixAchat(prixAchat);
        entree.setDescription(description);
        serviceEntree.insert(entree);
        return Action.SUCCESS;
    }

    public String newStock() throws Exception {
        Stock stock = new Stock();
        stock.setReference(reference);
        stock.setPrixLocation(prixLocation);
        stock.setDesignation(designation);
        stock.setQuantite(quantite);
        stock.setPrixCasse(this.getPrixCasse());
        serviceStock.insert(stock, prixAchat);
        return Action.SUCCESS;
    }

    public String sortieStock() throws Exception {
        Sortie sortie = new Sortie();
        sortie.setStock(new Stock(idStock));
        sortie.setQuantite(quantite);
        sortie.setDate(Calendar.getInstance().getTime());
        sortie.setDescription(description);
        serviceSortie.insert(sortie);
        return Action.SUCCESS;
    }

    public String toupdateStock() throws Exception {
        this.titre = "Modification de Stock";
        this.stock = serviceStock.find(idStock);
        this.refStock = stock.getRef();
        return Action.SUCCESS;
    }

    public String modifStock() throws Exception {
        Stock stock = serviceStock.find(idStock);
        stock.setDesignation(designation);
        stock.setPrixLocation(prixLocation);
        stock.setPrixCasse(prixCasse);
        stock.setReference(reference);
        serviceStock.update(stock);
        return Action.SUCCESS;
    }

    public String listInStock() throws Exception {
        try {
            Users u = this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        this.titre = "Liste entrée de Stock";
        listeEntree = serviceEntree.find(designation, prixAchatMin, prixAchatMax, quantiteMin, quantiteMax, dateMin, dateMax);
        return Action.SUCCESS;
    }

    public String listOutStock() throws Exception {
        try {
            Users u = this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        this.titre = "Liste sortie de Stock";
        listeSortie = serviceSortie.find(designation, quantiteMin, quantiteMax, dateMin, dateMax);
        return Action.SUCCESS;
    }

    public String commandedujour() throws Exception {
        try {
            Users u = this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        this.titre = "Commande du jour";
        this.listeCommande = serviceCommande.find("", Calendar.getInstance().getTime(), null, false, false, false, false);
        return Action.SUCCESS;
    }

    public String fichecommandestock() throws Exception {
        try {
            Users u = this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        this.commande = this.serviceCommande.find(idCommande);
        this.listeCommandeStock = this.serviceCommande.find(commande);
        this.titre = "Fiche Commande";
        return Action.SUCCESS;
    }

    public String commandeprepare() throws Exception {
        try {
            Users u = this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        this.commande = this.serviceCommande.find(idCommande);
        this.serviceCommande.updateEtatPreparee(idCommande, prepare);
        return Action.SUCCESS;
    }
    
    public String recuparclient() throws Exception {
        try {
            Users u = this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        this.commande = this.serviceCommande.find(idCommande);
        this.serviceCommande.updateEtatRecuParClient(idCommande, recu);
        return Action.SUCCESS;
    }

    public String listcommandestock() throws Exception {
        try {
            Users u = this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        try {
            if (reference != null) {
                Commande commande = new Commande();
                long idcommande = commande.getId(reference);
                commande = serviceCommande.find(idcommande);
                this.listeCommande = new ArrayList<>();
                this.listeCommande.add(commande);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            this.listeCommande = new ArrayList<>();
            return Action.SUCCESS;
        }

        this.titre = "Commande Stock";
        return Action.SUCCESS;
    }
}
