package com.Publication.pezeshkisalamt;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;




public class tanzimat extends Activity {
private Ui mUi=null;
private DatabaseHandler dbHandler;
private Contact contact;
	
	private class Ui{
		
		private Activity mActivity;
		private ImageView tanzimat_font_kelid;
		private ImageView tanzimat_size_kelid;
		private ImageView tanzimat_day_kelid;
		private ImageView tanzimat_night_kelid;
		
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			 tanzimat_font_kelid=(ImageView) findViewById(R.id.tanzimat_font_kelid);
			 tanzimat_size_kelid=(ImageView) findViewById(R.id.tanzimat_sayz_kelid);
			 tanzimat_day_kelid=(ImageView) findViewById(R.id.tanzimat_day_kelid);
			 tanzimat_night_kelid=(ImageView) findViewById(R.id.tanzimat_night_kelid);
			
		}
		private void ejra() {
			
			tanzimat_font_kelid.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,tanzimat_font.class);
					startActivity(intent);
				}
			});
			
			
			tanzimat_size_kelid.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,tanzimat_size.class);
					startActivity(intent);
				}
			});
			
			
			tanzimat_day_kelid.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					dbHandler.updateContact(4,"1");
					Toast toast;
		    		toast = Toast.makeText(tanzimat.this, "حالت نمایش روز انتخاب شد",Toast.LENGTH_LONG);
		            toast.show();
				}
			});
			
			tanzimat_night_kelid.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					dbHandler.updateContact(4,"2");
					Toast toast;
		    		toast = Toast.makeText(tanzimat.this, "حالت نمایش شب انتخاب شد",Toast.LENGTH_LONG);
		            toast.show();
					
				}
			});
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tanzimat);
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
