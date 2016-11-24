package com.mysimcard.tools;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class ch extends Activity{
	private Ui mUi=null;
	private DatabaseHandler dbHandler;
	private Contact contact;
	public String sim="8";
	public String buy="2";
	
	
	
	
	private class Ui{
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity=activity;
			 tarif();
		}
		
		private void tarif(){
			
			
			final Timer t = new Timer();
	       
	        t.scheduleAtFixedRate(new TimerTask() 
	        {
				public void run() 
				{
					runOnUiThread(new Runnable() 
					{
						public void run() 
						{
								t.cancel();
								create();
						}
						
					});
				}
	        	
	        }, 1, 100);
			
		}
		private void create(){
			dbHandler.insertContact( "0");
			buy=dbHandler.Display(2);
			sim=dbHandler.Display(1);
			read();
		}
		
		public void read(){
		
		
			
			int sim2=Integer.parseInt(sim.toString());
			int buy2=Integer.parseInt(buy.toString());
			
			if(buy2==1){
				Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
	            myWebLink.setData(Uri.parse("http://www.ir-charge.com"));
	            startActivity(myWebLink);
			}
			
			if(buy2==2){
				
				
				if(sim2==1){
					Intent intent = new Intent(mActivity,ch_aval.class);
					startActivity(intent);
					finish();
				}
				
				if(sim2==2){
					Intent intent = new Intent(mActivity,ch_aval.class);
					startActivity(intent);
					finish();
				}
				
				if(sim2==3){
					Intent intent = new Intent(mActivity,ch_hamrah.class);
					startActivity(intent);
					finish();
				}
				if(sim2==4){
					Intent intent = new Intent(mActivity,ch_hamrah.class);
					startActivity(intent);
					finish();
				}
				if(sim2==5){
					Intent intent = new Intent(mActivity,ch_rightel.class);
					startActivity(intent);
					finish();
				}
				if(sim2==6){
					Intent intent = new Intent(mActivity,ch_rightel.class);
					startActivity(intent);
					finish();
				}
				if(sim2==7){
					Intent intent = new Intent(mActivity,chm_irancell.class);
					startActivity(intent);
					finish();
				}
				if(sim2==8){
					Intent intent = new Intent(mActivity,chm_irancell.class);
					startActivity(intent);
					finish();
				}
			}
			
			
			
			
		    finish();
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
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
		finish();
		
	}

}
