package com.example.lenovo.visibility;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mainClick(View view) {
        if (button1.getVisibility() == View.VISIBLE) {
            button1.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.VISIBLE);
        } else {
            button2.setVisibility(View.INVISIBLE);
            button1.setVisibility(View.VISIBLE);
        }
    }

}
