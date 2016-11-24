package com.mysimcard.tools;





import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;




public class tanzimat_modesim extends Activity {
private Ui mUi=null;
private DatabaseHandler dbHandler;
private Contact contact;

	private class Ui{
		
		private Activity mActivity;
		private ImageView m_i_d;
		private ImageView m_i_e;
		private ImageView m_h_d;
		private ImageView m_h_e;
		private ImageView m_r_d;
		private ImageView m_r_e;
		private ImageView m_t;
		private ImageView m_none;
		
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			m_i_d=(ImageView) findViewById(R.id.m_irancell_d);
			m_i_e=(ImageView) findViewById(R.id.m_irancell_e);
			m_h_d=(ImageView) findViewById(R.id.m_hamrahaval_d);
			m_h_e=(ImageView) findViewById(R.id.m_hamrahaval_e);
			m_r_d=(ImageView) findViewById(R.id.m_rightel_d);
			m_r_e=(ImageView) findViewById(R.id.m_rightel_e);
			m_t=(ImageView) findViewById(R.id.m_talia);
			m_none=(ImageView) findViewById(R.id.m_none);
			
		}
		private void ejra() {
			
			
			m_i_d.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					dbHandler.updateContact(2,"1");
					Toast toast;
		    		toast = Toast.makeText(tanzimat_modesim.this, "سیم کارت ایرانسل دائمی انتخاب شد",Toast.LENGTH_LONG);
		            toast.show();
					finish();
				}
			});
			
			m_i_e.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					dbHandler.updateContact(2,"2");
					Toast toast;
		    		toast = Toast.makeText(tanzimat_modesim.this, "سیم کارت ایرانسل اعتباری انتخاب شد",Toast.LENGTH_LONG);
		            toast.show();
					finish();
				}
			});
			
			m_h_d.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					dbHandler.updateContact(2,"3");
					Toast toast;
		    		toast = Toast.makeText(tanzimat_modesim.this, "سیم کارت همراه اول دائمی انتخاب شد",Toast.LENGTH_LONG);
		            toast.show();
					finish();
				}
			});
			
			m_h_e.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					dbHandler.updateContact(2,"4");
					Toast toast;
		    		toast = Toast.makeText(tanzimat_modesim.this, "سیم کارت همراه اول اعتباری انتخاب شد",Toast.LENGTH_LONG);
		            toast.show();
					finish();
				}
			});
			
			
			m_r_d.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					dbHandler.updateContact(2,"5");
					Toast toast;
		    		toast = Toast.makeText(tanzimat_modesim.this, "سیم کارت رایتل دائمی  انتخاب شد",Toast.LENGTH_LONG);
		            toast.show();
					finish();
				}
			});
			
			
			m_r_e.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					dbHandler.updateContact(2,"6");
					Toast toast;
		    		toast = Toast.makeText(tanzimat_modesim.this, "سیم کارت رایتل اعتباری انتخاب شد",Toast.LENGTH_LONG);
		            toast.show();
					finish();
				}
			});
			
			
			m_t.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					dbHandler.updateContact(2,"7");
					Toast toast;
		    		toast = Toast.makeText(tanzimat_modesim.this, "سیم کارت تالیا انتخاب شد",Toast.LENGTH_LONG);
		            toast.show();
					finish();
				}
			});
			
			m_none.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					dbHandler.updateContact(2,"8");
					Toast toast;
		    		toast = Toast.makeText(tanzimat_modesim.this, "هیچ سیم کارتی انتخاب نشده است",Toast.LENGTH_LONG);
		            toast.show();
					finish();
				}
			});

		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tanzimat_modesim);
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
