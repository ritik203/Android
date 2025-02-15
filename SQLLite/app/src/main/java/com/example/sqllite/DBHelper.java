package com.example.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static  final String Database_Name="ContactDB";
    public static  final int  Database_Id= 1;
    public static  final String Table_Name="Contact";
    public static  final String Key_id="id";

    public static  final String Key_Name= "Name";
    public static  final String Key_Phone= "Phone";



    public DBHelper( Context context) {
        super(context,Database_Name, null, Database_Id);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL("CREATE TABLE"+Table_Name+
             "("+Key_id+"INTEGER PRIMARY KEY AUTOINCREMENT,"+
             Key_Name+"TEXT,"+
             Key_Phone+"TEXT"+")" );

     SQLiteDatabase database=this.getWritableDatabase();
     database.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("DROP TABLE IF EXISTS"+Table_Name);
              onCreate(db);

    }

    public void addContact(String name,String phone){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Key_Name,name);
        values.put(Key_Phone,phone);
        db.insert(Table_Name,null,values);
    }
}
