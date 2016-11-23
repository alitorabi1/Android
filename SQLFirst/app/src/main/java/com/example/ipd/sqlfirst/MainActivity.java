package com.example.ipd.sqlfirst;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    EditText etName;
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = (EditText) findViewById(R.id.editText);
    }

    public void loginClick(View view) {
        name = etName.getText().toString();
        Intent intent = new Intent(this, EmailEdit.class);
        intent.putExtra("Name", name);
        startActivity(intent);
    }

}
