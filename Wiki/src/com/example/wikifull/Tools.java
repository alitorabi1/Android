package com.example.wikifull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.database.SQLException;
import android.os.Environment;
import android.widget.Toast;


public class Tools  {
	private static String DB_PATH = "/data/data/com.Reference.wikipdf/databases/";
    private static String DB_NAME = "dbmain";
	private dbtemp dbtem;
	
	public void copyDataBase() throws IOException{
		
		File file = new File(DB_PATH + DB_NAME);
		file.delete();
		
		
		
        String source = Environment.getExternalStorageDirectory() + "/dbmain";
    	InputStream myInput = new FileInputStream(source);
    	
    	String outFileName = DB_PATH + DB_NAME;
    	OutputStream myOutput = new FileOutputStream(outFileName);
    	
    	byte[] buffer = new byte[1024];
    	int length;
    	while ((length = myInput.read(buffer))>0){
    		myOutput.write(buffer, 0, length);
    	}
    	myOutput.flush();
    	myOutput.close();
    	myInput.close();
 
    	File file2 = new File(Environment.getExternalStorageDirectory() + "/dbmain");
		file2.delete();
    }
	
	
	
	
		public void copyDataBaset() throws IOException{
		
		//File file = new File(DB_PATH + DB_NAME);
		//file.delete();
		
		
		
        String source = Environment.getExternalStorageDirectory() + "/dbtemp";
    	InputStream myInput = new FileInputStream(source);
    	
    	String outFileName = DB_PATH + "dbtemp";
    	OutputStream myOutput = new FileOutputStream(outFileName);
    	
    	byte[] buffer = new byte[1024];
    	int length;
    	while ((length = myInput.read(buffer))>0){
    		myOutput.write(buffer, 0, length);
    	}
    	myOutput.flush();
    	myOutput.close();
    	myInput.close();
 
    	File file2 = new File(Environment.getExternalStorageDirectory() + "/dbtemp");
		file2.delete();
		
    }
		
		
	
	
	
	
}
