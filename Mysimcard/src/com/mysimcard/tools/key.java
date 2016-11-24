package com.mysimcard.tools;

import java.util.Timer;
import java.util.TimerTask;



import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class key extends Activity {
	private Ui mUi=null;	
		private DatabaseHandler dbHandler;
	
		private class Ui{
			
			private EditText pold;
			private EditText pnew;
			
			private ImageView ok;
			
			
			private Typeface list;
			private Activity mActivity;
			public Ui(Activity activity){
				mActivity = activity;
				tarif();
				ejra();
				
			}
			private void tarif() {																			
					
				pold=(EditText) findViewById(R.id.key_oldpass);
				pnew=(EditText) findViewById(R.id.key_newpass);
				ok=(ImageView) findViewById(R.id.key_ok);
				list=Typeface.createFromAsset(getAssets(), "font/koodak.ttf"+"");
				
				
			}	
		
			
			private void ejra(){
				
			
				
			
		       ok.setOnClickListener(new OnClickListener(){
					public void onClick(View v) {
						
							chek();
							
						
						
					}
			   });
		        
			
			}
			private void chek(){
				String a=dbHandler.Display(3);
				String b=pold.getText().toString();
				if(a.equals(b)){
					
					dbHandler.updateContact(4, pnew.getText().toString());
					Toast toast;
		    		toast = Toast.makeText(key.this, "رمز ورود با موفقیت به روزرسانی شد",Toast.LENGTH_LONG);
		            toast.show();
		            pold.setText("");
		            pnew.setText("");
				}
				else{
					
					pold.setText("");
					pnew.setText("");
					Toast toast;
		    		toast = Toast.makeText(key.this, "رمز ورود اشتباه است",Toast.LENGTH_LONG);
		            toast.show();
		            
				}
				
			}
			
		}
			

		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.key);
			
			
			
			dbHandler=new DatabaseHandler(this);
			
			
		}
		
				
		

		
		
		protected void onResume() {
			super.onResume();
			
			dbHandler.open();	
			mUi=new Ui(this);
		}

		@Override
		protected void onPause() {
			super.onPause();
			
			dbHandler.close();
		}
		
		

	}

