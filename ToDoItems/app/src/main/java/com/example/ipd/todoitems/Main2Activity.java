package com.example.ipd.todoitems;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    String todo1;
    String todo2;
    String todo3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        todo1 = getIntent().getExtras().getString("Item1");
        tv1.setText(todo1);
        todo2 = getIntent().getExtras().getString("Item2");
        tv2.setText(todo2);
        todo3 = getIntent().getExtras().getString("Item3");
        tv3.setText(todo3);
    }
}
