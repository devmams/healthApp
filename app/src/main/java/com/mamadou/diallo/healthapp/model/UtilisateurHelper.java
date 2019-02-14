package com.mamadou.diallo.healthapp.model;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurHelper extends SQLiteOpenHelper {

    private static Connexion connexion =  new Connexion();

    private static final String TABLE_NAME = "utilisateur";
    private static final String KEY_ID = "id";
    private static final String KEY_NOM = "nom";
    private static final String KEY_PRENOM = "prenom";
    private static final String KEY_ADRESSE_MAIL = "adresseMail";
    private static final String KEY_PASSWORD = "password";

    public UtilisateurHelper(Context context){

        super(context, connexion.getDatabaseName(), null, connexion.getVersion());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_UTILISATEUR="CREATE TABLE "+TABLE_NAME+" ("
                + KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NOM +" TEXT , "
                + KEY_PRENOM +" TEXT , "
                + KEY_ADRESSE_MAIL  +" TEXT , "
                + KEY_PASSWORD  +" TEXT )"  ;

        db.execSQL(CREATE_TABLE_UTILISATEUR);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    /**
     *
     * @param utilisateur
     */
    boolean addUtilisateur(Utilisateur utilisateur){

        if( getUser(utilisateur.getAdresseMail(), utilisateur.getPassword()) !=null)
            return false;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        //content.put(KEY_ID,utilisateur.getId() );
        content.put(KEY_NOM,utilisateur.getNom() );
        content.put(KEY_PRENOM,utilisateur.getPrenom() );
        content.put(KEY_ADRESSE_MAIL,utilisateur.getAdresseMail() );
        content.put(KEY_PASSWORD,utilisateur.getPassword() );
        db.insert(TABLE_NAME, null,content );
        db.close();
        return true;
    }

    Utilisateur getUser(String addresse, String pass){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{ KEY_ID, KEY_NOM, KEY_PRENOM,KEY_ADRESSE_MAIL},  KEY_ADRESSE_MAIL +" =? AND "+KEY_PASSWORD+" =?" ,new String[]{String.valueOf(addresse),pass},null,null,null,null);
        Utilisateur utilisateur=null;
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            utilisateur=  new Utilisateur(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(3)) ;

        }

        return utilisateur;
    }



    /**
     * @return liste de tous les utilisateurs de la base
     */
    List<Utilisateur> getAllUser(){

        List<Utilisateur> listUser = new ArrayList<>();
        String query = "SELECT * from "+TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do {
                Utilisateur utilisateur =  new Utilisateur(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(3)) ;
                listUser.add(utilisateur);
            }while (cursor.moveToNext());
        }
        return listUser;
    }

    /**
     *
     * @param utilisateur , l'objet user à modifier
     */
    boolean updateUtilisateur(Utilisateur utilisateur){
        if( getUser(utilisateur.getAdresseMail(), utilisateur.getPassword()) !=null)
            return false;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content= new ContentValues();
        content.put(KEY_ID,0);
        content.put(KEY_NOM,utilisateur.nom );
        content.put(KEY_PRENOM,utilisateur.prenom );
        content.put(KEY_ADRESSE_MAIL,utilisateur.adresseMail );
        content.put(KEY_PASSWORD,utilisateur.password );
        db.update(TABLE_NAME , content , KEY_ID +" =? ",new String[]{String.valueOf(utilisateur.getId())});
        return true;
    }

    void delete(Utilisateur utilisateur){
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_NAME,KEY_ID+"= ?",new String[]{String.valueOf(utilisateur.getId())});
        db.close();;

    }

}