package com.Publication.pezeshkisalamt;






import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ImageView;
import android.media.AudioManager;
import android.media.SoundPool;



public class Main extends Activity {
private Ui mUi=null;
private DatabaseHandler dbHandler;
private Contact contact;
	



	//public void onBackPressed() {
	
	//}

	private class Ui{
		
		private Activity mActivity;
		private ImageView main_vorood_kelid;
		
		private ImageView main_tanzimat_kelid;
		private ImageView main_khorooj_kelid;
		private WebView back;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			
			
			main_vorood_kelid=(ImageView) findViewById(R.id.main_vorood_kelid);
			
			main_tanzimat_kelid=(ImageView) findViewById(R.id.main_tanzimat_kelid);
			main_khorooj_kelid=(ImageView) findViewById(R.id.main_khorooj_kelid);
			
			
		}
		
		private void create(){
			dbHandler.insertContact( "0");
			String tnt0=dbHandler.Display(0);
					if(dbHandler.count()==1){
						    dbHandler.insertContact("1");//font
						    
							dbHandler.insertContact("2");//size
							
							dbHandler.insertContact("1");//mode
							
							
								
					}	
			
		}
		private void ejra() {
			
			main_vorood_kelid.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {	
				create();
				Intent intent = new Intent(mActivity,main_p.class);
					startActivity(intent);
				}
			});
		
			
			
			
			main_tanzimat_kelid.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {
					
					Intent intent = new Intent(mActivity,tanzimat.class);
					startActivity(intent);
					
				}
				
				
			});
			
			
			
			main_khorooj_kelid.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {
					finish();
				}
				
				
			});
			
			
		}
	
	}
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		dbHandler=new DatabaseHandler(this);
		contact=new Contact();
		mUi=new Ui(this);
	}
	protected void onResume() {
		super.onResume();
		dbHandler.open();		
	}

	@Override
	protected void onPause() {
		super.onPause();
		dbHandler.close();
	}
	

}
