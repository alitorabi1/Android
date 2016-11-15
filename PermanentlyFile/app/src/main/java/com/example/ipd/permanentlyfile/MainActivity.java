package com.example.ipd.permanentlyfile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et;
    EditText et2;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        et  = (EditText)findViewById(R.id.editText);
        et2  = (EditText)findViewById(R.id.editText2);
        String stored_text = sharedPref.getString("SOMEID1", "sometext1");
        et.setText(stored_text);
        String stored_text2 = sharedPref.getString("SOMEID2", "sometext2");
        et2.setText(stored_text2);
    }

    public void mainClick(View view) {
        SharedPreferences.Editor prefEditor = sharedPref.edit();
        prefEditor.putString("SOMEID1", et.getText().toString());
        prefEditor.commit();
        prefEditor.putString("SOMEID2", et2.getText().toString());
        prefEditor.commit();
    }

    public void quitApp(View view) {
        this.finishAffinity();
    }
}
