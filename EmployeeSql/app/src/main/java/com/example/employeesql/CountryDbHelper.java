package com.example.employeesql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CountryDbHelper extends SQLiteOpenHelper {


    public CountryDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "dmc", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String sql="Create Table  country(id Integer primary key autoincrement,name Text)";
    db.execSQL(sql);
    }


    public long insertCountry(String name){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name);
        return db.insert("country",null,values);
    }


    public List<String> getAllCountries(){
        List<String> countries =new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.query("country",null,null,null,null,null,null);
while (cursor.moveToNext()){
    String name=cursor.getString(1);
    countries.add(name);
}
return countries;
    }
    public Cursor getAll(){
        SQLiteDatabase db=getReadableDatabase();
        return db.query("country",null,null,null,null,null,null);


    }





    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
