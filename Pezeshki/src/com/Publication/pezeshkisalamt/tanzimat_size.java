package com.Publication.pezeshkisalamt;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class tanzimat_size extends Activity {
private Ui mUi=null;
private DatabaseHandler dbHandler;
private Contact contact;
	private class Ui{
		
		private Activity mActivity;
		private ImageView koochik;
		private ImageView motevaset;
		private ImageView bozorg;
		
		
		
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			

			koochik=(ImageView) findViewById(R.id.tanzimat_size_koochak_kelid);
			motevaset=(ImageView) findViewById(R.id.tanzimat_size_motevaset_kelid);
			bozorg=(ImageView) findViewById(R.id.tanzimat_size_bozorg_kelid);

		}
		private void ejra() {
			
			koochik.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					dbHandler.updateContact(3,"1");
					Toast toast;
		    		toast = Toast.makeText(tanzimat_size.this, "سایز کوچک برای نمایش متن انتخاب شد",Toast.LENGTH_LONG);
		            toast.show();
					finish();
				}
			});
			
			motevaset.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					dbHandler.updateContact(3,"2");
					Toast toast;
		    		toast = Toast.makeText(tanzimat_size.this, "سایز متوسط برای نمایش متن انتخاب شد",Toast.LENGTH_LONG);
		            toast.show();
					finish();

				}
			});
			
			bozorg.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					dbHandler.updateContact(3,"3");
					Toast toast;
		    		toast = Toast.makeText(tanzimat_size.this, "سایز بزرگ برای نمایش متن انتخاب شد",Toast.LENGTH_LONG);
		            toast.show();
					finish();
				}
			});
			
			
		}
	
	}


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tanzimat_size);
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
