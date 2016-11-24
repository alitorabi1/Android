package com.Publication.pezeshkisalamt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;




public class zibayi extends Activity {
private Ui mUi=null;
	
	private class Ui{
		
		private ImageView z_men;
		private ImageView z_women;
		
		
		
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
		z_men=(ImageView)findViewById(R.id.z_men);
		z_women=(ImageView)findViewById(R.id.z_women);
			
		}
		private void ejra() {
			
			z_men.setOnClickListener(new OnClickListener(){
				

				public void onClick(View arg0) {
					
					Intent intent = new Intent(mActivity,z_men.class);
					startActivity(intent);
					
				}
			});
			
			z_women.setOnClickListener(new OnClickListener(){
	

				public void onClick(View arg0) {
		
					Intent intent = new Intent(mActivity,z_women.class);
					startActivity(intent);
		
				}
			});

			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zibayi);
		mUi=new Ui(this);
	}
	

}
