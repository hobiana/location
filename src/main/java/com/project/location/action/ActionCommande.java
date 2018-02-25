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
import com.project.location.reference.ReferenceSession;
import com.project.location.service.ServiceCommande;
import com.project.location.service.ServiceStock;
import com.project.location.util.DateUtil;
import com.project.location.util.Test;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

/**
 *
 * @author Hobiana
 */
public class ActionCommande extends BaseAction {

    private List<Stock> listeStock;
    private List<CommandeStock> listeCommandeStock;
    private ServiceStock serviceStock;
    private ServiceCommande serviceCommande;

    private int idCommande;
    private int idCommandeStock;
    private int idStock;
    private int idClient;
    private int quantite;

    private String dateDebut;
    private String dateFin;
    private String dateDebutCommande; 
    private String dateFinCommande; 
    private String action;

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    
    public String getDateDebutCommande() {
        return dateDebutCommande;
    }

    public void setDateDebutCommande(String dateDebutCommande) {
        this.dateDebutCommande = dateDebutCommande;
    }

    public String getDateFinCommande() {
        return dateFinCommande;
    }

    public void setDateFinCommande(String dateFinCommande) {
        this.dateFinCommande = dateFinCommande;
    }
    
    
    
    private String recu; 
    private String retour; 
    private String annule; 

    public String getRecu() {
        return recu;
    }

    public void setRecu(String recu) {
        this.recu = recu;
    }

    public String getRetour() {
        return retour;
    }

    public void setRetour(String retour) {
        this.retour = retour;
    }

    public String getAnnule() {
        return annule;
    }

    public void setAnnule(String annule) {
        this.annule = annule;
    }

    
    
    private String client; 

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
    
    
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
        if(idCommande<=0){
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
        }else{
            HttpSession session = ServletActionContext.getRequest().getSession();          
            long idCommandeSession =0;
            if(session.getAttribute(ReferenceSession.IDCOMMANDE)!=null) idCommandeSession = (long) session.getAttribute(ReferenceSession.IDCOMMANDE);
            if(idCommandeSession==0) idCommandeSession = this.idCommande;
            Commande commande = this.serviceCommande.find(idCommandeSession);
            this.idCommande = 0; 
            session.setAttribute(ReferenceSession.IDCOMMANDE,idCommandeSession);
            dateDebut = DateUtil.convert(commande.getDateDebut()); 
            dateFin = DateUtil.convert(commande.getDateFin());
            this.serviceCommande.setCommande(this.serviceCommande.fin(commande));
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
            if (
                serviceCommande.saveCommande(idClient, dateDebut, dateFin)) {
                return Action.SUCCESS;
            }
        }
        else if(!action.equals("save")){
            // ito fonction update ito ilay ataon la
           
            if (serviceCommande.updateCommande(dateDebut, dateFin)) {
                return Action.SUCCESS;
            }
        }
        return Action.ERROR;
    }
   
    public String listCommande() throws Exception {
        try{
            this.listeCommande = this.serviceCommande.getCommande(client,dateDebutCommande,dateFinCommande,this.dateDebut, this.dateFin,!Test.argmumentNull(recu),!Test.argmumentNull(retour),!Test.argmumentNull(annule));
        }catch(Exception e){
            e.printStackTrace();
        }
        this.titre = "Liste Commande";
        return Action.SUCCESS;
    }

    public String ficheCommande() throws Exception {
        this.titre = "Fiche Commande";
        return Action.SUCCESS;
    }
}
