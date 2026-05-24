package com.example.nauka;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Asystent extends SQLiteOpenHelper {
    public Asystent(@Nullable Context context) {
        super(context, "notes", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("\n" +
                "Create table notes(\n" +
                "\tid integer primary key autoincrement,\n" +
                "\ttitle text,\n" +
                "\tcontent text,\n" +
                "\tcategory text,\n" +
                "\timportant integer,\n" +
                "\tcreated_at text\n" +
                ");\n");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void dodaj(String tytul){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("title",tytul);
        db.insertOrThrow("notes", null ,contentValues);
    }
    public Cursor wypiszCalosc(){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * from notes",null);
    }
}
