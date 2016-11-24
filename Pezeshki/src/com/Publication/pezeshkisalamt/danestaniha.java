package com.Publication.pezeshkisalamt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;




public class danestaniha extends Activity {
private Ui mUi=null;

	private class Ui{
		
		private ImageView d_part1;
		private ImageView d_part2;
		private ImageView d_part3;
		private ImageView d_part4;
		private ImageView d_part5;
		private ImageView d_part6;
		private ImageView d_part7;
		private ImageView d_part8;
		private ImageView d_part9;
		private ImageView d_part10;
		private ImageView d_part11;
		private ImageView d_part12;
		
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			d_part1=(ImageView) findViewById(R.id.d_part1);
			d_part2=(ImageView) findViewById(R.id.d_part2);
			d_part3=(ImageView) findViewById(R.id.d_part3);
			d_part4=(ImageView) findViewById(R.id.d_part4);
			d_part5=(ImageView) findViewById(R.id.d_part5);
			d_part6=(ImageView) findViewById(R.id.d_part6);
			d_part7=(ImageView) findViewById(R.id.d_part7);
			d_part8=(ImageView) findViewById(R.id.d_part8);
			d_part9=(ImageView) findViewById(R.id.d_part9);
			d_part10=(ImageView) findViewById(R.id.d_part10);
			d_part11=(ImageView) findViewById(R.id.d_part11);
			d_part12=(ImageView) findViewById(R.id.d_part12);
			
		}
		private void ejra() {
			d_part1.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,danestaniha_list.class);
					intent.putExtra("titrtext","دانستنیها  - بخش اول");
					intent.putExtra("part","1");
					startActivity(intent);
				}
			});
			d_part2.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,danestaniha_list.class);
					intent.putExtra("titrtext","دانستنیها  - بخش دوم");
					intent.putExtra("part","2");
					startActivity(intent);
				}
			});
			d_part3.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,danestaniha_list.class);
					intent.putExtra("titrtext","دانستنیها  - بخش سوم");
					intent.putExtra("part","3");
					startActivity(intent);
				}
			});
			d_part4.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,danestaniha_list.class);
					intent.putExtra("titrtext","دانستنیها  - بخش چهارم");
					intent.putExtra("part","4");
					startActivity(intent);
				}
			});
			d_part5.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,danestaniha_list.class);
					intent.putExtra("titrtext","دانستنیها  - بخش پنجم");
					intent.putExtra("part","5");
					startActivity(intent);
				}
			});
			d_part6.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,danestaniha_list.class);
					intent.putExtra("titrtext","دانستنیها  - بخش ششم");
					intent.putExtra("part","6");
					startActivity(intent);
				}
			});
			d_part7.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,danestaniha_list.class);
					intent.putExtra("titrtext","دانستنیها  - بخش هفتم");
					intent.putExtra("part","7");
					startActivity(intent);
				}
			});
			d_part8.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,danestaniha_list.class);
					intent.putExtra("titrtext","دانستنیها  - بخش هشتم");
					intent.putExtra("part","8");
					startActivity(intent);
				}
			});
			d_part9.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,danestaniha_list.class);
					intent.putExtra("titrtext","دانستنیها  - بخش نهم");
					intent.putExtra("part","9");
					startActivity(intent);
				}
			});
			d_part10.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,danestaniha_list.class);
					intent.putExtra("titrtext","دانستنیها  - بخش دهم");
					intent.putExtra("part","10");
					startActivity(intent);
				}
			});
			d_part11.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,danestaniha_list.class);
					intent.putExtra("titrtext","دانستنیها  - بخش یازدهم");
					intent.putExtra("part","11");
					startActivity(intent);
				}
			});
			d_part12.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,danestaniha_list.class);
					intent.putExtra("titrtext","دانستنیها  - بخش دوازدهم");
					intent.putExtra("part","12");
					startActivity(intent);
				}
			});
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.danestaniha);
		
		mUi=new Ui(this);
	}
	

}
