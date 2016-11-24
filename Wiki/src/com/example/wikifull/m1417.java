package com.example.wikifull;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.Reference.wikifull.R;



public class m1417 extends Activity {
private Ui mUi=null;
	
	private class Ui{
		
		
		
		private ImageView z1417_86;
		private ImageView z1417_87;
		private ImageView z1417_88;
		private ImageView z1417_89;
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
		
			z1417_86=(ImageView) findViewById(R.id.z1417_86);
			z1417_87=(ImageView) findViewById(R.id.z1417_87);
			z1417_88=(ImageView) findViewById(R.id.z1417_88);
			z1417_89=(ImageView) findViewById(R.id.z1417_89);
			
			
		}
		private void ejra() {
			
			z1417_86.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "86");
						startActivity(intent);
					
					
				}
			});
			z1417_87.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "87");
						startActivity(intent);
					
					
				}
			});
			z1417_88.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "88");
						startActivity(intent);	
				}
			});
			z1417_89.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "89");
						startActivity(intent);
					
					
				}
			});
			
			
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.m1417);
		mUi=new Ui(this);
	}
	

}
