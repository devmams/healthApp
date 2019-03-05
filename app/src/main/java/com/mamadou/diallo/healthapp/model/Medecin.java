package com.mamadou.diallo.healthapp.model;

import java.util.ArrayList;
import java.util.List;

public class Medecin {


    int idMedecin;
    String nomMedecin;
    String prenomMedecin;
    Specialite specialiteMedecin;

    private static  List<Medecin> medecins =new ArrayList<Medecin>();


    public Medecin(int idMedecin, String nomMedecin) {
        this.idMedecin = idMedecin;
        this.nomMedecin = nomMedecin;
    }

    public Medecin(int idMedecin,String nomMedecin, String prenomMedecin, Specialite specialiteMedecin) {
        this.idMedecin=idMedecin;
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


    public static List<Medecin> getAllMedecin(){
        // List<Medecin> medecins =  new ArrayList<Medecin>();
        medecins.add(new Medecin(1,"ADAMS","Gerard",Specialite.getSpecialite(1)) );
        medecins.add(new Medecin(2,"Stephanie","ROSE",Specialite.getSpecialite(2)) );
        medecins.add(new Medecin(3,"Ange","DREY",Specialite.getSpecialite(2)) );

        return medecins;

    }

    public static Medecin getMedecin(int idMedecin){
        getAllMedecin();
        for(Medecin medecin :  medecins){
            if(medecin.idMedecin==idMedecin)
                return medecin;
        }
        return null;

    }





}