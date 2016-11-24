package com.example.ipd.androidsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseWrapper extends SQLiteOpenHelper {

//  Database fields
    public static final String MESSAGE = "Message";
    public static final String Message_ID = "_id";
    public static final String Message_NAME = "_name";

//  Naming database and defining its version
    private static final String DATABASE_NAME = "Message.db";
    private static final int DATABASE_VERSION = 1;

//  make a query to grab data
    private static final String DATABASE_CREATE = "create table " + MESSAGE
            + "(" + Message_ID + " integer primary key autoincrement, "
            + Message_NAME + " text not null);";

    public DataBaseWrapper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL("DROP TABLE IF EXISTS " + MESSAGE);
        onCreate(db);
    }

}