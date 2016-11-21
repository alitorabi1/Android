package com.example.ipd.studenttracker;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView logo;
    Button btn1;
    Button btn2;
    Button btn3;

    UpdateTask updateTask = new UpdateTask();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo = (ImageView) findViewById(R.id.logo);
        logo.bringToFront();

        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn1.setVisibility(View.INVISIBLE);
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);

        if (updateTask != null && updateTask.getStatus() == AsyncTask.Status.RUNNING){
            if (updateTask.isCancelled()) {
                updateTask = new UpdateTask();
                updateTask.execute();
            }
        } else {
            updateTask.execute();
        }
    }

    class UpdateTask extends AsyncTask<Void, Integer, Void> {

        protected void onProgressUpdate(Integer... i) {
            // code to update the user interface
            super.onProgressUpdate(i);
            logo.setVisibility(View.INVISIBLE);
            btn1.setVisibility(View.VISIBLE);
            btn2.setVisibility(View.VISIBLE);
            btn3.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... params) {
            int i = 0;
            while (true) {
                // call the publishProgress method
                // publishProgress will call the onProgressUpdate method
                if ( isCancelled())
                    break;
                try {
                    Thread.sleep(7000);
                    publishProgress(i);
                    i++;
                } catch (Exception e) {
                    Log.i("makemachine", e.getMessage());
                }
            }
            return null;
        }

    }

    protected void onCreate() {
        setContentView(R.layout.activity_main);
    }

    public void signIn(View v){
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
    }

    public void signUp(View v){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

    public void watchDemo(View v){
        Intent intent = new Intent(this, Demo.class);
        startActivity(intent);
    }
}
