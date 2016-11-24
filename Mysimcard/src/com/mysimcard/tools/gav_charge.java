package com.mysimcard.tools;



import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class gav_charge extends Activity {
private Ui mUi=null;
private DatabaseHandler01 dbHandler01;
 	

	
	private class Ui{
		private TextView matn;
	 	private TextView code;
	 	private TextView arzesh;
	 	
	 	private EditText ntext;
	 	
	 	private ImageView tk;
	 	private ImageView cs;
	 	private ImageView cm;
	 	private ImageView sma;
	 	private ImageView smo;
	 	private ImageView h;
	 	private ImageView htext;
	 	private ImageView hno;
	 	private ImageView hyes;
	 	
	 	
	 	
	 	private Typeface fmatn;
	 	private Typeface fcode;
	 	private Typeface fvaz;
	 	
	 	
	 	private int a=0;
	 	private int b=0;
	 	private int r=0;
	 	private String d;
	 	
	 	
		private Activity mActivity;
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			
			final Timer t = new Timer();
	        t.scheduleAtFixedRate(new TimerTask() 
	        {
				public void run() 
				{
					runOnUiThread(new Runnable() 
					{
						public void run() 
						{
							
		
								t.cancel();
								ejra();
							
							
						}
						
					});
				}
	        	
	        }, 1, 100);
			
		}
		
		// به روز رسانی متن نمایشی
		private void arzeshi(){
			String s=dbHandler01.Display_Code(b);
			arzesh.setText(s);
			if(s.equals("استفاده شده برای یک دوست")){
				arzesh.setTextColor(Color.RED);
			}
			if(s.equals("استفاده شده")){
				arzesh.setTextColor(Color.RED);
			}
			if(s.equals("ارسال شده برای یک دوست")){
				arzesh.setTextColor(Color.MAGENTA);
			}
			if(s.equals("آماده استفاده")){
				arzesh.setTextColor(Color.GREEN);
			}
			
		}
		private void tarif() {
			
			matn=(TextView) findViewById(R.id.gav_charge_matn);
			code=(TextView) findViewById(R.id.gav_charge_code);
			arzesh=(TextView) findViewById(R.id.gav_charge_arzesh);
			
			ntext=(EditText) findViewById(R.id.gav_charge_ntext);
			
			tk=(ImageView) findViewById(R.id.gav_charge_tk);
			cs=(ImageView) findViewById(R.id.gav_charge_cs);
			cm=(ImageView) findViewById(R.id.gav_charge_cm);
			sma=(ImageView) findViewById(R.id.gav_charge_sma);
			smo=(ImageView) findViewById(R.id.gav_charge_smo);
			h=(ImageView) findViewById(R.id.gav_charge_h);
			htext=(ImageView) findViewById(R.id.hazf_text);
			hno=(ImageView) findViewById(R.id.hazf_no);
			hyes=(ImageView) findViewById(R.id.hazf_yes);
			
			fmatn=Typeface.createFromAsset(getAssets(), "font/bardiya.ttf"+"");
			fcode=Typeface.createFromAsset(getAssets(), "font/tekton.ttf"+"");
			fvaz=Typeface.createFromAsset(getAssets(), "font/koodak.ttf"+"");
			
			matn.setTypeface(fmatn);
			code.setTypeface(fcode);
			arzesh.setTypeface(fvaz);
		
			
		}
		
		
		
		private void ejra() {
			
			Bundle extras = getIntent().getExtras();
		    String value1 = extras.getString("name");
		    b=Integer.parseInt(value1.toString());
		    r=b;
		    r++;
		    String c=dbHandler01.Display_Name(b)+""+dbHandler01.Display_No(b);
		    matn.setText(c);
		    code.setText(dbHandler01.Display_Matn(b));
			d=dbHandler01.Display_Name(b);	    
		    arzeshi();
		   
		    
		    
		    tk.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					
					// اجرای کد ارسال مستقیم برای ایرانسل
					String encodedHash = Uri.encode("#");
					String ussd = "*"+"141"+"*" + code.getText().toString()+"*"+ntext.getText().toString() + encodedHash;
					startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:" + ussd)), 1);
					dbHandler01.update_code(r, "استفاده شده برای یک دوست");
					arzeshi();
				}
		    });
		    cs.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					
					// استفاده کد برای ایرانسل
					if(d.equals("ایرانسل"))
					{
					String encodedHash = Uri.encode("#");
					String ussd = "*"+"144"+"*" +code.getText().toString()+ encodedHash;
					startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:" + ussd)), 1);
					dbHandler01.update_code(r, "استفاده شده");
					arzeshi();
					}
					else
					{
						Toast toast;
						toast = Toast.makeText(gav_charge.this, "این قابلیت فقط برای ایرانسل فعال می باشد",Toast.LENGTH_LONG);
				        toast.show();
					}
				}
		    });
		    cm.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					
					// شارژ معمولی با تشخیص نوع سیم کارت
					if(d.equals("ایرانسل"))
					{
					String encodedHash = Uri.encode("#");
					String ussd = "*"+"141"+"*" +code.getText().toString()+ encodedHash;
					startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:" + ussd)), 1);
					}
					
					if(d.equals("همراه اول"))
					{
					String encodedHash = Uri.encode("#");
					String ussd = "*"+"140"+"*" + encodedHash + code.getText().toString()+ encodedHash;
					startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:" + ussd)), 1);
					}
					
					if(d.equals("تالیا"))
					{
					String encodedHash = Uri.encode("#");
					String ussd = "*"+"140"+"*" +code.getText().toString()+ encodedHash;
					startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:" + ussd)), 1);
					}
					
					if(d.equals("رایتل"))
					{
					String encodedHash = Uri.encode("#");
					String ussd = "*"+"140"+"*" + code.getText().toString()+ encodedHash;
					startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:" + ussd)), 1);
					}
					dbHandler01.update_code(r, "استفاده شده");
					arzeshi();
				}
		    });
		   
		    sma.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					// قطعه کد لازم برای به اشتراک گذاری کد خریداری شده
					String shareBody = code.getText().toString();
				    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
				        sharingIntent.setType("text/plain");
				        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "");
				        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
				        startActivity(Intent.createChooser(sharingIntent, "نوع ارسال"));
				    //
				        
				    // به روزرسانی فیلد مربوط به وضعیت کد شارژ
				        dbHandler01.update_code(r, "ارسال شده برای یک دوست");
				        
				    // تفراخوانی ابع تعویض متن برای نمایش
				        arzeshi();
					
				}
		    });
		    smo.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					
					// کلید گرفتن شماره دوست برای شارژ
					if(d.equals("ایرانسل")){
						if(a==0){
							ntext.setVisibility(View.VISIBLE);
							tk.setVisibility(View.VISIBLE);
							a=1;
						}else{
							ntext.setVisibility(View.INVISIBLE);
							tk.setVisibility(View.INVISIBLE);
							a=0;
						}
					}
					else
					{
						Toast toast;
						toast = Toast.makeText(gav_charge.this, "این قابلیت فقط برای ایرانسل فعال می باشد",Toast.LENGTH_LONG);
				        toast.show();
					}
					
				}
		    });
		    h.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					
					cm.setVisibility(View.INVISIBLE);
					cs.setVisibility(View.INVISIBLE);
					sma.setVisibility(View.INVISIBLE);
					smo.setVisibility(View.INVISIBLE);
					h.setVisibility(View.INVISIBLE);
					matn.setVisibility(View.INVISIBLE);
					code.setVisibility(View.INVISIBLE);
					tk.setVisibility(View.INVISIBLE);
					ntext.setVisibility(View.INVISIBLE);
					
					hno.setVisibility(View.VISIBLE);
					hyes.setVisibility(View.VISIBLE);
					htext.setVisibility(View.VISIBLE);
					
				}
		    });
		    hno.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					
					cm.setVisibility(View.VISIBLE);
					cs.setVisibility(View.VISIBLE);
					sma.setVisibility(View.VISIBLE);
					smo.setVisibility(View.VISIBLE);
					h.setVisibility(View.VISIBLE);
					matn.setVisibility(View.VISIBLE);
					code.setVisibility(View.VISIBLE);
					hno.setVisibility(View.INVISIBLE);
					hyes.setVisibility(View.INVISIBLE);
					htext.setVisibility(View.INVISIBLE);
				}
		    });
		    hyes.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					
					dbHandler01.update_matn(r, "");
					dbHandler01.update_code(r, "خالی");
					dbHandler01.update_name(r, "");
					dbHandler01.update_no(r, "");
					Toast toast;
					toast = Toast.makeText(gav_charge.this, "کد شارژ مورد نظر حذف شد",Toast.LENGTH_LONG);
			        toast.show();
			        finish();
				}
		    });
		    
		}

	}
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gav_charge);
		dbHandler01=new DatabaseHandler01(this);
		
		
	}
	protected void onResume() {
		super.onResume();
		dbHandler01.open();
		mUi=new Ui(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		dbHandler01.close();
		
	}
	

}
