package com.mamadou.diallo.healthapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DisponibiliteHelper  extends SQLiteOpenHelper {

    private static Connexion connexion =  new Connexion();

    private static final String TABLE_NAME = "disponibilite";

    private static final String KEY_ID = "id";
    private static final String KEY_DATE = "date";
    private static final String KEY_UTILISATEUR = "utilisateur";
    private static final String KEY_MEDECIN = "medecin";

    public DisponibiliteHelper(Context context){

        super(context, connexion.getDatabaseName(), null, connexion.getVersion());
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_DISPONIBILITE="CREATE TABLE "+TABLE_NAME+" ("
                + KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_DATE +" INTEGER , "
                + KEY_MEDECIN +" INTEGER , "
                + KEY_UTILISATEUR +" INTEGER )"  ;

        db.execSQL(CREATE_TABLE_DISPONIBILITE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean ajouterDisponibilite(Date date, int medecin){

        SQLiteDatabase db = this.getWritableDatabase();
       // onCreate(db);
        ContentValues content = new ContentValues();
        content.put(KEY_DATE,date.getTime() );
        content.put(KEY_UTILISATEUR, 0);
        content.put(KEY_MEDECIN,medecin);
        db.insert(TABLE_NAME, null,content );
        return true;
    }




    public boolean prendreRendezVous( int disponibilite, int utilisateur){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content= new ContentValues();
        //content.put(KEY_ID,0);
        content.put(KEY_UTILISATEUR,utilisateur);
        db.update(TABLE_NAME , content , KEY_ID +" =? ",new String[]{String.valueOf(disponibilite)});
        return true;
    }



    /**
     * @return liste de toutes les disponibilité
     */
    public List<Disponibilite> getAllDisponibilite(){
        List<Disponibilite> listDisponibilite = new ArrayList<Disponibilite>();
        String query = "SELECT * from "+TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do {
                Date date = new Date();
                Disponibilite disponibilite = new Disponibilite(cursor.getInt(0),new Date(new Long(cursor.getString(1))),Medecin.getMedecin(cursor.getInt(2)),new Utilisateur(cursor.getInt(3)));
                listDisponibilite.add(disponibilite);

            }while (cursor.moveToNext());
        }
        return listDisponibilite;
    }



    /**
     * @return liste de toutes les disponibilité d'un medecin
     */
    public List<Disponibilite> getMedecinDisponibilite(int medecin){
        List<Disponibilite> listDisponibilite = new ArrayList<Disponibilite>();
        String query = "SELECT * from "+TABLE_NAME+" where "+KEY_MEDECIN+"="+medecin+" and "+KEY_DATE+">"+(new Date()).getTime()+" and  "+KEY_UTILISATEUR +"=0";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do {
                Date date = new Date();
                Disponibilite disponibilite = new Disponibilite(cursor.getInt(0),new Date(new Long(cursor.getString(1))),Medecin.getMedecin(cursor.getInt(2)),new Utilisateur(cursor.getInt(3)));
                listDisponibilite.add(disponibilite);

            }while (cursor.moveToNext());
        }
        return listDisponibilite;
    }


    /**
     * @return liste de toutes les disponibilité d'un utilisateur
     */
    public List<Disponibilite> getPreviousUserDisponibilite(int utilisateur){
        List<Disponibilite> listDisponibilite = new ArrayList<Disponibilite>();
        String query = "SELECT * from "+TABLE_NAME+" where "+KEY_UTILISATEUR+"="+utilisateur+" and "+KEY_DATE+"<"+(new Date()).getTime();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do {
                Date date = new Date();
                Disponibilite disponibilite = new Disponibilite(cursor.getInt(0),new Date(new Long(cursor.getString(1))),Medecin.getMedecin(cursor.getInt(2)),new Utilisateur(cursor.getInt(3)));
                listDisponibilite.add(disponibilite);

            }while (cursor.moveToNext());
        }
        return listDisponibilite;
    }

    /**
     * @return liste de toutes les disponibilité d'un utilisateur
     */
    public List<Disponibilite> getNextUserDisponibilite(int utilisateur){
        List<Disponibilite> listDisponibilite = new ArrayList<Disponibilite>();
        String query = "SELECT * from "+TABLE_NAME+" where "+KEY_UTILISATEUR+"="+utilisateur+" and "+KEY_DATE+">= "+(new Date()).getTime();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do {
                Date date = new Date();
                Disponibilite disponibilite = new Disponibilite(cursor.getInt(0),new Date(new Long(cursor.getString(1))),Medecin.getMedecin(cursor.getInt(2)),new Utilisateur(cursor.getInt(3)));
                listDisponibilite.add(disponibilite);

            }while (cursor.moveToNext());
        }
        return listDisponibilite;
    }







}
