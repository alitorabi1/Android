package com.mysimcard.tools;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;




public class about extends Activity {
private Ui mUi=null;

	private class Ui{
		
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			
			
		}
		private void ejra() {
			
			
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
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
