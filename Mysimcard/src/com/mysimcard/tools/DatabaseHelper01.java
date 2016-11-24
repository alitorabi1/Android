package com.mysimcard.tools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHelper01 extends SQLiteOpenHelper{
	private static final String DATABASE_NAME = "dbsim";	
	private static final String TABLE_NAME    = "contacts_sim";
	private static final String COLUMN_ID     = "_id";
	private static final String COLUMN_CODE   = "code";
	private static final String COLUMN_NAME   = "name";
	private static final String COLUMN_MATN   = "matn";
	private static final String COLUMN_NO  = "no";
	
	String CREATE_TABLE = "create table if not exists " +
	        TABLE_NAME + " ("+ COLUMN_ID + " integer primary key autoincrement,"

	                    + COLUMN_CODE + " text not null,"
	                    + COLUMN_NAME + " text not null,"
	                    + COLUMN_MATN + " text not null,"
	                    + COLUMN_NO + " text not null);";
	
	
	public DatabaseHelper01(Context context) {
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
