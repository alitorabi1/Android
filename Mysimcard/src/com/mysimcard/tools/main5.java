package com.mysimcard.tools;


import java.util.Timer;
import java.util.TimerTask;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;


public class main5 extends Activity {
	private Ui mUi=null;
	private DatabaseHandler dbHandler;
	private Contact contact;
	
	
	
	
	
	private class Ui{
		
		private ImageView kelid_kharid_rightel;
		private ImageView kelid_balance_rightel;
		private ImageView kelid_khadamat_rightel;
		private ImageView r_t;
		
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity=activity;
			 tarif();
			 ejra();
			 
		}

		private void tarif() {
			kelid_kharid_rightel=(ImageView) findViewById(R.id.kelid_kharid_rightel);
			kelid_balance_rightel=(ImageView) findViewById(R.id.kelid_balance_rightel);
			kelid_khadamat_rightel=(ImageView) findViewById(R.id.kelid_khadamat_rightel);
			r_t=(ImageView) findViewById(R.id.rightell_tanzimat);
			
	        
	        
		}

		private void ejra() {
			
			
			
			r_t.setOnClickListener(new OnClickListener(){

				public void onClick(View v) {
					Intent intent = new Intent(mActivity,tanzimat.class);
					startActivity(intent);
					}
				
			});
			
			
			kelid_balance_rightel.setOnClickListener(new OnClickListener(){

				public void onClick(View v) {
					String encodedHash = Uri.encode("#");
					String ussd = "*"+"140"+ encodedHash;
					startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:" + ussd)), 1);
				}
				
			});
			
			
			kelid_kharid_rightel.setOnClickListener(new OnClickListener(){

				public void onClick(View v) {
					
					//String sim=dbHandler.Display(1);
					String buy=dbHandler.Display(2);
					
					//int sim2=Integer.parseInt(sim.toString());
					int buy2=Integer.parseInt(buy.toString());
					
					if(buy2==1){
						Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
		                myWebLink.setData(Uri.parse("http://www.ir-charge.com"));
		                startActivity(myWebLink);
					}
					
					if(buy2==2){
						Intent intent = new Intent(mActivity,ch_rightel.class);
						startActivity(intent);
						finish();
					}
					
				}
				
			});
			
			
			
			kelid_khadamat_rightel.setOnClickListener(new OnClickListener(){

				public void onClick(View v) {
				Intent intent = new Intent(mActivity,khadamat_rightel.class);
				startActivity(intent);
				}
				
			});
			
			
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_rightel);
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
