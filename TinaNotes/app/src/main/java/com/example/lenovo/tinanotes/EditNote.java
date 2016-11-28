package com.example.lenovo.tinanotes;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class EditNote extends Activity{
	
	public static String curDate = "";
	public static String curText = "";	
    private EditText mNameText;
    private EditText mBodyText;
    private TextView mDateText;
    private Long mNoteId;

    private Cursor note;

    private DbActivities mDbHelper;
      
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        mDbHelper = new DbActivities(this);
        mDbHelper.open();        
        
        setContentView(R.layout.edit_note);
        setTitle(R.string.app_name);

        mNameText = (EditText) findViewById(R.id.title);
        mBodyText = (EditText) findViewById(R.id.body);
        mDateText = (TextView) findViewById(R.id.notelist_date);

        long msTime = System.currentTimeMillis();  
        Date curDateTime = new Date(msTime);
 	
        SimpleDateFormat formatter = new SimpleDateFormat("d'/'M'/'y");  
        curDate = formatter.format(curDateTime);        
        
        mDateText.setText(""+curDate);


		mNoteId = (savedInstanceState == null) ? null :
            (Long) savedInstanceState.getSerializable(DbActivities.NOTEID);
        if (mNoteId == null) {
            Bundle extras = getIntent().getExtras();
			mNoteId = extras != null ? extras.getLong(DbActivities.NOTEID)
                                    : null;
        }

        populateFields();
    
    }
	
	  public static class LineEditText extends EditText{

		  private Rect mRect;
		  private Paint mPaint;

		  // we need this constructor for LayoutInflater
			public LineEditText(Context context, AttributeSet attrs) {
				super(context, attrs);
					mRect = new Rect();
			        mPaint = new Paint();
			        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
//			        mPaint.setColor(Color.BLUE);
			}

		    @Override
		    protected void onDraw(Canvas canvas) {
		  
		        int height = getHeight();
		        int line_height = getLineHeight();

		        int count = height / line_height;

		        if (getLineCount() > count)
		            count = getLineCount();

		        Rect r = mRect;
		        Paint paint = mPaint;
		        int baseline = getLineBounds(0, r);

		        for (int i = 0; i < count; i++) {

		            canvas.drawLine(r.left, baseline + 1, r.right, baseline + 1, paint);
		            baseline += getLineHeight();

		        super.onDraw(canvas);
		    }

		}
	  }
	  
	  @Override
	    protected void onSaveInstanceState(Bundle outState) {
	        super.onSaveInstanceState(outState);
	        saveState();
	        outState.putSerializable(DbActivities.NOTEID, mNoteId);
	    }
	    
	    @Override
	    protected void onPause() {
	        super.onPause();
	        saveState();
	    }
	    
	    @Override
	    protected void onResume() {
	        super.onResume();
	        populateFields();
	    }
	    
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.noteedit_menu, menu);
			return true;
		}

		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
		    switch (item.getItemId()) {
		    case R.id.menu_delete:
				if(note != null){
	    			note.close();
	    			note = null;
	    		}
	    		if(mNoteId != null){
	    			mDbHelper.deleteNote(mNoteId);
	    		}
	    		finish();

		        return true;
		    case R.id.menu_save:
	    		saveState();
	    		finish();
		    default:
		    	return super.onOptionsItemSelected(item);
		    }
		}

	    private void saveState() {
	        String name = mNameText.getText().toString();
	        String body = mBodyText.getText().toString();

	        if(mNoteId == null){
	        	long id = mDbHelper.makeNote(name, body, curDate);
	        	if(id > 0){
					mNoteId = id;
	        	}else{
	        		Log.e("saveState","failed to create note");
	        	}
	        }else{
	        	if(!mDbHelper.updateNote(mNoteId, name, body, curDate)){
	        		Log.e("saveState","failed to update note");
	        	}
	        }
	    }
	    
	    private void populateFields() {
	        if (mNoteId != null) {
	            note = mDbHelper.selectNoteById(mNoteId);
	            startManagingCursor(note);
	            mNameText.setText(note.getString(
	    	            note.getColumnIndexOrThrow(DbActivities.NAME)));
	            mBodyText.setText(note.getString(
	                    note.getColumnIndexOrThrow(DbActivities.BODY)));
	            curText = note.getString(
	                    note.getColumnIndexOrThrow(DbActivities.BODY));
	        }
	    }

}
