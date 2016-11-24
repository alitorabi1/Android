package com.mysimcard.tools;

import android.inputmethodservice.Keyboard.Key;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
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



public class chm_irancell extends Activity {
	
	private Ui mUi=null;
	
	
	public class Ui{
		public WebView wb;
		private Activity mActivity;
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
			
		}

		public void tarif() {
			wb=(WebView) findViewById(R.id.webm_irancell);
			
		}

		private void ejra() {
			
			
			Bundle extras = getIntent().getExtras();
		    String value1 = extras.getString("bill");
		    
		    
		    if(value1.toString().equals("1")){
		    	
		    	wb.getSettings().setJavaScriptEnabled(true);
				wb.loadUrl("http://www.ir-charge.com/bill");
				wb.setWebViewClient(new webs());
				Toast toast;
				toast = Toast.makeText(chm_irancell.this, "در حال اتصال ...",Toast.LENGTH_SHORT);
		        toast.show();
		    }
		    else
		    {
		    	Toast toast;
				toast = Toast.makeText(chm_irancell.this, "در حال اتصال به فروشگاه اینترنتی ...",Toast.LENGTH_SHORT);
		        toast.show();
		        toast = Toast.makeText(chm_irancell.this, "لطفا برای جلوگیری از بروز خطا از درگاه پرداخت بانک ملت استفاده کنید",Toast.LENGTH_SHORT);
		        toast.show();
		    	wb.getSettings().setJavaScriptEnabled(true);
				wb.loadUrl("http://www.ir-charge.com/directcharge");
				wb.setWebViewClient(new webs());
		    }
			
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
		if((keycode == KeyEvent.KEYCODE_BACK)&&  mUi.wb.canGoBack()){
		mUi.wb.canGoBack();
		return true;
	}
		return super.onKeyDown(keycode, Event);
		}
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chm_irancell);
		
		mUi=new Ui(this);
	
	}
	protected void onResume() {
		super.onResume();
				
	}

	@Override
	protected void onPause() {
		super.onPause();
		
		
	}
}
