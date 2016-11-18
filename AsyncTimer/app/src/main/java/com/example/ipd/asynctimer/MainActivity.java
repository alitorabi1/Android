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

    UpdateTask updateTask = new UpdateTask();

    public void startApp(View view) {
        // detect the view that was "clicked"
        if (updateTask != null && updateTask.getStatus() == AsyncTask.Status.RUNNING){
            if (updateTask.isCancelled()) {
                updateTask = new UpdateTask();
                updateTask.execute();
            }
        } else {
            updateTask.execute();
        }
    }

    public void stopApp(View view) {
        // detect the view that was "clicked"
        updateTask.cancel(true);
    }

    class UpdateTask extends AsyncTask<Void, Integer, Void> {

        protected void onProgressUpdate(Integer... i) {
            // code to update the user interface
            super.onProgressUpdate(i);
            txt.setText(i[0].toString());
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
                    Thread.sleep(200);
                    publishProgress(i);
                    i++;
                } catch (Exception e) {
                    Log.i("makemachine", e.getMessage());
                }
            }
            return null;
        }

    }
}