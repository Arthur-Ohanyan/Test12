package com.example.arthur.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "XANUTNER";
    public static final String TABLE_NAME = "SAS";

    public static final String KEY_ID = "_id";
    public static final String KEY_MACUN = "macun";
    public static final String KEY_KAT = "kat";
    public static final String KEY_TTVASER = "ttvaser";
    public static final String KEY_AMSATIV = "amsativ";


    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(" + KEY_ID
                + " integer primary key," + KEY_MACUN + " text," + KEY_AMSATIV +"integer," + KEY_KAT + "text," + KEY_TTVASER + " text" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);

    }
}