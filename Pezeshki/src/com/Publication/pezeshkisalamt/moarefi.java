package com.Publication.pezeshkisalamt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;




public class moarefi extends Activity {
private Ui mUi=null;
	
	private class Ui{
		
		private Activity mActivity;
		
		
		private ImageView t26;
		private ImageView t27;
		
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			
			t26=(ImageView) findViewById(R.id.t26);
			t27=(ImageView) findViewById(R.id.t27);
			
			
		}
		private void ejra() {
			
			t26.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"پروفسر مجید سمیعی");
					intent.putExtra("maintext"  ,"26");
					intent.putExtra("imagetext" ,"26");
					startActivity(intent);
				}
			});
			
			t27.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,text.class);
					
					intent.putExtra("titrtext"  ,"دکتر محمد حسین ماندگار");
					intent.putExtra("maintext"  ,"27");
					intent.putExtra("imagetext" ,"27");
					startActivity(intent);
				}
			});
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.moarefi);
		mUi=new Ui(this);
	}
	

}
