package com.mamadou.diallo.healthapp.model;

import java.util.Date;

public class Disponibilite {

    private int id;
    private Date date;
    private Medecin medecin;
    private Utilisateur utilisateur;
    private int etat;

    public Disponibilite(Date date, Medecin medecin) {
        this.date = date;
        this.medecin = medecin;
    }


    public Disponibilite(int id, Date date, Medecin medecin) {
        this.id = id;
        this.date = date;
        this.medecin = medecin;
    }


    public Disponibilite(int id, Date date, Medecin medecin, Utilisateur utilisateur) {
        this.id = id;
        this.date = date;
        this.medecin = medecin;
        this.utilisateur = utilisateur;
    }

    public Date getDate() {
        return date;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Medecin getMedecin() {
        return medecin;
    }
}
