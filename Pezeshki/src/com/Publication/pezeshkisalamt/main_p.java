package com.Publication.pezeshkisalamt;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;




public class main_p extends Activity {
private Ui mUi=null;

	
	private class Ui{
		
		private Activity mActivity;
		
		private ImageView main_p_danestaniha_kelid;
		private ImageView main_p_bimariha_kelid;
		private ImageView main_p_darokhane_kelid;
		private ImageView main_p_nokat_kelid;
		private ImageView main_p_tabestan_kelid;
		private ImageView main_p_zibayi_kelid;
		
		private ImageView main_p_moarefi_kelid;
		
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			
			main_p_danestaniha_kelid=(ImageView) findViewById(R.id.main_p_danestaniha_kelid);
			main_p_bimariha_kelid=(ImageView) findViewById(R.id.main_p_bimariha_kelid);
			main_p_darokhane_kelid=(ImageView) findViewById(R.id.main_p_darokhane);
			main_p_nokat_kelid=(ImageView) findViewById(R.id.main_p_nokat_kelid);
			main_p_tabestan_kelid=(ImageView) findViewById(R.id.main_p_tabestan_kelid);
			main_p_tabestan_kelid=(ImageView) findViewById(R.id.main_p_tabestan_kelid);
			
			main_p_moarefi_kelid=(ImageView) findViewById(R.id.main_p_moarefi_kelid);
			
			main_p_zibayi_kelid=(ImageView) findViewById(R.id.main_p_zibayi_kelid);
		}
		private void ejra() {
			
			
			
			main_p_danestaniha_kelid.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {
					Intent intent = new Intent(mActivity,danestaniha.class);
					startActivity(intent);
				}
				
				
			});
			
			main_p_bimariha_kelid.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {
					Intent intent = new Intent(mActivity,bimariha.class);
					startActivity(intent);
				}
				
				
			});
			
			
			main_p_darokhane_kelid.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {
					Intent intent = new Intent(mActivity,darokhane.class);
					startActivity(intent);
				}
				
				
			});
			
			
			main_p_nokat_kelid.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {
					Intent intent = new Intent(mActivity,nokat.class);
					startActivity(intent);
				}
				
				
			});
			
			main_p_tabestan_kelid.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {
					Intent intent = new Intent(mActivity,tabestan.class);
					startActivity(intent);
				}
				
				
			});
			
			main_p_zibayi_kelid.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {
					Intent intent = new Intent(mActivity,zibayi.class);
					startActivity(intent);
				}
				
				
			});
			
			
			
			
			main_p_moarefi_kelid.setOnClickListener(new OnClickListener(){
				public void onClick(View arg0) {
					Intent intent = new Intent(mActivity,moarefi.class);
					startActivity(intent);
				}
				
				
			});
			
			
			
			
			
			
			
			
			
		}
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_p);
		mUi=new Ui(this);
	}
	

}
