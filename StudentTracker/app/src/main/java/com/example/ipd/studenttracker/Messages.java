package com.example.ipd.studenttracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Messages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        setTitle("Messages");
    }

    public void goBack(View v) {
        Intent intent = new Intent(this, ListItems.class);
        startActivity(intent);
    }

}
