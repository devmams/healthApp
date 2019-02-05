package com.mamadou.diallo.healthapp.model;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 6;

    private static final String DATABASE_NAME = "rendezVous";

    private static final String TABLE_NAME = "utilisateur";
    private static final String KEY_ID = "id";
    private static final String KEY_NOM = "nom";
    private static final String KEY_PRENOM = "prenom";
    private static final String KEY_CODE_POSTAL = "codePostal";
    private static final String KEY_ADRESSE_MAIL = "adresseMail";
    private static final String KEY_TELEPHONE = "telephone";
    private static final String KEY_CARTE_VITALE = "carteVitale";
    private static final String KEY_ADRESSEPOSTALE = "adressePostale";
    private static final String KEY_PASSWORD = "password";

    public UtilisateurHelper(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_UTILISATEUR="CREATE TABLE "+TABLE_NAME+" ("
                + KEY_ID +" INTEGER PRIMARY KEY ,"
                + KEY_NOM +" TEXT , "
                + KEY_PRENOM +" TEXT , "
                + KEY_CODE_POSTAL +" TEXT , "
                + KEY_ADRESSE_MAIL  +" TEXT , "
                + KEY_TELEPHONE  +" TEXT , "
                + KEY_CARTE_VITALE  +" TEXT , "
                + KEY_ADRESSEPOSTALE  +" TEXT , "
                + KEY_PASSWORD  +" TEXT )"  ;
        System.out.println(CREATE_TABLE_UTILISATEUR);
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
    void addUtilisateur(Utilisateur utilisateur){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(KEY_ID,utilisateur.getId() );
        content.put(KEY_NOM,utilisateur.getNom() );
        content.put(KEY_PRENOM,utilisateur.getPrenom() );
        content.put(KEY_CODE_POSTAL,utilisateur.getCodePostal() );
        content.put(KEY_ADRESSE_MAIL,utilisateur.getAdresseMail() );
        content.put(KEY_TELEPHONE,utilisateur.getTelephone() );
        content.put(KEY_CARTE_VITALE,utilisateur.getNumero_carte_vitale() );
        content.put(KEY_ADRESSEPOSTALE,utilisateur.getAdressePostal() );
        content.put(KEY_PASSWORD,utilisateur.getPassword() );

        db.insert(TABLE_NAME, null,content );
        db.close();
    }

    Utilisateur getUser(String addresse, String pass){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{ KEY_ID, KEY_NOM, KEY_PRENOM, KEY_CODE_POSTAL,KEY_ADRESSE_MAIL, KEY_TELEPHONE,KEY_CARTE_VITALE},  KEY_ADRESSE_MAIL +" =? AND "+KEY_PASSWORD+" =?" ,new String[]{String.valueOf(addresse),pass},null,null,null,null);
        Utilisateur utilisateur=null;
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            utilisateur=  new Utilisateur(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),Integer.parseInt(cursor.getString(3)), cursor.getString(4), cursor.getString(5),   cursor.getString(6)) ;

        }

        return utilisateur;
    }

    /**
     * @return liste de tous les utilisateurs de la base
     */
    public List<Utilisateur> getAllUser(){

        List<Utilisateur> listUser = new ArrayList<>();
        String query = "SELECT * from "+TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do {
                Utilisateur utilisateur =  new Utilisateur(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),Integer.parseInt(cursor.getString(3)), cursor.getString(4), cursor.getString(5),   cursor.getString(6),cursor.getString(7)) ;
                listUser.add(utilisateur);
            }while (cursor.moveToNext());
        }
        return listUser;
    }


    /**
     *
     * @param utilisateur , l'objet user à modifier
     */
    public int updateUtilisateur(Utilisateur utilisateur){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content= new ContentValues();
        content.put(KEY_ID,0 );
        content.put(KEY_NOM,utilisateur.nom );
        content.put(KEY_PRENOM,utilisateur.prenom );
        content.put(KEY_CODE_POSTAL,utilisateur.codePostal );
        content.put(KEY_ADRESSE_MAIL,utilisateur.adresseMail );
        content.put(KEY_TELEPHONE,utilisateur.telephone );
        content.put(KEY_CARTE_VITALE,utilisateur.numero_carte_vitale);
        content.put(KEY_ADRESSEPOSTALE,utilisateur.adressePostal );
        content.put(KEY_PASSWORD,utilisateur.password );
        return db.update(TABLE_NAME , content , KEY_ID +" =? ",new String[]{String.valueOf(utilisateur.getId())});
    }

    public void delete(Utilisateur utilisateur){
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_NAME,KEY_ID+"= ?",new String[]{String.valueOf(utilisateur.getId())});
        db.close();;

    }

}
