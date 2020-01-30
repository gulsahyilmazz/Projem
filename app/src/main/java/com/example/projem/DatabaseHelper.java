package com.example.projem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "Giris.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(kullaniciadi text primary key, sifre text not null, " +
                "ad text not null, soyad text not null, yas text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }
    //insert
    public boolean insert (String kullaniciadi, String sifre, String ad, String soyad, String yas){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("kullaniciadi", kullaniciadi);
        contentValues.put("sifre", sifre);
        contentValues.put("ad", ad);
        contentValues.put("soyad", soyad);
        contentValues.put("yas", yas);
        long ins=db.insert("user", null, contentValues);
        if(ins==-1) return false;
        else return true;
    }
    public boolean chkkullaniciadi(String kullaniciaidi){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where kullaniciadi=?", new String [] {kullaniciaidi});
        if(cursor.getCount()>0) return false;
        else return true;
    }
    //şifre ve kullanıcı adı kontrol
    public Boolean kullaniciadisifre(String kullaniciadi, String sifre) {
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("select * from user where kullaniciadi=? and sifre =?", new String[] {kullaniciadi, sifre});
        if(cursor.getCount()>0) return true;
        else return false;
    }
}
