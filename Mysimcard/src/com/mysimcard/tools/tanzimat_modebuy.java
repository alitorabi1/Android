package com.mysimcard.tools;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;




public class tanzimat_modebuy extends Activity {
private Ui mUi=null;
private DatabaseHandler dbHandler;
private Contact contact;


	private class Ui{
		
		private Activity mActivity;
		private ImageView wos;
		private ImageView wapp;
		
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			wos=(ImageView) findViewById(R.id.wos);
			wapp=(ImageView) findViewById(R.id.wapp);
			
		}
		private void ejra() {
			
			wos.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					dbHandler.updateContact(3,"1");
					Toast toast;
		    		toast = Toast.makeText(tanzimat_modebuy.this, "استفاده از مرورگر سیستم عامل انتخاب شد",Toast.LENGTH_LONG);
		            toast.show();
					finish();
				}
			});
			
			wapp.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					dbHandler.updateContact(3,"2");
					Toast toast;
		    		toast = Toast.makeText(tanzimat_modebuy.this, "استفاده از مرورگر نرم افزار انتخاب شد",Toast.LENGTH_LONG);
		            toast.show();
					finish();
				}
			});
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tanzimat_modebuy);
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
