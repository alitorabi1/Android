package com.mysimcard.tools;



import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.app.Activity;
import android.content.Intent;


public class main4 extends Activity {
	private Ui mUi=null;
	private DatabaseHandler dbHandler;
	private Contact contact;
	
	
	
	
	
	private class Ui{
		
		private ImageView kharid_talia;
		private ImageView balance_talia;
		private ImageView t_t;
		
		
		
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity=activity;
			 tarif();
			 ejra();
			 
		}

		private void tarif() {
			kharid_talia=(ImageView) findViewById(R.id.kharid_talia);
			balance_talia=(ImageView) findViewById(R.id.balance_talia);
			t_t=(ImageView) findViewById(R.id.talia_tanzimat);
		
				}

		private void ejra() {
			
			
			
			t_t.setOnClickListener(new OnClickListener(){

				public void onClick(View v) {
					Intent intent = new Intent(mActivity,tanzimat.class);
					startActivity(intent);
					}
				
			});
			
			balance_talia.setOnClickListener(new OnClickListener(){

				public void onClick(View v) {
					String encodedHash = Uri.encode("#");
					String ussd = "*"+"140"+ encodedHash;
					startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:" + ussd)), 1);
				}
				
			});
			
			
			kharid_talia.setOnClickListener(new OnClickListener(){

				public void onClick(View v) {
					Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
	                myWebLink.setData(Uri.parse("http://www.ir-charge.com"));
	                startActivity(myWebLink);
				}
				
			});
			
			
			
			
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_talia);
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
