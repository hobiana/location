/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.location.action;

import com.opensymphony.xwork2.Action;
import com.project.location.model.Users;
import com.project.location.reference.ReferenceErreur;
import com.project.location.security.Cryptage;
import com.project.location.service.ServiceUsers;
import com.project.location.util.Test;
import java.util.List;

/**
 *
 * @author Diary
 */
public class ActionUsers extends BaseAction {

    private Users utilisateur; 
    private ServiceUsers serviceUsers;
    private List<Users> users;
    
    private long idUsers; 
    private String nom; 
    private String prenom; 
    private String phone; 
    private String adresse; 
    private String pseudo; 
    private String mdp; 
    private String confirmation;

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
        this.titre = "Users | Liste";
        try {
            this.users = this.serviceUsers.findAll();
            return Action.SUCCESS;
        } catch (Exception e) {
            this.linkError = ReferenceErreur.VISIBLE; 
            this.messageError = e.getMessage(); 
            return Action.ERROR;
        }
    }
    public String loadModifier(){
        try{
            this.utilisateur = this.serviceUsers.find(this.idUsers);
            if(Test.argmumentNull(pseudo)) this.setPseudo(utilisateur.getPseudo());
            if(Test.argmumentNull(nom)) this.setNom(utilisateur.getNom());
            if(Test.argmumentNull(prenom)) this.setPrenom(utilisateur.getPrenom());
            if(Test.argmumentNull(phone)) this.setPhone(utilisateur.getPhone());
            if(Test.argmumentNull(adresse)) this.setAdresse(utilisateur.getAdresse());
            
            return Action.SUCCESS;
        }catch(Exception e){
            this.linkError = ReferenceErreur.VISIBLE; 
            this.messageError = e.getMessage();
            return Action.ERROR;
        }
    }
    public String updateUsers(){
        try{
            Users temp = new Users(this.getIdUsers());
            temp.setPseudo(pseudo);
            temp.setNom(nom);
            temp.setPrenom(prenom);
            temp.setPhone(phone);
            temp.setAdresse(adresse);
            if(!Test.argmumentNull(mdp)){
                if(mdp.compareTo(this.confirmation)!=0) throw new Exception("les mots de passe sont différents");
                temp.setMdp(Cryptage.crypterHashage(mdp));
            }
            this.serviceUsers.update(temp);
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
        Users e = new Users();
        try {
            this.titre = "Users | Nouveau utilisateurs";
            e.setNom(nom);
            e.setPrenom(prenom);
            e.setAdresse(adresse);
            e.setPhone(phone);
            e.setPseudo(pseudo);
            e.setMdp(Cryptage.crypterHashage(mdp));
            
            if(this.mdp.compareTo(confirmation)!=0)throw new Exception("Les mots de passe sont differents");
            
            this.serviceUsers.save(e);
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
    
    public String historiqueuser(){
        this.titre="Historiques Utilisateur";
        return Action.SUCCESS;
    }
    
    public String modifuser(){
        this.titre="Modifier Utilisateur";
        return Action.SUCCESS;
    }
    
    public String deluser(){
        this.titre="Utilisateurs";
        return Action.SUCCESS;
    }
}
