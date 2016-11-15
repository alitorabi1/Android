package com.example.ipd.userlogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tv;
    EditText et;
    EditText et2;
    String name;
    String email;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        name = getIntent().getExtras().getString("Name");
        et  = (EditText)findViewById(R.id.editText2);
        String stored_text = sharedPref.getString(name, name);
    }

    public void mainClick(View view) {
        SharedPreferences.Editor prefEditor = sharedPref.edit();
        prefEditor.putString(name, et.getText().toString());
        prefEditor.commit();
    }

    public void quitApp(View view) {
        this.finishAffinity();
    }

    public void backApp(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
