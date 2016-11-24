package com.example.wikifull;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.Reference.wikifull.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.SQLException;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Downloader_File extends Activity 
{
	// Used to communicate state changes in the DownloaderThread
	public static final int MESSAGE_DOWNLOAD_STARTED = 1000;
	public static final int MESSAGE_DOWNLOAD_COMPLETE = 1001;
	public static final int MESSAGE_UPDATE_PROGRESS_BAR = 1002;
	public static final int MESSAGE_DOWNLOAD_CANCELED = 1003;
	public static final int MESSAGE_CONNECTING_STARTED = 1004;
	public static final int MESSAGE_ENCOUNTERED_ERROR = 1005;
	
	// instance variables
	private Downloader_File thisActivity;
	private Tools tools;
	private Thread downloaderThreadF;
	private ProgressDialog progressDialog;
	
	
	private dbmain dbmain;
	private TextView name;
	private TextView matn;
	private TextView mode;
	private TextView rez;
	
	private TextView txt1;
	private TextView txt2;
	private TextView txt3;
	private TextView txt4;
	
	public String idt;
	private ImageView download;
	private ImageView runfile;
	private ImageView cancel;
	public String Pname;
	public String fullname;
	
	
	
	
	
	public String urlInput;
	public String urlInput0;
	public String Pmatn;
	public String Pmode;
	public String Prez;
	protected Object alert;
	
	
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        thisActivity = this;
        downloaderThreadF = null;
        progressDialog = null;
        setContentView(R.layout.user_download);
        
        
        dbmain=new dbmain(this);
        
        Typeface fontyas=Typeface.createFromAsset(getAssets(), "font/yas.ttf");
    	Typeface fontyekan=Typeface.createFromAsset(getAssets(), "font/yekan.ttf");
    	Typeface fontmode=Typeface.createFromAsset(getAssets(), "font/mode.otf");
    	Typeface fonthoma=Typeface.createFromAsset(getAssets(), "font/homa.ttf");
    	
        name=(TextView) findViewById(R.id.user_name_text);
        matn=(TextView) findViewById(R.id.user_matn_text);
        mode=(TextView) findViewById(R.id.user_mode_text);
        
        
        txt1=(TextView) findViewById(R.id.firstdownload_payam_text);
        txt2=(TextView) findViewById(R.id.help2_txt2);
        txt3=(TextView) findViewById(R.id.help2_txt3);
        txt4=(TextView) findViewById(R.id.about_txt6);
        
        rez=(TextView) findViewById(R.id.user_rez);
        download=(ImageView) findViewById(R.id.download_kelid);
        cancel=(ImageView) findViewById(R.id.cancel_kelid);
        runfile=(ImageView) findViewById(R.id.run_kelid);
        
        name.setTypeface(fontyas);
        rez.setTypeface(fontyekan);
        mode.setTypeface(fontmode);
        matn.setTypeface(fontyas);
        
        
        txt1.setTypeface(fonthoma);
        txt2.setTypeface(fonthoma);
        txt3.setTypeface(fonthoma);
        txt4.setTypeface(fonthoma);
        
        Bundle extras = getIntent().getExtras();
		 Pname= extras.getString("name");
		 urlInput0= extras.getString("link");
		 Pmatn= extras.getString("matn");
		 if(Pmatn.equals("")){
			 
			 Prez="ندارد";
		 }

		 Pmode= extras.getString("mode");
		
		 
		 Prez= extras.getString("rez");
		 if(Prez.equals("")){
			 
			 Prez="آماده دانلود";
		 }
		 
		 idt=extras.getString("id");
		 name.setText(Pname.toString());
		 matn.setText(Pmatn.toString());
		 mode.setText(Pmode.toString());
		 rez.setText(Prez.toString());
		 
		 fullname=Pname+"."+Pmode;
	
		
			
		
		 
		run();
		
		
        
       
    }
   
    
    public void run(){
    	
    	download.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				
				try {
					
					String downloadUrl=URLEncoder.encode(Pname, "UTF-8");
					urlInput=urlInput0+downloadUrl+"."+Pmode;
					urlInput=urlInput.replace("+", "%20");
					//matn.setText(urlInput);
					
					Start();
				} catch (UnsupportedEncodingException e) {
					
					e.printStackTrace();
				}
				
				
				
			}
    	});
    	cancel.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				finish();
				
			}
    	});
    	
    	runfile.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				
				
				
				String Finalpath = Environment.getExternalStorageDirectory() + "/Wiki/" + fullname;
	            File file = new File(Finalpath);
	            if (file.exists()) {
	                Uri filepath = Uri.fromFile(file);
	                Intent intent = new Intent(Intent.ACTION_VIEW);
	                intent.setDataAndType(filepath, "application/pdf");
	                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

	                try {
	                    startActivity(intent);
	                } catch (Exception e) {
	                	Toast toast1;
						toast1 = Toast.makeText(Downloader_File.this, "File Not Started...",Toast.LENGTH_LONG);
				        toast1.show();	                    
	                }

	            } else {
	            	Toast toast2;
					toast2 = Toast.makeText(Downloader_File.this, "File not found!",Toast.LENGTH_LONG);
			        toast2.show();
	            }	
			}
    	});
    }

    
    
   
	public void Start()
	{
		
		
		
		downloaderThreadF = new DownloadThreadF(thisActivity, urlInput,fullname);
		downloaderThreadF.start();
	
	}
	
	/**
	 * This is the Handler for this activity. It will receive messages from the
	 * DownloaderThread and make the necessary updates to the UI.
	 */
	
	
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
					//	pdMsg += " " + url;
						
						
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
						String pdMsg = "";
						pdMsg += " " + fileName;
						
						dismissCurrentProgressDialog();
						progressDialog = new ProgressDialog(thisActivity);
						progressDialog.setTitle(pdTitle);
						progressDialog.setMessage(pdMsg);
						progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
						progressDialog.setProgress(0);
						progressDialog.setMax(maxValue);
						// set the message to be sent when this dialog is canceled
						Message newMsg = Message.obtain(this, MESSAGE_DOWNLOAD_CANCELED);
						progressDialog.setCancelMessage(newMsg);
						progressDialog.setCancelable(true);
						progressDialog.show();
					}
					break;
				
				
				case MESSAGE_DOWNLOAD_COMPLETE:
					dismissCurrentProgressDialog();
					displayMessage(getString(R.string.user_message_filedownload_complete));
					try {
			    		 
			 	 		dbmain.open();
			 	 
			 	        }catch(SQLException sqle){
			 	 
			 	 		throw sqle;
			 	 
			 	        }
					
					int idt2=Integer.parseInt(idt.toString());
					//name.setText(idt);
					dbmain.updateContact(idt2, "فایل دانلود شده");
					rez.setText("فایل دانلود شده");
					break;
					
				
				case MESSAGE_DOWNLOAD_CANCELED:
					if(downloaderThreadF != null)
					{
						downloaderThreadF.interrupt();
					}
					dismissCurrentProgressDialog();
					displayMessage(getString(R.string.user_message_downloadf_canceled));
					break;
				
				
				case MESSAGE_ENCOUNTERED_ERROR:
					
					if(msg.obj != null && msg.obj instanceof String)
					{
						String errorMessage = (String) msg.obj;
						dismissCurrentProgressDialog();
						displayMessage(errorMessage);
					}
					break;
					
				default:
					
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