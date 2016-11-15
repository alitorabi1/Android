package com.example.ipd.todoitems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    EditText et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1  = (EditText)findViewById(R.id.editText1);
        et2  = (EditText)findViewById(R.id.editText2);
        et3  = (EditText)findViewById(R.id.editText3);
    }

    public void mainClick(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("Item1", et1.getText().toString());
        intent.putExtra("Item2", et2.getText().toString());
        intent.putExtra("Item3", et3.getText().toString());
        startActivity(intent);
    }
}
