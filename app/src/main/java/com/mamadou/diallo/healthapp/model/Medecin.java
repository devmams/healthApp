package com.mamadou.diallo.healthapp.model;

public class Medecin {


    int idMedecin;
    String nomMedecin;
    String prenomMedecin;
    Specialite specialiteMedecin;


    public Medecin(int idMedecin, String nomMedecin) {
        this.idMedecin = idMedecin;
        this.nomMedecin = nomMedecin;
    }

    public Medecin(String nomMedecin, String prenomMedecin, Specialite specialiteMedecin) {
        this.nomMedecin = nomMedecin;
        this.prenomMedecin = prenomMedecin;
        this.specialiteMedecin = specialiteMedecin;
    }

    public Medecin(int idMedecin, String nomMedecin, String prenomMedecin) {
        this.idMedecin = idMedecin;
        this.nomMedecin = nomMedecin;
        this.prenomMedecin = prenomMedecin;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public String getPrenomMedecin() {
        return prenomMedecin;
    }

    public Specialite getSpecialiteMedecin() {
        return specialiteMedecin;
    }
}
