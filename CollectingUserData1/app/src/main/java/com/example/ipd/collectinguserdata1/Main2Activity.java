package com.example.ipd.collectinguserdata1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tv;
    EditText et;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et  = (EditText)findViewById(R.id.editText3);
        tv  = (TextView) findViewById(R.id.textView2);
        name = getIntent().getExtras().getString("Name");
        tv.setText("Your name is " + name);
    }

    public void mainClick(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("Name", name);
        intent.putExtra("Email", et.getText().toString());
        startActivity(intent);
    }

}
