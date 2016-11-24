package com.mysimcard.tools;

import java.util.ArrayList;
import java.util.List;







import android.R.string;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseHandler {
	static final  String NAME    = "name";
	private DatabaseHelper dbHelper;
	private SQLiteDatabase database;
	public DatabaseHandler(Context context){
		dbHelper = new DatabaseHelper(context);
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
	public void updateContact(int id,String name) {
		ContentValues cv = new ContentValues();	
		cv.put(NAME,  name);
		database.update(dbHelper.getTableName(), cv, dbHelper.getRowIdName() + "=" + id, null);
	}
	public String Display(int id){
		Cursor cursor = database.query(dbHelper.getTableName(),	null, null, null, null, null, null);
		Contact contact = new Contact();
		cursor.moveToPosition(id);
		contact.setName(cursor.getString(1));
		cursor.close();
		return contact.getName();
	}
	public Integer count(){
		Cursor cursor = database.query(dbHelper.getTableName(),	null, null, null, null, null, null);
		Contact contact = new Contact();
		contact.setcounti(cursor.getCount());
		return contact.getcounti();
	}
	public List<Contact> getAllContacts() {
		List<Contact> contacts = new ArrayList<Contact>();
		Cursor cursor = database.query(dbHelper.getTableName(),	null, null, null, null, null, null);
	    Contact contact = new Contact();
	    cursor.moveToLast();
		cursor.close();
		return contacts;
	}
	 Contact cursorToContact(Cursor cursor) {
	Contact contact = new Contact();	
	contact.setId(cursor.getLong(0));
	contact.setName(cursor.getString(1));	
		return contact;
	}
}
