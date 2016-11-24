package com.mysimcard.tools;





import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class Start extends Activity {
	
	private DatabaseHandler dbHandler;
	private DatabaseHandler01 dbHandler01;
	
	
	
	private Ui mUi=null;
	private class Ui{
		private ImageView img2;
		private ImageView img3;
		private ImageView img4;
		private ImageView img5;
		private ImageView k_m_t;
		private ImageView k_m_g;
		private ImageView bill;
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity=activity;
			
			tarif();
			
		}

		public void onBackPressed() {
			finish();
		}

		private void tarif() {
			img2=(ImageView) findViewById(R.id.img2);
			img3=(ImageView) findViewById(R.id.img3);
			img4=(ImageView) findViewById(R.id.img4);
			img5=(ImageView) findViewById(R.id.img5);
			k_m_t=(ImageView) findViewById(R.id.kelid_main_tanzimat);
			k_m_g=(ImageView) findViewById(R.id.kelid_main_gav);
			bill=(ImageView) findViewById(R.id.main_bill);
			ejra();
			
			final Timer t = new Timer();
	        //Set the schedule function and rate
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
			String tnt0=dbHandler.Display(0);
					if(dbHandler.count()==1){
						    dbHandler.insertContact("8");// modesim
							dbHandler.insertContact("2");//modebuy	
							dbHandler.insertContact("0000");//pass	
							
							dbHandler01.insertContact("خالی", "", "", "");//0
							dbHandler01.insertContact("خالی", "", "", "");//1
							dbHandler01.insertContact("خالی", "", "", "");//2
							dbHandler01.insertContact("خالی", "", "", "");//3
							dbHandler01.insertContact("خالی", "", "", "");//4
							dbHandler01.insertContact("خالی", "", "", "");//5
							dbHandler01.insertContact("خالی", "", "", "");//6
							dbHandler01.insertContact("خالی", "", "", "");//7
							dbHandler01.insertContact("خالی", "", "", "");//8
							dbHandler01.insertContact("خالی", "", "", "");//9
							dbHandler01.insertContact("خالی", "", "", "");//10
					}	
					readfont();
		}
		
		
		
		private void readfont(){
		
			String sim=dbHandler.Display(1);
			int sim2=Integer.parseInt(sim.toString());
			
			if(sim2==1){
				Intent intent = new Intent(mActivity,main3.class);
				startActivity(intent);
				
			}
			
			if(sim2==2){
				Intent intent = new Intent(mActivity,main3.class);
				startActivity(intent);
				
			}
			
			if(sim2==3){
				Intent intent = new Intent(mActivity,main2.class);
				startActivity(intent);
				
			}
			if(sim2==4){
				Intent intent = new Intent(mActivity,main2.class);
				startActivity(intent);
				
			}
			if(sim2==5){
				Intent intent = new Intent(mActivity,main5.class);
				startActivity(intent);
				
			}
			if(sim2==6){
				Intent intent = new Intent(mActivity,main5.class);
				startActivity(intent);
				
			}
			if(sim2==7){
				Intent intent = new Intent(mActivity,main4.class);
				startActivity(intent);
				
			}
			if(sim2==8){
				ejra();
			}
			
			
		}


		private void ejra() {
			
			
	        
			img2.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent(mActivity,main2.class);
					startActivity(intent);
					
				}
				
			});
			
			
			img3.setOnClickListener(new OnClickListener(){

				public void onClick(View arg0) {
					Intent intent = new Intent(mActivity,main3.class);
				
					startActivity(intent);
						
				}
				
			});
			
			
			bill.setOnClickListener(new OnClickListener(){

				public void onClick(View arg0) {
					Intent intent = new Intent(mActivity,chm_irancell.class);
					intent.putExtra("bill"  ,"1");
					startActivity(intent);
						
				}
				
			});
			
			
			
			img4.setOnClickListener(new OnClickListener(){

				public void onClick(View arg0) {
					Intent intent = new Intent(mActivity,main4.class);
					startActivity(intent);
					
				}
				
			});
			
			
			
			img5.setOnClickListener(new OnClickListener(){

				public void onClick(View arg0) {
					
					Intent intent = new Intent(mActivity,main5.class);
					startActivity(intent);
					
				}
				
			});
			
			k_m_t.setOnClickListener(new OnClickListener(){

				public void onClick(View arg0) {
					
					Intent intent = new Intent(mActivity,tanzimat.class);
					startActivity(intent);
					
				}
				
			});
			k_m_g.setOnClickListener(new OnClickListener(){

				public void onClick(View arg0) {
					
					Intent intent = new Intent(mActivity,Gav.class);
					startActivity(intent);
					
				}
				
			});
		
		
		}
		
		

		
	}
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main1);
		
		
		dbHandler=new DatabaseHandler(this);
		dbHandler01=new DatabaseHandler01(this);
		mUi=new Ui(this);
	}
	protected void onResume() {
		super.onResume();
		dbHandler.open();
		dbHandler01.open();
		
	}

	@Override
	protected void onPause() {
		super.onPause();
		
		
		dbHandler.close();
		dbHandler01.close();
		
	}

	
	
	
}