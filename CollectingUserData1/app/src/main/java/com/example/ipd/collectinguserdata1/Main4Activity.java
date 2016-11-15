package com.example.ipd.collectinguserdata1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    String name;
    String email;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        tv1  = (TextView) findViewById(R.id.textView5);
        tv2  = (TextView) findViewById(R.id.textView7);
        tv3  = (TextView) findViewById(R.id.textView8);
        name = getIntent().getExtras().getString("Name");
        email = getIntent().getExtras().getString("Email");
        phone = getIntent().getExtras().getString("Phone");
        tv1.setText("Your name is " + email);
        tv2.setText("Your email is " + email);
        tv3.setText("Your phone is " + phone);
    }

}
