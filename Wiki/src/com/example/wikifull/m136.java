package com.example.wikifull;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.Reference.wikifull.R;



public class m136 extends Activity {
private Ui mUi=null;
	
	private class Ui{
		
		private ImageView z136_55;
		private ImageView z136_56;
		private ImageView z136_57;
		private ImageView z136_58;
		
		
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
		
			z136_55=(ImageView) findViewById(R.id.z136_55);
			z136_56=(ImageView) findViewById(R.id.z136_56);
			z136_57=(ImageView) findViewById(R.id.z136_57);
			z136_58=(ImageView) findViewById(R.id.z136_58);
			
		}
		private void ejra() {
			
			
			z136_55.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "55");
						startActivity(intent);
					
					
				}
			});
			z136_56.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "56");
						startActivity(intent);
					
					
				}
			});
			z136_57.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "57");
						startActivity(intent);
					
					
				}
			});
			z136_58.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "58");
						startActivity(intent);
					
					
				}
			});
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.m136);
		mUi=new Ui(this);
	}
	

}
