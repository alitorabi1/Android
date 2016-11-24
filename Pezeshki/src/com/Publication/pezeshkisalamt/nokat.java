package com.Publication.pezeshkisalamt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;




public class nokat extends Activity {
private Ui mUi=null;
	
	private class Ui{
		
		private Activity mActivity;
		private ImageView t1;
		private ImageView t2;
		private ImageView t3;
		private ImageView t4;
		private ImageView t5;
		private ImageView t6;
		private ImageView t7;
		private ImageView t8;
		private ImageView t9;
		private ImageView t10;
		private ImageView t11;
		private ImageView t12;
		private ImageView t13;
		private ImageView t14;
		private ImageView t15;
		private ImageView t16;
		private ImageView t17;
		private ImageView t18;
		private ImageView t19;
		private ImageView t20;
		private ImageView t21;
		private ImageView t22;
		private ImageView t23;
		private ImageView t24;
		private ImageView t25;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			t1=(ImageView) findViewById(R.id.t1);
			t2=(ImageView) findViewById(R.id.t2);
			t3=(ImageView) findViewById(R.id.t3);
			t4=(ImageView) findViewById(R.id.t4);
			t5=(ImageView) findViewById(R.id.t5);
			t6=(ImageView) findViewById(R.id.t6);
			t7=(ImageView) findViewById(R.id.t7);
			t8=(ImageView) findViewById(R.id.t8);
			t9=(ImageView) findViewById(R.id.t9);
			t10=(ImageView) findViewById(R.id.t10);
			t11=(ImageView) findViewById(R.id.t11);
			t12=(ImageView) findViewById(R.id.t12);
			t13=(ImageView) findViewById(R.id.t13);
			t14=(ImageView) findViewById(R.id.t14);
			t15=(ImageView) findViewById(R.id.t15);
			t16=(ImageView) findViewById(R.id.t16);
			t17=(ImageView) findViewById(R.id.t17);
			t18=(ImageView) findViewById(R.id.t18);
			t19=(ImageView) findViewById(R.id.t19);
			t20=(ImageView) findViewById(R.id.t20);
			t21=(ImageView) findViewById(R.id.t21);
			t22=(ImageView) findViewById(R.id.t22);
			t23=(ImageView) findViewById(R.id.t23);
			t24=(ImageView) findViewById(R.id.t24);
			t25=(ImageView) findViewById(R.id.t25);
			
			
			
			
			
		}
		private void ejra() {
			
			t1.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"از چربی خون چه میدانیم؟");
					intent.putExtra("maintext"  ,"1");
					intent.putExtra("imagetext" ,"1");
					startActivity(intent);
				}
			});
			
			t2.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"چه کنیم بیمار نشویم؟");
					intent.putExtra("maintext"  ,"2");
					intent.putExtra("imagetext" ,"2");
					startActivity(intent);
				}
			});
			
			t3.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"درمان تب به روش خانگی");
					intent.putExtra("maintext"  ,"3");
					intent.putExtra("imagetext" ,"3");
					startActivity(intent);
				}
			});
			
			
			t4.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"مقابله با خارش نیش پشه");
					intent.putExtra("maintext"  ,"4");
					intent.putExtra("imagetext" ,"4");
					startActivity(intent);
				}
			});
			t5.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"ده توصیه ضد نفخ");
					intent.putExtra("maintext"  ,"5");
					intent.putExtra("imagetext" ,"5");
					startActivity(intent);
				}
			});
			
			
			t6.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"هفت راه برای توقف خروپف");
					intent.putExtra("maintext"  ,"6");
					intent.putExtra("imagetext" ,"6");
					startActivity(intent);
				}
			});
			
			t7.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"درمان تیرگی زیر چشم");
					intent.putExtra("maintext"  ,"7");
					intent.putExtra("imagetext" ,"7");
					startActivity(intent);
				}
			});
			
			t8.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"20کلید سلامتی برای مردان");
					intent.putExtra("maintext"  ,"8");
					intent.putExtra("imagetext" ,"8");
					startActivity(intent);
				}
			});
			t9.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"راهکارهای موثر برای تقویت تمرکز و حافظه");
					intent.putExtra("maintext"  ,"9");
					intent.putExtra("imagetext" ,"9");
					startActivity(intent);
				}
			});
			t10.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"پانزده دردی که در خانه درمان میشوند");
					intent.putExtra("maintext"  ,"10");
					intent.putExtra("imagetext" ,"10");
					startActivity(intent);
				}
			});
			t11.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"درمان جوش های سرسفید");
					intent.putExtra("maintext"  ,"11");
					intent.putExtra("imagetext" ,"11");
					startActivity(intent);
				}
			});
			t12.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"درمان مسمومیت های غذایی");
					intent.putExtra("maintext"  ,"12");
					intent.putExtra("imagetext" ,"12");
					startActivity(intent);
				}
			});
			t13.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"علائم افسردگی در مردان");
					intent.putExtra("maintext"  ,"13");
					intent.putExtra("imagetext" ,"13");
					startActivity(intent);
				}
			});
			t14.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"پیشگیری از سوزش سردل");
					intent.putExtra("maintext"  ,"14");
					intent.putExtra("imagetext" ,"14");
					startActivity(intent);
				}
			});
			t15.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"درمان گلودرد بدون دارو");
					intent.putExtra("maintext"  ,"15");
					intent.putExtra("imagetext" ,"15");
					startActivity(intent);
				}
			});
			t16.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"تفاوت درد آپاندیس با سایر دردها");
					intent.putExtra("maintext"  ,"16");
					intent.putExtra("imagetext" ,"16");
					startActivity(intent);
				}
			});
			t17.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"چگونه خواب آرامی داشته باشیم؟");
					intent.putExtra("maintext"  ,"17");
					intent.putExtra("imagetext" ,"17");
					startActivity(intent);
				}
			});
			t18.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"درمان بوی بد دهان با گیاهان");
					intent.putExtra("maintext"  ,"18");
					intent.putExtra("imagetext" ,"18");
					startActivity(intent);
				}
			});
			t19.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"چگونگی مراقبت از چشمانتان");
					intent.putExtra("maintext"  ,"19");
					intent.putExtra("imagetext" ,"19");
					startActivity(intent);
				}
			});
			t20.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"دلایل خواب رفتن دست و پا");
					intent.putExtra("maintext"  ,"20");
					intent.putExtra("imagetext" ,"20");
					startActivity(intent);
				}
			});
			t21.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"چگونه صدای خوبی داشته باشیم");
					intent.putExtra("maintext"  ,"21");
					intent.putExtra("imagetext" ,"21");
					startActivity(intent);
				}
			});
			t22.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"روش های جلوگیری از تعرق زیاد");
					intent.putExtra("maintext"  ,"22");
					intent.putExtra("imagetext" ,"22");
					startActivity(intent);
				}
			});
			t23.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"اگر استخر میروید بخوانید");
					intent.putExtra("maintext"  ,"23");
					intent.putExtra("imagetext" ,"23");
					startActivity(intent);
				}
			});
			t24.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"آب درمانی");
					intent.putExtra("maintext"  ,"24");
					intent.putExtra("imagetext" ,"24");
					startActivity(intent);
				}
			});
			t25.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"پف زیر چشم");
					intent.putExtra("maintext"  ,"25");
					intent.putExtra("imagetext" ,"25");
					startActivity(intent);
				}
			});
			
			
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nokat);
		mUi=new Ui(this);
	}
	

}
