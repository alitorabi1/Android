package com.example.wikifull;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.Reference.wikifull.R;



public class help extends Activity {
private Ui mUi=null;
	
	private class Ui{
		
		private ImageView help2;
		private ImageView about;
		
		
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
		
			help2=(ImageView) findViewById(R.id.help_help_kelid);

			about=(ImageView) findViewById(R.id.help_abuot_kelid);
			
		}
		private void ejra() {
			
			
			help2.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Intent intent = new Intent(getApplicationContext(),help2.class);
					intent.putExtra("name"  , "main");
					startActivity(intent);
					
				}
			});
			
			about.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Intent intent = new Intent(getApplicationContext(),about.class);
					
					startActivity(intent);	
					
				}
			});
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
		mUi=new Ui(this);
	}
	

}
