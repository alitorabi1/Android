package com.mysimcard.tools;


import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;



public class khadamat_irancell extends ListActivity {
	
	private String txt="";
	private static final String[] items = {"دریافت تنظیمات gprs", "دریافت تنظیمات mms","منوی آهنگ پیشواز", "فعال سازی طرح قرمز ماهیانه", 
		"فعال سازی طرح قرمز هفتگی", "فعال سازی طرح آبی ماهیانه", "فعال سازی طرح آبی هفتگی", "فعال سازی طرح طلایی ماهیانه", "فعال سازی طرح طلایی هفتگی", "تخفیف پله ای ماهیانه", 
		"جی پی آر اس یک روزه 125 مگابایت", "جی پی آر اس هفت روزه 600 مگابایت", "جی پی آر اس یک ماهه 200 مگابایت", "جی پی آر اس یک ماهه دو گیگابایت", "ثبت شماره در فهرست طلایی", "حذف شماره از فهرست طلایی", 
		"مشاهده فهرست طلایی", "فعال سازی رومینگ", "غیر فعال سازی رومینگ", "تغییر تعرفه", "سرویس خط به خط","فعال کردن پیامک صوتی","غیر فعال کردن پیامک صوتی","نما"};
	
	

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.khadamat_irancell);
		
        setListAdapter(new ArrayAdapter<String>(this,R.layout.row, R.id.label, items));   
	}
	public void onListItemClick(ListView parent, View v, int position, long id){
    	txt=items[position];
    	if(txt == "دریافت تنظیمات gprs"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  ,"دریافت تنظیمات GPRS");
			intent.putExtra("text"  ,"*140*3*6");
			startActivity(intent);
    		
    	
    	}
    	else if(txt == "دریافت تنظیمات mms"){
    		
    		
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  ,"دریافت تنظیمات mms");
			intent.putExtra("text"  ,"*140*3*5");
			startActivity(intent);
			
    		
    	}
    	else if(txt == "منوی آهنگ پیشواز"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  ,"منوی آهنگ پیشواز");
			intent.putExtra("text"  ,"*777");
			startActivity(intent);
    	}
    	else if(txt == "فعال سازی طرح قرمز ماهیانه"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  ,"فعال سازی طرح قرمز ماهیانه");
			intent.putExtra("text"  ,"*140*7*5*3*3");
			startActivity(intent);
			
    		
    	}else if(txt == "فعال سازی طرح قرمز هفتگی"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  ,"فعال سازی طرح قرمز هفتگی");
			intent.putExtra("text"  ,"*140*7*5*2*3");
			startActivity(intent);
    		
    		
    	}else if(txt == "فعال سازی طرح آبی ماهیانه"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  ,"فعال سازی طرح آبی ماهیانه");
			intent.putExtra("text"  ,"*140*7*5*3*2");
			startActivity(intent);
			
    		
    	}else if(txt == "فعال سازی طرح آبی هفتگی"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  ,"فعال سازی طرح آبی هفتگی");
			intent.putExtra("text"  ,"*140*7*5*2*2");
			startActivity(intent);
			
    		
    	}else if(txt == "فعال سازی طرح طلایی ماهیانه"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  ,"فعال سازی طرح طلایی ماهیانه");
			intent.putExtra("text"  ,"*140*7*5*3*1");
			startActivity(intent);
			
    		
    	}else if(txt == "فعال سازی طرح طلایی هفتگی"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  ,"فعال سازی طرح طلایی هفتگی");
			intent.putExtra("text"  ,"*140*7*5*2*1");
			startActivity(intent);
			
    		
    	}else if(txt == "تخفیف پله ای ماهیانه"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  ,"تخفیف پله ای ماهیانه");
			intent.putExtra("text"  ,"*140*7*3");
			startActivity(intent);
			
    		
    	}else if(txt == "جی پی آر اس یک روزه 125 مگابایت"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  ,"جی پی آر اس یک روزه 125 مگابایت");
			intent.putExtra("text"  ,"*140*3*7*1*1");
			startActivity(intent);
			
    		
    	}else if(txt == "جی پی آر اس هفت روزه 600 مگابایت"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  ,"جی پی آر اس هفت روزه 600 مگابایت");
			intent.putExtra("text"  ,"*140*3*7*1*2");
			startActivity(intent);
			
    		
    	}else if(txt == "جی پی آر اس یک ماهه 200 مگابایت"){

    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  ,"جی پی آر اس یک ماهه 200 مگابایت");
			intent.putExtra("text"  ,"*140*3*7*1*4");
			startActivity(intent);
			
    		
    	}else if(txt == "جی پی آر اس یک ماهه دو گیگابایت"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  ,"جی پی آر اس یک ماهه دو گیگابایت");
			intent.putExtra("text"  ,"*140*3*7*1*3");
			startActivity(intent);
    		
    		
    	}else if(txt == "ثبت شماره در فهرست طلایی"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  ,"ثبت شماره در فهرست طلایی");
			intent.putExtra("text"  ,"*140*3*4*1");
			startActivity(intent);
			
    		
    	}else if(txt == "حذف شماره از فهرست طلایی"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  ,"حذف شماره از فهرست طلایی");
			intent.putExtra("text"  ,"*140*3*4*2");
			startActivity(intent);
			
    		
    	}else if(txt == "مشاهده فهرست طلایی"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  ,"مشاهده فهرست طلایی");
			intent.putExtra("text"  ,"*140*3*4*3");
			startActivity(intent);
			
    		
    	}else if(txt =="فعال سازی رومینگ"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  ,"فعال سازی رومینگ");
			intent.putExtra("text"  ,"*111*1");
			startActivity(intent);
    		
    		
    	}else if(txt == "غیر فعال سازی رومینگ"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  ,"غیر فعال سازی رومینگ");
			intent.putExtra("text"  , "*111*2");
			startActivity(intent);
    		
    		
    		
    	}else if(txt == "تغییر تعرفه"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "تغییر تعرفه");
			intent.putExtra("text"  , "*140*7*1");
			startActivity(intent);
			
    		
    	}else if(txt == "سرویس خط به خط"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "سرویس خط به خط");
			intent.putExtra("text"  , "*142");
			startActivity(intent);
			
    		
    		
    	}else if(txt == "فعال کردن پیامک صوتی"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "فعال کردن پیامک صوتی");
			intent.putExtra("text"  , "*140*3*1*1");
			startActivity(intent);
			
    		
    		
    	}else if(txt == "غیر فعال کردن پیامک صوتی"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "غیر فعال کردن پیامک صوتی");
			intent.putExtra("text"  , "*140*3*1*2");
			startActivity(intent);
			
			
    		
    		
    	}else if(txt == "نما"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "نما");
			intent.putExtra("text"  , "*898");
			startActivity(intent);
			
    		
    	}
    	
    }
	protected void onResume() {
		super.onResume();
				
	}

	@Override
	protected void onPause() {
		super.onPause();
		
		
	}
	

}
