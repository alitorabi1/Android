package com.mysimcard.tools;

import java.util.ArrayList;
import java.util.List;



import android.R.string;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseHandler01 {
	static final  String NAME    = "name";
	static final  String CODE    = "code";
	static final  String MATN    = "matn";
	static final  String NO   = "no";
	private DatabaseHelper01 dbHelper;
	private SQLiteDatabase database;
	public DatabaseHandler01(Context context){
		dbHelper = new DatabaseHelper01(context);
	}
	public void open() throws SQLException{
		database=dbHelper.getWritableDatabase();
	}
	public void close(){
		dbHelper.close();
	}
	public void insertContact(String code,String name, String matn,String no){
		ContentValues cv = new ContentValues();
		cv.put(CODE, code);
		cv.put(NAME, name);
		cv.put(MATN, matn);
		cv.put(NO, no);
		database.insert(dbHelper.getTableName(),null, cv);	
	}
	public void update_code(int id,String code) {
		ContentValues cv = new ContentValues();	
		cv.put(CODE,  code);
		database.update(dbHelper.getTableName(), cv, dbHelper.getRowIdName() + "=" + id, null);
	}
	
	public void update_name(int id,String name) {
		ContentValues cv = new ContentValues();	
		cv.put(NAME,  name);
		database.update(dbHelper.getTableName(), cv, dbHelper.getRowIdName() + "=" + id, null);
	}
	public void update_matn(int id,String matn) {
		ContentValues cv = new ContentValues();	
		cv.put(MATN,  matn);
		database.update(dbHelper.getTableName(), cv, dbHelper.getRowIdName() + "=" + id, null);
	}
	public void update_no(int id,String no) {
		ContentValues cv = new ContentValues();	
		cv.put(NO,  no);
		database.update(dbHelper.getTableName(), cv, dbHelper.getRowIdName() + "=" + id, null);
	}
	
	
	public String Display_Code(int id){
		Cursor cursor = database.query(dbHelper.getTableName(),new String[] {"code","name","matn","no"}, null, null, null, null, null);
		Contact01 contact = new Contact01();
		cursor.moveToPosition(id);
		contact.setName(cursor.getString(0));
		cursor.close();
		return contact.getName();

	}
	
	
	public String Display_Name(int id){
		Cursor cursor = database.query(dbHelper.getTableName(),new String[] {"code","name","matn","no"}, null, null, null, null, null);
		Contact01 contact = new Contact01();
		cursor.moveToPosition(id);
		contact.setName(cursor.getString(1));
		cursor.close();
		return contact.getName();
	}
	
	
	public String Display_Matn(int id){
		Cursor cursor = database.query(dbHelper.getTableName(),new String[] {"code","name","matn","no"}, null, null, null, null, null);
		Contact01 contact = new Contact01();
		cursor.moveToPosition(id);
		contact.setName(cursor.getString(2));
		cursor.close();
		return contact.getName();
	}
	
	public String Display_No(int id){
		Cursor cursor = database.query(dbHelper.getTableName(),new String[] {"code","name","matn","no"}, null, null, null, null, null);
		Contact01 contact = new Contact01();
		cursor.moveToPosition(id);
		contact.setName(cursor.getString(3));
		cursor.close();
		return contact.getName();

	}
	
	public Integer count(){
		Cursor cursor = database.query(dbHelper.getTableName(),	null, null, null, null, null, null);
		Contact01 contact = new Contact01();
		contact.setcounti(cursor.getCount());
		return contact.getcounti();
	}
	public List<Contact01> getAllContacts() {
		List<Contact01> contacts = new ArrayList<Contact01>();
		Cursor cursor = database.query(dbHelper.getTableName(),	null, null, null, null, null, null);
	    Contact01 contact = new Contact01();
	    cursor.moveToLast();
		cursor.close();
		return contacts;
	}
	 Contact01 cursorToContact(Cursor cursor) {
	Contact01 contact = new Contact01();	
	contact.setId(cursor.getLong(0));
	contact.setName(cursor.getString(1));	
		return contact;
	}
}
