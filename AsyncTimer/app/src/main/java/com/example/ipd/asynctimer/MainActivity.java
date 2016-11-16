package com.example.ipd.asynctimer;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    TextView txt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.textView);
    }

    public void startApp(View view) {
        // detect the view that was "clicked"
        switch (view.getId()) {
            case R.id.button:
                new UpdateTask().execute();
                break;
        }
    }

    private class UpdateTask extends AsyncTask<Void, Integer, Void> {

        protected void onProgressUpdate(Integer... i) {
            // code to update the user interface goes here
            super.onProgressUpdate(i);
            txt.setText(i[0].toString());
        }


        @Override
        protected Void doInBackground(Void... params) {
            int i = 0;
            while (!isCancelled()) {
                // you will need to call the publishProgress method somewhere here
                // publishProgress will call the onProgressUpdate method
                    try {
                        Thread.sleep(1000);
                        publishProgress(i);
                        i++;
                    } catch (Exception e) {
                        Log.i("makemachine", e.getMessage());
                    }
            }
            return null;
        }


        public void stopApp(View view) {
            //this is 'Stop' button click listener
            switch (view.getId()) {
                case R.id.button2:
                    new UpdateTask().cancel(false);
                    break;
            }
       }
    }
}
