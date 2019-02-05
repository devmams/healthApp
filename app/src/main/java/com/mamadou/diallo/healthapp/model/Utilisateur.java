package com.mamadou.diallo.healthapp.model;

public class Utilisateur {

    int id;

    String nom;

    String prenom;

    int codePostal;

    String adresseMail;

    String telephone;

    String numero_carte_vitale;

    String adressePostal;

    String password;

    public Utilisateur(int id,String nom, String prenom,  int codePostal, String adresseMail, String telephone,   String numero_carte_vitale,String adressePostal,String password ) {
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.codePostal=  codePostal;
        this.adresseMail=adresseMail;
        this.telephone=telephone;
        this.numero_carte_vitale=numero_carte_vitale;
        this.adressePostal=adressePostal;
        this.password =  password;
    }

    public Utilisateur(int id,String nom, String prenom, int codePostal, String adresseMail, String telephone,   String numero_carte_vitale,String adressePostal) {
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.adresseMail=adresseMail;
        this.telephone=telephone;
        this.numero_carte_vitale=numero_carte_vitale;
        this.adressePostal=adressePostal;
        this.codePostal=  codePostal;
    }


    public Utilisateur(int id,String nom, String adresseMail, String pass) {
        this.id=id;
        this.nom=nom;
        this.prenom="";
        this.adresseMail=adresseMail;
        this.telephone="";
        this.numero_carte_vitale="";
        this.adressePostal="";
        this.codePostal=  0;
        this.password =  pass;
    }


    public Utilisateur(int id, String nom, String prenom,int codePostal, String adresseMail, String password, String telephone ) {
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.codePostal=  codePostal;
        this.adresseMail=adresseMail;
        this.telephone=telephone;
        this.password =  password;
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

    public int getCodePostal() {
        return codePostal;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public String getNumero_carte_vitale() {
        return numero_carte_vitale;
    }

    public String getAdressePostal() {
        return adressePostal;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephone() {
        return telephone;
    }
}
