package com.mysimcard.tools;

import android.inputmethodservice.Keyboard.Key;
import android.net.Uri;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.Toast;

import android.app.Activity;
import android.content.Intent;



public class ch_hamrah extends Activity {
	
	private Ui mUi=null;
	private DatabaseHandler01 dbHandler01;
	
	
	public class Ui{
		private ImageView mamooli;
		private ImageView send;
		private ImageView sandoogh;
		
		private Button m1 ;
		private Button m2 ;
		private Button m5 ;
		private Button m10 ;
		private Button m20 ;
		private Button m50 ;
		public String ch="خالی";
		
		
		private EditText txt_chcode_hamrahaval;
		public WebView web_hamrahaval;
		public String txt=null;
		
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
			
		}

		public void tarif() {
			web_hamrahaval=(WebView) findViewById(R.id.hamrahaval_web_web);
			mamooli=(ImageView) findViewById(R.id.hamrahaval_mamooli_kelid);
			txt_chcode_hamrahaval=(EditText) findViewById(R.id.chcode_hamrahaval);
			send=(ImageView) findViewById(R.id.hamrahaval_send_kelid);
			sandoogh=(ImageView) findViewById(R.id.hamrahaval_sandoogh_kelid);
			m1=(Button) findViewById(R.id.h1);
			m2=(Button) findViewById(R.id.h2);
			m5=(Button) findViewById(R.id.h5);
			m10=(Button) findViewById(R.id.h10);
			m20=(Button) findViewById(R.id.h20);
			m50=(Button) findViewById(R.id.h50);
		}

