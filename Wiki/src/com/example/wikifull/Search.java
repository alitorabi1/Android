package com.example.wikifull;


import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;
import com.Reference.wikifull.R;



public class Search extends Activity {
private Ui mUi=null;
private dbthandler dbt;
	
	private class Ui{
		
		private Activity mActivity;
		private ImageView start;
		private ImageView cancel;
		private EditText key;
		private RadioButton rd1;
		
		public Ui(Activity activity){
			mActivity = activity;
			tarif();
			ejra();
		}
		private void tarif() {
			
			start=(ImageView) findViewById(R.id.s_start_kelid);
			cancel=(ImageView) findViewById(R.id.s_cancel_kelid);
			key=(EditText) findViewById(R.id.s_text_fild);
			rd1=(RadioButton) findViewById(R.id.rd1);
			
		}
		private void ejra() {
			
			rd1.setChecked(true);
			
			start.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					
					if(dbt.Display(2).equals("0")){	
						
						Toast toast;
						toast = Toast.makeText(Search.this, "لطفا ابتدا دیتای برنامه را دانلود نمایید",Toast.LENGTH_LONG);
				        toast.show();
					}
					else
					{
						Intent intent = new Intent(getApplicationContext(),Main_list.class);
						intent.putExtra("mode"  , "search");
						intent.putExtra("key"  , key.getText().toString());
						startActivity(intent);	
					}
				}
			});
			
			cancel.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					finish();
				}
			});
		}
		
		
	
	}


	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		dbt=new dbthandler(this);
		mUi=new Ui(this);
	}
	protected void onResume() {
		super.onResume();
		dbt.open();		
	}

	@Override
	protected void onPause() {
		super.onPause();
		dbt.close();
	}

}
