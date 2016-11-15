package com.example.student.email;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPref;
    EditText etName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPref= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        etName=(EditText) findViewById(R.id.etName);
        //tvName.setText(stored_text);
       // String stored_text = sharedPref.getString(tvName.get, "sometext");
    }
    public void login(View v){
        SharedPreferences.Editor prefEditor = sharedPref.edit();
      //  prefEditor.putString(etName.getText().toString(), "EMAIL");
        sharedPref.getString(etName.getText().toString(), "Email");
        prefEditor.commit();

        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("userName", etName.getText().toString());
        startActivity(intent);


    }

}
