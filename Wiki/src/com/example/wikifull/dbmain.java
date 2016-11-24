package com.example.wikifull;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class dbmain extends SQLiteOpenHelper {

	//The Android's default system path of your application database.
    private static String DB_PATH = "/data/data/com.Reference.wikipdf/databases/";
    //private static String DB_PATH = "/poriyaaa/pooriya/com.Reference.wikipdf/poiitr/";
    private static String DB_NAME = "dbmain";
 
    private SQLiteDatabase myDataBase; 
 private Tools tools;
 static final  String NAME    = "rez";
 
    private final Context myContext;
 
    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public dbmain(Context context) {
 
    	super(context, DB_NAME, null, 1);
        this.myContext = context;
    }	
 
  /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDataBase() throws IOException{
    	//SQLiteDatabase db_read = null;
    	boolean dbExist = checkDataBase();
    	//String mPath = DB_PATH + DB_NAME;
    	//SQLiteDatabase db_read2 = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.OPEN_READONLY);
    	
    	tools=new Tools();
    	if(dbExist){
    		//do nothing - database already exist
    		
    	}else{
 
    		//By calling this method and empty database will be created into the default system path
               //of your application so we are gonna be able to overwrite that database with our database.
        	this.getReadableDatabase();
        	this.close();
    		//db_read2 = this.getReadableDatabase(); 
    		//db_read2.close();
        	try {
 
    			//copyDataBase();
 
        		tools.copyDataBase();
    		} catch (IOException e) {
 
        		throw new Error("Error copying database");
 
        	}
    	}
 
    }
 
    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase(){
 
    	SQLiteDatabase checkDB = null;
 
    	try{
    		String myPath = DB_PATH + DB_NAME;
    		checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
 
    	}catch(SQLiteException e){
 
    		//database does't exist yet.
 
    	}
 
    	if(checkDB != null){
 
    		checkDB.close();
 
    	}
 
    	return checkDB != null ? true : false;
    }
 
    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException{
 
    	//Open your local db as the input stream
    	InputStream myInput = myContext.getAssets().open(DB_NAME);
 
    	// Path to the just created empty db
    	String outFileName = DB_PATH + DB_NAME;
 
    	//Open the empty db as the output stream
    	OutputStream myOutput = new FileOutputStream(outFileName);
 
    	//transfer bytes from the inputfile to the outputfile
    	byte[] buffer = new byte[1024];
    	int length;
    	while ((length = myInput.read(buffer))>0){
    		myOutput.write(buffer, 0, length);
    	}
 
    	//Close the streams
    	myOutput.flush();
    	myOutput.close();
    	myInput.close();
 
    }
 
    public void open() throws SQLException{
 
    	//Open the database
        String myPath = DB_PATH + DB_NAME;
    	myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
 
    }
 
    @Override
	public synchronized void close() {
 
    	    if(myDataBase != null)
    		    myDataBase.close();
 
    	    super.close();
 
	}
 
	@Override
	public void onCreate(SQLiteDatabase db) {
 
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 
	}
 
        // Add your public helper methods to access and get content from the database.
       // You could return cursors by doing "return myDataBase.query(....)" so it'd be easy
       // to you to create adapters for your views.
	public List<dbcontact> getSearchContacts(String key) {
		List<dbcontact> contacts = new ArrayList<dbcontact>();
		//Cursor cursor = myDataBase.query("tablemain",	null, null, null, null, null, null);
		Cursor cursor = myDataBase.rawQuery("select * from tablemain where name='"+key+"'", null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			dbcontact contact = cursorToContact(cursor);
			contacts.add(contact);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return contacts;
		
	}
	public List<dbcontact> getcodeContacts(String code) {
		List<dbcontact> contacts = new ArrayList<dbcontact>();
		//int code2=Integer.parseInt(code.toString());
		//Cursor cursor = myDataBase.query("tablemain",	null, null, null, null, null, null);
		Cursor cursor = myDataBase.rawQuery("select * from tablemain where code='"+code+"'", null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			dbcontact contact = cursorToContact(cursor);
			contacts.add(contact);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return contacts;
	}
	public List<dbcontact> getAllContacts() {
		List<dbcontact> contacts = new ArrayList<dbcontact>();
		Cursor cursor = myDataBase.query("tablemain",	null, null, null, null, null, null);
		//Cursor cursor = myDataBase.rawQuery("select * from tablemain where code='"+code+"'", null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			dbcontact contact = cursorToContact(cursor);
			contacts.add(contact);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return contacts;
	}
	
	public void insertContact(String name,String mode,String link,String code,String swlast,String matn,String rez){
		ContentValues cv = new ContentValues();
		cv.put("name", name);
		cv.put("mode", mode);
		cv.put("link", link);
		cv.put("code", code);
		cv.put("swlast", swlast);
		cv.put("matn", matn);
		cv.put("rez", rez);
		myDataBase.insert("tablemain", null, cv);	
	
	}
	
	public String Display(int id){
		Cursor cursor =  myDataBase.query("tablemain",	null, null, null, null, null, null);
		dbcontact contact = new dbcontact();
		cursor.moveToPosition(id);
		contact.setname(cursor.getString(1));
		cursor.close();
		return contact.getname();
	}
	public String Display_link(int id){
		Cursor cursor =  myDataBase.query("tablemain",	null, null, null, null, null, null);
		dbcontact contact = new dbcontact();
		cursor.moveToPosition(id);
		contact.setname(cursor.getString(3));
		cursor.close();
		return contact.getname();
	}
	public String Display_codeup(int id){
		Cursor cursor =  myDataBase.query("codeup",	null, null, null, null, null, null);
		dbcontact contact = new dbcontact();
		cursor.moveToPosition(id);
		contact.setname(cursor.getString(0));
		cursor.close();
		return contact.getname();
	}
	
	public void updateContact(int id,String rez) {
		ContentValues cv = new ContentValues();	
		cv.put("rez",  rez);
		myDataBase.update("tablemain", cv, "id=" + id, null);
	}
	
	public void updateContactlastcode(int id,String rez) {
		ContentValues cv = new ContentValues();	
		cv.put("link",  rez);
		myDataBase.update("tablemain", cv, "id=" + id, null);
	}
	
	
	
	
	dbcontact cursorToContact(Cursor cursor) {
		dbcontact contact = new dbcontact();	
		contact.setId(cursor.getLong(0));
		contact.setname(cursor.getString(1));	
		contact.setmode(cursor.getString(2));
		contact.setlink(cursor.getString(3));
		contact.setmatn(cursor.getString(6));
		contact.setrez(cursor.getString(7));
			return contact;
	}
	//public String getRowIdName() {
	//	return "_id";
	//}

}
