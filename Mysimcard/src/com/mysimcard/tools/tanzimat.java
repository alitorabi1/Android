package com.mysimcard.tools;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;




public class tanzimat extends Activity {
private Ui mUi=null;
private DatabaseHandler dbHandler;
private Contact contact;


	
	
		
		

	
	private class Ui{
		private ImageView modesim;
		private ImageView modebuy;
		private ImageView modeabout;
		private ImageView modepass;
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			modesim=(ImageView) findViewById(R.id.k_modesim);
			modebuy=(ImageView) findViewById(R.id.k_modebuy);
			modeabout=(ImageView) findViewById(R.id.k_modeabout);
			modepass=(ImageView) findViewById(R.id.k_modepass);
		}
		
		private void ejra() {
			
			modesim.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,tanzimat_modesim.class);
					startActivity(intent);
				}
			});
			
			modebuy.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,tanzimat_modebuy.class);
					startActivity(intent);
				}
			});
			
			
			modeabout.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,about.class);
					startActivity(intent);
				}
			});
			
			modepass.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,key.class);
					startActivity(intent);
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
