package com.example.student.email;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    SharedPreferences sharedPref;
    EditText etEmail;
    TextView tvName2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sharedPref= PreferenceManager.getDefaultSharedPreferences(getBaseContext());




        String userName = getIntent().getExtras().getString("userName");
        String keyName = sharedPref.getString(userName, "EMAIL");




        tvName2=(TextView) findViewById(R.id.tvName2);
        tvName2.setText(userName);
        etEmail=(EditText) findViewById(R.id.etEmail);
        etEmail.setText(keyName);





    }
    public void goBack(View v){
        SharedPreferences.Editor prefEditor = sharedPref.edit();
        prefEditor.putString(tvName2.getText().toString(), etEmail.getText().toString());
        prefEditor.commit();
        ////////////
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
