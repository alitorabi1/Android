package com.example.ipd.collectinguserdata1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    EditText et;
    String name;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        et  = (EditText)findViewById(R.id.editText2);
        tv1  = (TextView) findViewById(R.id.textView3);
        tv2  = (TextView) findViewById(R.id.textView6);
        name = getIntent().getExtras().getString("Name");
        email = getIntent().getExtras().getString("Email");
        tv1.setText("Your name is " + name);
        tv2.setText("Your email is " + email);
    }

    public void mainClick(View view) {
        Intent intent = new Intent(this, Main4Activity.class);
        intent.putExtra("Name", name);
        intent.putExtra("Email", email);
        intent.putExtra("Phone", et.getText().toString());
        startActivity(intent);
    }
}
