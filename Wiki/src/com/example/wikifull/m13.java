package com.example.wikifull;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.Reference.wikifull.R;



public class m13 extends Activity {
private Ui mUi=null;
	
	private class Ui{
		
		private ImageView z131;
		private ImageView z132;
		private ImageView z133;
		private ImageView z134;
		private ImageView z135;
		private ImageView z136;
		private ImageView z137;
		private ImageView z138;
		private ImageView z139;
		
		
		private Activity mActivity;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			z131=(ImageView) findViewById(R.id.z131);
			z132=(ImageView) findViewById(R.id.z132);
			z133=(ImageView) findViewById(R.id.z133);
			z134=(ImageView) findViewById(R.id.z134);
			z135=(ImageView) findViewById(R.id.z135);
			z136=(ImageView) findViewById(R.id.z136);
			z137=(ImageView) findViewById(R.id.z137);
			z138=(ImageView) findViewById(R.id.z138);
			z139=(ImageView) findViewById(R.id.z139);
			
			
			
		}
		private void ejra() {
			
			z131.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "50");
						startActivity(intent);
					
					
				}
			});	
			z132.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "51");
						startActivity(intent);
					
					
				}
			});	
			z133.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "52");
						startActivity(intent);
					
					
				}
			});	
			z134.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "53");
						startActivity(intent);
					
					
				}
			});	
			z135.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "54");
						startActivity(intent);
					
					
				}
			});	
			z136.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),m136.class);
					
						startActivity(intent);
					
					
				}
			});	
			z137.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "59");
						startActivity(intent);
					
					
				}
			});	
			z138.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "60");
						startActivity(intent);
					
					
				}
			});	
			z139.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
				
					 Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "code");
						intent.putExtra("key"  , "61");
						startActivity(intent);
					
					
				}
			});	
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.m13);
		mUi=new Ui(this);
	}
	

}
