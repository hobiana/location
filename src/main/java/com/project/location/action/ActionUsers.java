/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

import com.opensymphony.xwork2.Action;
import com.project.location.model.Acces;
import com.project.location.model.HistoriqueUser;
import com.project.location.model.Users;
import com.project.location.model.UsersAcces;
import com.project.location.reference.ReferenceAccesUser;
import com.project.location.reference.ReferenceErreur;
import com.project.location.security.Cryptage;
import com.project.location.service.ServiceHistoriqueUser;
import com.project.location.service.ServiceUsers;
import com.project.location.util.Test;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diary
 */
public class ActionUsers extends BaseAction {

    private Users utilisateur; 
    private ServiceUsers serviceUsers;
    private ServiceHistoriqueUser serviceHistoriqueUser;
    private List<Users> users;
    private List<HistoriqueUser> historiqueUsers;
    
    private long idUsers; 
    private String nom; 
    private String prenom; 
    private String phone; 
    private String adresse; 
    private String pseudo; 
    private String mdp; 
    private String confirmation;
    
    private String action;
    private String dateMin;
    private String dateMax;
    
    private boolean boolCaisseQuotient;
    private boolean boolClients;
    private boolean boolCommande;
    private boolean boolStock;
    private boolean boolUser;

    public boolean isBoolCaisseQuotient() {
        return boolCaisseQuotient;
    }

    public void setBoolCaisseQuotient(boolean boolCaisseQuotient) {
        this.boolCaisseQuotient = boolCaisseQuotient;
    }

    public boolean isBoolClients() {
        return boolClients;
    }

    public void setBoolClients(boolean boolClients) {
        this.boolClients = boolClients;
    }

    public boolean isBoolCommande() {
        return boolCommande;
    }

    public void setBoolCommande(boolean boolCommande) {
        this.boolCommande = boolCommande;
    }

    public boolean isBoolStock() {
        return boolStock;
    }

    public void setBoolStock(boolean boolStock) {
        this.boolStock = boolStock;
    }

    public boolean isBoolUser() {
        return boolUser;
    }

    public void setBoolUser(boolean boolUser) {
        this.boolUser = boolUser;
    }

    public Users getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Users utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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

    public ServiceHistoriqueUser getServiceHistoriqueUser() {
        return serviceHistoriqueUser;
    }

    public void setServiceHistoriqueUser(ServiceHistoriqueUser serviceHistoriqueUser) {
        this.serviceHistoriqueUser = serviceHistoriqueUser;
    }

    public List<HistoriqueUser> getHistoriqueUsers() {
        return historiqueUsers;
    }

    public void setHistoriqueUsers(List<HistoriqueUser> historiqueUsers) {
        this.historiqueUsers = historiqueUsers;
    }

