package com.example.wikifull;


import java.io.IOException;
import java.util.List;



import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.Reference.wikifull.R;
public class Main_list extends Activity {
    
	
	
	private dbmain dbmain;
	
	private List<dbcontact> list;
	
	private ListView listView;
	private ListAdapter adapter;
	private dbthandler dbt;
	private String mode;
	private String key;
	private String code;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_list);
        adapter  	= new ListAdapter(this);
        dbmain 		= new dbmain(this);
        dbt=new dbthandler(this);
	
        
        
        
        
        
        
        
        
        
        
        
        try {
        	dbmain.createDataBase();
        } catch (IOException ioe) {
 		throw new Error("Unable to create database");
        }
	 try {
	 		dbmain.open();
	        }catch(SQLException sqle){
	 		throw sqle;
	        }
        listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {	
				String name =(String) ((TextView) v.findViewById(R.id.row_name)).getText();
				String mode =(String) ((TextView) v.findViewById(R.id.row_mode)).getText();
				String link =(String) ((TextView) v.findViewById(R.id.row_link)).getText();
				String matn =(String) ((TextView) v.findViewById(R.id.row_matn)).getText();
				String rez =(String) ((TextView) v.findViewById(R.id.row_rez)).getText();
				String idt =(String) ((TextView) v.findViewById(R.id.row_id)).getText();
				Intent intent = new Intent(getApplicationContext(),Downloader_File.class);
				intent.putExtra("name"  , name);
				intent.putExtra("link"  , dbmain.Display_link(0));
				intent.putExtra("mode"  , mode);
				intent.putExtra("matn"  , matn);
				intent.putExtra("rez"  , rez);
				intent.putExtra("id"  , idt);
				startActivity(intent);
				
			}
		});
        
        
      //  dbt.open();
        Bundle extras = getIntent().getExtras();
		mode= extras.getString("mode");
		key= extras.getString("key");
        if(mode.equals("search"))
        {
        	refreshListSearch(key);
        }
        else if(mode.equals("main"))
        {
        	refreshList();
        }
        else if(mode.equals("code"))
        {
        	refreshListnormal(key);
        }
        
        
      
      
    }
   

	@Override
	protected void onResume() {
		super.onResume();
		 dbt.open();
		//dbmain.open();
//		dbHandler.clearTable();
		 
		 /*
		 Bundle extras = getIntent().getExtras();
			mode= extras.getString("mode");
			key= extras.getString("key");
			
			
			
	        if(mode.equals("search"))
	        {
	        	refreshListSearch(key);
	        }
	        else if(mode.equals("main"))
	        {
	        	refreshList();
	        }
	        else if(mode.equals("code"))
	        {
	        	refreshListnormal(code);
	        }
	        */
	}

	@Override
	protected void onPause() {
		super.onPause();
		 dbt.close();
	//	dbmain.close();
		
	}
	
	protected void refreshListSearch(String key) {
    	list = dbmain.getSearchContacts(key);
        adapter.setData(list);
        listView.setAdapter(adapter);
	}
	protected void refreshList() {
    	list = dbmain.getAllContacts();
        adapter.setData(list);
        listView.setAdapter(adapter);
	}
	
	protected void refreshListnormal(String code) {
    	list = dbmain.getcodeContacts(code);
        adapter.setData(list);
        listView.setAdapter(adapter);
	}
}