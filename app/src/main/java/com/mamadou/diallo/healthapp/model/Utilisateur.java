package com.mamadou.diallo.healthapp.model;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.mamadou.diallo.healthapp.controller.LoginActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Utilisateur extends AppCompatActivity implements Serializable {

    // private UtilisateurHelper userHelper= new UtilisateurHelper();
    int id;
    String nom;
    String prenom;
    String adresseMail;
    String password;



    public Utilisateur(String nom,String prenom, String adresseMail, String pass) {
        this.nom=nom;
        this.prenom=prenom;
        this.adresseMail=adresseMail;
        this.password =  pass;
    }



    public Utilisateur(String adresseMail, String password) {
        this.adresseMail = adresseMail;
        this.password = password;
    }


    public Utilisateur(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }


    public Utilisateur(int id) {
        this.id = id;
    }

    /**
     *
     * @return la liste de tous les  utilisateurs
     */
    public static List<Utilisateur>getAllUser(Context context){
        UtilisateurHelper userHelper= new UtilisateurHelper(context);
        return  userHelper.getAllUser();
    }

    /**
     * permet de connecter l'utilisateur
     * @return
     */
    public Utilisateur login(Context context){
        UtilisateurHelper userHelper= new UtilisateurHelper(context);
        return userHelper.getUser(this.getAdresseMail(),this.getPassword());
    }

    /**
     * permet d'ajouter un nouvel utilisateur
     * @return
     */
    public boolean add(Context context){
        UtilisateurHelper userHelper= new UtilisateurHelper(context);
        return userHelper.addUtilisateur(this);
    }

    /**
     * permet de modifier un utilisateur
     * @return
     */
    public boolean update(Context context){
        UtilisateurHelper userHelper= new UtilisateurHelper(context);
        return userHelper.updateUtilisateur(this);
    }


    public static void annulerRdv(Context context, int idDispo){
        DisponibiliteHelper disponibiliteHelper = new DisponibiliteHelper(context);
        disponibiliteHelper.annulerRendezVous(idDispo);
    }





//    public List<Disponibilite> getNextVisit(){
//        DisponibiliteHelper disponibiliteHelper = new DisponibiliteHelper(getApplicationContext());
//        return disponibiliteHelper.getNextUserDisponibilite(LoginActivity.getUserConnecter().getId());
//    }




    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public String getAdresseMail() {
        return adresseMail;
    }

    public String getPassword() {
        return password;
    }


}