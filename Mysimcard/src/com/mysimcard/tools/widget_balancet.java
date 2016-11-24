package com.mysimcard.tools;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;




public class widget_balancet extends Activity {
			
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String encodedHash = Uri.encode("#");
		String ussd = "*"+"140"+ encodedHash;
		startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:" + ussd)), 1);
		finish();
	}

	
}
