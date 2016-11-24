package com.example.wikifull;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.Reference.wikifull.R;



public class m105 extends Activity {
private Ui mUi=null;
	
	private class Ui{
		
		
		
		private ImageView z105_21;
		private ImageView z105_22;
		private ImageView z105_23;
		private ImageView z105_24;
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			z105_21=(ImageView) findViewById(R.id.z105_21);
			z105_22=(ImageView) findViewById(R.id.z105_22);
			z105_23=(ImageView) findViewById(R.id.z105_23);
			z105_24=(ImageView) findViewById(R.id.z105_24);
			
			
			
		}
		private void ejra() {
			
			z105_21.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "21");
						startActivity(intent);
					
					
				}
			});
			z105_22.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "22");
						startActivity(intent);
					
					
				}
			});
			z105_23.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "23");
						startActivity(intent);
					
					
				}
			});
			z105_24.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "24");
						startActivity(intent);
					
					
				}
			});
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.m105);
		mUi=new Ui(this);
	}
	

}
