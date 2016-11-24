package com.Publication.pezeshkisalamt;

import android.app.Activity;
import android.os.Bundle;




public class galery extends Activity {
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
		setContentView(R.layout.galery);
		mUi=new Ui(this);
	}
	

}
