package com.Publication.pezeshkisalamt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;




public class z_women extends Activity {
private Ui mUi=null;
	
	private class Ui{
		
		private ImageView t41;
		private ImageView t42;
		private ImageView t43;
		private ImageView t44;
		private ImageView t45;
		private ImageView t46;
		private ImageView t48;
		private ImageView t49;
		private ImageView t50;
		private ImageView t51;
		private ImageView t52;
		private ImageView t53;
		private ImageView t54;
		
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			t41=(ImageView) findViewById(R.id.t41);
			t42=(ImageView) findViewById(R.id.t42);
			t43=(ImageView) findViewById(R.id.t43);
			t44=(ImageView) findViewById(R.id.t44);
			t45=(ImageView) findViewById(R.id.t45);
			t46=(ImageView) findViewById(R.id.t46);
			t48=(ImageView) findViewById(R.id.t48);
			t49=(ImageView) findViewById(R.id.t49);
			t50=(ImageView) findViewById(R.id.t50);
			t51=(ImageView) findViewById(R.id.t51);
			t52=(ImageView) findViewById(R.id.t52);
			t53=(ImageView) findViewById(R.id.t53);
			t54=(ImageView) findViewById(R.id.t54);
			
		}
		private void ejra() {
			
			t41.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,z_text.class);
					
					intent.putExtra("z_titrtext"  ,"نکاتی برای داشتن پوست زیبا");
					intent.putExtra("z_maintext"  ,"41");
					intent.putExtra("z_imagetext" ,"41");
					startActivity(intent);
				}
			});
			t42.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,z_text.class);
					
					intent.putExtra("z_titrtext"  ,"نکات آرایشی از آریشگران ممتاز دنیا");
					intent.putExtra("z_maintext"  ,"42");
					intent.putExtra("z_imagetext" ,"42");
					startActivity(intent);
				}
			});
			t43.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,z_text.class);
					
					intent.putExtra("z_titrtext"  ,"آرایش مناسب برای رنگ پوستهای مختلف");
					intent.putExtra("z_maintext"  ,"43");
					intent.putExtra("z_imagetext" ,"43");
					startActivity(intent);
				}
			});
			t44.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,z_text.class);
					
					intent.putExtra("z_titrtext"  ,"پنج اشتباه در آرایش");
					intent.putExtra("z_maintext"  ,"44");
					intent.putExtra("z_imagetext" ,"44");
					startActivity(intent);
				}
			});
			t45.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,z_text.class);
					
					intent.putExtra("z_titrtext"  ,"پوستی نرم و بدون چروک");
					intent.putExtra("z_maintext"  ,"45");
					intent.putExtra("z_imagetext" ,"45");
					startActivity(intent);
				}
			});
			t46.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,z_text.class);
					
					intent.putExtra("z_titrtext"  ,"خشکی پوست و درمان آن");
					intent.putExtra("z_maintext"  ,"46");
					intent.putExtra("z_imagetext" ,"46");
					startActivity(intent);
				}
			});
			t48.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,z_text.class);
					
					intent.putExtra("z_titrtext"  ,"بهداشت مو");
					intent.putExtra("z_maintext"  ,"48");
					intent.putExtra("z_imagetext" ,"48");
					startActivity(intent);
				}
			});
			t49.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,z_text.class);
					
					intent.putExtra("z_titrtext"  ,"خوش حالت نمودن مو");
					intent.putExtra("z_maintext"  ,"49");
					intent.putExtra("z_imagetext" ,"49");
					startActivity(intent);
				}
			});
			t50.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,z_text.class);
					
					intent.putExtra("z_titrtext"  ,"هفت باور در مورد مو");
					intent.putExtra("z_maintext"  ,"50");
					intent.putExtra("z_imagetext" ,"50");
					startActivity(intent);
				}
			});
			t51.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,z_text.class);
					
					intent.putExtra("z_titrtext"  ,"عوارض کاشت ناخن");
					intent.putExtra("z_maintext"  ,"51");
					intent.putExtra("z_imagetext" ,"51");
					startActivity(intent);
				}
			});
			t52.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,z_text.class);
					
					intent.putExtra("z_titrtext"  ,"روش انجام مانیکور");
					intent.putExtra("z_maintext"  ,"52");
					intent.putExtra("z_imagetext" ,"52");
					startActivity(intent);
				}
			});
			t53.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,z_text.class);
					
					intent.putExtra("z_titrtext"  ,"ماسک زیبایی برای چشم");
					intent.putExtra("z_maintext"  ,"53");
					intent.putExtra("z_imagetext" ,"53");
					startActivity(intent);
				}
			});
			t54.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,z_text.class);
					
					intent.putExtra("z_titrtext"  ,"ماسک برای از بین بردن آثار جوش");
					intent.putExtra("z_maintext"  ,"54");
					intent.putExtra("z_imagetext" ,"54");
					startActivity(intent);
				}
			});
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.z_women);
		mUi=new Ui(this);
	}
	

}