		private void ejra() {
			mamooli.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					txt = txt_chcode_hamrahaval.getText().toString();
					String encodedHash = Uri.encode("#");
					String ussd = "*"+"140"+"*" + encodedHash + txt+ encodedHash;
					startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:" + ussd)), 1);
				}
				
			});
			
			send.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					String shareBody = txt_chcode_hamrahaval.getText().toString();
				    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
				        sharingIntent.setType("text/plain");
				        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
				        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
				        startActivity(Intent.createChooser(sharingIntent, getResources().getString(R.string.app_name)));
					
				}
				
			});
			sandoogh.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					if(txt_chcode_hamrahaval.getText().toString().equals("")){
						Toast toast;
						toast = Toast.makeText(ch_hamrah.this, "لطفا کد شارژ را وارد نمایید",Toast.LENGTH_LONG);
				        toast.show();
					}
					else{
						
						m1.setVisibility(View.VISIBLE);
						m2.setVisibility(View.VISIBLE);
						m5.setVisibility(View.VISIBLE);
						m10.setVisibility(View.VISIBLE);
						m20.setVisibility(View.VISIBLE);
						//m50.setVisibility(View.VISIBLE);
						
					}
				}
				
			});
			
			
			
			
			
			
			
			
			m1.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					int sw=0;
					for(int i=1;i<11;i++){
						String o=dbHandler01.Display_Code(i).toString();
						if(o.equals(ch))
						{
							i++;
							dbHandler01.update_code(i, "آماده استفاده");
							dbHandler01.update_matn(i, txt_chcode_hamrahaval.getText().toString());
							dbHandler01.update_name(i, "همراه اول");
							dbHandler01.update_no(i, "000 1 تومانی");
							m1.setVisibility(View.INVISIBLE);
							m2.setVisibility(View.INVISIBLE);
							m5.setVisibility(View.INVISIBLE);
							m10.setVisibility(View.INVISIBLE);
							m20.setVisibility(View.INVISIBLE);
							m50.setVisibility(View.INVISIBLE);
							sw=1;
							break;
							
						}
					}
					if(sw==0){
						Toast toast;
			    		toast = Toast.makeText(ch_hamrah.this, "فضای خالی برای ذخیره سازی موجود نمیباشد",Toast.LENGTH_LONG);
			            toast.show();
					}
					if(sw==1){
						Toast toast;
			    		toast = Toast.makeText(ch_hamrah.this, "کد شارژ  همراه اول هزار تومانی با موفقت ذخیره شد",Toast.LENGTH_LONG);
			            toast.show();
					}
				
					
				}
				
			});
			m2.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					int sw=0;
					for(int i=1;i<11;i++){
						String o=dbHandler01.Display_Code(i).toString();
						if(o.equals(ch))
						{
							i++;
							dbHandler01.update_code(i, "آماده استفاده");
							dbHandler01.update_matn(i, txt_chcode_hamrahaval.getText().toString());
							dbHandler01.update_name(i, "همراه اول");
							dbHandler01.update_no(i, "000 2 تومانی");
							m1.setVisibility(View.INVISIBLE);
							m2.setVisibility(View.INVISIBLE);
							m5.setVisibility(View.INVISIBLE);
							m10.setVisibility(View.INVISIBLE);
							m20.setVisibility(View.INVISIBLE);
							m50.setVisibility(View.INVISIBLE);
							sw=1;
							break;
						}
					}
					if(sw==0){
						Toast toast;
			    		toast = Toast.makeText(ch_hamrah.this, "فضای خالی برای ذخیره سازی موجود نمیباشد",Toast.LENGTH_LONG);
			            toast.show();
					}
					if(sw==1){
						Toast toast;
			    		toast = Toast.makeText(ch_hamrah.this, "کد شارژ  همراه اول دوهزار تومانی با موفقت ذخیره شد",Toast.LENGTH_LONG);
			            toast.show();
					}
					
				}
				
			});
			m5.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					int sw=0;
					for(int i=1;i<11;i++){
						String o=dbHandler01.Display_Code(i).toString();
						if(o.equals(ch))
						{
							i++;
							dbHandler01.update_code(i, "آماده استفاده");
							dbHandler01.update_matn(i, txt_chcode_hamrahaval.getText().toString());
							dbHandler01.update_name(i, "همراه اول");
							dbHandler01.update_no(i, "000 5 تومانی");
							m1.setVisibility(View.INVISIBLE);
							m2.setVisibility(View.INVISIBLE);
							m5.setVisibility(View.INVISIBLE);
							m10.setVisibility(View.INVISIBLE);
							m20.setVisibility(View.INVISIBLE);
							m50.setVisibility(View.INVISIBLE);
							sw=1;
							break;
						}
					}
					if(sw==0){
						Toast toast;
			    		toast = Toast.makeText(ch_hamrah.this, "فضای خالی برای ذخیره سازی موجود نمیباشد",Toast.LENGTH_LONG);
			            toast.show();
					}
					if(sw==1){
						Toast toast;
			    		toast = Toast.makeText(ch_hamrah.this, "کد شارژ  همراه اول پنج هزار تومانی با موفقت ذخیره شد",Toast.LENGTH_LONG);
			            toast.show();
					}
					
				}
				
			});
			m10.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					int sw=0;
					for(int i=1;i<11;i++){
						String o=dbHandler01.Display_Code(i).toString();
						if(o.equals(ch))
						{
							i++;
							dbHandler01.update_code(i, "آماده استفاده");
							dbHandler01.update_matn(i, txt_chcode_hamrahaval.getText().toString());
							dbHandler01.update_name(i, "همراه اول");
							dbHandler01.update_no(i, "000 10 تومانی");
							m1.setVisibility(View.INVISIBLE);
							m2.setVisibility(View.INVISIBLE);
							m5.setVisibility(View.INVISIBLE);
							m10.setVisibility(View.INVISIBLE);
							m20.setVisibility(View.INVISIBLE);
							m50.setVisibility(View.INVISIBLE);
							sw=1;
							break;
							
						}
					}
					if(sw==0){
						Toast toast;
			    		toast = Toast.makeText(ch_hamrah.this, "فضای خالی برای ذخیره سازی موجود نمیباشد",Toast.LENGTH_LONG);
			            toast.show();
					}
					if(sw==1){
						Toast toast;
			    		toast = Toast.makeText(ch_hamrah.this, "کد شارژ  همراه اول ده هزار تومانی با موفقت ذخیره شد",Toast.LENGTH_LONG);
			            toast.show();
					}
					
				}
				
			});
			m20.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					int sw=0;
					for(int i=1;i<11;i++){
						String o=dbHandler01.Display_Code(i).toString();
						if(o.equals(ch))
						{
							i++;
							dbHandler01.update_code(i, "آماده استفاده");
							dbHandler01.update_matn(i, txt_chcode_hamrahaval.getText().toString());
							dbHandler01.update_name(i, "همراه اول");
							dbHandler01.update_no(i, "000 20 تومانی");
							m1.setVisibility(View.INVISIBLE);
							m2.setVisibility(View.INVISIBLE);
							m5.setVisibility(View.INVISIBLE);
							m10.setVisibility(View.INVISIBLE);
							m20.setVisibility(View.INVISIBLE);
							m50.setVisibility(View.INVISIBLE);
							sw=1;
							break;
							
						}
					}
					if(sw==0){
						Toast toast;
			    		toast = Toast.makeText(ch_hamrah.this, "فضای خالی برای ذخیره سازی موجود نمیباشد",Toast.LENGTH_LONG);
			            toast.show();
					}
					if(sw==1){
						Toast toast;
			    		toast = Toast.makeText(ch_hamrah.this, "کد شارژ  همراه اول بیست هزار تومانی با موفقت ذخیره شد",Toast.LENGTH_LONG);
			            toast.show();
					}
					
				}
				
			});
			m50.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					int sw=0;
					for(int i=1;i<11;i++){
						String o=dbHandler01.Display_Code(i).toString();
						if(o.equals(ch))
						{
							i++;
							dbHandler01.update_code(i, "آماده استفاده");
							dbHandler01.update_matn(i, txt_chcode_hamrahaval.getText().toString());
							dbHandler01.update_name(i, "همراه اول");
							dbHandler01.update_no(i, "000 50 تومانی");
							m1.setVisibility(View.INVISIBLE);
							m2.setVisibility(View.INVISIBLE);
							m5.setVisibility(View.INVISIBLE);
							m10.setVisibility(View.INVISIBLE);
							m20.setVisibility(View.INVISIBLE);
							m50.setVisibility(View.INVISIBLE);
							sw=1;
							break;
						}	
					}
					if(sw==0){
						Toast toast;
			    		toast = Toast.makeText(ch_hamrah.this, "فضای خالی برای ذخیره سازی موجود نمیباشد",Toast.LENGTH_LONG);
			            toast.show();
					}
					if(sw==1){
						Toast toast;
			    		toast = Toast.makeText(ch_hamrah.this, "کد شارژ  همراه اول پنجاه هزار تومانی با موفقت ذخیره شد",Toast.LENGTH_LONG);
			            toast.show();
					}
					
				}
				
			});
			
			
			
			
			
			
			
			
			
			
			
			web_hamrahaval.getSettings().setJavaScriptEnabled(true);
			web_hamrahaval.loadUrl("http://www.ir-charge.com");
			web_hamrahaval.setWebViewClient(new webs());
		}
	}
	private class webs extends WebViewClient{
		public boolean brows(WebView webview,String URL){
		webview.loadUrl(URL);
		return true;
		}
		
	}
	public boolean OnKeyDown(int keycode,KeyEvent Event){
		mUi = new Ui(this);
		if((keycode == KeyEvent.KEYCODE_BACK)&&  mUi.web_hamrahaval.canGoBack()){
		mUi.web_hamrahaval.canGoBack();
		return true;
	}
		return super.onKeyDown(keycode, Event);
		}
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ch_hamrah);
		String msg="در حال اتصال ...";
		dbHandler01=new DatabaseHandler01(this);
		
		mUi=new Ui(this);
		Toast toast;
		toast = Toast.makeText(ch_hamrah.this, msg,Toast.LENGTH_LONG);
        toast.show();
        toast = Toast.makeText(ch_hamrah.this, "لطفا برای جلوگیری از بروز خطا از درگاه پرداخت بانک ملت استفاده کنید",Toast.LENGTH_SHORT);
        toast.show();
	}
	protected void onResume() {
		super.onResume();
		dbHandler01.open();	
	}

	@Override
	protected void onPause() {
		super.onPause();
		dbHandler01.close();	
		
	}
}
