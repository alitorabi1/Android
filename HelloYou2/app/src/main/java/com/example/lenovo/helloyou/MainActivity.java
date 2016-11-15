package com.example.lenovo.helloyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button button;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et  = (EditText)findViewById(R.id.editText);
        button  = (Button)findViewById(R.id.button);
        tv  = (TextView) findViewById(R.id.textView);
    }

    public void mainClick(View view) {
        tv.setText("Hello " + et.getText());
    }

}
