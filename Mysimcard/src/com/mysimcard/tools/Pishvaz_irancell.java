package com.mysimcard.tools;



import android.os.Bundle;
import android.view.KeyEvent;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import android.app.Activity;
import android.content.Intent;



public class Pishvaz_irancell extends Activity {
	
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
			wb=(WebView) findViewById(R.id.webp_irancell);
			
		}

		private void ejra() {
			
			wb.getSettings().setJavaScriptEnabled(true);
			wb.loadUrl("http://vitrin.irancell.ir/");
			wb.setWebViewClient(new webs());
			
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
		setContentView(R.layout.pishvaz_irancell);
	
		
		Toast toast;
		toast = Toast.makeText(Pishvaz_irancell.this, "در حال اتصال به سایت ایرانسل",Toast.LENGTH_LONG);
        toast.show();
        
        
		
       
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
