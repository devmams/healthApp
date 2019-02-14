package com.mamadou.diallo.healthapp.model;

import android.content.Context;

import java.util.List;

public class Specialite {

    private int idSpecialite;
    private String libelleSpecialite;

    public Specialite(String libelleSpecialite) {
        this.libelleSpecialite = libelleSpecialite;
    }

    public Specialite(int idSpecialite, String libelleSpecialite) {
        this.idSpecialite = idSpecialite;
        this.libelleSpecialite = libelleSpecialite;
    }

    public String getLibelleSpecialite() {
        return libelleSpecialite;
    }

    public int getIdSpecialite() {
        return idSpecialite;
    }


    public boolean addSpecialite(Context context){
        SpecialiteHelper specialiteHelper =  new SpecialiteHelper(context);
        specialiteHelper.addSpecialite(this);
        return true;
    }

    public List<Specialite> getAll(Context context){
         SpecialiteHelper specialiteHelper =  new SpecialiteHelper(context);
         return   null;//specialiteHelper.getAllSpecialite();
    }
}
