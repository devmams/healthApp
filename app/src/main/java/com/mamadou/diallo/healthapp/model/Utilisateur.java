package com.mamadou.diallo.healthapp.model;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.mamadou.diallo.healthapp.controller.LoginActivity;

import java.util.ArrayList;
import java.util.List;
public class Utilisateur extends AppCompatActivity {

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

    /**
     *
     * @return la liste de tous les  utilisateurs
     */
    public List<Utilisateur>getAllUser(Context context){
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