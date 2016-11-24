package com.example.wikifull;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.Reference.wikifull.R;



public class m11 extends Activity {
private Ui mUi=null;
	
	private class Ui{
		
		
		private ImageView z111;
		private ImageView z112;
		private ImageView z113;
		
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			z111=(ImageView) findViewById(R.id.z111);
			z112=(ImageView) findViewById(R.id.z112);
			z113=(ImageView) findViewById(R.id.z113);
			
			
			
		}
		private void ejra() {
			
			z111.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "30");
						startActivity(intent);
					
					
				}
			});
			z112.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "31");
						startActivity(intent);
					
					
				}
			});
			z113.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "32");
						startActivity(intent);
					
					
				}
			});
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.m11);
		mUi=new Ui(this);
	}
	

}