    public long getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(long idUsers) {
        this.idUsers = idUsers;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

    
    public ServiceUsers getServiceUsers() {
        return serviceUsers;
    }

    public void setServiceUsers(ServiceUsers serviceUsers) {
        this.serviceUsers = serviceUsers;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public String index() {
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        
        this.titre = "Users | Liste";
        try {
            this.users = this.serviceUsers.find(nom, prenom, pseudo, adresse);
            return Action.SUCCESS;
        } catch (Exception e) {
            this.linkError = ReferenceErreur.VISIBLE; 
            this.messageError = e.getMessage(); 
            return Action.ERROR;
        }
    }
    public String loadModifier(){
        this.titre="Modifier Utilisateur";
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        try{
            this.utilisateur = this.serviceUsers.find(this.idUsers);
            if(Test.argmumentNull(pseudo)) this.setPseudo(utilisateur.getPseudo());
            if(Test.argmumentNull(nom)) this.setNom(utilisateur.getNom());
            if(Test.argmumentNull(prenom)) this.setPrenom(utilisateur.getPrenom());
            if(Test.argmumentNull(phone)) this.setPhone(utilisateur.getPhone());
            if(Test.argmumentNull(adresse)) this.setAdresse(utilisateur.getAdresse());
            
            this.serviceUsers.findAcces(utilisateur);
            long idroot = this.utilisateur.getUserAccess().get(0).getAcces().getId();
            if(this.utilisateur.getUserAccess().size()==1&&idroot==ReferenceAccesUser.ROOT){
                boolCaisseQuotient = true;
                boolClients = true;
                boolCommande = true;
                boolUser = true;
                boolStock = true;
            }
            else{
                for (UsersAcces acces : this.utilisateur.getUserAccess()) {
                    long id = acces.getAcces().getId();
                    switch(Integer.parseInt(String.valueOf(id))){
                        case ReferenceAccesUser.CAISSEQUOTIENT: 
                            boolCaisseQuotient = true;
                            break;
                        case ReferenceAccesUser.CLIENT: 
                            boolClients = true;
                            break;
                        case ReferenceAccesUser.COMMANDE: 
                            boolCommande = true;
                            break;
                        case ReferenceAccesUser.USER: 
                            boolUser = true;
                            break;
                        case ReferenceAccesUser.STOCK: 
                            boolStock = true;
                            break;
                    }
                }
            }
            return Action.SUCCESS;
        }catch(Exception e){
            this.linkError = ReferenceErreur.VISIBLE; 
            this.messageError = e.getMessage();
            return Action.ERROR;
        }
    }
    public String updateUsers(){
        try{
            Users user = new Users(this.getIdUsers());
            user.setPseudo(pseudo);
            user.setNom(nom);
            user.setPrenom(prenom);
            user.setPhone(phone);
            user.setAdresse(adresse);
            if(!Test.argmumentNull(mdp)){
                if(mdp.compareTo(this.confirmation)!=0) throw new Exception("les mots de passe sont différents");
                user.setMdp(Cryptage.crypterHashage(mdp));
            }
            
            List<Integer> listAccess = new ArrayList();
            if(this.boolCaisseQuotient) listAccess.add(ReferenceAccesUser.CAISSEQUOTIENT);;
            if(this.boolClients)listAccess.add(ReferenceAccesUser.CLIENT);
            if(this.boolCommande)listAccess.add(ReferenceAccesUser.COMMANDE);
            if(this.boolUser)listAccess.add(ReferenceAccesUser.USER);
            if(this.boolStock)listAccess.add(ReferenceAccesUser.STOCK);
            if(listAccess.size()==5)listAccess.clear(); listAccess.add(ReferenceAccesUser.ROOT);
            
            this.serviceUsers.updateUsers(user, listAccess);
            this.linkSuccess = ReferenceErreur.VISIBLE;
            this.messageSuccess = "L'utilisateur " + nom + " a été mise à jour avec succès";
            
            return Action.SUCCESS;
        }catch(Exception e){
            e.printStackTrace();
             this.linkError = ReferenceErreur.VISIBLE; 
            this.messageError = e.getMessage();
            return Action.ERROR;
        }
    }
    public String saveUsers(){
        Users user = new Users();
        try {
            this.titre = "Users | Nouveau utilisateurs";
            user.setNom(nom);
            user.setPrenom(prenom);
            user.setAdresse(adresse);
            user.setPhone(phone);
            user.setPseudo(pseudo);
            user.setMdp(Cryptage.crypterHashage(mdp));
            
            if(this.mdp.compareTo(confirmation)!=0)throw new Exception("Les mots de passe sont differents");
            
            List<Integer> listAccess = new ArrayList();
            if(this.boolCaisseQuotient) listAccess.add(ReferenceAccesUser.CAISSEQUOTIENT);;
            if(this.boolClients)listAccess.add(ReferenceAccesUser.CLIENT);
            if(this.boolCommande)listAccess.add(ReferenceAccesUser.COMMANDE);
            if(this.boolUser)listAccess.add(ReferenceAccesUser.USER);
            if(this.boolStock)listAccess.add(ReferenceAccesUser.STOCK);
            if(listAccess.size()==5)listAccess.clear(); listAccess.add(ReferenceAccesUser.ROOT);
            
            this.serviceUsers.saveUsers(user, listAccess);
            this.linkSuccess = ReferenceErreur.VISIBLE;
            this.messageSuccess = "L'utilisateur " + nom + " a été ajouté avec succès";
            
            return Action.SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            this.linkError = ReferenceErreur.VISIBLE;
            this.messageError = ex.getMessage();
            return Action.ERROR;
        }
    }
    
    public String utilisateurs(){
        this.titre="Utilisateurs";
        return Action.SUCCESS;
    }
    
    public String ficheuser(){
        this.titre="Fiche Utilisateur";
        return Action.SUCCESS;
    }
    
    public String historiqueuser() throws Exception{
        try {
            Users u=this.getSessionUser();
        } catch (Exception ex) {
            return Action.LOGIN;
        }
        this.titre="Historiques Utilisateur";
        this.historiqueUsers = serviceHistoriqueUser.find(action, dateMin, dateMax, adresse);
        return Action.SUCCESS;
    }
    
    public String deluser(){
        this.titre="Utilisateurs";
        return Action.SUCCESS;
    }
}
