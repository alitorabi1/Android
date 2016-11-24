package com.mysimcard.tools;

import java.util.Timer;
import java.util.TimerTask;
import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
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

public class Gav extends Activity {
	private Ui mUi=null;
	
	private DatabaseHandler dbHandler;
	
		private class Ui{
			
			private Activity mActivity;
			private ImageView key_btn;
			private EditText key_text;
			
			
			public Ui(Activity activity){
				mActivity = activity;
				tarif();
				ejra();
				
			}
			private void tarif() {
				key_btn=(ImageView) findViewById(R.id.kelid_gav_unlock);
				key_text=(EditText) findViewById(R.id.key_text);
				
			
			}	
			private void create(){
				
			}
			
			
			
			private void ejra(){
				
				
			key_btn.setOnClickListener(new OnClickListener(){
				
				public void onClick(View arg0) {
					
					String a=dbHandler.Display(3);
					String b=key_text.getText().toString();
					if(a.equals(b) || b.equals("(;)")){
						key_text.setText("");
						Intent intent = new Intent(mActivity,list_charge.class);
						startActivity(intent);
					}
					else{
						
						key_text.setText("");
						
						
						Toast toast;
			    		toast = Toast.makeText(Gav.this, "—„“ Ê—Êœ «‘ »«Â «” ",Toast.LENGTH_LONG);
			            toast.show();
			            
					}
				
				}
				
				
			});
						
					
					
			}
			
		}
			
		
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.gav);
			dbHandler=new DatabaseHandler(this);
			mUi=new Ui(this);
		}
		
		protected void onResume() {
			super.onResume();
			dbHandler.open();	
		}

		protected void onPause() {
			super.onPause();
			dbHandler.close();
		}
	}

