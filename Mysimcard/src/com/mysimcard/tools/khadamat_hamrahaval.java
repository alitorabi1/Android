package com.mysimcard.tools;


import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class khadamat_hamrahaval extends ListActivity {
	
	
	private String txt="";
	private static final String[] items = {"دریافت رمز یکبار مصرف", "دریافت رمز دوم", "ثبت نام سرویس خدمات خاص", 
		"فعال سازی آوای انتظار", "غیر فعال سازی آوای انتظار", "تغییر آهنگ آوای انتظار", "فعال سازی اینترنت", "غیر فعال سازی اینترنت", "خرید بسته اینترنتی", 
		"پیغامگیر صوتی", "انتظار مکالمه", "انتقال مکالمه", "محدودیت مکالمه", "انجمن دوستداران فوتبال", 
		"بسته ی پیامک صدتایی", "بسته ی پیامک سیصدتایی", "بسته ی پیامک پانصدتایی", "بسته ی پیامک هزارتایی", "بسته اینترنت یک روزه","بسته اینترنت یک هفته ای","بسته اینترنت یک ماهه","بسته اینترنت یک ماهه شبانه"
		,"بسته اینترنت شش ماهه"};
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.khadamat_hamrahaval);
        setListAdapter(new ArrayAdapter<String>(this,R.layout.row, R.id.label, items));   

	}
	
	public void onListItemClick(ListView parent, View v, int position, long id){
    	txt=items[position];
    	if(txt == "دریافت رمز یکبار مصرف"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "دریافت رمز یکبار مصرف");
			intent.putExtra("text"  ,"*111*211");
			startActivity(intent);
			
			
    	}
    	else if(txt == "دریافت رمز دوم"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "دریافت رمز دوم");
			intent.putExtra("text"  ,"*111*212");
			startActivity(intent);
    		
    		
    	}
    	else if(txt == "ثبت نام سرویس خدمات خاص"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "ثبت نام سرویس خدمات خاص");
			intent.putExtra("text"  ,"*111*213");
			startActivity(intent);
			
    		
    		
    	}else if(txt == "فعال سازی آوای انتظار"){
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "فعال سازی آوای انتظار");
			intent.putExtra("text"  ,"*111*221");
			startActivity(intent);
    		
    		
    		
    	}else if(txt == "غیر فعال سازی آوای انتظار"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "غیر فعال سازی آوای انتظار");
			intent.putExtra("text"  ,"*111*222");
			startActivity(intent);
			
    		
    		
    	}else if(txt == "تغییر آهنگ آوای انتظار"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "تغییر آهنگ آوای انتظار");
			intent.putExtra("text"  ,"*111*223");
			startActivity(intent);
			
    		
    		
    	}else if(txt == "فعال سازی اینترنت"){
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "فعال سازی اینترنت");
			intent.putExtra("text"  ,"*111*231");
			startActivity(intent);
			
    		
    	}else if(txt == "غیر فعال سازی اینترنت"){
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "غیر فعال سازی اینترنت");
			intent.putExtra("text"  ,"*111*232");
			startActivity(intent);
			
    		
    		
    	}else if(txt == "خرید بسته اینترنتی"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "خرید بسته اینترنتی");
			intent.putExtra("text"  ,"*111*233");
			startActivity(intent);
			
    		
    		
    	}else if(txt == "پیغامگیر صوتی"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "پیغامگیر صوتی");
			intent.putExtra("text"  ,"*111*241");
			startActivity(intent);
    		
    		
    		
    	}else if(txt == "انتظار مکالمه"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "انتظار مکالمه");
			intent.putExtra("text"  ,"*111*242");
			startActivity(intent);
			
    		
    		
    	}else if(txt == "انتقال مکالمه"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "انتقال مکالمه");
			intent.putExtra("text"  ,"*111*243");
			startActivity(intent);
			
    		
    		
    	}else if(txt == "محدودیت مکالمه"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "محدودیت مکالمه");
			intent.putExtra("text"  ,"*111*244");
			startActivity(intent);
			
    		
    		
    	}else if(txt == "انجمن دوستداران فوتبال"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  ,"انجمن دوستداران فوتبال");
			intent.putExtra("text"  ,"*111*251");
			startActivity(intent);
			
    		
    		
    	}else if(txt == "بسته ی پیامک صدتایی"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "بسته ی پیامک صدتایی");
			intent.putExtra("text"  ,"*111*311");
			startActivity(intent);
			
    		
    		
    	}else if(txt == "بسته ی پیامک سیصدتایی"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "بسته ی پیامک سیصدتایی");
			intent.putExtra("text"  ,"*111*312");
			startActivity(intent);
			
    		
    		
    	}else if(txt =="بسته ی پیامک پانصدتایی"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "بسته ی پیامک پانصدتایی");
			intent.putExtra("text"  ,"*111*313");
			startActivity(intent);
			
    		
    		
    		
    	}else if(txt == "بسته ی پیامک هزارتایی"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "بسته ی پیامک هزارتایی");
			intent.putExtra("text"  ,"*111*314");
			startActivity(intent);
			
    		
    		
    	}else if(txt == "بسته اینترنت یک روزه"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "بسته اینترنت یک روزه");
			intent.putExtra("text"  ,"*111*321");
			startActivity(intent);
			
    		
    		
    	}else if(txt == "بسته اینترنت یک هفته ای"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "بسته اینترنت یک هفته ای");
			intent.putExtra("text"  ,"*111*322");
			startActivity(intent);
			
    		
    		
    	}else if(txt =="بسته اینترنت یک ماهه"){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "بسته اینترنت یک ماهه");
			intent.putExtra("text"  ,"*111*323");
			startActivity(intent);
			
    		
    		
    	}else if(txt =="بسته اینترنت یک ماهه شبانه" ){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  , "بسته اینترنت یک ماهه شبانه");
			intent.putExtra("text"  ,"*111*324");
			startActivity(intent);
			
    		
    		
    	}else if(txt =="بسته اینترنت شش ماهه" ){
    		
    		Intent intent = new Intent(getApplicationContext(),ussd.class);
			intent.putExtra("titr"  ,"بسته اینترنت شش ماهه");
			intent.putExtra("text"  ,"*111*325");
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
