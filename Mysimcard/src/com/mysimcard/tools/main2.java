package com.mysimcard.tools;


import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;


public class main2 extends Activity {
	
	private Ui mUi=null;
	private DatabaseHandler dbHandler;
	private Contact contact;
	
	
	
	
	
	private class Ui{
		
		private ImageView kelid_ch_hamrahaval;
		
		private ImageView kelid_balance_hamrahaval;
		private ImageView kelid_khadamat_hamrahaval;
		private ImageView kelid_ava_hamrahaval;
		private ImageView h_t;
		
		
		private Activity mActivity;
		
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
			
		}

		private void tarif() {
			kelid_ch_hamrahaval=(ImageView) findViewById(R.id.kelid_ch_hamrahaval);
			kelid_balance_hamrahaval=(ImageView) findViewById(R.id.kelid_balanc_hamrahaval);
			kelid_khadamat_hamrahaval=(ImageView) findViewById(R.id.kelid_khadamat_hamrahaval);
			kelid_ava_hamrahaval=(ImageView) findViewById(R.id.kelid_ava_hamrahaval);
			h_t=(ImageView) findViewById(R.id.hamrahaval_tanzimat);
			

		}

		private void ejra() {
			
			
			
			
			
			
			h_t.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,tanzimat.class);
					startActivity(intent);					
				}
			});
			
			
			
			kelid_ava_hamrahaval.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,Pishvaz_hamrah.class);
					startActivity(intent);					
				}
			});
			
			
			
			kelid_ch_hamrahaval.setOnClickListener(new OnClickListener(){
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
						Intent intent = new Intent(mActivity,ch_hamrah.class);
						startActivity(intent);
						finish();
					}
					
					
					
					
					
					
				}
			});
			
			
			
			
			kelid_khadamat_hamrahaval.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,khadamat_hamrahaval.class);
					startActivity(intent);
				}
			});
		
			
			kelid_balance_hamrahaval.setOnClickListener(new OnClickListener(){

				
				public void onClick(View v) {
					String encodedHash = Uri.encode("#");
					String ussd = "*"+"141"+"*" +"1"+ encodedHash;
					startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:" + ussd)), 1);
				
				}
				
				
			});
		}
		
	}

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_hamrahaval);
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
