package com.example.bazydanych;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Asystent extends SQLiteOpenHelper {

    public Asystent(Context context) {
        super(context, "szkola.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE UCZEN (id INTEGER PRIMARY KEY AUTOINCREMENT,"+"IMIE text,"+"NAZWISKO text,"+"KLASA text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void dodaj(String imie, String nazwisko, String klasa){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dane = new ContentValues();
        dane.put("imie",imie);
        dane.put("nazwisko",nazwisko);
        dane.put("klasa",klasa);
        db.insertOrThrow("UCZEN",null,dane);
    }
    public Cursor wypiszCalosc(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from UCZEN",null);
        return cursor;
    }
    public int policz(){
        SQLiteDatabase db = getReadableDatabase();
        String licznik = "SELECT count(*) FROM UCZEN";
        Cursor k2 = db.rawQuery(licznik,null);
        k2.moveToFirst();
        int ilosc =k2.getInt(0);
        return ilosc;
    }
}
