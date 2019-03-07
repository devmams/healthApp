package com.mamadou.diallo.healthapp.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Specialite {

    private int idSpecialite;
    private String libelleSpecialite;
    private static  List<Specialite> listeSpecialites=new ArrayList<Specialite>();


    public Specialite(String libelleSpecialite) {
        this.libelleSpecialite = libelleSpecialite;
    }

    public Specialite(int idSpecialite, String libelleSpecialite) {
        this.idSpecialite = idSpecialite;
        this.libelleSpecialite = libelleSpecialite;
    }


    public static List<Specialite> getAllSpecialite(){
        listeSpecialites.add(new Specialite(1,"Chirurgie")) ;
        listeSpecialites.add(new Specialite(2,"Medecine Generale")) ;
        listeSpecialites.add(new Specialite(3,"Ophtalmologie")) ;

        return listeSpecialites;

    }


    public String getLibelleSpecialite() {
        return libelleSpecialite;
    }


    public boolean addSpecialite(Context context){
        SpecialiteHelper specialiteHelper =  new SpecialiteHelper(context);
        specialiteHelper.addSpecialite(this);
        return true;
    }

    public List<Specialite> getAll(Context context){
        SpecialiteHelper specialiteHelper =  new SpecialiteHelper(context);
        return   null;
    }

    public  static Specialite getSpecialite( int idSpecialite){
        //getAllSpecialite();
        for(Specialite specialite :  listeSpecialites){

            if(specialite.idSpecialite ==idSpecialite ){

                return specialite;
            }
        }
        return null;
    }



}