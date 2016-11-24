package com.mysimcard.tools;

import android.inputmethodservice.Keyboard.Key;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
public class Pishvaz_hamrah extends Activity {
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
			wb=(WebView) findViewById(R.id.webp_hamrah);	
		}
		private void ejra() {	
			wb.getSettings().setJavaScriptEnabled(true);
			wb.loadUrl("http://rbt.mci.ir/");
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
		setContentView(R.layout.pishvaz_hamrah);
		mUi=new Ui(this);
		Toast toast;
		toast = Toast.makeText(Pishvaz_hamrah.this, "در حال اتصال به سایت همراه اول",Toast.LENGTH_LONG);
        toast.show();
	}
	protected void onResume() {
		super.onResume();
				
	}

	@Override
	protected void onPause() {
		super.onPause();
		
		
	}
}
