package com.example.ipd.helloyou3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv  = (TextView) findViewById(R.id.textView);
        String name = getIntent().getExtras().getString("SOMEKEY");
        tv.setText("Hello " + name);
    }
}
