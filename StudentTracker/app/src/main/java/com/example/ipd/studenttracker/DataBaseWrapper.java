package com.example.ipd.studenttracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseWrapper extends SQLiteOpenHelper {

    //  Naming database and defining its version
    private static final String DATABASE_NAME = "Message.db";
    private static final int DATABASE_VERSION = 1;

    //  Table and Database fields
    public static final String MESSAGE = "Message";
    public static final String MESSAGE_ID = "id";
    public static final String MESSAGE_NAME = "name";
    public static final String MESSAGE_URL = "url";

    //  make a query to grab data
    private static final String DATABASE_CREATE = "create table " + MESSAGE
            + "(" + MESSAGE_ID + " integer primary key autoincrement, "
            + MESSAGE_NAME + " varchar not null), "
            + MESSAGE_URL + " varchar not null);";

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
