package com.example.ipd.celsiustofahrenheit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    Button button1;
    Button button2;
    TextView tv1;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1  = (EditText)findViewById(R.id.editText1);
        et2  = (EditText)findViewById(R.id.editText2);
        button1  = (Button)findViewById(R.id.button1);
        button2  = (Button)findViewById(R.id.button2);
        tv1  = (TextView) findViewById(R.id.textView1);
        tv2  = (TextView) findViewById(R.id.textView2);
    }

    public void mainClick1(View view) {
        tv1.setText(String.valueOf((Double.parseDouble(String.valueOf(et2.getText())) * 5/9 )));
    }

    public void mainClick2(View view) {
        tv2.setText(String.valueOf((Double.parseDouble(String.valueOf(et1.getText())) * 9/5 ) + 32));
    }
}
