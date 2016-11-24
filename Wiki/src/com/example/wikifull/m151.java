package com.example.wikifull;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.Reference.wikifull.R;



public class m151 extends Activity {
private Ui mUi=null;
	
	private class Ui{
		
		
		
		
		private Activity mActivity;
		
		private ImageView z151_100;
		private ImageView z151_101;
		private ImageView z151_102;
		private ImageView z151_103;
		private ImageView z151_104;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			z151_100=(ImageView) findViewById(R.id.z151_101);
			z151_101=(ImageView) findViewById(R.id.z151_101);
			z151_102=(ImageView) findViewById(R.id.z151_102);
			z151_103=(ImageView) findViewById(R.id.z151_103);
			z151_104=(ImageView) findViewById(R.id.z151_104);
			
			
			
		}
		private void ejra() {
			
			z151_100.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "100");
						startActivity(intent);
					
					
				}
			});
			z151_101.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "101");
						startActivity(intent);
					
					
				}
			});
			z151_102.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "102");
						startActivity(intent);
					
					
				}
			});
			z151_103.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "103");
						startActivity(intent);
					
					
				}
			});
			z151_104.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "104");
						startActivity(intent);
					
					
				}
			});
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.m151);
		mUi=new Ui(this);
	}
	

}
