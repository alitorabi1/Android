package com.example.wikifull;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.Reference.wikifull.R;



public class m1 extends Activity {
private Ui mUi=null;
	
	private class Ui{
		
		private ImageView z10;
		private ImageView z11;
		private ImageView z12;
		private ImageView z13;
		private ImageView z14;
		private ImageView z15;
		
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			z10=(ImageView) findViewById(R.id.z10);
			z11=(ImageView) findViewById(R.id.z11);
			z12=(ImageView) findViewById(R.id.z12);
			z13=(ImageView) findViewById(R.id.z13);
			z14=(ImageView) findViewById(R.id.z14);
			z15=(ImageView) findViewById(R.id.z15);
			
			
			
		}
		private void ejra() {
			
			z10.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					Intent intent = new Intent(getApplicationContext(),m10.class);
					startActivity(intent);
					
					
				}
			});
			z11.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					Intent intent = new Intent(getApplicationContext(),m11.class);
					startActivity(intent);
					
					
				}
			});
			z12.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					Intent intent = new Intent(getApplicationContext(),m12.class);
					startActivity(intent);
					
					
				}
			});
			z13.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					Intent intent = new Intent(getApplicationContext(),m13.class);
					startActivity(intent);
					
					
				}
			});
			z14.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					
					Intent intent = new Intent(getApplicationContext(),m14.class);
					startActivity(intent);
					
				}
			});
			z15.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					Intent intent = new Intent(getApplicationContext(),m15.class);
					startActivity(intent);
					
					
				}
			});
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.m1);
		mUi=new Ui(this);
	}
	

}
