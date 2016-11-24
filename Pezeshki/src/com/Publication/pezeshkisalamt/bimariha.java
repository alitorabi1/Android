package com.Publication.pezeshkisalamt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;




public class bimariha extends Activity {
private Ui mUi=null;
	
	private class Ui{
		
		private Activity mActivity;
		private ImageView t56;
		private ImageView t57;
		private ImageView t58;
		private ImageView t59;
		private ImageView t60;
		private ImageView t61;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			t56=(ImageView) findViewById(R.id.t56);
			t57=(ImageView) findViewById(R.id.t57);
			t58=(ImageView) findViewById(R.id.t58);
			t59=(ImageView) findViewById(R.id.t59);
			t60=(ImageView) findViewById(R.id.t60);
			t61=(ImageView) findViewById(R.id.t61);
			
		}
		private void ejra() {
			
			t56.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,b_text.class);
					
					intent.putExtra("b_titrtext"  ,"سرطان ها");
					intent.putExtra("b_maintext"  ,"56");
					intent.putExtra("b_imagetext" ,"56");
					startActivity(intent);
				}
			});
			
			t57.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,b_text.class);
					
					intent.putExtra("b_titrtext"  ,"ویروس ها");
					intent.putExtra("b_maintext"  ,"57");
					intent.putExtra("b_imagetext" ,"57");
					startActivity(intent);
				}
			});
			t58.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,b_text.class);
					
					intent.putExtra("b_titrtext"  ,"عفونت ها");
					intent.putExtra("b_maintext"  ,"58");
					intent.putExtra("b_imagetext" ,"58");
					startActivity(intent);
				}
			});
			t59.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,b_text.class);
					
					intent.putExtra("b_titrtext"  ,"سردردها");
					intent.putExtra("b_maintext"  ,"59");
					intent.putExtra("b_imagetext" ,"59");
					startActivity(intent);
				}
			});
			t60.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,b_text.class);
					
					intent.putExtra("b_titrtext"  ,"دردهای مفاصل");
					intent.putExtra("b_maintext"  ,"60");
					intent.putExtra("b_imagetext" ,"60");
					startActivity(intent);
				}
			});
			t61.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,b_text.class);
					
					intent.putExtra("b_titrtext"  ,"چشم دردها");
					intent.putExtra("b_maintext"  ,"61");
					intent.putExtra("b_imagetext" ,"61");
					startActivity(intent);
				}
			});
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bimariha);
		mUi=new Ui(this);
	}
	

}
