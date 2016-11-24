package com.Publication.pezeshkisalamt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;




public class z_men extends Activity {
private Ui mUi=null;
	
	private class Ui{
		
		private Activity mActivity;
		private ImageView t70;
		private ImageView t71;
		
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
		t70=(ImageView) findViewById(R.id.t70);
		t71=(ImageView) findViewById(R.id.t71);
		
			
		}
		private void ejra() {
			
			t70.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,z_text.class);
					
					intent.putExtra("z_titrtext"  ,"نکات زیبایی برای آقایان");
					intent.putExtra("z_maintext"  ,"70");
					intent.putExtra("z_imagetext" ,"70");
					startActivity(intent);
				}
			});
			t71.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,z_text.class);
					
					intent.putExtra("z_titrtext"  ,"نکات اصلاح صورت");
					intent.putExtra("z_maintext"  ,"71");
					intent.putExtra("z_imagetext" ,"71");
					startActivity(intent);
				}
			});
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.z_men);
		mUi=new Ui(this);
	}
	

}
