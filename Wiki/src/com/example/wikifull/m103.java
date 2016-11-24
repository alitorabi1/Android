package com.example.wikifull;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.Reference.wikifull.R;



public class m103 extends Activity {
private Ui mUi=null;
	
	private class Ui{
		
		private ImageView z103_115;
		private ImageView z103_116;
		private ImageView z103_3;
		private ImageView z103_4;
		private ImageView z103_5;
		private ImageView z103_6;
		private ImageView z103_7;
		private ImageView z103_8;
		private ImageView z103_9;
		private ImageView z103_10;
		private ImageView z103_11;
		private ImageView z103_12;
		private ImageView z103_13;
		private ImageView z103_14;
		private ImageView z103_15;
		private ImageView z103_16;
		private ImageView z103_110;
		private ImageView z103_111;
		private ImageView z103_112;
		private ImageView z103_113;
		private ImageView z103_114;
		
		
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			z103_3=(ImageView) findViewById(R.id.z103_3);
			z103_4=(ImageView) findViewById(R.id.z103_4);
			z103_5=(ImageView) findViewById(R.id.z103_5);
			z103_6=(ImageView) findViewById(R.id.z103_6);
			z103_7=(ImageView) findViewById(R.id.z103_7);
			z103_8=(ImageView) findViewById(R.id.z103_8);
			z103_9=(ImageView) findViewById(R.id.z103_9);
			z103_10=(ImageView) findViewById(R.id.z103_10);
			z103_11=(ImageView) findViewById(R.id.z103_11);
			z103_12=(ImageView) findViewById(R.id.z103_12);
			z103_13=(ImageView) findViewById(R.id.z103_13);
			z103_14=(ImageView) findViewById(R.id.z103_14);
			z103_15=(ImageView) findViewById(R.id.z103_15);
			z103_16=(ImageView) findViewById(R.id.z103_16);
			z103_110=(ImageView) findViewById(R.id.z103_110);
			z103_111=(ImageView) findViewById(R.id.z103_111);
			z103_112=(ImageView) findViewById(R.id.z103_112);
			z103_113=(ImageView) findViewById(R.id.z103_113);
			z103_114=(ImageView) findViewById(R.id.z103_114);
			z103_115=(ImageView) findViewById(R.id.z103_115);
			z103_116=(ImageView) findViewById(R.id.z103_116);
			
			
			
		}
		private void ejra() {
			
			z103_3.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "3");
						startActivity(intent);
					
					
				}
			});
			z103_4.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "4");
						startActivity(intent);
					
					
				}
			});
			z103_5.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "5");
						startActivity(intent);
					
					
				}
			});
			z103_6.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "6");
						startActivity(intent);
					
					
				}
			});
			z103_7.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "7");
						startActivity(intent);
					
					
				}
			});
			z103_8.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "8");
						startActivity(intent);
					
					
				}
			});
			z103_9.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "9");
						startActivity(intent);
					
					
				}
			});
			z103_10.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "10");
						startActivity(intent);
					
					
				}
			});
			z103_11.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "11");
						startActivity(intent);
					
					
				}
			});
			z103_12.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "12");
						startActivity(intent);
					
					
				}
			});
			z103_13.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "13");
						startActivity(intent);
					
					
				}
			});
			z103_14.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "14");
						startActivity(intent);
					
					
				}
			});
			z103_15.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "15");
						startActivity(intent);
					
					
				}
			});
			z103_16.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "16");
						startActivity(intent);
					
					
				}
			});
			z103_110.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "110");
						startActivity(intent);
					
					
				}
			});
			z103_111.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "111");
						startActivity(intent);
					
					
				}
			});
			z103_112.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "112");
						startActivity(intent);
					
					
				}
			});
			z103_113.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "113");
						startActivity(intent);
					
					
				}
			});
			z103_114.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "114");
						startActivity(intent);
					
					
				}
			});
			z103_115.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "115");
						startActivity(intent);
					
					
				}
			});
			z103_116.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "116");
						startActivity(intent);
					
					
				}
			});
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.m103);
		mUi=new Ui(this);
	}
	

}
