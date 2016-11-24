package com.Publication.pezeshkisalamt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;




public class tabestan extends Activity {
private Ui mUi=null;
	
	private class Ui{
		
		private Activity mActivity;
		private ImageView t63;
		private ImageView t64;
		private ImageView t65;
		private ImageView t66;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			t63=(ImageView) findViewById(R.id.t63);
			t64=(ImageView) findViewById(R.id.t64);
			t65=(ImageView) findViewById(R.id.t65);
			t66=(ImageView) findViewById(R.id.t66);
			
			
		}
		private void ejra() {
			
			t63.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,b_text.class);
					
					intent.putExtra("b_titrtext"  ,"سلامت پوست در تابستان");
					intent.putExtra("b_maintext"  ,"63");
					intent.putExtra("b_imagetext" ,"63");
					startActivity(intent);
				}
			});
			
			t64.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,b_text.class);
					
					intent.putExtra("b_titrtext"  ,"مسمومیت های غذایی");
					intent.putExtra("b_maintext"  ,"64");
					intent.putExtra("b_imagetext" ,"64");
					startActivity(intent);
				}
			});
			
			t65.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,b_text.class);
					
					intent.putExtra("b_titrtext"  ,"توصیه های جالب تابستانی");
					intent.putExtra("b_maintext"  ,"65");
					intent.putExtra("b_imagetext" ,"65");
					startActivity(intent);
				}
			});
			
			t66.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,b_text.class);
					
					intent.putExtra("b_titrtext"  ,"توصیه های ابوعلی سینا برای تابستان");
					intent.putExtra("b_maintext"  ,"66");
					intent.putExtra("b_imagetext" ,"66");
					startActivity(intent);
				}
			});
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabestan);
		mUi=new Ui(this);
	}
	

}
