package com.example.mohrisalem.eventmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Game.db" ;
    private static final int DATABASE_VERSION = 1 ;

    public DatabaseManager ( Context context ){
        super( context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSql = "create table T_event ("
                      + "   idEvent integer primary key autoincrement,"
                      + "   name text not null,"
                      + "   event string not null,"
                      + "   when_ integer not null"
                      + ")";

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}