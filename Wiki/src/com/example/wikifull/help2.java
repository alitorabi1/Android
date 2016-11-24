package com.example.wikifull;


import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.Reference.wikifull.R;



public class help2 extends Activity {
private Ui mUi=null;
	
	private class Ui{
		
		private TextView txt1;
		private TextView txt2;
		private TextView txt3;
		private TextView txt4;
		private TextView txt5;
		
		
		
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
		
			txt1=(TextView) findViewById(R.id.help2_txt1);
			txt2=(TextView) findViewById(R.id.help2_txt2);
			txt3=(TextView) findViewById(R.id.help2_txt3);
			txt4=(TextView) findViewById(R.id.help2_txt4);
			txt5=(TextView) findViewById(R.id.help2_txt5);
			
		}
		private void ejra() {
			
			Typeface fontdavat=Typeface.createFromAsset(getAssets(), "font/davat.ttf");
			Typeface fontyas=Typeface.createFromAsset(getAssets(), "font/yas.ttf");
			
			txt1.setTypeface(fontdavat);
			txt2.setTypeface(fontyas);
			txt3.setTypeface(fontyas);
			txt4.setTypeface(fontyas);
			txt5.setTypeface(fontyas);
			
			
			String text2="الف : برای آپدیت اطلاعات برنامه کافیست بر روی علامت فلش سبز رنگ گوشه سمت چپ بالای منو اصلی کلیک کنید"+"\n"+"در صورت وصل بودن اینترنت و موجود بودن اطلاعات جدید ، بروزرسانی با موفقیت انجام میشود";
			String text3="نکته مهم : به کمک این گزینه فقط اطلاعات داخلی برنامه به روز رسانی میشود و بروزرسانی اصلی برنامه فقط از طریق مارکت بازار صورت میگیرد";
			String text4="ب: فایل های دانلود شده در پوشه ویکی داخل حافظه داخلی دستگاه ذخیره میشوند";
			String text5="ج: در صورتی که بعد از اجرای فایلی پیغام"+"\n"+"Not Started"+"\n"+"را مشاهده کردید، بدان معناست که دستگاه شما قابلیت اجرای فایل مد نظر را ندارد ولی فایل دانلود شده است";
			String text6="";
			
			txt2.setText(text2);
			txt3.setText(text3);
			txt4.setText(text4);
			txt5.setText(text5);
			
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help2);
		mUi=new Ui(this);
	}
	

}
