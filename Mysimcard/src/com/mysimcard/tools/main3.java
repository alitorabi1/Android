package com.mysimcard.tools;



import java.util.Timer;
import java.util.TimerTask;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.app.Activity;
import android.content.Intent;


public class main3 extends Activity {
	private Ui mUi=null;
	private DatabaseHandler dbHandler;
	private Contact contact;
	
	
	private class Ui{
		
		private ImageView kelid_balance_irancell;
		private ImageView kelid_ch_irancell;
		private ImageView kelid_chm_irancell;
		private ImageView kelid_set_irancell;
		private ImageView kelid_khadamat_irancell;
		private ImageView kelid_pishvaz_irancell;
		private Activity mActivity;
		private ImageView i_t;
		public int sim2;
		public int buy2;
		
		public Ui(Activity activity){
			mActivity=activity;
			 tarif();
			 ejra();
			 
		}

		private void tarif() {
			kelid_balance_irancell=(ImageView) findViewById(R.id.kelid_balance_irancell);
			kelid_ch_irancell=(ImageView) findViewById(R.id.kelid_ch_irancell);
			kelid_chm_irancell=(ImageView) findViewById(R.id.kelid_chm_irancell);
			kelid_khadamat_irancell=(ImageView) findViewById(R.id.kelid_khadamat_irancell);
			kelid_pishvaz_irancell=(ImageView) findViewById(R.id.kelid_pishvaz_irancell);
			i_t=(ImageView) findViewById(R.id.irancell_tanzimat);
			
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
								String sim=dbHandler.Display(1);
								String buy=dbHandler.Display(2);
								 sim2=Integer.parseInt(sim.toString());
								 buy2=Integer.parseInt(buy.toString());
								
								
							
							
						}
						
					});
				}
	        	
	        }, 1, 100);
			
			
			
			
			
			
		}
		
		
		

		private void ejra() {
			
			
			
			i_t.setOnClickListener(new OnClickListener(){

				public void onClick(View v) {
					Intent intent = new Intent(mActivity,tanzimat.class);
					startActivity(intent);
					}
				
			});
			
			
			kelid_balance_irancell.setOnClickListener(new OnClickListener(){

				public void onClick(View v) {
					String encodedHash = Uri.encode("#");
					String ussd = "*"+"140"+"*" +"1"+ encodedHash;
					startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:" + ussd)), 1);
				}
				
			});
			
			
			kelid_ch_irancell.setOnClickListener(new OnClickListener(){

				public void onClick(View v) {

					
					if(buy2==1){
						Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
		                myWebLink.setData(Uri.parse("http://www.ir-charge.com"));
		                startActivity(myWebLink);
					}
					
					if(buy2==2){
						Intent intent = new Intent(mActivity,ch_aval.class);
						startActivity(intent);
						
					}
				}
				
			});
			
			
			
			kelid_chm_irancell.setOnClickListener(new OnClickListener(){

				public void onClick(View v) {

					
					if(buy2==1){
						Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
		                myWebLink.setData(Uri.parse("http://www.ir-charge.com"));
		                startActivity(myWebLink);
					}
					
					if(buy2==2){
						Intent intent = new Intent(mActivity,chm_irancell.class);
						intent.putExtra("bill"  ,"2");
						startActivity(intent);
						
					}
				}
				
			});
			
			
			
			
			
			
			
			kelid_khadamat_irancell.setOnClickListener(new OnClickListener(){

				public void onClick(View v) {
					Intent intent = new Intent(mActivity,khadamat_irancell.class);
					startActivity(intent);
				}
				
			});
			
			
			
			kelid_pishvaz_irancell.setOnClickListener(new OnClickListener(){

				public void onClick(View v) {
					Intent intent = new Intent(mActivity,Pishvaz_irancell.class);
					startActivity(intent);
				}
				
			});
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_irancell);
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
