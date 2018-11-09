package com.example.mohrisalem.eventmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Date;

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
        db.execSQL( strSql );
        Log.i( "DATABASE", "onCreate invoker");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //String strSql = "alter table T_event add column ...";
        String strSql = "drop table T_event";
        db.execSQL( strSql );
        this.onCreate( db );
        Log.i( "DATABASE", "onUpgrade invoker");
    }

    public void insertEvent( String name, String event){
        name = name.replace("'", "''");
        String strSql = "insert into T_event (name, event, when_) values('"
                      + name + "', " + event + "," + new Date().getTime() + ")";
        
    }

}