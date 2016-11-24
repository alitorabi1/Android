package com.Publication.pezeshkisalamt;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class tanzimat_font extends Activity {
private Ui mUi=null;
private DatabaseHandler dbHandler;
private Contact contact;
	private class Ui{
		
		private Activity mActivity;
		private ImageView nazanin;
		private ImageView titr;
		private ImageView homa;
		private ImageView koodak;
		
		
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			

			nazanin=(ImageView) findViewById(R.id.nazanin_kelid);
			titr=(ImageView) findViewById(R.id.titr_kelid);
			homa=(ImageView) findViewById(R.id.homa_kelid);
			koodak=(ImageView) findViewById(R.id.koodak_kelid);

		}
		private void ejra() {
			
			nazanin.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					dbHandler.updateContact(2,"1");
					Toast toast;
		    		toast = Toast.makeText(tanzimat_font.this, "فونت نازنین برای نمایش متن انتخاب شد",Toast.LENGTH_LONG);
		            toast.show();
					finish();
				}
			});
			
			titr.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					dbHandler.updateContact(2,"2");
					Toast toast;
		    		toast = Toast.makeText(tanzimat_font.this, "فونت تیتر برای نمایش متن انتخاب شد",Toast.LENGTH_LONG);
		            toast.show();
					finish();

				}
			});
			
			homa.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					dbHandler.updateContact(2,"3");
					Toast toast;
		    		toast = Toast.makeText(tanzimat_font.this, "فونت هما برای نمایش متن انتخاب شد",Toast.LENGTH_LONG);
		            toast.show();
					finish();
				}
			});
			
			koodak.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					dbHandler.updateContact(2,"4");
					Toast toast;
		    		toast = Toast.makeText(tanzimat_font.this, "فونت کودک برای نمایش متن انتخاب شد",Toast.LENGTH_LONG);
		            toast.show();
					finish();
				}
			});
			
		}
	
	}


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tanzimat_font);
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
