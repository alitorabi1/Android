package com.example.wikifull;




import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import com.Reference.wikifull.R;


import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Main extends Activity {
private Ui mUi=null;
private dbmain dbmain;
private dbthandler dbt;
private Tools tools;
	private class Ui{
		
		private Activity mActivity;
		private ImageView Main_start_kelid;
		
		private ImageView Main_update_kelid;
		private ImageView Main_help_kelid;
		private ImageView Main_search_kelid;
		private ImageView Main_exit_kelid;
		private TextView payam;
		
		Typeface font=Typeface.createFromAsset(getAssets(), "font/davat.ttf");
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			Main_start_kelid=(ImageView) findViewById(R.id.main_start_kelid);
			
			Main_update_kelid=(ImageView) findViewById(R.id.main_updatedb_kelid);
			Main_help_kelid=(ImageView) findViewById(R.id.main_help_kelid);
			Main_search_kelid=(ImageView) findViewById(R.id.main_search_kelid);
			Main_exit_kelid=(ImageView) findViewById(R.id.main_khorooj_kelid);
			payam=(TextView) findViewById(R.id.main_payam);
		}
		
		private void create(){
			dbt.insertContact("0");
			String tnt0=dbt.Display(0);
					if(dbt.count()==1){
						    dbt.insertContact("1");
						    
							dbt.insertContact("0");
							
							dbt.insertContact("0");
							
							dbt.insertContact(" ");
							
							File folder = new File(Environment.getExternalStorageDirectory().toString()+"/Wiki");
							folder.mkdirs();
					}	
					
			
		}
		private void ejra() {
			
			
			payam.setTypeface(font);
			
			
			Main_start_kelid.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {
					create();
					
					if(dbt.Display(2).equals("0")){					
					Intent intent = new Intent(getApplicationContext(),AndroidFileDownloader.class);
					intent.putExtra("name"  , "main");
					startActivity(intent);
					
					}
					else
					{
						
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
				
					 payam.setText(dbt.Display(4));
					 Intent intent = new Intent(getApplicationContext(),m1.class);
						
						startActivity(intent);
					}
					
				}
			});
			
			
			
			Main_update_kelid.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {
					create();
					if(dbt.Display(2).equals("0")){
						
						Toast toast1;
						toast1 = Toast.makeText(Main.this, "لطفا ابتدا دیتای برنامه را دانلود نمایید",Toast.LENGTH_LONG);
				        toast1.show();
					}
					else
					{
					Intent intent = new Intent(getApplicationContext(),AndroidFileDownloader.class);
					intent.putExtra("name"  , "temp");
					startActivity(intent);
					}
				}
			});
			Main_search_kelid.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {
					Intent intent = new Intent(getApplicationContext(),Search.class);
					startActivity(intent);
					
				}
			});
			Main_help_kelid.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {
					
					Intent intent = new Intent(getApplicationContext(),help.class);
					startActivity(intent);
				}
			});
			Main_exit_kelid.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {
					
					finish();
				}
			});
			
			
		}
	
	}


	
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		dbmain = new dbmain(this);
		dbt = new dbthandler(this);
		tools=new Tools();
		mUi=new Ui(this);
		
	}
	protected void onResume() {
		super.onResume();
		dbt.open();		
	}

	@Override
	protected void onPause() {
		super.onPause();
		dbt.close();
	}
	

}
