package com.example.ipd.collectinguserdata1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et  = (EditText)findViewById(R.id.editText);
        button  = (Button)findViewById(R.id.button);
    }

    public void mainClick(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("Name", et.getText().toString());
        startActivity(intent);
    }
}
