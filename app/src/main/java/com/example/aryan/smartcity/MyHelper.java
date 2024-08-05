package com.example.aryan.smartcity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {

    public MyHelper(Context PageName, String DatabaseName, SQLiteDatabase.CursorFactory PageCursor, int DBVersion) {
        super(PageName, DatabaseName, PageCursor, DBVersion);
    }

    @Override public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Userdata ( StName VARCHAR,Reg VARCHAR,Email VARCHAR,Phone VARCHAR,Pswd VARCHAR);");
    }


    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Userdata");
        onCreate(db);
    }
}
