package com.example.wikifull;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.Reference.wikifull.R;



public class m12 extends Activity {
private Ui mUi=null;
	
	private class Ui{
		
		private ImageView z121;
		private ImageView z122;
		private ImageView z123;
		private ImageView z124;
		
		
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
		
			z121=(ImageView) findViewById(R.id.z121);
			z122=(ImageView) findViewById(R.id.z122);
			z123=(ImageView) findViewById(R.id.z123);
			z124=(ImageView) findViewById(R.id.z124);
			
			
		}
		private void ejra() {
			
			z121.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "40");
						startActivity(intent);
					
					
				}
			});
			z122.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "41");
						startActivity(intent);
					
					
				}
			});
			z123.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "42");
						startActivity(intent);
					
					
				}
			});
			z124.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "43");
						startActivity(intent);
					
				}
			});
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.m12);
		mUi=new Ui(this);
	}
	

}
