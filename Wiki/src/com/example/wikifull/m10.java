package com.example.wikifull;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.Reference.wikifull.R;



public class m10 extends Activity {
private Ui mUi=null;
	
	private class Ui{
		
		private ImageView z101;
		private ImageView z102;
		private ImageView z103;
		private ImageView z104;
		private ImageView z105;
		
		
		
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			z101=(ImageView) findViewById(R.id.z101);
			z102=(ImageView) findViewById(R.id.z102);
			z103=(ImageView) findViewById(R.id.z103);
			z104=(ImageView) findViewById(R.id.z104);
			z105=(ImageView) findViewById(R.id.z105m);
			
			
			
			
		}
		private void ejra() {
			
			z101.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "1");
						startActivity(intent);
					
					
				}
			});
			z102.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "2");
						startActivity(intent);
					
					
				}
			});
			z103.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					Intent intent = new Intent(getApplicationContext(),m103.class);
					startActivity(intent);
					
					
				}
			});
			z104.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "20");
						startActivity(intent);
					
				}
			});
			z105.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					Intent intent = new Intent(getApplicationContext(),m105.class);
					startActivity(intent);
					
					
				}
			});
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.m10);
		mUi=new Ui(this);
	}
	

}
