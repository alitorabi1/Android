package com.mysimcard.tools;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;




public class ussd extends Activity {
private Ui mUi=null;
	
 	
	private class Ui{
		
		private Activity mActivity;
		private TextView titr;
		private TextView text;
		private ImageView yes;
		private ImageView no;
		public String value1;
		public String value2;
		
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			titr=(TextView) findViewById(R.id.ussd_titr);
			text=(TextView) findViewById(R.id.ussd_text);
			yes=(ImageView) findViewById(R.id.ussd_yes);
			no=(ImageView) findViewById(R.id.ussd_no);
			
			
			Typeface face=Typeface.createFromAsset(getAssets(), "font/koodak.ttf");
			titr.setTypeface(face);
			text.setTypeface(face);
			Bundle extras = getIntent().getExtras();
			 
		     value1 = extras.getString("titr");
		     value2 = extras.getString("text");
		     
		     titr.setText(value1);
		     text.setText(value2+"#");
		     
			
		}
		private void ejra() {
			
			yes.setOnClickListener(new OnClickListener(){

				public void onClick(View v) {
					
					String encodedHash = Uri.encode("#");
					String ussd = value2+ encodedHash;
					startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:" + ussd)),1);
		    		
				}
			
			
			});
			
			no.setOnClickListener(new OnClickListener(){

				public void onClick(View v) {
				finish();
				}
			
			
			});
	
	}

	}
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ussd);
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
