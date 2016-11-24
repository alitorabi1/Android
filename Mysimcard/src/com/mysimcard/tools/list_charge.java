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

public class list_charge extends Activity {
	private Ui mUi=null;	
		private DatabaseHandler01 dbHandler01;
	
		private class Ui{
			private TextView C1 ;	
			private TextView C2 ;
			private TextView C3 ;	
			private TextView C4 ;	
			private TextView C5 ;
			private TextView C6 ;	
			private TextView C7 ;	
			private TextView C8 ;
			private TextView C9 ;
			private TextView C10 ;
			private Typeface list;
			private Activity mActivity;
			public Ui(Activity activity){
				mActivity = activity;
				tarif();
				ejra();
				
			}
			private void tarif() {																			
				C1=(TextView) findViewById(R.id.C1);			
				C2=(TextView) findViewById(R.id.C2);			
				C3=(TextView) findViewById(R.id.C3);			
				C4=(TextView) findViewById(R.id.C4);				
				C5=(TextView) findViewById(R.id.C5);				
				C6=(TextView) findViewById(R.id.C6);				
				C7=(TextView) findViewById(R.id.C7);				
				C8=(TextView) findViewById(R.id.C8);				
				C9=(TextView) findViewById(R.id.C9);				
				C10=(TextView) findViewById(R.id.C10);			
				list=Typeface.createFromAsset(getAssets(), "font/homa.ttf"+"");
				
				
			}	
			private void create(){
				
				C1.setTypeface(list);
				C2.setTypeface(list);
				C3.setTypeface(list);
				C4.setTypeface(list);
				C5.setTypeface(list);
				C6.setTypeface(list);
				C7.setTypeface(list);
				C8.setTypeface(list);
				C9.setTypeface(list);
				C10.setTypeface(list);
				
				C1.setText(dbHandler01.Display_Name(1)+""+dbHandler01.Display_No(1));
				C2.setText(dbHandler01.Display_Name(2)+""+dbHandler01.Display_No(2));
				C3.setText(dbHandler01.Display_Name(3)+""+dbHandler01.Display_No(3));
				C4.setText(dbHandler01.Display_Name(4)+""+dbHandler01.Display_No(4));
				C5.setText(dbHandler01.Display_Name(5)+""+dbHandler01.Display_No(5));
				C6.setText(dbHandler01.Display_Name(6)+""+dbHandler01.Display_No(6));
				C7.setText(dbHandler01.Display_Name(7)+""+dbHandler01.Display_No(7));
				C8.setText(dbHandler01.Display_Name(8)+""+dbHandler01.Display_No(8));
				C9.setText(dbHandler01.Display_Name(9)+""+dbHandler01.Display_No(9));
				C10.setText(dbHandler01.Display_Name(10)+""+dbHandler01.Display_No(10));
			}
			
			private void ejra(){
				
				

				final Timer t = new Timer();
		        //Set the schedule function and rate
		        t.scheduleAtFixedRate(new TimerTask() 
		        {
					public void run() 
					{
						runOnUiThread(new Runnable() 
						{
							public void run() 
							{
								
			
									t.cancel();
									create();
								
								
							}
							
						});
					}
		        	
		        }, 1, 100);
			
		        
			
		        
		        C1.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					Intent intent = new Intent(mActivity,gav_charge.class);
					intent.putExtra("name"  ,"1");
					startActivity(intent);
				}
		        });
		        
		        
		        C2.setOnClickListener(new OnClickListener(){
					public void onClick(View v) {
						Intent intent = new Intent(mActivity,gav_charge.class);
						intent.putExtra("name"  ,"2");
						startActivity(intent);
						
					}
			        });
		        
		        
		        C3.setOnClickListener(new OnClickListener(){
					public void onClick(View v) {
						Intent intent = new Intent(mActivity,gav_charge.class);
						intent.putExtra("name"  ,"3");
						startActivity(intent);
					}
			        });
		        
		        
		        C4.setOnClickListener(new OnClickListener(){
					public void onClick(View v) {
						Intent intent = new Intent(mActivity,gav_charge.class);
						intent.putExtra("name"  ,"4");
						startActivity(intent);
					}
			        });
		        
		        
		        C5.setOnClickListener(new OnClickListener(){
					public void onClick(View v) {
						Intent intent = new Intent(mActivity,gav_charge.class);
						intent.putExtra("name"  ,"5");
						startActivity(intent);
					}
			        });
		        
		        
		        C6.setOnClickListener(new OnClickListener(){
					public void onClick(View v) {
						Intent intent = new Intent(mActivity,gav_charge.class);
						intent.putExtra("name"  ,"6");
						startActivity(intent);
					}
			        });
		        
		        
		        C7.setOnClickListener(new OnClickListener(){
					public void onClick(View v) {
						Intent intent = new Intent(mActivity,gav_charge.class);
						intent.putExtra("name"  ,"7");
						startActivity(intent);
					}
			        });
		        
		        
		        C8.setOnClickListener(new OnClickListener(){
					public void onClick(View v) {
						Intent intent = new Intent(mActivity,gav_charge.class);
						intent.putExtra("name"  ,"8");
						startActivity(intent);
					}
			        });
		        
		        
		        C9.setOnClickListener(new OnClickListener(){
					public void onClick(View v) {
						Intent intent = new Intent(mActivity,gav_charge.class);
						intent.putExtra("name"  ,"9");
						startActivity(intent);
					}
			        });
		        
		        
		        C10.setOnClickListener(new OnClickListener(){
					public void onClick(View v) {
						Intent intent = new Intent(mActivity,gav_charge.class);
						intent.putExtra("name"  ,"10");
						startActivity(intent);
					}
			        });
		        
			
			}
			
		}
			
		
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.list_charge);
			
			
			
			dbHandler01=new DatabaseHandler01(this);
			
			
		}
		
				
		

		
		
		protected void onResume() {
			super.onResume();
			
			dbHandler01.open();	
			mUi=new Ui(this);
		}

		@Override
		protected void onPause() {
			super.onPause();
			
			dbHandler01.close();
		}
		
		

	}

