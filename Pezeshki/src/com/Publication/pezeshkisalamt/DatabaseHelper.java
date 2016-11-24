package com.Publication.pezeshkisalamt;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHelper extends SQLiteOpenHelper{
	private static final String DATABASE_NAME = "dbsim";	
	private static final String TABLE_NAME    = "contacts_sim";
	private static final String COLUMN_ID     = "_id";
	private static final String COLUMN_NAME   = "name";
	private static final String CREATE_TABLE  = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +COLUMN_NAME + " TEXT" +");";
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE);
	}
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("Drop table if exists " + TABLE_NAME);
		onCreate(db);
	}
	public String getTableName() {
		return TABLE_NAME;
	}
	public String getRowIdName() {
		return COLUMN_ID;
	}
}
