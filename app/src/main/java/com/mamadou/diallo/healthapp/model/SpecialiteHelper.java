package com.mamadou.diallo.healthapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class SpecialiteHelper extends SQLiteOpenHelper {


    private static Connexion connexion =  new Connexion();

    private static final String TABLE_NAME = "specialite";
    private static final String KEY_ID = "idSpecialite";
    private static final String KEY_LIBELLE = "libelleSpecialite";

    public SpecialiteHelper(Context context){
        super(context, connexion.getDatabaseName(), null, connexion.getVersion());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_SPECIALITE="CREATE TABLE "+TABLE_NAME+" ("
                + KEY_ID +" INTEGER PRIMARY KE AUTOINCREMENT,"
                + KEY_LIBELLE +" TEXT ) ";
        db.execSQL(CREATE_TABLE_SPECIALITE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addSpecialite(Specialite specialite ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(KEY_LIBELLE,specialite.getLibelleSpecialite() );
        db.insert(TABLE_NAME, null,content );
        db.close();
    }

    Specialite getSpecialite(int id){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{ KEY_ID, KEY_LIBELLE, }, KEY_ID +" =?",new String[]{String.valueOf(id)},null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return new Specialite(Integer.parseInt(cursor.getString(0)),cursor.getString(1));
    }

    /**
     * @return liste de toutes les specialité de la base
     */
    public List<Specialite> getAllSpecialite(){
        List<Specialite> listUser = new ArrayList<Specialite>();
        String query = "SELECT * from "+TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do {
                Specialite specialite= new Specialite(Integer.parseInt(cursor.getString(0)),cursor.getString(1));
                listUser.add(specialite);
            }while (cursor.moveToNext());
        }
        return listUser;
    }


    /**
     *
     * @param specialite , l'objet user à modifier
     */
    public int updateUtilisateur(Specialite specialite){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content= new ContentValues();
        content.put(KEY_ID,0 );
        content.put(KEY_LIBELLE,specialite.getLibelleSpecialite() );

        return db.update(TABLE_NAME , content , KEY_ID +" =? ",new String[]{String.valueOf(specialite.getIdSpecialite())});
    }

    public void delete(Specialite specialite){
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_NAME,KEY_ID+"= ?",new String[]{String.valueOf(specialite.getIdSpecialite())});
        db.close();;

    }

}
