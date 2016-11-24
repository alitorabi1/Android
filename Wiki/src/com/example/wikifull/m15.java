package com.example.wikifull;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.Reference.wikifull.R;



public class m15 extends Activity {
private Ui mUi=null;
	
	private class Ui{
		
		private ImageView z151;
		private ImageView z152;
		private ImageView z153;
		private ImageView z154;
		private ImageView z155;
		
		
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
		
			z151=(ImageView) findViewById(R.id.z151);
			z152=(ImageView) findViewById(R.id.z152);
			z153=(ImageView) findViewById(R.id.z153);
			z154=(ImageView) findViewById(R.id.z154);
			z155=(ImageView) findViewById(R.id.z155);
			
		}
		private void ejra() {
			z151.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 
					
					
				}
			});	
			z152.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "105");
						startActivity(intent);
					
					
				}
			});	
			z153.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "106");
						startActivity(intent);
					
					
				}
			});	
			z154.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "107");
						startActivity(intent);
					
					
				}
			});	
			z155.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "108");
						startActivity(intent);
					
					
				}
			});	
			
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.m15);
		mUi=new Ui(this);
	}
	

}
