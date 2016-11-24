package com.example.wikifull;


import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.Reference.wikifull.R;


public class about extends Activity {
private Ui mUi=null;
	
	private class Ui{
		
		private TextView txt1;
		private TextView txt2;
		private TextView txt3;
		private TextView txt4;
		private TextView txt5;
		private TextView txt6;
		private TextView txt7;
		private TextView textv;
		
		
		
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
		
			
			txt1=(TextView) findViewById(R.id.about_txt1);
			txt2=(TextView) findViewById(R.id.about_txt2);
			txt3=(TextView) findViewById(R.id.about_txt3);
			txt4=(TextView) findViewById(R.id.about_txt4);
			txt5=(TextView) findViewById(R.id.about_txt5);
			txt6=(TextView) findViewById(R.id.about_txt6);
			txt7=(TextView) findViewById(R.id.about_txt7);
			textv=(TextView) findViewById(R.id.textv);

			
			
			
		}
		private void ejra() {
			
			Typeface fontdavat=Typeface.createFromAsset(getAssets(), "font/davat.ttf");
			Typeface fontyas=Typeface.createFromAsset(getAssets(), "font/yas.ttf");
			Typeface fonttime=Typeface.createFromAsset(getAssets(), "font/time.ttf");
			Typeface fonthoma=Typeface.createFromAsset(getAssets(), "font/homa.ttf");
			
			
			
			String text1="ویکی";
			txt1.setText(text1);
			txt1.setTypeface(fontdavat);
			
			
			String text2="کاربر گرامی در جمع آوری این مجموعه تمام سعی و تلاش خود را کرده ایم تا تنها مقالاتی که از سوی صاحب اثر اجازه انتشار دارند را قرار دهیم"+"\n"+"لذا در صورتی که مقاله ، آموزش و یا پروژه ای که حق کپی رایت آن محفوظ و یا صاحب اثر آن اجازه انتشار عمومی را نداده است را با ذکر نام خود و نام اثر به آدرس ایمیل";
			txt2.setText(text2);
			txt2.setTypeface(fontyas);
			
			
			String text3="mywiki@mail.com";
			txt3.setText(text3);
			txt3.setTypeface(fonttime);
			
			String text4="با موضوع درخواست حذف فایل ارسال کرده تا نسبت به عدم انتشار آن اقدام گردد";
			txt4.setText(text4);
			txt4.setTypeface(fontyas);
			
			
			String text5="همچنین در صورتی که تمایل به همکاری با ما را دارید می توانید فایل آموزش و یا مقاله خود را با ذکر نام و توضیحات به آدرس ایمیل";
			txt5.setText(text5);
			txt5.setTypeface(fontyas);
			
			
			String text6="mywiki@mail.com";
			txt6.setText(text6);
			txt6.setTypeface(fonttime);
			
			
			String text7="ارسال کرده تا در صورتی که واجد شرایط بود به نام خودتان انتشار یابد";
			txt7.setText(text7);
			txt7.setTypeface(fontyas);
			
			
			String text8="نسخه : کامل";
			textv.setText(text8);
			textv.setTypeface(fonthoma);
			
			
			
			
			
			
			
			
			
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		mUi=new Ui(this);
	}
	

}
