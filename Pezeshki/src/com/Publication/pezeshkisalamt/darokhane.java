package com.Publication.pezeshkisalamt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;




public class darokhane extends Activity {
private Ui mUi=null;
	
	private class Ui{
		private ImageView t28;
		private ImageView t29;
		private ImageView t30;
		private ImageView t31;
		private ImageView t32;
		private ImageView t33;
		private ImageView t34;
		private ImageView t35;
		private ImageView t36;
		private ImageView t37;
		private ImageView t38;
		private ImageView t39;
		private ImageView t40;
		
		
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			t28=(ImageView) findViewById(R.id.t28);
			t29=(ImageView) findViewById(R.id.t29);
			t30=(ImageView) findViewById(R.id.t30);
			t31=(ImageView) findViewById(R.id.t31);
			t32=(ImageView) findViewById(R.id.t32);
			t33=(ImageView) findViewById(R.id.t33);
			t34=(ImageView) findViewById(R.id.t34);
			t35=(ImageView) findViewById(R.id.t35);
			t36=(ImageView) findViewById(R.id.t36);
			t37=(ImageView) findViewById(R.id.t37);
			t38=(ImageView) findViewById(R.id.t38);
			t39=(ImageView) findViewById(R.id.t39);
			t40=(ImageView) findViewById(R.id.t40);
			
		}
		private void ejra() {
			
			t28.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"سیر");
					intent.putExtra("maintext"  ,"28");
					intent.putExtra("imagetext" ,"28");
					startActivity(intent);
				}
			});
			t29.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"سیب");
					intent.putExtra("maintext"  ,"29");
					intent.putExtra("imagetext" ,"29");
					startActivity(intent);
				}
			});
			t30.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"اسفناج");
					intent.putExtra("maintext"  ,"30");
					intent.putExtra("imagetext" ,"30");
					startActivity(intent);
				}
			});
			t31.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"گردو");
					intent.putExtra("maintext"  ,"31");
					intent.putExtra("imagetext" ,"31");
					startActivity(intent);
				}
			});
			t32.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"پیاز");
					intent.putExtra("maintext"  ,"32");
					intent.putExtra("imagetext" ,"32");
					startActivity(intent);
				}
			});
			t33.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"موز");
					intent.putExtra("maintext"  ,"33");
					intent.putExtra("imagetext" ,"33");
					startActivity(intent);
				}
			});
			t34.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"انگور");
					intent.putExtra("maintext"  ,"34");
					intent.putExtra("imagetext" ,"34");
					startActivity(intent);
				}
			});
			t35.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"لیمو");
					intent.putExtra("maintext"  ,"35");
					intent.putExtra("imagetext" ,"35");
					startActivity(intent);
				}
			});
			t36.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"انار");
					intent.putExtra("maintext"  ,"36");
					intent.putExtra("imagetext" ,"36");
					startActivity(intent);
				}
			});
			t37.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"گوجه فرنگی");
					intent.putExtra("maintext"  ,"37");
					intent.putExtra("imagetext" ,"37");
					startActivity(intent);
				}
			});
			t38.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"خرما");
					intent.putExtra("maintext"  ,"38");
					intent.putExtra("imagetext" ,"38");
					startActivity(intent);
				}
			});
			t39.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"زیتون");
					intent.putExtra("maintext"  ,"39");
					intent.putExtra("imagetext" ,"39");
					startActivity(intent);
				}
			});
			t40.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"گلابی");
					intent.putExtra("maintext"  ,"40");
					intent.putExtra("imagetext" ,"40");
					startActivity(intent);
				}
			});
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.darookhane);
		mUi=new Ui(this);
	}
	

}
