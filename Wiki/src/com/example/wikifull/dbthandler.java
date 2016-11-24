package com.example.wikifull;
import java.util.ArrayList;
import java.util.List;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class dbthandler {
	static final  String NAME    = "name";
	private dbthelper dbHelper;
	private SQLiteDatabase database;
	public dbthandler(Context context){
		dbHelper = new dbthelper(context);
	}
	public void open() throws SQLException{
		database=dbHelper.getWritableDatabase();
	}
	public void close(){
		dbHelper.close();
	}
	public void insertContact(String name){
		ContentValues cv = new ContentValues();
		cv.put(NAME, name);
		database.insert(dbHelper.getTableName(), NAME, cv);	
	}
	public void updateContact(long id,String name) {
		ContentValues cv = new ContentValues();	
		cv.put(NAME,  name);
		database.update(dbHelper.getTableName(), cv, dbHelper.getRowIdName() + "=" + id, null);
	}
	public String Display(int id){
		Cursor cursor = database.query(dbHelper.getTableName(),	null, null, null, null, null, null);
		dbtcontact contact = new dbtcontact();
		cursor.moveToPosition(id);
		contact.setName(cursor.getString(1));
		cursor.close();
		return contact.getName();
	}
	public Integer count(){
		Cursor cursor = database.query(dbHelper.getTableName(),	null, null, null, null, null, null);
		dbtcontact contact = new dbtcontact();
		contact.setcounti(cursor.getCount());
		return contact.getcounti();
	}
	public List<dbtcontact> getAllContacts() {
		List<dbtcontact> contacts = new ArrayList<dbtcontact>();
		Cursor cursor = database.query(dbHelper.getTableName(),	null, null, null, null, null, null);
		dbtcontact contact = new dbtcontact();
	    cursor.moveToLast();
		cursor.close();
		return contacts;
	}
	dbtcontact cursorToContact(Cursor cursor) {
		 dbtcontact contact = new dbtcontact();	
	contact.setId(cursor.getLong(0));
	contact.setName(cursor.getString(1));	
		return contact;
	}
}
