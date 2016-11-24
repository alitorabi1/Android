package com.example.wikifull;

import java.io.File;
import java.io.IOException;
import com.Reference.wikifull.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.database.SQLException;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AndroidFileDownloader extends Activity 
{
	
	public static final int MESSAGE_DOWNLOAD_STARTED = 1000;
	public static final int MESSAGE_DOWNLOAD_COMPLETE = 1001;
	public static final int MESSAGE_UPDATE_PROGRESS_BAR = 1002;
	public static final int MESSAGE_DOWNLOAD_CANCELED = 1003;
	public static final int MESSAGE_CONNECTING_STARTED = 1004;
	public static final int MESSAGE_ENCOUNTERED_ERROR = 1005;
	
	
	private AndroidFileDownloader thisActivity;
	private Tools tools;
	private Thread downloaderThread;
	private ProgressDialog progressDialog;
	private ImageView yes;
	private ImageView text;
	
	private ImageView back;
	private TextView payam;
	
	private dbthandler dbt;
	private ImageView no;
	private ImageView wite;
	public String Pname;
	public String urlInput;
	private dbmain dbmains;
	private dbtemp dbtemps;
	
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        thisActivity = this;
        downloaderThread = null;
        progressDialog = null;
        dbt=new dbthandler(this);
        dbtemps=new dbtemp(this);
        dbmains=new dbmain(this);
        tools=new Tools();
        setContentView(R.layout.download_firstdata);
        
        
      
        
        
        Bundle extras = getIntent().getExtras();
		Pname= extras.getString("name");
		
		run();
		
        
       
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
    
    public void run(){
    	  Typeface fonthoma=Typeface.createFromAsset(getAssets(), "font/homa.ttf");
    	yes=(ImageView) findViewById(R.id.dfda_yes_kelid);
    	no=(ImageView) findViewById(R.id.dfda_no_kelid);
    	text=(ImageView) findViewById(R.id.ddf_text);
    	wite=(ImageView) findViewById(R.id.update_wite);
    	back=(ImageView) findViewById(R.id.update_back);
    	payam=(TextView) findViewById(R.id.firstdownload_payam_text);
    	payam.setTypeface(fonthoma);
    	
    	if(Pname.equals("main"))
		{
		urlInput= "http://wikipdf.ir/wikipdf-software/db/dbmain";
		}
		else if(Pname.equals("temp"))
		{
			
			yes.setVisibility(View.INVISIBLE);
			no.setVisibility(View.INVISIBLE);
			text.setVisibility(View.INVISIBLE);
			
			
			
		urlInput= "http://wikipdf.ir/wikipdf-software/db/dbtemp";
		Start();
		}
    	
    	
    	yes.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				yes.setVisibility(View.INVISIBLE);
				no.setVisibility(View.INVISIBLE);
				text.setVisibility(View.INVISIBLE);
				
				Start();	
			}
    	});
    	
    	back.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				finish();	
			}
    	});
    	
    	no.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				finish();
				
				
			}
    	});
    }

    public void mergh(){
    	
    	
    	
    	 try {
    		 
 	 		dbmains.open();
 	 
 	        }catch(SQLException sqle){
 	 
 	 		throw sqle;
 	 
 	        }
    	 try {
    		 
 	 		dbtemps.open();
 	 
 	        }catch(SQLException sqle){
 	 
 	 		throw sqle;
 	 
 	        }
    	 
    	 
    	int count =Integer.parseInt(dbtemps.Display_name(0).toString());
    	int lastcode =Integer.parseInt(dbtemps.Display_mode(0).toString());
    	lastcode=lastcode-1;
    	//String lastcode2=""+lastcode;
    	int lastcodemain=Integer.parseInt(dbmains.Display_link(1).toString());
    	
        
    	
        
        
    	if(lastcode==lastcodemain || lastcode>lastcodemain){
    		
    		
    		
    		Pname="main";
    		urlInput= "http://wikipdf.ir/wikipdf-software/db/dbmain";
    		
    		Start();
    		
    		lastcode=lastcode+1;
    		dbmains.updateContactlastcode(2, lastcode+"");
    	
    		
    		wite.setVisibility(View.INVISIBLE);
			
	        payam.setText("اطلاعات جدید موجود است");
	        
    		
    	}
    	else if(lastcode<lastcodemain){
    		
    		wite.setVisibility(View.INVISIBLE);
			payam.setVisibility(View.VISIBLE);
	        back.setVisibility(View.VISIBLE);
	        payam.setText("اطلاعات جدید موجود نیست");
	        
	        
    		
    	}
    	
    	
    	
    
    	payam.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
   
    	
    	
    }
    
    
    
    
    
   
	public void Start()
	{
		
		
		
		downloaderThread = new DownloaderThread(thisActivity, urlInput);
		downloaderThread.start();
		
	
	}
	
	
	
	
	public Handler activityHandler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			switch(msg.what)
			{
				
				case MESSAGE_UPDATE_PROGRESS_BAR:
					if(progressDialog != null)
					{
						int currentProgress = msg.arg1;
						progressDialog.setProgress(currentProgress);
					}
					break;
				
				
				case MESSAGE_CONNECTING_STARTED:
					if(msg.obj != null && msg.obj instanceof String)
					{
						String url = (String) msg.obj;
						// truncate the url
						if(url.length() > 16)
						{
							String tUrl = url.substring(0, 15);
							tUrl += "...";
							url = tUrl;
						}
						String pdTitle = thisActivity.getString(R.string.progress_dialog_title_connecting);
						String pdMsg = thisActivity.getString(R.string.progress_dialog_message_prefix_connecting);
						pdMsg += " ";
						
						
						dismissCurrentProgressDialog();
						progressDialog = new ProgressDialog(thisActivity);
						progressDialog.setTitle(pdTitle);
						progressDialog.setMessage(pdMsg);
						progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
						progressDialog.setIndeterminate(true);
						// set the message to be sent when this dialog is canceled
						Message newMsg = Message.obtain(this, MESSAGE_DOWNLOAD_CANCELED);
						progressDialog.setCancelMessage(newMsg);
						progressDialog.show();
					}
					break;
					
			
				case MESSAGE_DOWNLOAD_STARTED:
					
					if(msg.obj != null && msg.obj instanceof String)
					{
						int maxValue = msg.arg1;
						String fileName = (String) msg.obj;
						String pdTitle ="در حال دانلود";
						String pdMsg = "لطفا تا اتمام دانلود شکیبا باشید";
						
						
						
						dismissCurrentProgressDialog();
						progressDialog = new ProgressDialog(thisActivity);
						progressDialog.setTitle(pdTitle);
						progressDialog.setMessage(pdMsg);
						progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
						progressDialog.setProgress(0);
						progressDialog.setMax(maxValue);
						
						Message newMsg = Message.obtain(this, MESSAGE_DOWNLOAD_CANCELED);
						progressDialog.setCancelMessage(newMsg);
						progressDialog.setCancelable(true);
					
						wite.setVisibility(View.VISIBLE);
					    progressDialog.show();
						
						
						if(Pname.equals("temp")){
						dismissCurrentProgressDialog();
						}
					}
					break;
				
				case MESSAGE_DOWNLOAD_COMPLETE:
					dismissCurrentProgressDialog();
					if(Pname.equals("main")){
					//displayMessage(getString(R.string.user_message_download_complete));
					dbt.updateContact(3, "1");
			        wite.setVisibility(View.INVISIBLE);
			        payam.setVisibility(View.VISIBLE);
			        back.setVisibility(View.VISIBLE);
			        payam.setText("دانلود دیتای برنامه با موفقیت انجام شد");
			  
					}else{
						
							try {
								
								
								tools.copyDataBaset();
								mergh();
								
							
								} 
							catch (IOException e) {
								}
							
					}
					
					break;
					
			
				case MESSAGE_DOWNLOAD_CANCELED:
					if(downloaderThread != null)
					{
						downloaderThread.interrupt();
					}
					dismissCurrentProgressDialog();
					displayMessage(getString(R.string.user_message_download_canceled));
					wite.setVisibility(View.INVISIBLE);
					finish();
					break;
				
			
				case MESSAGE_ENCOUNTERED_ERROR:
					
					if(msg.obj != null && msg.obj instanceof String)
					{
						String errorMessage = (String) msg.obj;
						dismissCurrentProgressDialog();
						
						displayMessage(errorMessage);
						wite.setVisibility(View.INVISIBLE);
						finish();
					}
					break;
					
				default:
					
					
					wite.setVisibility(View.INVISIBLE);
					finish();
					break;
			}
			
		}
	};
	
	
	public void dismissCurrentProgressDialog()
	{
		if(progressDialog != null)
		{
			progressDialog.hide();
			progressDialog.dismiss();
			progressDialog = null;
		}
	}
	
	
	public void displayMessage(String message)
	{
		if(message != null)
		{
			Toast.makeText(thisActivity, message, Toast.LENGTH_SHORT).show();
		}
	}
}