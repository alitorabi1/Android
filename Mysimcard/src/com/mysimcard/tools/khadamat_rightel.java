package com.mysimcard.tools;


import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class khadamat_rightel extends ListActivity {
	
	
	private String txt="";
	private static final String[] items = {"تماس با امور مشترکین"};
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.khadamat_rightel);
        setListAdapter(new ArrayAdapter<String>(this,R.layout.row, R.id.label, items));   

	}
	
	public void onListItemClick(ListView parent, View v, int position, long id){
    	txt=items[position];
    	if(txt == "تماس با امور مشترکین"){
			String encodedHash = Uri.encode("#");
			String ussd = "2222";
			startActivityForResult(new Intent("android.intent.action.CALL",Uri.parse("tel:" + ussd)), 1);
    		Toast toast;
    		toast = Toast.makeText(khadamat_rightel.this, "2222",Toast.LENGTH_LONG);
            toast.show();
    	}
    	
    	
    }
	
		
		
	

}
